//package com.michael.idp
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.annotation.Order
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository
//import org.springframework.security.web.util.matcher.AnyRequestMatcher
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector
//
//@EnableWebSecurity()
//open class CustomSecurityConfig {
//
//    @Configuration
//    open class UnauthenticatedNoSessionSecurityConfig : WebSecurityConfigurerAdapter() {
//
//        @Autowired
//        private lateinit var tokenRepository: SessionCsrfTokenRepository
//
//        override fun configure(http: HttpSecurity) {
//            //https://stackoverflow.com/questions/33117989/spring-boot-starter-security-post-methods-not-working
//            //https://stackoverflow.com/questions/38820342/disable-csrf-protection-for-specific-url-pattern-in-spring-boot
//            //I couldnt do a post to /token....
//            http.cors().and()
//                .csrf().csrfTokenRepository(tokenRepository).ignoringAntMatchers("/server/token", "/scim/v2/Users").and()
//                .httpBasic().disable()
//        }
//    }
//}