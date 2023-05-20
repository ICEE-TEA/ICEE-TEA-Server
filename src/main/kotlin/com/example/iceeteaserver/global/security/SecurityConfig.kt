package com.example.iceeteaserver.global.security

import com.example.iceeteaserver.global.filter.JwtRequestFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val jwtRequestFilter: JwtRequestFilter
) {

    @Bean
    protected open fun filterChain(http: HttpSecurity): SecurityFilterChain =
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
            .antMatchers(HttpMethod.POST,"/email/**").permitAll()
            .antMatchers(HttpMethod.GET,"/email/**").permitAll()

            // member
            .antMatchers(HttpMethod.GET, "/member/**").authenticated()

            // purchase
            .antMatchers(HttpMethod.POST,"/purchase/**").authenticated()
            .antMatchers(HttpMethod.GET, "/purchase/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/purchase/**").authenticated()

            // admin
            .antMatchers(HttpMethod.GET, "/admin/**").hasAuthority("ADMIN")

            // health
            .antMatchers(HttpMethod.GET,"/").permitAll()

            .anyRequest().denyAll()
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()

    @Bean
    open fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}