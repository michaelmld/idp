package com.michael.idp.models

import com.michael.idp.utils.Json
import com.unboundid.scim2.common.types.UserResource
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    scimUser: UserResource,
    @Column(columnDefinition="TEXT")
    var scimUserBlob: String? = null,
    @Id val id: String = UUID.randomUUID().toString()
) {

    init {
        this.scimUserBlob = Json.objectMapper.writeValueAsString(scimUser)
    }

//    @Transient
//    var scimUser = scimUser
//        set(value) {
//            this.scimUserBlob = Json.objectMapper.writeValueAsString(scimUser)
//            field = value
//        }

    init {
//        scimUserBlob = Json.objectMapper.writeValueAsString(scimUser)
    }

//    fun getScimUser(): UserResource {
//        return Json.objectMapper.readValue(this.scimUserBlob, UserResource::class.java)
//    }
}