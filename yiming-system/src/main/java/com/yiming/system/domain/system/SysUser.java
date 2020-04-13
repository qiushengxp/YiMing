package com.yiming.system.domain.system;

import com.yiming.common.core.domain.BaseEntity;

/**
 * 管理员表(SysUser)实体类
 *
 * @author wa.huang
 * @since 2020-04-09 16:54:50
 */
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String name;
    /**
    * 用户名
    */
    private String account;
    /**
    * 密码
    */
    private String password;
    private String salt;
    /**
    * 最后登录IP
    */
    private String lastLoginIp;
    /**
    * 最后登录时间
    */
    private Long lastLoginTime;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    
    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}