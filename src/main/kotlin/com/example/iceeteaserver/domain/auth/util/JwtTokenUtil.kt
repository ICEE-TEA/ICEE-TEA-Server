package com.example.iceeteaserver.domain.auth.util

import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse

interface JwtTokenUtil {
    fun generateToken(email : String) : TokenResponse
}