package com.example.iceeteaserver.domain.purchase.service

import com.example.iceeteaserver.domain.purchase.presentation.dto.request.PurchaseRequest

interface PurchaseIceteaService {
    fun execute(purchaseRequest: PurchaseRequest)
}