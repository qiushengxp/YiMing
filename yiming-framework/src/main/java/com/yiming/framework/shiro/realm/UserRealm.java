package com.yiming.framework.shiro.realm;

import com.yiming.domain.system.SysUser;
import com.yiming.framework.shiro.service.LoginService;
import com.yiming.framework.shiro.util.ShiroUtils;
import com.yiming.mapper.system.SysAuthRuleMapper;
import com.yiming.service.system.ISysAuthRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-03-23 17:03
 */
public class UserRealm extends AuthorizingRealm {

    private static final transient Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private ISysAuthRoleService roleService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = ShiroUtils.getSysUser();

        Set<String> rolus = new HashSet<String>();
        Set<String> menus = new HashSet<String>();

        // 获取用户角色键值
        rolus = roleService.selectRoleKeys(user.getId());
        rolus.add("common");
        menus.add("system:test");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 角色加入AuthorizationInfo认证对象
        info.setRoles(rolus);
        // 权限加入AuthorizationInfo认证对象
        info.setStringPermissions(menus);
        return info;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }

        SysUser user = null;
        try {
            user = loginService.login(username, password);

        } catch (RuntimeException re) {
            log.info("对用户[" + username + "]进行登录验证..验证未通过{}", re.getMessage());
            throw new AuthenticationException(re.getMessage(), re);
        } catch (Exception e) {
            log.info("对用户[" + username + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
