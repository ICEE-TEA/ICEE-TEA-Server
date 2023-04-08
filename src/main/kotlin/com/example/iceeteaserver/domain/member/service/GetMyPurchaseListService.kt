package com.example.iceeteaserver.domain.member.service

import com.example.iceeteaserver.domain.purchase.presentation.dto.response.PurchaseResponse

interface GetMyPurchaseListService {
    fun execute() : List<PurchaseResponse>
}