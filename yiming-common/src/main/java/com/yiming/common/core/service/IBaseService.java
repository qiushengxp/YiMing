package com.yiming.common.core.service;

import java.util.List;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-04-10 11:45
 */
public interface IBaseService<T> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    T selectById(Long id);

    /**
     * 通过实体查询数据
     *
     * @param entity 实例对象
     * @return 对象列表
     */
    List<T> selectAll(T entity);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> selectAllByLimit(T entity, int offset, int limit);

    /**
     * 新增数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    T insert(T entity);

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    T update(T entity);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
}
