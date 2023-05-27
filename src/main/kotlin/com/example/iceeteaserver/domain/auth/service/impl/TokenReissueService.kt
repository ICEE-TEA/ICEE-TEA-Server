package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.repository.RefreshTokenRepository
import com.example.iceeteaserver.domain.auth.service.TokenReissuance
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import com.example.iceeteaserver.global.security.exception.ExpiredTokenException
import com.example.iceeteaserver.global.security.exception.InvalidTokenException
import com.example.iceeteaserver.global.security.jwt.JwtGenerator
import com.example.iceeteaserver.global.security.jwt.JwtParser
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.security.auth.login.AccountNotFoundException


@Service
class TokenReissueService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val memberRepository: MemberRepository,
    private val jwtGenerator: JwtGenerator,
    private val jwtParser: JwtParser
) : TokenReissuance {
    @Transactional(rollbackFor = [Exception::class])
    override fun execute(refreshToken: String): TokenResponse {
        val parsedRefreshToken = jwtParser.parseRefreshToken(refreshToken) ?: throw InvalidTokenException()
        val refreshToken = refreshTokenRepository.findByIdOrNull(parsedRefreshToken) ?: throw ExpiredTokenException()
        val member = memberRepository.findByEmail(refreshToken.email) ?: throw AccountNotFoundException()

        return jwtGenerator.generateToken(member.email, member.role)
    }

}