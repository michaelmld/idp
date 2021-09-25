package com.michael.idp.controllers.server.controllers.oauth

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


/*
*
* Entry point to my dumb IDP, this will load the login page.
* The login page currently has 2 buttons, Authorize and GetProtectedResource
*
* If i change this to rest controller itll just return string
*
* */
@Controller
@RequestMapping("/server")
class LoginController {

    @GetMapping("/login")
    fun login(model: Model): String {
        println("LOGIN")
        model["name"] = "Blog"
        return "client/login"
    }

}