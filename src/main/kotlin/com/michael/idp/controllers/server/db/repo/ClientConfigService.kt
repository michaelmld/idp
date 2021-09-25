package com.michael.idp.controllers.server.db.repo

import com.michael.idp.controllers.server.db.model.ClientConfig
import org.springframework.stereotype.Service

@Service
class ClientConfigService(val db: ClientConfigRepository) {
    fun getLocalClientConfig(): ClientConfig {
        return db.findById("123").get()
    }
}