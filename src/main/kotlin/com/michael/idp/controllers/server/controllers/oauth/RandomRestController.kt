package com.michael.idp.controllers.server.controllers.oauth

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/internal")
class RandomRestController {

    @GetMapping("/foo")
    fun index(): String {
        return "Hello World"
    }

    @GetMapping("/getFoo")
    fun getFoos(@RequestParam id: String): String? {
        return "ID: $id"
    }
}
