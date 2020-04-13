package com.yiming.service.system.impl;

import com.yiming.domain.system.SysAuthRule;
import com.yiming.mapper.system.SysAuthRuleMapper;
import com.yiming.service.system.ISysAuthRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 规则表(SysAuthRule)表服务实现类
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:45
 */
@Service
public class SysAuthRuleServiceImpl implements ISysAuthRuleService {
    @Resource
    private SysAuthRuleMapper sysAuthRuleMapper;

   /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysAuthRule selectById(Long id) {
        return this.sysAuthRuleMapper.selectById(id);
    }
    
    /**
     * 通过实体查询数据
     *
     * @param sysAuthRule 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysAuthRule> selectAll(SysAuthRule sysAuthRule) {
        return this.sysAuthRuleMapper.selectAll(sysAuthRule);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysAuthRule> selectAllByLimit(SysAuthRule sysAuthRule, int offset, int limit) {
        return this.sysAuthRuleMapper.selectAllByLimit(sysAuthRule, offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysAuthRule 实例对象
     * @return 实例对象
     */
    @Override
    public SysAuthRule insert(SysAuthRule sysAuthRule) {
        this.sysAuthRuleMapper.insert(sysAuthRule);
        return sysAuthRule;
    }

    /**
     * 修改数据
     *
     * @param sysAuthRule 实例对象
     * @return 实例对象
     */
    @Override
    public SysAuthRule update(SysAuthRule sysAuthRule) {
        this.sysAuthRuleMapper.update(sysAuthRule);
        return this.selectById(sysAuthRule.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysAuthRuleMapper.deleteById(id) > 0;
    }
}