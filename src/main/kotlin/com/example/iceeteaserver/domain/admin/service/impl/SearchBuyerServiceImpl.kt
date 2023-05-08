package com.example.iceeteaserver.domain.admin.service.impl

import com.example.iceeteaserver.domain.admin.converter.PurchaseConverter
import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse
import com.example.iceeteaserver.domain.admin.service.SearchBuyerService
import com.example.iceeteaserver.domain.member.converter.MemberConverter
import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class SearchBuyerServiceImpl (
    private val purchaseRepository: PurchaseRepository,
    private val purchaseConverter: PurchaseConverter,
    private val memberConverter: MemberConverter
) : SearchBuyerService {
    @Transactional(rollbackFor = [Exception::class])
    override fun execute(buyerName: String): List<GetBuyerListResponse> =
        purchaseRepository.findByMemberName(buyerName)
            .map { purchaseConverter.toPurchaseResponse(it,memberConverter.toPurchaseResponse(it.member)) }

}