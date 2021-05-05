package com.qsh.exception

import groovy.util.logging.Slf4j
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * @ControllerAdvice + @ExceptionHandler处理全局异常
 * 全局异常处理器：
 * 处理整个web controller的异常
 *
 */

@Slf4j
@ControllerAdvice
class GlobalExceptionHandler {

    /**
     * @ExceptionHandler ：代表标注的是异常处理器
     * ArithmeticException.class, NullPointerException.class 处理数学运算异常，空指针异常
     */
    @ExceptionHandler([ArithmeticException.class, NullPointerException.class])
    String handlerArithException(Exception e) {


        log.info("异常信息：${e}")
        return "error/error" //视图地址ModelAndView
    }
}
