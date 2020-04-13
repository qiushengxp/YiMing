package com.yiming.web.controller.index;

import com.yiming.common.core.conntroller.BaseController;
import com.yiming.system.domain.system.SysUser;
import com.yiming.system.service.system.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-03-19 11:33
 */
@Controller
public class IndexContrllor extends BaseController {

    @Autowired
    ISysUserService userService;

    @RequestMapping("/index")
    public String index() {
        SysUser admin = userService.selectById(1L);
        return "index";
    }

    @RequestMapping("/system/main")
    public String welcome() {
        return "main";
    }

    @RequiresPermissions("system:test")
    @RequestMapping("/test/{date}")
    @ResponseBody
    public SysUser test(@PathVariable("date") Long d) {
        return userService.selectById(1L);
    }
}
