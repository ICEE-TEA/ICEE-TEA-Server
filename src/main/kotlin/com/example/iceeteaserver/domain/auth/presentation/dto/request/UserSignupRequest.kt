package com.example.iceeteaserver.domain.auth.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserSignupRequest(
    @NotBlank
    val email : String,
    @NotBlank
    val password : String,
    @NotBlank
    val passwordCheck : String,
    @NotBlank
    val name : String,

)
