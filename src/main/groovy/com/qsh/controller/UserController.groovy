package com.qsh.controller

import com.qsh.domain.User
import com.qsh.exception.UserTooManyException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    //@RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping
    String getUser() {
        return "getUser"
    }

    //@RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping("")
    String saveUser() {
        return "saveUser"
    }

    @GetMapping("/list")
    String list() {
        List<User> users = []
        users << new User(username: "张三",password: "123456")
        users << new User(username: "李四",password: "123456")
        users << new User(username: "黎明",password: "123456")
        users << new User(username: "赵丽颖",password: "123456")

        if(users.size()>3){
            throw new UserTooManyException()
        }

        return "getUser"
    }
}
