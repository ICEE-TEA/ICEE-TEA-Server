package com.example.iceeteaserver.domain.auth.service

import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest

interface UserSignupService {
    fun execute(userSignupRequest: UserSignupRequest)
}