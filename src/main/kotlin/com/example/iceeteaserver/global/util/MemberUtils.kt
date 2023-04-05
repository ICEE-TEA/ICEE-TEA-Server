package com.example.iceeteaserver.global.util

import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.domain.member.exception.MemberNotFoundException
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import com.example.iceeteaserver.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberUtilImpl(
    private val memberRepository: MemberRepository
) {
    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    fun currentMember(): Member {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val email = if (principal is UserDetails) {
            (principal as AuthDetails).username
        } else {
            principal.toString()
        }
        return findMemberByEmail(email)
    }

    fun findMemberByEmail(email: String): Member =
        memberRepository.findByEmail(email) ?: throw MemberNotFoundException()
}