package com.yiming.service.system;

import com.yiming.common.core.service.IBaseService;
import com.yiming.domain.system.SysAuthRole;

import java.util.List;
import java.util.Set;

/**
 * 角色表(SysAuthRole)表服务接口
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:43
 */
public interface ISysAuthRoleService extends IBaseService<SysAuthRole> {

    /**
     * 查询用户角色键值
     * @param userId
     * @return
     */
    Set<String> selectRoleKeys(Long userId);
}