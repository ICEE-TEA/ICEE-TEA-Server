package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.presentation.dto.type.ValidatorType
import com.example.iceeteaserver.domain.auth.service.UserLoginService
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import com.example.iceeteaserver.domain.auth.util.AccountValidator
import com.example.iceeteaserver.domain.auth.util.JwtTokenUtil
import com.example.iceeteaserver.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserLoginServiceImpl(
    private val accountValidator: AccountValidator,
    private val jwtTokenUtil: JwtTokenUtil
) : UserLoginService{
    @Transactional
    override fun execute(memberDto: MemberDto): TokenResponse =
        accountValidator.validate(ValidatorType.LOGIN,memberDto)
            .let { jwtTokenUtil.generateToken(memberDto.email) }
}