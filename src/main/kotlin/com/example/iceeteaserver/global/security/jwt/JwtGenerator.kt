package com.example.iceeteaserver.global.security.jwt

import com.example.iceeteaserver.domain.auth.entity.RefreshToken
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.repository.RefreshTokenRepository
import com.example.iceeteaserver.global.role.Role
import com.example.iceeteaserver.global.security.jwt.properties.JwtExpTimeProperties
import com.example.iceeteaserver.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtGenerator(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProperties: JwtProperties,
    private val jwtExpTimeProperties: JwtExpTimeProperties
) {

    fun generateToken(email: String, role: Role): TokenResponse =
        TokenResponse(
            accessToken = generateAccessToken(email, role),
            refreshToken = generateRefreshToken(email),
            accessTokenExp = LocalDateTime.now().plusSeconds(jwtExpTimeProperties.accessExp.toLong()),
            refreshTokenExp = LocalDateTime.now().plusSeconds(jwtExpTimeProperties.refreshExp.toLong())
        )

    fun generateAccessToken(email: String, role: Role): String =
        Jwts.builder()
            .signWith(jwtProperties.accessSecret, SignatureAlgorithm.HS256)
            .setHeaderParam("typ", "JWT")
            .setSubject(email)
            .claim(JwtProperties.TOKEN_TYPE, JwtProperties.ACCESS_TYPE)
            .claim(JwtProperties.AUTHORITY, role)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtExpTimeProperties.accessExp * 1000))
            .compact()

    fun generateRefreshToken(email: String): String {
        val refreshToken = Jwts.builder()
            .signWith(jwtProperties.refreshSecret, SignatureAlgorithm.HS256)
            .setHeaderParam("typ", "JWT")
            .setSubject(email)
            .claim(JwtProperties.TOKEN_TYPE, JwtProperties.REFRESH_TYPE)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtExpTimeProperties.refreshExp * 1000))
            .compact()

        refreshTokenRepository.save(RefreshToken(email, refreshToken, jwtExpTimeProperties.refreshExp))
        return refreshToken
    }

}