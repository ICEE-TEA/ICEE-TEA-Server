package com.example.iceeteaserver.domain.auth.service

import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse

interface TokenReissuance {
    fun execute(refreshToken : String) : TokenResponse
}