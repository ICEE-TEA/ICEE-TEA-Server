package com.example.iceeteaserver.domain.member.presentation

import com.example.iceeteaserver.domain.member.service.GetMyPurchaseListService
import com.example.iceeteaserver.domain.purchase.presentation.dto.response.PurchaseResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/member")
class MemberController(
    private val getMyPurchaseListService: GetMyPurchaseListService
) {

    @GetMapping
    fun getMyPurchase() : ResponseEntity<List<PurchaseResponse>>{
        return getMyPurchaseListService.execute()
            .let { ResponseEntity.ok(it) }
    }

}