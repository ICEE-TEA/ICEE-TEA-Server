package com.example.iceeteaserver.domain.purchase.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class PurchaseRequest(
    @field:NotBlank
    val flavor: String,
    @field:NotNull
    val size: Long,
    @field:NotBlank
    val pay: String
)