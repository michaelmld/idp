package com.michael.idp.controllers.server.controllers.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/*
* Three methods of sending bearer access tokens in resource requests to resource servers.
* 1. Authorization Request Header Field
* - Authorization: Bearer 987tghjkiu6trfghjuytrghj
* - Clients SHOULD make authenticated requests with a bearer token using
   the "Authorization" request header field with the "Bearer" HTTP
   authorization scheme.  Resource servers MUST support this method.
   *
* 2. Form-Encoded Body Parameter (Not Recommended)
* - access_token=mF_9.B5f-4.1JqM
*
* 3. URI Query Parameter (This method is recommended by OAuth only as a last resort when the other two methods aren’t applicable.)
* - https://server.example.com/resource?access_token=mF_9.B5f-4.1JqM&p=q
*
* OAuth does not define any particular values for scopes, since it is highly dependent on the service's internal architecture and needs.
*
* @see [[https://livebook.manning.com/book/oauth-2-in-action/chapter-4/20]]
* @see [[https://datatracker.ietf.org/doc/html/rfc6750]]
* */
@RestController
class ProtectedResourceController {

    @GetMapping("/resource")
    fun approve(): String {

        /*
        * The resource server can validate the access token quite a few ways.
        * 1. Check against a shared DB
        * 2. Check claims in a JWT
        *
        *
        * */


        //TODO i can add scope to the access token and check scopes

        println("get resource")
        return "someResource"
    }
}