package com.michael.idp.controllers.server.db.repo

import com.michael.idp.controllers.server.db.model.ClientConfig
import org.springframework.data.repository.CrudRepository

interface ClientConfigRepository: CrudRepository<ClientConfig, String> {
}