package com.yiming.domain.system;

import com.yiming.common.core.domain.BaseEntity;

/**
 * 规则表(SysAuthRule)实体类
 *
 * @author wa.huang
 * @since 2020-04-09 16:54:50
 */
public class SysAuthRule extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
    * 规则
    */
    private String conditions;
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

    
    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
    
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

}