package com.michael.idp.controllers.server.controllers.oauth

import com.michael.idp.utils.Constants.CSRF_TOKEN_HEADER
import com.michael.idp.utils.Json
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/server")
class CsrfController {

    @ResponseBody
    @GetMapping("/csrf")
    fun csrfToken(request: HttpServletRequest): ResponseEntity<String> {
        val token: String? = request.session.getAttribute(CSRF_TOKEN_HEADER) as? String

        val t: String = if (token == null) {
            request.session.setAttribute(CSRF_TOKEN_HEADER, "newToken")
            "newToken"
        } else {
            token
        }

        val jsonPayload = Json.toJson(
            mapOf(
                "csrfToken" to t
            )
        )
        return ResponseEntity(jsonPayload, HttpStatus.OK)
    }
}
