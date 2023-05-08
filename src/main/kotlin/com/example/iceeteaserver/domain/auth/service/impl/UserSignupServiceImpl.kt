package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.service.UserSignupService
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import com.example.iceeteaserver.domain.auth.util.AccountValidator
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception


@Service
class UserSignupServiceImpl(
    private val memberRepository: MemberRepository,
    private val accountValidator: AccountValidator,
    private val accountConverter: AccountConverter,
    private val passwordEncoder: PasswordEncoder
) : UserSignupService{

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(memberDto: MemberDto) {
        accountValidator.validateSignUp(memberDto)
            .let {  accountConverter.toEntity(memberDto,passwordEncoder.encode(memberDto.password)) }
            .let {  memberRepository.save(it) }
    }
}