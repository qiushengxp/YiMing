package com.yiming.system.domain.system;

import com.yiming.common.core.domain.BaseEntity;

/**
 * 角色表(SysAuthRole)实体类
 *
 * @author wa.huang
 * @since 2020-04-09 16:54:50
 */
public class SysAuthRole extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
    * 角色名称
    */
    private String roleName;

    /**
     * 角色键值
     */
    private String roleKey;
    /**
    * 权限节点数据
    */
    private String rule;

    
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

}