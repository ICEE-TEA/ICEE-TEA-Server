package com.example.iceeteaserver.domain.auth.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserSignupRequest(
    @field:NotBlank
    val email : String,
    @field:NotBlank
    val password : String,
    @field:NotBlank
    val passwordCheck : String,
    @field:NotBlank
    val name : String,

)
