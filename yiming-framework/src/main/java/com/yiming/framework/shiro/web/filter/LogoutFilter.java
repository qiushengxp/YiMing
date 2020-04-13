package com.yiming.framework.shiro.web.filter;

import com.yiming.framework.shiro.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-03-31 18:06
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

    private Cache<String, Deque<Serializable>> cache;

    /**
     * 自定义登出,登出之后,清理当前用户redis部分缓存信息
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        //登出操作 清除缓存  subject.logout() 可以自动清理缓存信息, 这些代码是可以省略的  这里只是做个笔记 表示这种方式也可以清除
        Subject subject = getSubject(request, response);
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm shiroRealm = (UserRealm) securityManager.getRealms().iterator().next();
        PrincipalCollection principals = subject.getPrincipals();
//        shiroRealm.clearCache(principals);

        //登出
        subject.logout();

        //获取登出后重定向到的地址
        String redirectUrl = getRedirectUrl(request, response, subject);
        //重定向
        issueRedirect(request, response, redirectUrl);
        return false;
    }

    // 设置Cache的key的前缀
    public void setCacheManager(CacheManager cacheManager) {
        // 必须和ehcache缓存配置中的缓存name一致
        this.cache = cacheManager.getCache("sys-userCache");
    }
}
