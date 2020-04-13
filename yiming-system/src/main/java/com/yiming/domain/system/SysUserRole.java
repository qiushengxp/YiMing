package com.yiming.domain.system;

import com.yiming.common.core.domain.BaseEntity;

/**
 * 用户角色表 (SysUserRole)实体类
 *
 * @author wa.huang
 * @since 2020-04-10 16:23:36
 */
public class SysUserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
    * 用户编号
    */
    private Long uid;
    /**
    * 角色编号
    */
    private Long roleId;

    
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}