package com.qsh.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * 定制springMVC的web功能：必须实现WebMvcConfigurer接口
 */
@Configuration
class WebConfig implements WebMvcConfigurer {

    /**
     * 拦截器使用步骤：
     * 1、编写一个拦截器实现HandlerInterceptor接口
     * 2、拦截器注册到容器中（实现WebMvcConfigurer中的addInterceptors）
     * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
     */
    //把自定义的拦截器放到容器中
//    @Override
//    void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**") //拦截哪些(所有请求都会被拦截，包括静态资源)
//                .excludePathPatterns("/", "/index.html", "/login", "/error", "css/**") //放行哪些
//    }
}
