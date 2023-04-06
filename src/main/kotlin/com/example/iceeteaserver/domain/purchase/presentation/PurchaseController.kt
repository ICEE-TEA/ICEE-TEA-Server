package com.example.iceeteaserver.domain.purchase.presentation

import com.example.iceeteaserver.domain.purchase.service.PurchaseIceteaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/purchase")
class PurchaseController (
    private val purchaseIceteaService: PurchaseIceteaService
){
    @GetMapping
    fun purchaseTea(@RequestParam flavor:String, @RequestParam size:Long,@RequestParam pay:String) : ResponseEntity<Void> {
        purchaseIceteaService.execute(flavor,size,pay)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}