package com.example.iceeteaserver.domain.auth.util.impl

import com.example.iceeteaserver.domain.auth.exception.MismatchPasswordException
import com.example.iceeteaserver.domain.auth.exception.NotVerifyEmailException
import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.type.ValidatorType
import com.example.iceeteaserver.domain.auth.util.AccountValidator
import com.example.iceeteaserver.domain.email.repository.EmailAuthRepository
import org.springframework.stereotype.Component


@Component
class AccountValidatorImpl(
    private val emailAuthRepository: EmailAuthRepository
) : AccountValidator{

    fun validateSignUp(memberDto: MemberDto){
        if(!emailAuthRepository.findById(memberDto.email).get().authentication) {
            throw NotVerifyEmailException()
        }
        if(memberDto.password != memberDto.passwordCheck){
            throw MismatchPasswordException()
        }

    }
    override fun validate(validatorType: ValidatorType, memberDto: MemberDto) {
        validateSignUp(memberDto)
    }
}