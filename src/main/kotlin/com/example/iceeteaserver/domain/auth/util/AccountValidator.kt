package com.example.iceeteaserver.domain.auth.util

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto

interface AccountValidator {
    fun validateSignUp(memberDto: MemberDto)
    fun validateLogin(memberDto: MemberDto)
}