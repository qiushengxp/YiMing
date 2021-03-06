package com.yiming.system.mapper.system;

import com.yiming.system.domain.system.SysAuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(SysAuthRole)表数据库访问层
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:41
 */
public interface SysAuthRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysAuthRole selectById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysAuthRole> selectAllByLimit(SysAuthRole sysAuthRole, @Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysAuthRole 实例对象
     * @return 对象列表
     */
    List<SysAuthRole> selectAll(SysAuthRole sysAuthRole);

    /**
     * 新增数据
     *
     * @param sysAuthRole 实例对象
     * @return 影响行数
     */
    int insert(SysAuthRole sysAuthRole);

    /**
     * 修改数据
     *
     * @param sysAuthRole 实例对象
     * @return 影响行数
     */
    int update(SysAuthRole sysAuthRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<SysAuthRole> selectRoleByUserId(Long userId);
}