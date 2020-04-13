package com.yiming.framework.shiro.service;

import com.yiming.common.utils.DateUtils;
import com.yiming.common.utils.StringUtils;
import com.yiming.common.utils.security.Md5Utils;
import com.yiming.system.domain.system.SysUser;
import com.yiming.framework.shiro.util.ShiroUtils;
import com.yiming.system.service.system.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-04-04 09:24
 */
@Component
public class LoginService {

    @Autowired
    private ISysUserService userService;

    public SysUser login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("用户名密码不能为空");
        }
        SysUser userInfo = userService.selectUserByLoginName(username);
        if (StringUtils.isNull(userInfo)) {
            throw new RuntimeException("账号不存在");
        }
        String pass = Md5Utils.hash(password + userInfo.getSalt());

        if (!pass.equals(userInfo.getPassword())) {
            throw new RuntimeException("密码不正确");
        }
        recordLoginInfo(userInfo);

        return userInfo;
    }

    public void recordLoginInfo(SysUser user) {
        user.setLastLoginIp(ShiroUtils.getIp());
        user.setLastLoginTime(DateUtils.getNowDateTimestamp());
        userService.update(user);
    }
}
