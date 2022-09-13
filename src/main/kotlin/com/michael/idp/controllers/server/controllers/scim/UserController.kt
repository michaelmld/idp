package com.michael.idp.controllers.server.controllers.scim

import com.michael.idp.models.User
import com.michael.idp.repository.UserRepository
import com.michael.idp.utils.Json
import com.unboundid.scim2.common.messages.ListResponse
import com.unboundid.scim2.common.types.UserResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/scim/v2")
class UserController(val userRepository: UserRepository) {

    @PostMapping("/Users")
    fun createUser(@RequestBody scimUser: UserResource): UserResource? {
        val user = User(scimUser)
        userRepository.save(user)
        scimUser.id = user.id
        //We should exclude nulls lol
        return scimUser
    }

    @GetMapping("/Users/{id}")
    fun getUser(@PathVariable id: String): UserResource? {
         val scimUserBlob: String? = userRepository.findById(id).get().scimUserBlob
        return Json.objectMapper.readValue(scimUserBlob, UserResource::class.java)
    }

    @GetMapping("/Users")
    fun getAllUsers(): ListResponse<UserResource> {
        val scimUserList: List<UserResource> = userRepository.findAll().map { user ->
            Json.objectMapper.readValue(user.scimUserBlob, UserResource::class.java)
        }

        return ListResponse(scimUserList)
    }
}


//Perform CRUD operations on a user resource:
//1. Create
//2. Update
//3. Delete
//4. Get
//5. List
//6. Filter