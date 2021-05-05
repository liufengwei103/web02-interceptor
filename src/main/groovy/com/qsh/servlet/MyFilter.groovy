package com.qsh.servlet

import groovy.util.logging.Slf4j

import javax.servlet.*
/**
 * 1.创建一个Filter,必须实现Filter接口
 * 2.@WebFilter,标注这是一个Filter
 * 3.urlPatterns 设置filter拦截路径
 * 注意：*单星是servlet的写法，**双星是spring的写法
 */

@Slf4j
//@WebFilter(urlPatterns = ["/hello","/home","css/*"])
class MyFilter implements Filter {

    @Override
    void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成")
    }

    @Override
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("MyFilter工作")
        chain.doFilter(request, request)
    }

    @Override
    void destroy() {
        log.info("MyFilter销毁了")
    }
}
