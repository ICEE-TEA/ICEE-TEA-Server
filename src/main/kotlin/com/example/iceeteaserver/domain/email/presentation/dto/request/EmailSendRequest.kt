package com.example.iceeteaserver.domain.email.presentation.dto.request

import javax.validation.constraints.NotBlank

data class EmailSendRequest(
    @NotBlank
    val email : String
)
