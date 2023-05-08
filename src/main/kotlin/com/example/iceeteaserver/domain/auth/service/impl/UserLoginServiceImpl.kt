package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.presentation.dto.type.ValidatorType
import com.example.iceeteaserver.domain.auth.service.UserLoginService
import com.example.iceeteaserver.domain.auth.util.AccountValidator
import com.example.iceeteaserver.domain.auth.util.JwtTokenUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserLoginServiceImpl(
    private val accountValidator: AccountValidator,
    private val jwtTokenUtil: JwtTokenUtil
) : UserLoginService{

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(memberDto: MemberDto): TokenResponse =
        accountValidator.validateLogin(memberDto)
            .let { jwtTokenUtil.generateToken(memberDto.email) }

}