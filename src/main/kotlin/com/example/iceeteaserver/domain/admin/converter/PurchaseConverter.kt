package com.example.iceeteaserver.domain.admin.converter

import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse
import com.example.iceeteaserver.domain.member.converter.MemberConverter
import com.example.iceeteaserver.domain.member.presentation.dto.response.MemberResponse
import com.example.iceeteaserver.domain.purchase.entity.Purchase
import org.springframework.stereotype.Component


@Component
class PurchaseConverter(
    private val memberConverter: MemberConverter
) {
    fun toPurchaseResponse(purchase: Purchase) =
        GetBuyerListResponse(purchase.flavor,purchase.size,purchase.pay,memberConverter.toPurchaseResponse(purchase.member))
}