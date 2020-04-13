package com.yiming.service.system;

import com.yiming.common.core.service.IBaseService;
import com.yiming.domain.system.SysUser;
import java.util.List;

/**
 * 管理员表(SysUser)表服务接口
 *
 * @author wa.huang
 * @since 2020-04-04 16:32:38
 */
public interface ISysUserService extends IBaseService<SysUser> {
    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    SysUser selectUserByLoginName(String username);
}