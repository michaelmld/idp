package com.michael.idp.controllers.server.filters

import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders.AUTHORIZATION
import java.lang.RuntimeException

class AccessTokenFilter: OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {

        try {
            request.getHeader(AUTHORIZATION)?.let { authHeader ->
                if (authHeader.isNullOrEmpty()) {
                    throw RuntimeException("no auth header found")
                }
            }
        } catch (e: Exception) {
            println("well i have no auth header or its invald " + e.message)
        }
        filterChain.doFilter(request, response)
    }
}