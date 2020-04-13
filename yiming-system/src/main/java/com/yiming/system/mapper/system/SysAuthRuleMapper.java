package com.yiming.system.mapper.system;

import com.yiming.system.domain.system.SysAuthRule;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 规则表(SysAuthRule)表数据库访问层
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:44
 */
public interface SysAuthRuleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysAuthRule selectById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysAuthRule> selectAllByLimit(SysAuthRule sysAuthRule, @Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysAuthRule 实例对象
     * @return 对象列表
     */
    List<SysAuthRule> selectAll(SysAuthRule sysAuthRule);

    /**
     * 新增数据
     *
     * @param sysAuthRule 实例对象
     * @return 影响行数
     */
    int insert(SysAuthRule sysAuthRule);

    /**
     * 修改数据
     *
     * @param sysAuthRule 实例对象
     * @return 影响行数
     */
    int update(SysAuthRule sysAuthRule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}