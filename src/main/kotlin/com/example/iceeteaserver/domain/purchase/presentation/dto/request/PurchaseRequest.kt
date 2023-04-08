package com.example.iceeteaserver.domain.purchase.presentation.dto.request

import javax.validation.constraints.NotBlank

data class PurchaseRequest(
    @NotBlank
    val flavor : String,
    @NotBlank
    val size : Long,
    @NotBlank
    val pay : String
)