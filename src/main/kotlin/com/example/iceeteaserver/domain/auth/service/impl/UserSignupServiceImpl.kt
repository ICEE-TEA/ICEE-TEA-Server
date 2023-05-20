package com.example.iceeteaserver.domain.auth.service.impl

import com.example.iceeteaserver.domain.auth.exception.DuplicateEmailException
import com.example.iceeteaserver.domain.auth.exception.MismatchPasswordException
import com.example.iceeteaserver.domain.auth.exception.NotVerifyEmailException
import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.auth.service.UserSignupService
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import com.example.iceeteaserver.domain.email.repository.EmailAuthRepository
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception


@Service
class UserSignupServiceImpl(
    private val memberRepository: MemberRepository,
    private val accountConverter: AccountConverter,
    private val passwordEncoder: PasswordEncoder
) : UserSignupService{

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(userSignupRequest: UserSignupRequest) {
        memberValidator(userSignupRequest)
            .let {  accountConverter.toEntity(userSignupRequest,passwordEncoder.encode(userSignupRequest.password)) }
            .let {  memberRepository.save(it) }
    }

    private fun memberValidator(userSignupRequest: UserSignupRequest) {
        if (memberRepository.existsByEmail(userSignupRequest.email)) {
            throw DuplicateEmailException()
        }
        if (userSignupRequest.password!=(userSignupRequest.passwordCheck)){
            throw MismatchPasswordException()
        }
//        val emailAuth = emailAuthRepository.findByIdOrNull(email) ?: throw NotVerifyEmailException()
//
//        if(!emailAuth.authentication) {
//            throw NotVerifyEmailException()
//        }
    }
}