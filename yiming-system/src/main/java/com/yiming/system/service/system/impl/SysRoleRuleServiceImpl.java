package com.yiming.system.service.system.impl;

import com.yiming.system.mapper.system.SysRoleRuleMapper;
import com.yiming.system.service.system.ISysRoleRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色权限表 (SysRoleRule)表服务实现类
 *
 * @author wa.huang
 * @since 2020-04-10 16:23:36
 */
@Service
public class SysRoleRuleServiceImpl implements ISysRoleRuleService{
    @Resource
    private SysRoleRuleMapper sysRoleRuleMapper;


}