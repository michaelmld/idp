package com.michael.idp.models

import com.fasterxml.jackson.annotation.JsonProperty
//TODO letes go back and match the spec 1:1

data class TokenInput(
    val code: String?,
    val redirect_uri: String,
    val client_id: String,
    val client_secret: String,
    val grant_type: String
)

//https://datatracker.ietf.org/doc/html/rfc6749#section-5.1
data class TokenOutput(
    val token_type: String, //https://datatracker.ietf.org/doc/html/rfc6749#section-7.1 ("Bearer")
    val id_token: String,
    val access_token: String,
    val expires_in: Int, // RECOMMENDED in spec
    val refresh_token: String? = null,
    val scope: String? = null
)

const val GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code"
const val GRANT_TYPE_REFRESH_TOKEN = "refresh_token"
