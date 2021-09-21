package com.michael.idp.models

data class OAuthConfig(val client_id: String,
                       val client_secret: String,
                       val redirectUris: List<String>)

data class AuthorizeInput(
        val response_type: String,
        val client_id: String,
        val redirect_uri: String?,
        val scope: String?,
        //State should be used to prevent CSRF attack
//        val state: String,
)



object InMemDatabase {
    val TestClient: OAuthConfig = OAuthConfig("randomId", "randomSecret", listOf("localhost:8080/callback"))
    val Configs: List<OAuthConfig> = listOf(TestClient)
}