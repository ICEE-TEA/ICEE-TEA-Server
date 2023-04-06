package com.example.iceeteaserver.domain.purchase.service

interface PurchaseIceteaService {
    fun execute(flavor:String, size:Long, pay:String)
}