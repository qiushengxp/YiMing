package com.yiming.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author:wa.huang
 * @CreateDate: 2020-03-22 14:21
 */
@Configuration
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan("com.yiming**.mapper")
public class ApplicationConfig {
}
