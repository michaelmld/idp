package com.michael.idp.repository

import com.michael.idp.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String>