package com.michael.idp.controllers

import com.michael.idp.models.TokenInput
import com.michael.idp.models.TokenOutput
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class TokenController {

    //Might want to take in authorization header
    @PostMapping("/token")
    fun token(@RequestBody tokenInput: TokenInput): TokenOutput? {
        println(tokenInput.code)

        val tokenOutput = TokenOutput("Bearer", "idT","accesToken", -1)
        return tokenOutput
    }
}