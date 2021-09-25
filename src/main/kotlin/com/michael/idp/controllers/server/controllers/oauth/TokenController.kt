package com.michael.idp.controllers.server.controllers.oauth

import com.michael.idp.models.GRANT_TYPE_AUTHORIZATION_CODE
import com.michael.idp.models.GRANT_TYPE_REFRESH_TOKEN
import com.michael.idp.models.TokenInput
import com.michael.idp.models.TokenOutput
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/*
* https://openid.net/specs/openid-connect-core-1_0.html#TokenEndpoint
*
*
* https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.3
*
* well well well....looks like fugu is sending in clientSecret for no reason
*
* */
@RestController
@RequestMapping("/server")
class TokenController {

    //Might want to take in authorization header
    @PostMapping("/token")
    fun token(@RequestBody tokenInput: TokenInput): TokenOutput? {
        println("/token called")

        var tokenOutput: TokenOutput? = null
        //TODO
        if (tokenInput.grant_type == GRANT_TYPE_AUTHORIZATION_CODE) {
            tokenOutput = TokenOutput("Bearer", "idT","accesToken", -1)
        } else if (tokenInput.grant_type == GRANT_TYPE_REFRESH_TOKEN) {
            tokenOutput = TokenOutput("Bearer", "idT","accesToken", -1)
        } else {
            throw Exception("BAD GRAND TYPE")
        }

        return tokenOutput
    }

    @GetMapping("/fool")
    fun index(): String {
        return "Hello World"
    }
}