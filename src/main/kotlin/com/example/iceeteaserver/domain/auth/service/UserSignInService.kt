package com.example.iceeteaserver.domain.auth.service

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse

interface UserSignInService {
    fun execute(memberDto: MemberDto): TokenResponse
}