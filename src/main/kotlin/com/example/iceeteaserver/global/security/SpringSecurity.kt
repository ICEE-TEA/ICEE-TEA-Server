package com.example.iceeteaserver.global.security

import com.example.iceeteaserver.global.filter.JwtTokenFilter
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
    private val jwtTokenFilter: JwtTokenFilter
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
            .antMatchers(HttpMethod.DELETE, "/auth/**").authenticated()
            .antMatchers(HttpMethod.PATCH, "/auth/password/initialize").permitAll()

            // email
            .antMatchers(HttpMethod.POST,"/email/**").permitAll()
            .antMatchers(HttpMethod.GET,"/email/**").permitAll()


            // member
            .antMatchers(HttpMethod.PATCH, "/member/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/member/**").authenticated()

            // application
            .antMatchers(HttpMethod.POST,"/application/**").authenticated()
            .antMatchers(HttpMethod.GET, "/application/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/application/**").authenticated()

            .anyRequest().denyAll()
            .and()
            .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()

    @Bean
    open fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}