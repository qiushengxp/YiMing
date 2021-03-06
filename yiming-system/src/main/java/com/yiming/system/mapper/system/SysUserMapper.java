package com.yiming.system.mapper.system;

import com.yiming.system.domain.system.SysUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 管理员表(SysUser)表数据库访问层
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:37
 */
public interface SysUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser selectById(Long id);

    /**
     *  通过用户名查询单条数据
     * @param username 用户名
     * @return
     */
    SysUser selectUserByLoginName(String username);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysUser> selectAllByLimit(SysUser sysUser, @Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> selectAll(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}