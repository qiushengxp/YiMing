package com.yiming.common.core.conntroller;

import com.yiming.common.core.domain.AjaxResult;
import com.yiming.common.utils.DateUtils;
import com.yiming.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-04-04 09:39
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Long 时间戳
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Long 类型转换
        binder.registerCustomEditor(Long.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseTimestamp(text));
            }
        });
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return
     */
    public AjaxResult success(String msg) {
        return AjaxResult.success(msg);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return
     */
    public AjaxResult success(String msg, Object data) {
        return AjaxResult.success(msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return
     */
    public AjaxResult error(String msg) {
        return AjaxResult.error(msg);
    }

    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }
}
