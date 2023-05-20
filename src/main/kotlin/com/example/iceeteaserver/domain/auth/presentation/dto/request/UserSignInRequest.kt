package com.example.iceeteaserver.domain.auth.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserSignInRequest (
    @field:NotBlank
    val email : String,
    @field:NotBlank
    val password : String
)