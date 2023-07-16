package com.example.iceeteaserver.domain.purchase.repository

import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.domain.purchase.entity.Purchase
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PurchaseRepository : JpaRepository<Purchase, UUID> {
    fun findByMember(member: Member): List<Purchase>
    fun findByMemberName(name: String): List<Purchase>
}