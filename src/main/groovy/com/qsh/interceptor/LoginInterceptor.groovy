package com.qsh.interceptor

import groovy.util.logging.Slf4j
import org.springframework.lang.Nullable
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * 登录拦截器
 * 1.必须实现HandlerInterceptor
 * 2.写好拦截逻辑
 *
 * 3.将拦截器放置到容器中（放的同时，配置好拦截哪些请求）
 */
@Slf4j
class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     */
    @Override
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI()
        log.info("preHandle请求路径：${requestURI}")

        //登录检查逻辑
        HttpSession session = request.getSession()
        Object loginUser = session.getAttribute("loginUser")
        if (loginUser) {
            //放行
            return true
        }

        //拦截住（未登录，跳转到登录页面）
        request.setAttribute("msg", '请先登录')
        log.info("请先登录，跳转到登录页")
//        request.getRequestDispatcher("/login").forward(request, response)

        return false
    }

    /**
     * 目标方法执行之后，页面渲染之前
     */
    @Override
    void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行：{modelAndView}")
        super.postHandle(request, response, handler, modelAndView)
    }

    /**
     * 页面渲染之后
     */
    @Override
    void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("afterCompletion执行：{ex}")
        super.afterCompletion(request, response, handler, ex)
    }
}
