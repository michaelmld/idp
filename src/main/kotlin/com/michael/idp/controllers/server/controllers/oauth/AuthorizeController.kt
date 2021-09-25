package com.michael.idp.controllers.server.controllers.oauth

import com.michael.idp.controllers.server.db.model.ClientConfig
import com.michael.idp.controllers.server.db.repo.ClientConfigRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.ModelAndView
import java.util.*

/*
* https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.1
* TODO cross reference the doc to make sure we do everyhting
*
* Serves front channel interactions
*
* TODO if there was an error then we apend it to the redirectUri
*  https://client.example.org/cb?
 iss=https%3A%2F%2Fc2id.com
 &error=invalid_request
 &error_description=Unsupported%20response_type%20value
 &state=af0ifjsldkj
* */
@Controller
@RequestMapping("/server")
class AuthorizeController(private val repository: ClientConfigRepository) {

    @GetMapping("/authorize")
    fun authorize(@RequestParam client_id: String,
                  @RequestParam response_type: String,
                  @RequestParam state: String,
                  @RequestParam scope: String?,
                  @RequestParam redirect_uri: String?): ModelAndView {
        println("authorize")

        val maybeClientConfig: ClientConfig? = repository.findById(client_id).unwrap()
        val clientConfig = maybeClientConfig ?:throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "unknown client id")

        if (response_type != "code") {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "exepected code")
        }

        //Check RedirectUri matches the one in DB

        val mv = ModelAndView("server/approveDeny")
        mv.addObject("client_id", client_id)
        mv.addObject("response_type", response_type)
        mv.addObject("redirect_uri", redirect_uri)
        mv.addObject("state", state)
        //TODO look at spec. Do a bunch of validations.

        return mv
    }
}

//Optional is java concept...https://stackoverflow.com/questions/38767376/how-to-map-java-util-optionalsomething-to-something-in-kotlin
fun <T> Optional<T>.unwrap(): T? = orElse(null)
