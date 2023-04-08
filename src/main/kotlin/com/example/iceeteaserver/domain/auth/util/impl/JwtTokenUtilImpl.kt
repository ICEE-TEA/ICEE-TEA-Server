package com.example.iceeteaserver.domain.auth.util.impl

import com.example.iceeteaserver.domain.auth.entity.RefreshToken
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.repository.RefreshTokenRepository
import com.example.iceeteaserver.domain.auth.util.JwtTokenUtil
import com.example.iceeteaserver.domain.member.exception.MemberNotFoundException
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import com.example.iceeteaserver.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class JwtTokenUtilImpl(
    private val jwtTokenProvider: JwtTokenProvider,
    private val memberRepository: MemberRepository,
    private val refreshTokenRepository: RefreshTokenRepository

) : JwtTokenUtil {

    @Transactional
    override fun generateToken(email: String): TokenResponse {
        val member = memberRepository.findByEmail(email) ?: MemberNotFoundException()
        val accessToken = jwtTokenProvider.generateAccessToken(email)
        val refreshToken = jwtTokenProvider.generateRefreshToken(email)
        refreshTokenRepository.save(RefreshToken(email,refreshToken))
        return TokenResponse(accessToken,refreshToken,jwtTokenProvider.accessExpiredTime)
    }
}