package com.michael.idp.controllers.server.controllers.scim

import com.michael.idp.models.User
import com.michael.idp.repository.UserRepository
import com.unboundid.scim2.common.types.Name
import com.unboundid.scim2.common.types.UserResource
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest - same as teh above, but does not auto configure the entire app. Its better for just testing http layer
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var userRepository: UserRepository

    @BeforeEach
    fun before() {
        userRepository.deleteAll()
    }

    @Test
    fun testGet() {
        val scimUser = UserResource()
        scimUser.userName = "hey"
        scimUser.id = "fakeId"
        val user = User(scimUser)

        userRepository.save(user)

        this.mockMvc.perform(MockMvcRequestBuilders.get("/scim/v2/Users"))
            .andExpect(jsonPath("$.totalResults").value(1))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

}