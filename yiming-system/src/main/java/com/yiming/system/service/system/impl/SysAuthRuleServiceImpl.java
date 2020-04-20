package com.yiming.system.service.system.impl;

import com.yiming.common.utils.StringUtils;
import com.yiming.system.domain.system.SysAuthRule;
import com.yiming.system.domain.system.SysUser;
import com.yiming.system.mapper.system.SysAuthRuleMapper;
import com.yiming.system.service.system.ISysAuthRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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
     * @param limit  查询条数
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

    @Override
    public Set<String> selectRuleKeys(Long userId) {
        List<SysAuthRule> rules = this.sysAuthRuleMapper.selectRuleByUserId(userId);
        Set<String> keys = new HashSet<>();
        for (SysAuthRule rule : rules) {
            if (StringUtils.isNotNull(rule)) {
                keys.add(rule.getPerms());
            }
        }
        return keys;
    }

    @Override
    public List<SysAuthRule> selectMenusByUser(SysUser user) {
        List<SysAuthRule> menus = new LinkedList<SysAuthRule>();
        if (user.isAdmin()) {
            menus = this.sysAuthRuleMapper.selectMenuNormalAll();
        }

        return getChildPerms(menus, 0);
    }

    /**
     * 查询子权限
     *
     * @param list
     * @param parentId
     * @return
     */
    public List<SysAuthRule> getChildPerms(List<SysAuthRule> list, int parentId) {
        List<SysAuthRule> retureList = new ArrayList<>();
        for (Iterator<SysAuthRule> iterator = list.iterator(); iterator.hasNext(); ) {
            SysAuthRule t = (SysAuthRule) iterator.next();
            if (t.getPid() == parentId) {
                recursiveFu(list, t);
                retureList.add(t);
            }
        }
        return retureList;
    }

    /**
     * 获取子菜单
     *
     * @param list
     * @param t
     * @return
     */
    private List<SysAuthRule> getChildList(List<SysAuthRule> list, SysAuthRule t) {
        List<SysAuthRule> tlist = new ArrayList<SysAuthRule>();
        Iterator<SysAuthRule> it = list.iterator();
        while (it.hasNext()) {
            SysAuthRule n = (SysAuthRule) it.next();
            if (n.getPid().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 递归查询所有子菜单
     *
     * @param list
     * @param t
     * @return
     */
    private void recursiveFu(List<SysAuthRule> list, SysAuthRule t) {
        List<SysAuthRule> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysAuthRule tChild : childList) {
            if (hasChild(list, tChild)) {
                Iterator<SysAuthRule> it = childList.iterator();
                while (it.hasNext()) {
                    SysAuthRule n = (SysAuthRule) it.next();
                    recursiveFu(list, n);
                }
            }
        }
    }

    /**
     * 检查是否有子菜单
     *
     * @param list
     * @param t
     * @return
     */
    private boolean hasChild(List<SysAuthRule> list, SysAuthRule t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}