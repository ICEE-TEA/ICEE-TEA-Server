package com.example.iceeteaserver.domain.member.service.impl

import com.example.iceeteaserver.domain.admin.converter.PurchaseConverter
import com.example.iceeteaserver.domain.member.service.GetMyPurchaseListService
import com.example.iceeteaserver.domain.purchase.converter.MyPurchaseConverter
import com.example.iceeteaserver.domain.purchase.presentation.dto.response.PurchaseResponse
import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import com.example.iceeteaserver.global.util.MemberUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class GetMyPurchaseListServiceImpl (
    private val purchaseRepository: PurchaseRepository,
    private val myPurchaseConverter: MyPurchaseConverter,
    private val memberUtils: MemberUtils
) : GetMyPurchaseListService{

    @Transactional
    override fun execute(): List<PurchaseResponse> {
        val member = memberUtils.currentMember()
        return purchaseRepository.findByMember(member)
            .map { myPurchaseConverter.toMyPurchaseResponse(it) }
    }
}