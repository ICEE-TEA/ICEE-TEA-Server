package com.example.iceeteaserver.domain.member.repository

import com.example.iceeteaserver.domain.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member,Long> {
    fun findByEmail(email : String) : Member?
}