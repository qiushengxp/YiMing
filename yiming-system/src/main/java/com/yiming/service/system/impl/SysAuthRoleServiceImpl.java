package com.yiming.service.system.impl;

import com.yiming.common.utils.StringUtils;
import com.yiming.domain.system.SysAuthRole;
import com.yiming.mapper.system.SysAuthRoleMapper;
import com.yiming.service.system.ISysAuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色表(SysAuthRole)表服务实现类
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:43
 */
@Service
public class SysAuthRoleServiceImpl implements ISysAuthRoleService {
    @Resource
    private SysAuthRoleMapper sysAuthRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysAuthRole selectById(Long id) {
        return this.sysAuthRoleMapper.selectById(id);
    }

    /**
     * 通过实体查询数据
     *
     * @param sysAuthRole 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysAuthRole> selectAll(SysAuthRole sysAuthRole) {
        return this.sysAuthRoleMapper.selectAll(sysAuthRole);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysAuthRole> selectAllByLimit(SysAuthRole sysAuthRole, int offset, int limit) {
        return this.sysAuthRoleMapper.selectAllByLimit(sysAuthRole, offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysAuthRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysAuthRole insert(SysAuthRole sysAuthRole) {
        this.sysAuthRoleMapper.insert(sysAuthRole);
        return sysAuthRole;
    }

    /**
     * 修改数据
     *
     * @param sysAuthRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysAuthRole update(SysAuthRole sysAuthRole) {
        this.sysAuthRoleMapper.update(sysAuthRole);
        return this.selectById(sysAuthRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysAuthRoleMapper.deleteById(id) > 0;
    }

    /**
     * 查询用户角色键值
     * @param userId
     * @return
     */
    @Override
    public Set<String> selectRoleKeys(Long userId) {
        List<SysAuthRole> roles = this.sysAuthRoleMapper.selectRoleByUserId(userId);
        Set<String> keys = new HashSet<>();
        for (SysAuthRole role : roles) {
            if (StringUtils.isNotNull(role)) {
                keys.add(role.getRoleKey().trim());
            }
        }
        return keys;
    }
}