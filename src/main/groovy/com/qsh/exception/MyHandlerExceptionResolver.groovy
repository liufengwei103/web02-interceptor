package com.qsh.exception

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.lang.Nullable
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 自定义异常解析器
 * 只需@Component放到容器中即可
 * @Order (value=Ordered.HIGHEST_PRECEDENCE)  想让自定义异常解析器生效，要制定优先级，放到前面去(默认是最低优先级的)
 * 可以作为默认的全局异常处理规则
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)  //优先级：数字越小优先级越高
@Component
class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        httpServletResponse.sendError(511, '我自己定义的错误')
        return new ModelAndView()
    }
}
