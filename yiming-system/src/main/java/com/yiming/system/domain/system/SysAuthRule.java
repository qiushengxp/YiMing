package com.yiming.system.domain.system;

import com.yiming.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 规则表(SysAuthRule)实体类
 *
 * @author wa.huang
 * @since 2020-04-09 16:54:50
 */
public class SysAuthRule extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 链接
     */
    private String url;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 父级ID
     */
    private Long pid;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Long sort;

    /**
     * 权限名
     */
    private String perms;

    /**
     * 可见状态
     */
    private String visible;

    /**
     * 目标打开方式
     */
    private String target;

    private List<SysAuthRule> children = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public List<SysAuthRule> getChildren() {
        return children;
    }

    public void setChildren(List<SysAuthRule> children) {
        this.children = children;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}