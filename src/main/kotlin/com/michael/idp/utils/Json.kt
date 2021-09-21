package com.michael.idp.utils

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.Reader

object Json {
    val objectMapper: ObjectMapper = jacksonObjectMapper()
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    inline fun <reified T> fromJson(input: String): T? =
        try {
            fromJsonSafe(input) as T
        } catch (e: MismatchedInputException) {
            null
        }

    inline fun <reified T> fromJson(input: Reader): T? =
        try {
            fromJsonSafe(input) as T
        } catch (e: MismatchedInputException) {
            null
        }

    inline fun <reified T> fromJsonSafe(string: String): T = objectMapper.readValue(string)
    inline fun <reified T> fromJsonSafe(stream: Reader): T = objectMapper.readValue(stream)

    fun toJson(any: Any?): String = objectMapper.writeValueAsString(any)
}