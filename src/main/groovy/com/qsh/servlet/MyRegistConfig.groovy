package com.qsh.servlet

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * 1.Myservlet -->处理的路径是/my
 * 2.DispatcherServlet -->要处理的路径是/
 */

/**
 * 1.@Configuration 标注这是一个配置类
 * 2.把Filter Servlet Listener 都放在容器中
 *
 * @Configuration(proxyBeanMethods = true):保证依赖的组件始终是单实例的
 */

@Configuration(proxyBeanMethods = true)
class MyRegistConfig {

    @Bean
    ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet()
        return new ServletRegistrationBean(myServlet, "/my", "/my02")
    }

    @Bean
    FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter()

//        return new FilterRegistrationBean(myFilter, myServlet())

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter)
        filterRegistrationBean.setUrlPatterns(["/my", "/css/*"])
        return filterRegistrationBean
    }

    @Bean
    ServletListenerRegistrationBean myListener() {
        MyServletContextListener myServletContextListener = new MyServletContextListener()

        return new ServletListenerRegistrationBean(myServletContextListener)
    }
}
