package com.example.iceeteaserver.domain.admin.service.impl

import com.example.iceeteaserver.domain.admin.converter.PurchaseConverter
import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse
import com.example.iceeteaserver.domain.admin.service.GetBuyerListService
import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class GetBuyerListServiceImpl(
    private val purchaseRepository: PurchaseRepository,
    private val purchaseConverter: PurchaseConverter
) : GetBuyerListService{
    @Transactional
    override fun execute(): List<GetBuyerListResponse> =
        purchaseRepository.findAll()
            .map { purchaseConverter.toPurchaseResponse(it) }
}