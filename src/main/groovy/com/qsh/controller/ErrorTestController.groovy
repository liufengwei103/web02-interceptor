package com.qsh.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ErrorTestController {

    @GetMapping("/test500")
    String test500Error(){
        def m = 10/0

        return "500error"
    }
}
