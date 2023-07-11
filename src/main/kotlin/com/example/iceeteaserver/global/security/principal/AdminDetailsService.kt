package com.example.iceeteaserver.global.security.principal

import com.example.iceeteaserver.domain.member.exception.MemberNotFoundException
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminDetailsService(
    private val memberRepository: MemberRepository
) : UserDetailsService {

    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun loadUserByUsername(username: String): UserDetails {
        val admin = memberRepository.findByEmail(username) ?: throw MemberNotFoundException()
        return AdminDetails(admin.email)
    }

}