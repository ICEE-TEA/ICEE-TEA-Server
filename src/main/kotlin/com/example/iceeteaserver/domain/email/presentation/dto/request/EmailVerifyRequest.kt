package com.example.iceeteaserver.domain.email.presentation.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class EmailVerifyRequest(
    @field:NotBlank
    @field:Email
    val email : String,
    @field:NotBlank
    val authKey : String
)
