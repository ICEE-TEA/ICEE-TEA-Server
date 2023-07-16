package com.example.iceeteaserver.global.filter.config

import com.example.iceeteaserver.global.filter.ExceptionHandlerFilter
import com.example.iceeteaserver.global.filter.JwtRequestFilter
import com.example.iceeteaserver.global.filter.RequestLogFilter
import com.example.iceeteaserver.global.security.jwt.JwtParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtParser: JwtParser
): SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(RequestLogFilter(), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(JwtRequestFilter(jwtParser), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(ExceptionHandlerFilter(), JwtRequestFilter::class.java)
    }

}