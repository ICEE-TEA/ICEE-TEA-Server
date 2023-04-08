package com.example.iceeteaserver.domain.purchase.service.impl

import com.example.iceeteaserver.domain.purchase.entity.Purchase
import com.example.iceeteaserver.domain.purchase.presentation.dto.request.PurchaseRequest
import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import com.example.iceeteaserver.domain.purchase.service.PurchaseIceteaService
import com.example.iceeteaserver.global.util.MemberUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class PurchaseIceteaServiceImpl(
    private val purchaseRepository: PurchaseRepository,
    private val memberUtils: MemberUtils
) : PurchaseIceteaService{
    @Transactional
    override fun execute(purchaseRequest : PurchaseRequest) {
        purchaseRepository.save(Purchase(purchaseRequest.flavor,purchaseRequest.size,purchaseRequest.pay,memberUtils.currentMember()))
    }
}