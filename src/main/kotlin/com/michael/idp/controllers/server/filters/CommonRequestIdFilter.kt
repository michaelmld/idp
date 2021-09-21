package com.michael.idp.controllers.server.filters

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CommonRequestIdFilter: OncePerRequestFilter() {

    companion object {
        const val COMMON_REQUEST_ID = "Common-Request-Id"
    }

    override fun doFilterInternal(request: HttpServletRequest,
                                  response: HttpServletResponse,
                                  filterChain: FilterChain) {
        println("do filter!!!!!")
        var commonRequestId = request.getHeader(COMMON_REQUEST_ID)
        if (commonRequestId == null) {
            commonRequestId = "common_req_id"
            response.addHeader(COMMON_REQUEST_ID, commonRequestId)
        }
        filterChain.doFilter(request, response)

    }
}