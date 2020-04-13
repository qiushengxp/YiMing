package com.yiming.service.system.impl;

import com.yiming.domain.system.SysUser;
import com.yiming.mapper.system.SysUserMapper;
import com.yiming.service.system.ISysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员表(SysUser)表服务实现类
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:38
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

   /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser selectById(Long id) {
        return this.sysUserMapper.selectById(id);
    }

    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    @Override
    public SysUser selectUserByLoginName(String username) {
        return this.sysUserMapper.selectUserByLoginName(username);
    }

    /**
     * 通过实体查询数据
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysUser> selectAll(SysUser sysUser) {
        return this.sysUserMapper.selectAll(sysUser);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> selectAllByLimit(SysUser sysUser, int offset, int limit) {
        return this.sysUserMapper.selectAllByLimit(sysUser, offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserMapper.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserMapper.update(sysUser);
        return this.selectById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserMapper.deleteById(id) > 0;
    }
}