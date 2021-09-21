package com.michael.idp.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping


/*
* If i change this to rest controller itll just return string
*
* */
@Controller
class HtmlController {

    @GetMapping("/login")
    fun blog(model: Model): String {
        model["name"] = "Blog"
        return "client/login"
    }

}