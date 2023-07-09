package com.example.iceeteaserver.domain.purchase.repository

import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.domain.purchase.entity.Purchase
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PurchaseRepository : CrudRepository<Purchase, UUID> {
    fun findByMember(member: Member): List<Purchase>
    fun findByMemberName(name: String): List<Purchase>
}