package com.qsh.servlet

import groovy.util.logging.Slf4j

import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
/**
 * 1.创建一个Filter，继承ServletContextListener接口
 * 2.@WebFilter,标注这是一个监听器
 */

@Slf4j
//@WebFilter
class MyServletContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyServletContextListener监听的项目初始化完成")
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyServletContextListener监听的项目销毁")
    }
}
