package com.example.iceeteaserver.domain.purchase.converter

import com.example.iceeteaserver.domain.purchase.entity.Purchase
import com.example.iceeteaserver.domain.purchase.presentation.dto.response.PurchaseResponse
import org.springframework.stereotype.Component

@Component
class MyPurchaseConverter {
    fun toMyPurchaseResponse(purchase: Purchase) =
        PurchaseResponse(purchase.flavor,purchase.size,purchase.pay)

}