package com.example.iceeteaserver.domain.purchase.schedule

import com.example.iceeteaserver.domain.purchase.service.ResetPurchaseIceteaService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class PurchaseSchedule(
    private val resetPurchaseIceteaService: ResetPurchaseIceteaService
) {
    @Scheduled(cron = "0 0 0 ? * MON-FRI")
    fun weekdayPurchaseStatusReset(){
        resetPurchaseIceteaService.execute()
    }

}