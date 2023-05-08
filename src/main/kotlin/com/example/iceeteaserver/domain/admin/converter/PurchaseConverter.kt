package com.example.iceeteaserver.domain.admin.converter

import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse
import com.example.iceeteaserver.domain.member.presentation.dto.response.MemberResponse
import com.example.iceeteaserver.domain.purchase.entity.Purchase
import org.springframework.stereotype.Component

@Component
class PurchaseConverter{
    fun toPurchaseResponse(purchase: Purchase, member : MemberResponse): GetBuyerListResponse {
        val getBuyerListResponse = GetBuyerListResponse(
            purchase.flavor,
            purchase.size,
            purchase.pay,
            member
        )
        return getBuyerListResponse
    }
}