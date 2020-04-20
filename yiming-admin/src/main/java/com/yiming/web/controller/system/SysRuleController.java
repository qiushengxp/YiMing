package com.yiming.web.controller.system;

import com.yiming.common.core.conntroller.BaseController;
import com.yiming.system.domain.system.SysAuthRule;
import com.yiming.system.service.system.ISysAuthRuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-04-18 16:28
 */
@Controller
@RequestMapping("/admin/system/rule")
public class SysRuleController extends BaseController {
    @Autowired
    private ISysAuthRuleService ruleService;
    private String prefix = "admin/system/rule";

    @RequiresPermissions("admin:rule:view")
    @GetMapping()
    public String rule() {
        return prefix + "/rule";
    }

    @RequiresPermissions("admin:rule:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysAuthRule> list(SysAuthRule rule) {

        return ruleService.selectAll(rule);
    }
}
