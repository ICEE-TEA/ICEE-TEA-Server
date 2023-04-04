package com.example.iceeteaserver.domain.email.presentation

import com.example.iceeteaserver.domain.email.presentation.dto.request.EmailSendRequest
import com.example.iceeteaserver.domain.email.service.EmailSendService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/email")
class EmailController (
    private val emailSendService: EmailSendService
){
    @PostMapping("/send")
    fun sendEmail(@RequestBody @Valid emailSendRequest: EmailSendRequest) : ResponseEntity<Void> {
        emailSendService.execute(emailSendRequest)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

}