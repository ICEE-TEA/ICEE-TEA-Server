package com.example.iceeteaserver.domain.auth.util.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignInRequest
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.global.role.Role
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountConvertImpl : AccountConverter {
    override fun todo(userSignupRequest: UserSignupRequest): MemberDto =
        MemberDto(
            UUID.randomUUID(),
            userSignupRequest.email,
            userSignupRequest.password,
            userSignupRequest.passwordCheck,
            userSignupRequest.name,
            Role.MEMBER
        )

    override fun todo(userLoginRequest: UserSignInRequest): MemberDto =
        MemberDto(UUID.randomUUID(), userLoginRequest.email, userLoginRequest.password, "", "", Role.MEMBER)

    override fun toEntity(userSignupRequest: UserSignupRequest, encodePassword: String): Member =
        Member(
            idx = UUID.randomUUID(),
            email = userSignupRequest.email,
            password = encodePassword,
            name = userSignupRequest.name,
            role = Role.MEMBER
        )

}