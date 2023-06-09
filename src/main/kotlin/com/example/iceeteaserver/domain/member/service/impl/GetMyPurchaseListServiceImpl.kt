package com.example.iceeteaserver.domain.member.service.impl

import com.example.iceeteaserver.domain.auth.util.MemberUtil
import com.example.iceeteaserver.domain.member.service.GetMyPurchaseListService
import com.example.iceeteaserver.domain.purchase.converter.MyPurchaseConverter
import com.example.iceeteaserver.domain.purchase.presentation.dto.response.PurchaseResponse
import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetMyPurchaseListServiceImpl(
    private val purchaseRepository: PurchaseRepository,
    private val myPurchaseConverter: MyPurchaseConverter,
    private val memberUtil: MemberUtil
) : GetMyPurchaseListService {
    @Transactional(rollbackFor = [Exception::class])
    override fun execute(): List<PurchaseResponse> =
        purchaseRepository.findByMember(memberUtil.currentMember())
            .map { myPurchaseConverter.toMyPurchaseResponse(it) }

}