package com.example.iceeteaserver.domain.email.service

import com.example.iceeteaserver.domain.email.presentation.dto.request.EmailVerifyRequest

interface EmailVerifyService {
    fun execute(emailVerifyRequest: EmailVerifyRequest)
}