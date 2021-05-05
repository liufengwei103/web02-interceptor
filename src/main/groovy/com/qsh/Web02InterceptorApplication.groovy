package com.qsh

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan(basePackages = "com.qsh")
@SpringBootApplication
class Web02InterceptorApplication {

    static void main(String[] args) {
        SpringApplication.run(Web02InterceptorApplication, args)
    }

}
