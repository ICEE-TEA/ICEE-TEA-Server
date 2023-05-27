package com.example.iceeteaserver.domain.purchase.presentation

import com.example.iceeteaserver.domain.purchase.presentation.dto.request.PurchaseRequest
import com.example.iceeteaserver.domain.purchase.service.PurchaseIceteaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/purchase")
class PurchaseController(
    private val purchaseIceteaService: PurchaseIceteaService
) {
    @PostMapping
    fun purchaseTea(@RequestBody @Valid purchaseRequest: PurchaseRequest): ResponseEntity<Void> =
        purchaseIceteaService.execute(purchaseRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

}