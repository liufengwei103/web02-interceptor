package com.qsh.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * @ResponseStatus+自定义异常
 * @ResponseStatus：表示异常可以返回状态码信息
 * value指定http状态码
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason="用户数量太多")
class UserTooManyException extends RuntimeException {

}
