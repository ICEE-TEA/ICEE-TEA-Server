package com.example.iceeteaserver.domain.purchase.presentation.dto.request

import javax.validation.constraints.NotBlank

data class PurchaseRequest(
    @field:NotBlank
    val flavor : String,
    @field:NotBlank
    val size : Long,
    @field:NotBlank
    val pay : String
)