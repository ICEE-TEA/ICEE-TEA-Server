package com.example.iceeteaserver.domain.purchase.service.impl

import com.example.iceeteaserver.domain.auth.util.MemberUtil
import com.example.iceeteaserver.domain.purchase.entity.Purchase
import com.example.iceeteaserver.domain.purchase.exception.NotExistFlavorException
import com.example.iceeteaserver.domain.purchase.presentation.dto.request.PurchaseRequest
import com.example.iceeteaserver.domain.purchase.repository.PurchaseRepository
import com.example.iceeteaserver.domain.purchase.service.PurchaseIceteaService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PurchaseIceteaServiceImpl(
    private val purchaseRepository: PurchaseRepository,
    private val memberUtil: MemberUtil
) : PurchaseIceteaService {

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(purchaseRequest: PurchaseRequest) {
        val flavor = purchaseRequest.flavor
        if (flavor != "청포도" || flavor != "복숭아" || flavor != "레몬") throw NotExistFlavorException()
        purchaseRepository.save(
            Purchase(
                UUID.randomUUID(),
                purchaseRequest.flavor,
                purchaseRequest.size,
                purchaseRequest.pay,
                memberUtil.currentMember()
            )
        )
    }

}