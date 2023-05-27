package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.exception.MismatchPasswordException
import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.service.UserSignInService
import com.example.iceeteaserver.domain.member.exception.MemberNotFoundException
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import com.example.iceeteaserver.global.security.jwt.JwtGenerator
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserSignInServiceImpl(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtGenerator: JwtGenerator
) : UserSignInService {
    @Transactional(rollbackFor = [Exception::class])
    override fun execute(memberDto: MemberDto): TokenResponse =
        validateLogin(memberDto)
            .let { jwtGenerator.generateToken(memberDto.email, memberDto.role) }

    private fun validateLogin(memberDto: MemberDto) {
        memberRepository.findByEmail(memberDto.email)
            .let { it ?: throw MemberNotFoundException() }
            .let { passwordEncoder.matches(memberDto.password, it.password) }
            .let {
                if (it)
                    return
                else throw MismatchPasswordException()
            }
    }

}