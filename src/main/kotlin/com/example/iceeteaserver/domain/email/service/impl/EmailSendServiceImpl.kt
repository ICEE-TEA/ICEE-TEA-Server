package com.example.iceeteaserver.domain.email.service.impl

import com.example.iceeteaserver.domain.email.entity.EmailAuth
import com.example.iceeteaserver.domain.email.exception.EmailSendFailException
import com.example.iceeteaserver.domain.email.exception.ManyEmailRequestException
import com.example.iceeteaserver.domain.email.presentation.dto.request.EmailSendRequest
import com.example.iceeteaserver.domain.email.repository.EmailAuthRepository
import com.example.iceeteaserver.domain.email.service.EmailSendService
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.mail.MessagingException

@Service
class EmailSendServiceImpl(
    private val mailSender: JavaMailSender,
    private val emailAuthRepository: EmailAuthRepository
) : EmailSendService {

    @Transactional(rollbackFor = [Exception::class])
    override fun execute(emailSendRequest: EmailSendRequest) {
        val authKey = generateCertificationNumber(9999)
        sendEmail(emailSendRequest.email, authKey)
    }

    fun sendEmail(email: String, authKey: String) {
        val subject = "아이스티 맛있게 먹자~~"
        val content = "ICEE-TEA 인증번호는 " + authKey + "입니다"
        val emailAuth = emailAuthRepository.findById(email)
            .orElse(EmailAuth(email,authKey,false,0))
        if(emailAuth.attemptCount >=5) {
            throw ManyEmailRequestException()
        }
        emailAuth.updateRandomValue(authKey)
        emailAuth.authentication
        emailAuthRepository.save(emailAuth)

        try {
            val mimeMailMessage = mailSender.createMimeMessage()
            val helper = MimeMessageHelper(mimeMailMessage,true,"utf8")
            helper.setTo(email)
            helper.setSubject(subject)
            helper.setText(content)
            mailSender.send(mimeMailMessage)
        } catch (e : MessagingException) {
            throw EmailSendFailException()
        }
    }
    fun generateCertificationNumber(number: Int = 9999) = (0..number).random()
        .toString()
        .padStart(number.toString().length, '0')
}