package com.example.iceeteaserver.global.security.jwt

import com.example.iceeteaserver.global.role.Role
import com.example.iceeteaserver.global.security.auth.AdminDetailsService
import com.example.iceeteaserver.global.security.auth.MemberDetailsService
import com.example.iceeteaserver.global.security.exception.InvalidTokenException
import com.example.iceeteaserver.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.security.Key
import javax.servlet.http.HttpServletRequest

@Component
class JwtParser(
    private val jwtProperties: JwtProperties,
    private val memberDetailsService: MemberDetailsService,
    private val adminDetailsService: AdminDetailsService

) {

    fun parseAccessToken(request: HttpServletRequest): String? =
        request.getHeader(JwtProperties.TOKEN_HEADER)
            .let { it ?: return null }
            .let { if (it.startsWith(JwtProperties.TOKEN_PREFIX)) it.replace(JwtProperties.TOKEN_PREFIX, "") else null }

    fun parseRefreshToken(refreshToken: String): String? =
        if (refreshToken.startsWith(JwtProperties.TOKEN_PREFIX)) refreshToken.replace(JwtProperties.TOKEN_PREFIX, "") else null

    fun authentication(accessToken: String): Authentication =
        getAuthority(getTokenBody(accessToken, jwtProperties.accessSecret))
            .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    fun getTokenBody(token: String, secret: Key): Claims =
        Jwts.parserBuilder()
            .setSigningKey(secret)
            .build()
            .parseClaimsJws(token)
            .body

    private fun getAuthority(body: Claims): UserDetails =
        when (body.get(JwtProperties.AUTHORITY, String::class.java)) {
            Role.MEMBER.name -> memberDetailsService.loadUserByUsername(body.subject)
            Role.ADMIN.name -> adminDetailsService.loadUserByUsername(body.subject)
            else -> throw InvalidTokenException()
        }


}