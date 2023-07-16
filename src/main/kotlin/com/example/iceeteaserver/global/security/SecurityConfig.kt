package com.example.iceeteaserver.global.security

import com.example.iceeteaserver.global.security.handler.CustomAccessDeniedHandler
import com.example.iceeteaserver.global.security.handler.CustomAuthenticationEntryPoint
import com.example.iceeteaserver.global.filter.config.FilterConfig
import com.example.iceeteaserver.global.security.jwt.JwtParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtParser: JwtParser
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .cors()
            .and()
            .csrf().disable()
            .httpBasic().disable()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()

            // auth
            .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
            .antMatchers(HttpMethod.PATCH, "/auth/**").permitAll()

            // email
            .antMatchers(HttpMethod.POST, "/email/**").permitAll()
            .antMatchers(HttpMethod.GET, "/email/**").permitAll()

            // member
            .antMatchers(HttpMethod.GET, "/member/**").authenticated()

            // purchase
            .antMatchers(HttpMethod.POST, "/purchase/**").authenticated()
            .antMatchers(HttpMethod.GET, "/purchase/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/purchase/**").authenticated()

            // admin
            .antMatchers(HttpMethod.GET, "/admin/**").hasAuthority("ADMIN")

            // health
            .antMatchers(HttpMethod.GET, "/health/**").permitAll()

            .anyRequest().permitAll()
            .and()

            .exceptionHandling()
            .accessDeniedHandler(CustomAccessDeniedHandler())
            .and()
            .httpBasic()
            .authenticationEntryPoint(CustomAuthenticationEntryPoint())
            .and()

            .apply(FilterConfig(jwtParser))
            .and()
            .build()

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}