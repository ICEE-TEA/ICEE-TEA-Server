package com.example.iceeteaserver.domain.purchase.repository

import com.example.iceeteaserver.domain.purchase.entity.Purchase
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<Purchase,Long> {
}