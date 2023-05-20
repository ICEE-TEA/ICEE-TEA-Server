package com.example.iceeteaserver.domain.email.service.impl

import com.example.iceeteaserver.domain.email.entity.EmailAuth
import com.example.iceeteaserver.domain.email.exception.EmailNotFoundException
import com.example.iceeteaserver.domain.email.exception.MismatchAuthkeyException
import com.example.iceeteaserver.domain.email.presentation.dto.request.EmailVerifyRequest
import com.example.iceeteaserver.domain.email.repository.EmailAuthRepository
import com.example.iceeteaserver.domain.email.service.EmailVerifyService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Objects


@Service
class EmailVerifyServiceImpl(
    private val emailAuthRepository: EmailAuthRepository
) : EmailVerifyService{

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(emailVerifyRequest: EmailVerifyRequest) {
        val emailAuth = emailAuthRepository.findById(emailVerifyRequest.email)
            .orElseThrow { EmailNotFoundException() }
        verifyAuthKey(emailAuth,emailVerifyRequest.authKey)
        emailAuth.updateAuthentication(true)
        emailAuthRepository.save(emailAuth)
    }

    fun verifyAuthKey(emailAuth: EmailAuth, authKey: String) {
        if (!Objects.equals(emailAuth.randomValue,authKey)) {
            throw MismatchAuthkeyException()
        }
    }

}