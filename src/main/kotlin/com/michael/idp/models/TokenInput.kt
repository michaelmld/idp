package com.michael.idp.models

import com.fasterxml.jackson.annotation.JsonProperty
//TODO letes go back and match the spec 1:1

data class TokenInput(
    val code: String?,
    val redirect_uri: String?,
    val client_id: String?,
    val client_secret: String?,
)

//https://datatracker.ietf.org/doc/html/rfc6749#section-5.1
data class TokenOutput(
    val tokenType: String, //https://datatracker.ietf.org/doc/html/rfc6749#section-7.1
    val idToken: String,
    val accessToken: String,
    val expiresIn: Int, // RECOMMENDED in spec
    val refreshToken: String? = null
)