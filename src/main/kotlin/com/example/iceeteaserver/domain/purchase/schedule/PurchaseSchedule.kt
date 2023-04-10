package com.example.iceeteaserver.domain.purchase.schedule

import com.example.iceeteaserver.domain.purchase.service.DeletePurchaseIceteaService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class PurchaseSchedule(
    private val deletePurchaseIceteaService: DeletePurchaseIceteaService
) {
    @Scheduled(cron = "0 0 0 ? * MON-FRI")
    fun weekdayPurchaseStatusReset(){
        deletePurchaseIceteaService.execute()
    }

}