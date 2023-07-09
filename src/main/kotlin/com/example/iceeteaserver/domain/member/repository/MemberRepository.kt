package com.example.iceeteaserver.domain.member.repository

import com.example.iceeteaserver.domain.member.entity.Member
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MemberRepository : CrudRepository<Member, UUID> {
    fun findByEmail(email: String?): Member?
    fun existsByEmail(email: String?): Boolean
}