package com.example.iceeteaserver.domain.email.service

import com.example.iceeteaserver.domain.email.presentation.dto.request.EmailSendRequest

interface EmailSendService {
    fun execute(emailSendRequest: EmailSendRequest)
}