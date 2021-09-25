package com.michael.idp

import com.michael.idp.controllers.server.db.model.ClientConfig
import com.michael.idp.controllers.server.db.repo.ClientConfigRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfigConfiguration {

    @Bean
    fun dataBaseInit(clientConfigRepository: ClientConfigRepository) = ApplicationRunner {
        clientConfigRepository.save(
            ClientConfig(
                clientId = "123",
                clientName = "Michael's Client",
                redirectUris = "http://localhost:8080/client/callback"
            )
        )
    }
}