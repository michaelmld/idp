package com.michael.idp.controllers

import com.michael.idp.models.Properties
import org.springframework.web.bind.annotation.*

@RestController
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
        return "${Properties.LOCALHOST}/callback?code=${code}&state=$state"
    }
}