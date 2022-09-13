//package com.michael.idp.controllers.server.filters
//
//import org.springframework.http.HttpHeaders.AUTHORIZATION
//import org.springframework.stereotype.Component
//import org.springframework.web.filter.OncePerRequestFilter
//import javax.servlet.FilterChain
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//@Component
//class AccessTokenFilter: OncePerRequestFilter() {
//
//    override fun doFilterInternal(request: HttpServletRequest,
//                                  response: HttpServletResponse,
//                                  filterChain: FilterChain) {
//
//        try {
//            println("TRYING TO FILTER FOR ACCESS TOKEN")
//            request.getHeader(AUTHORIZATION)?.let { authHeader ->
//                println("i found a auth header let me throw this exception")
//
//                if (authHeader.isNullOrEmpty()) {
//                    //Can we show an error page???
//                    throw RuntimeException("no auth header found")
//                } else {
//                    //Check if auth header is ok
//                    println("valid auth token " + authHeader)
//                    filterChain.doFilter(request, response)
//                }
//            }
//        } catch (e: Exception) {
//            //Can we show an error page???
//            println("well i have no auth header or its invald " + e.message)
//
//            response.sendError(404, "bad")
//        }
//
//        println("do chain")
//        filterChain.doFilter(request, response)
//    }
//
//    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
//        val path = request.servletPath
//        return path.startsWith("/server") || path.startsWith("/client")
//    }
//}