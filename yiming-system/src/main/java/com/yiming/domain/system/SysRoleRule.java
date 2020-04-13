package com.yiming.domain.system;

import com.yiming.common.core.domain.BaseEntity;

/**
 * 角色权限表 (SysRoleRule)实体类
 *
 * @author wa.huang
 * @since 2020-04-10 16:23:36
 */
public class SysRoleRule extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
    * 角色编号
    */
    private Long roleId;
    /**
    * 权限编号
    */
    private Long ruleId;

    
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

}