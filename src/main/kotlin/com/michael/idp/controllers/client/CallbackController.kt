package com.michael.idp.controllers.client

import com.michael.idp.models.Properties.LOCALHOST
import com.michael.idp.models.TokenInput
import com.michael.idp.models.TokenOutput
import com.michael.idp.utils.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
class CallbackController {

    @GetMapping("/callback")
    fun token(@RequestParam code: String,
              @RequestParam state: String): String? {
        println("callback $code")

        //TODO check that state matches expected state on client
        //protects against CSRF

        val tokenInput = TokenInput(code, null, null, null)
        val client = OkHttpClient()
        val postBody: RequestBody = Json.toJson(tokenInput).toRequestBody(MediaType.APPLICATION_JSON_VALUE.toMediaTypeOrNull())


        //TODO - Headers
        val request: Request = Request.Builder()
            .url(LOCALHOST + "/token")
            .post(postBody)
            .build()

        client.newCall(request).execute().use { response ->
            val tokenOutput = Json.fromJson<TokenOutput>(response.body.toString())
            return tokenOutput?.accessToken
        }
    }
}