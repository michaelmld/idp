package com.michael.idp.controllers.aws

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/helloworld")
    fun helloWorld(): String {
        return "hello world"
    }

    @GetMapping("/")
    fun health(): String {
        return "ok"
    }
}