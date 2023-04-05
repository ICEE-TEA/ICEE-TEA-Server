package com.example.iceeteaserver.domain.auth.service

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto

interface UserSignupService {
    fun execute(memberDto: MemberDto)
}