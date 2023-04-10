package com.example.iceeteaserver.domain.auth.presentation.dto

import com.example.iceeteaserver.global.role.Role

data class MemberDto(
    val userId: Long,
    val email: String,
    val password: String,
    val passwordCheck: String,
    val name: String,
    val role: Role
)