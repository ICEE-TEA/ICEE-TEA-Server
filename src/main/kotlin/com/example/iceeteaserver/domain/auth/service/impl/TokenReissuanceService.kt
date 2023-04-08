package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.repository.RefreshTokenRepository
import com.example.iceeteaserver.domain.auth.service.TokenReissuance
import com.example.iceeteaserver.domain.auth.util.JwtTokenUtil
import com.example.iceeteaserver.global.security.exception.ExpiredTokenException
import com.example.iceeteaserver.global.security.exception.InvalidTokenException
import com.example.iceeteaserver.global.security.jwt.JwtTokenProvider
import com.example.iceeteaserver.global.util.MemberUtils
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class TokenReissuanceService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val memberUtils: MemberUtils,
    private val jwtTokenUtil: JwtTokenUtil,
    private val jwtTokenProvider: JwtTokenProvider
) : TokenReissuance{

    @Transactional
    override fun execute(refreshToken: String): TokenResponse {
        val email = jwtTokenProvider.exactEmailFromRefreshToken(refreshToken)
        refreshTokenRepository.findByIdOrNull(email)
            .let { it ?: throw ExpiredTokenException() }
            .let {
                if (it.refreshToken!=refreshToken){
                    throw InvalidTokenException()
                }
            }
        return jwtTokenUtil.generateToken(email)
    }
}