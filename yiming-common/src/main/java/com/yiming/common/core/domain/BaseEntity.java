package com.yiming.common.core.domain;

import com.yiming.common.utils.DateUtils;

import java.io.Serializable;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-03-24 10:31
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 信息编号
     */
    private Long id;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 创建人
     */
    private Long createBy;
    /**
     * 更新时间
     */
    private Long updateTime;
    /**
     * 更新人
     */
    private Long updateBy;
    /**
     * 删除时间
     */
    private Long deleteTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 删除标识
     */
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 将时间转换成字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getCreateTimeText() {
        return DateUtils.parseTimestampToStr(createTime);
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 将时间转换成字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getUpdateTimeText() {
        return DateUtils.parseTimestampToStr(updateTime);
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Long getDeleteTime() {
        return deleteTime;
    }

    /**
     * 将时间转换成字符串
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public String getDeleteTimeText() {
        return DateUtils.parseTimestampToStr(deleteTime);
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
