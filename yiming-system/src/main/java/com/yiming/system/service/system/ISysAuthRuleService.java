package com.yiming.system.service.system;

import com.yiming.common.core.service.IBaseService;
import com.yiming.system.domain.system.SysAuthRule;
import com.yiming.system.domain.system.SysUser;

import java.util.List;
import java.util.Set;

/**
 * 规则表(SysAuthRule)表服务接口
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:45
 */
public interface ISysAuthRuleService extends IBaseService<SysAuthRule> {
    /**
     * 查询权限关键字
     *
     * @param userId
     * @return
     */
    Set<String> selectRuleKeys(Long userId);

    /**
     * 查询菜单集合
     *
     * @return 所有菜单信息
     */
    List<SysAuthRule> selectMenusByUser(SysUser user);
}