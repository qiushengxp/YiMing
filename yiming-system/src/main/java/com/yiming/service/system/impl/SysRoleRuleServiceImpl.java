package com.yiming.service.system.impl;

import com.yiming.domain.system.SysRoleRule;
import com.yiming.mapper.system.SysRoleRuleMapper;
import com.yiming.service.system.ISysRoleRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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