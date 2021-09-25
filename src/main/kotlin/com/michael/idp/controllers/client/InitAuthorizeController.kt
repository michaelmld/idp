package com.michael.idp.controllers.client

import com.michael.idp.controllers.server.db.repo.ClientConfigRepository
import com.michael.idp.controllers.server.db.repo.ClientConfigService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@RestController
@RequestMapping("/client")
class InitAuthorizeController(private val service: ClientConfigService) {

    @GetMapping("/init")
    fun init(): RedirectView {
        val state = "456"
        LocalCache.state = state

        val localClientConfig = service.getLocalClientConfig()

        return RedirectView("http://localhost:8080/server/authorize?client_id=${localClientConfig.clientId}&redirect_uri=${localClientConfig.redirectUris}&response_type=code&state=$state")
    }
}