package com.michael.idp.controllers.client

import com.michael.idp.controllers.server.db.repo.ClientConfigService
import com.michael.idp.models.GRANT_TYPE_AUTHORIZATION_CODE
import com.michael.idp.models.Properties.LOCALHOST
import com.michael.idp.models.TokenInput
import com.michael.idp.models.TokenOutput
import com.michael.idp.utils.Constants
import com.michael.idp.utils.Json
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.ModelAndView


/*
*
* We have both the client and server in 1 code base.
* The client submodule asks as an Oauth2.0 client. This is where the /authorize redirects back to.
*
* */

@RestController
@RequestMapping("/client")
class CallbackController(private val service: ClientConfigService) {

    val logger = LoggerFactory.getLogger(CallbackController::class.java)

    @GetMapping("/okta-callback")
    fun oktaToken(
        @RequestParam code: String,
        @RequestParam state: String
    ): ModelAndView {
        logger.info("hey!!!!!!!!")
        println("callback $code")


        val clientId = "0oa4a6dhyl82JZLWs5d7"
        val clientSecret = "ZidUekITb7xTSPWL-0daj_1Q-xU8FOX_jX7lrgla"
        //https://dev-22415998.okta.com/oauth2/default/.well-known/oauth-authorization-server
        //https://dev-22415998.okta.com/oauth2/default/v1/authorize

//        if (LocalCache.state != state) {
//            println("BAD STATE")
//        }

        val localConfig = service.getLocalClientConfig()

//        val tokenInput = TokenInput(
//            code,
//            "http://localhost:8080/client/okta-callback",
//            client_id = clientId,
//            clientSecret,
//            GRANT_TYPE_AUTHORIZATION_CODE
//        )
        val client = OkHttpClient()


//        val postBody: RequestBody = Json.toJson(tokenInput).toRequestBody(MediaType.APPLICATION_JSON_VALUE.toMediaTypeOrNull())

//        val postBody: RequestBody =
//            Json.toJson(tokenInput).toRequestBody(MediaType.APPLICATION_FORM_URLENCODED_VALUE.toMediaType())

        val postBody: RequestBody = FormBody.Builder()
            .add("code", code)
            .add("client_id", clientId)
            .add("client_secret", clientSecret)
            .add("redirect_uri", "http://localhost:8080/client/okta-callback")
            .add("grant_type", GRANT_TYPE_AUTHORIZATION_CODE)
            .build()
//        val buffer = Buffer()


        //TODO - Headers
        val oktaAuthServer = "https://dev-22415998.okta.com/oauth2/default/v1/token"
        val request: Request = Request.Builder()
            .url(oktaAuthServer)
            //Not sure why this doenst wokr hoenstly
            .post(postBody)
            .build()


//        request.body!!.writeTo(buffer)
//        logger.info(buffer.readUtf8())
//        buffer.close()


        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                val tokenOutput: TokenOutput? = Json.fromJson<TokenOutput>(response.body!!.string())


                val mv = ModelAndView("client/login")
                mv.addObject("accessToken", tokenOutput!!.access_token)

                return mv
            } else {
                logger.error(response.body!!.string())
                println(response.code)
                println(response.body!!.string())
                throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "bad stuff")
            }

        }
    }

    @GetMapping("/callback")
    fun token(
        @RequestParam code: String,
        @RequestParam state: String
    ): ModelAndView {
        println("callback $code")


        if (LocalCache.state != state) {
            println("BAD STATE")
        }

        val localConfig = service.getLocalClientConfig()

        val tokenInput = TokenInput(code, "", "", "", GRANT_TYPE_AUTHORIZATION_CODE)
        val client = OkHttpClient()
        val postBody: RequestBody =
            Json.toJson(tokenInput).toRequestBody(MediaType.APPLICATION_JSON_VALUE.toMediaTypeOrNull())


        //TODO - Headers
        val request: Request = Request.Builder()
            .url(LOCALHOST + "/server/token")
            //Not sure why this doenst wokr hoenstly
            .header(Constants.CSRF_TOKEN_HEADER, "newToken")
            .post(postBody)
            .build()


        client.newCall(request).execute().use { response ->
            if (response.isSuccessful) {
                logger.info("success")
                val tokenOutput: TokenOutput? = Json.fromJson<TokenOutput>(response.body!!.string())


                val mv = ModelAndView("client/login")
                mv.addObject("accessToken", tokenOutput!!.access_token)

                return mv
            } else {
                logger.error("failure exchanging token")
                println(response.body!!.string())
                throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "bad stuff")
            }

        }
    }
}

// Cs Okta - JPh-azeRxT6TXqqBcdHYjY-A2JxnHLiGlCS6hjw6
//Client Id - 0oa3v5rkztlcXiKHZ5d7