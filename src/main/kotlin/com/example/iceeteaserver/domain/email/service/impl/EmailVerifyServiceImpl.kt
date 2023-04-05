package com.example.iceeteaserver.domain.email.service.impl

import com.example.iceeteaserver.domain.email.exception.EmailNotFoundException
import com.example.iceeteaserver.domain.email.exception.MismatchAuthkeyException
import com.example.iceeteaserver.domain.email.repository.EmailAuthRepository
import com.example.iceeteaserver.domain.email.service.EmailVerifyService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class EmailVerifyServiceImpl(
    private val emailAuthRepository: EmailAuthRepository
) : EmailVerifyService{

    @Transactional
    override fun execute(email: String, authKey: String) {
        val emailAuth = emailAuthRepository.findById(email)
            .orElseThrow {
                EmailNotFoundException()
            }
        if(emailAuth.randomValue != authKey){
            throw MismatchAuthkeyException()
        }
        emailAuth.updateAuthentication(true)
        emailAuthRepository.save(emailAuth)

    }


}