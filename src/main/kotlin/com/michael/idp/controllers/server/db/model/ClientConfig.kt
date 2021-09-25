package com.michael.idp.controllers.server.db.model

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class ClientConfig(
    @Id var clientId: String? = null,
    val clientName: String? = null,
    val redirectUris: String = "",
)