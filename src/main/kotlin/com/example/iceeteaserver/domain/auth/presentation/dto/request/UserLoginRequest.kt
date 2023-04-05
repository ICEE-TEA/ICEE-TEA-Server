package com.example.iceeteaserver.domain.auth.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserLoginRequest (
    @NotBlank
    val email : String,
    @NotBlank
    val password : String
)