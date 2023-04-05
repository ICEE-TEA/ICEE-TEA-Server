package com.example.iceeteaserver.domain.auth.util

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserLoginRequest
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.member.entity.Member

interface AccountConverter {
    fun todo(userSignupRequest: UserSignupRequest) : MemberDto
    fun todo(userLoginRequest: UserLoginRequest) : MemberDto

    fun toEntity(memberDto: MemberDto, encodePassword : String) : Member
}