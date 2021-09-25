package com.michael.idp.controllers.server.controllers.oauth

import com.michael.idp.models.Properties
import org.springframework.web.bind.annotation.*

/*
* https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.1
* really kinda of just a proxy, you dont need the approve/deny here
* */
@RestController
@RequestMapping("/server")
class ApproveController {

    @GetMapping("/approve")
    fun approve(
        @RequestParam client_id: String,
        @RequestParam response_type: String,
        @RequestParam redirect_uri: String,
        @RequestParam state: String
        ): String {
        println("approve")
        //TODO Generate authCode
        val code = 123


        //This should be a redirectView, but teh ajax that calls this controller wont allow me to redirect
        //https://stackoverflow.com/questions/46694393/spring-boot-redirect-and-refresh-model-and-page
        return "$redirect_uri?code=${code}&state=$state"
    }
}