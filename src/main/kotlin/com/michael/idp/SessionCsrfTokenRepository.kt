//package com.michael.idp
//
//import com.michael.idp.utils.Constants.CSRF_TOKEN_HEADER
//import org.springframework.security.web.csrf.CsrfToken
//import org.springframework.security.web.csrf.CsrfTokenRepository
//import org.springframework.security.web.csrf.DefaultCsrfToken
//import org.springframework.stereotype.Component
//import java.util.*
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
//data class UPCCsrfToken(val header: String? = null, val name: String? = null,val token: String? = null)
//
//
//@Component
//class SessionCsrfTokenRepository : CsrfTokenRepository {
//
//    companion object {
//
//        fun createCsrfToken(): DefaultCsrfToken {
//            return UPCCsrfToken(CSRF_TOKEN_HEADER, CSRF_TOKEN_HEADER, UUID.randomUUID().toString())
//                .let {
//                    DefaultCsrfToken(it.header, it.name, it.token)
//                }
//        }
//    }
//
//    override fun generateToken(request: HttpServletRequest?): CsrfToken {
//        return createCsrfToken()
//    }
//
//    override fun saveToken(token: CsrfToken?, request: HttpServletRequest, response: HttpServletResponse) {
//        if (token == null) {
//            request.session.removeAttribute(CSRF_TOKEN_HEADER)
//        } else {
//            val t = UPCCsrfToken(token.headerName, token.parameterName, token.token)
//            request.session.setAttribute(CSRF_TOKEN_HEADER, t)
//        }
//    }
//
//    override fun loadToken(request: HttpServletRequest): CsrfToken? {
//        val t = request.session.getAttribute(CSRF_TOKEN_HEADER) as? UPCCsrfToken
//        println(t?.token)
//
//        return t?.let {
//            DefaultCsrfToken(it.header, it.name, it.token)
//        }
//    }
//}