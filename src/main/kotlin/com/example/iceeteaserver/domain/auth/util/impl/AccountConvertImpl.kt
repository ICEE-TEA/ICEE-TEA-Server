package com.example.iceeteaserver.domain.auth.util.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.global.role.Role
import org.springframework.stereotype.Component

@Component
class AccountConvertImpl : AccountConverter{
    override fun todo(userSignupRequest: UserSignupRequest): MemberDto =
        MemberDto(-1,userSignupRequest.email,userSignupRequest.password,userSignupRequest.passwordCheck,userSignupRequest.name,Role.MEMBER)

    override fun toEntity(memberDto: MemberDto, encodePassword: String): Member =
        Member(memberDto.email,encodePassword,memberDto.name, mutableListOf(Role.MEMBER))

}