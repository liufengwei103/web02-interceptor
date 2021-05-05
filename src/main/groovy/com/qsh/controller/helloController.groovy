package com.qsh.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class helloController {

    @GetMapping("/hello")
    String hello() {
        return "hello 1"
    }

    @GetMapping("/home")
    String home() {
        return "home 2"
    }

    @GetMapping("/getTest")
    String getTest() {
        return "get test"
    }
}
