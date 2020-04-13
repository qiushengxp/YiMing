package com.yiming.service.system.impl;

import com.yiming.domain.system.SysUserRole;
import com.yiming.mapper.system.SysUserRoleMapper;
import com.yiming.service.system.ISysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色表 (SysUserRole)表服务实现类
 *
 * @author wa.huang
 * @since 2020-04-10 16:23:36
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

}