package com.michael.idp.controllers.server

import com.michael.idp.models.Properties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProtectedResourceController {

    @GetMapping("/resource")
    fun approve(): String {
        println("get resource")
        return "someResource"
    }
}