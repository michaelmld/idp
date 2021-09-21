package com.michael.idp.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

/*
* https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.1
*
* */
@Controller
class AuthorizeController {

    @GetMapping("/authorize")
    fun authorize(@RequestParam client_id: String,
                  @RequestParam response_type: String,
                  @RequestParam state: String,
                  @RequestParam redirect_uri: String): ModelAndView {
        println("authorize")
        val mv = ModelAndView("server/approveDeny")
        mv.addObject("client_id", client_id)
        mv.addObject("response_type", response_type)
        mv.addObject("redirect_uri", redirect_uri)
        mv.addObject("state", state) // Adding cross-site protection with the state parameter
        //TODO look at spec. Do a bunch of validations.
        return mv
    }
}