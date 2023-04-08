package com.example.iceeteaserver.domain.auth.util.impl

import com.example.iceeteaserver.domain.auth.exception.AlreadyExistEmailException
import com.example.iceeteaserver.domain.auth.exception.MismatchPasswordException
import com.example.iceeteaserver.domain.auth.exception.NotVerifyEmailException
import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.type.ValidatorType
import com.example.iceeteaserver.domain.auth.util.AccountValidator
import com.example.iceeteaserver.domain.email.repository.EmailAuthRepository
import com.example.iceeteaserver.domain.member.exception.MemberNotFoundException
import com.example.iceeteaserver.domain.member.repository.MemberRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component


@Component
class AccountValidatorImpl(
    private val emailAuthRepository: EmailAuthRepository,
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
) : AccountValidator {

    private fun validateSignUp(memberDto: MemberDto) {
        if(!emailAuthRepository.findById(memberDto.email).get().authentication) {
            throw NotVerifyEmailException()
        }
        if (memberRepository.existsByEmail(memberDto.email)) {
            throw AlreadyExistEmailException()
        }
        if (memberDto.password != memberDto.passwordCheck) {
            throw MismatchPasswordException()
        }
    }
    private fun validateLogin(memberDto: MemberDto) {
        memberRepository.findByEmail(memberDto.email)
            .let { it ?: throw MemberNotFoundException() }
            .let {
                passwordEncoder.matches(memberDto.password, it.password)
            }
            .let {
                if (it)
                    return
                else throw MismatchPasswordException()
            }
    }

    override fun validate(validatorType: ValidatorType, memberDto: MemberDto) {
        when (validatorType) {
            ValidatorType.SIGNUP -> validateSignUp(memberDto)
            ValidatorType.LOGIN -> validateLogin(memberDto)
        }
    }
}
