package com.qsh.controller

import com.qsh.domain.User
import groovy.util.logging.Slf4j
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpSession

@Slf4j
@RestController
@RequestMapping("/login")
class LoginController {
    @GetMapping
    String login() {
        return "登录页login"
    }

    @PostMapping
    String loginSubmit(User user, HttpSession session, Model model) {
        log.info("登录用户信息：${user}")
        if (user.username && user.password == '123456') {
            session.setAttribute("loginUser", user)
            return "登录提交成功！"
        } else {
            model.addAttribute("msg", "账号密码错误")
            return "账号密码错误"
        }
    }
}
