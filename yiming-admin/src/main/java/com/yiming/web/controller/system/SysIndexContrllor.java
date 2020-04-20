package com.yiming.web.controller.system;

import com.yiming.common.core.conntroller.BaseController;
import com.yiming.framework.shiro.util.ShiroUtils;
import com.yiming.system.domain.system.SysAuthRule;
import com.yiming.system.domain.system.SysUser;
import com.yiming.system.service.system.ISysAuthRoleService;
import com.yiming.system.service.system.ISysAuthRuleService;
import com.yiming.system.service.system.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-03-19 11:33
 */
@Controller
public class SysIndexContrllor extends BaseController {

    @Autowired
    ISysUserService userService;
    @Autowired
    ISysAuthRoleService roleService;
    @Autowired
    ISysAuthRuleService ruleService;
    private String prefix = "admin";


    @RequestMapping("/index")
    public String index(ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        List<SysAuthRule> menus = ruleService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        return prefix + "/index";
    }

    @RequestMapping("/system/main")
    public String welcome() {
        return prefix + "/main";
    }

    @RequiresPermissions("system:test:mysql")
    @GetMapping("/test")
    @ResponseBody
    public List<SysAuthRule> test() {
        return this.ruleService.selectMenusByUser(ShiroUtils.getSysUser());
    }
}
