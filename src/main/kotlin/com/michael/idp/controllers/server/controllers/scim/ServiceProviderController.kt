package com.michael.idp.controllers.server.controllers.scim

import com.unboundid.scim2.common.messages.ListResponse
import com.unboundid.scim2.common.types.EnterpriseUserExtension
import com.unboundid.scim2.common.types.SchemaResource
import com.unboundid.scim2.common.types.UserResource
import com.unboundid.scim2.common.utils.SchemaUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scim/v2")
class ServiceProviderController {
    //https://www.rfc-editor.org/rfc/rfc7644#section-4
    //ServiceProviderConfigResource

    private val schemas: List<SchemaResource> = listOf(
        SchemaUtils.getSchema(UserResource::class.java),
        SchemaUtils.getSchema(EnterpriseUserExtension::class.java)
    )

    /**
     * Returns all the schemas in the database
     */
    fun getAllSchemas(): ListResponse<SchemaResource> {
        return ListResponse<SchemaResource>(schemas)
    }

    /**
     * Returns a specific schema
     * @param uri the schema to get
     */
    fun getSchema(uri: String): SchemaResource? {
        return schemas.find { it.id == uri }
    }
}