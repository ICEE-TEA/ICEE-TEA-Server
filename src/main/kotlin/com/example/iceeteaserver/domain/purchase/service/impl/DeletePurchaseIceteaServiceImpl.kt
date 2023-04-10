package com.example.iceeteaserver.domain.purchase.service.impl

import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import com.example.iceeteaserver.domain.purchase.service.DeletePurchaseIceteaService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeletePurchaseIceteaServiceImpl(
    private val purchaseRepository: PurchaseRepository
) : DeletePurchaseIceteaService{
    @Transactional
    override fun execute() {
        purchaseRepository.deleteAll()
    }
}