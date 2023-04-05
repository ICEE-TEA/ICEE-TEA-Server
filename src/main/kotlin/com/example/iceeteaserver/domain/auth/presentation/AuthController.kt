package com.example.iceeteaserver.domain.auth.presentation

import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.auth.service.UserSignupService
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthController(
    private val userSignupService: UserSignupService,
    private val accountConverter: AccountConverter
) {

    @PostMapping("/signup")
    fun signup(@RequestBody userSignupRequest: UserSignupRequest) : ResponseEntity<Void>{
        accountConverter.todo(userSignupRequest)
            .let { userSignupService.execute(it) }
            .let { return ResponseEntity.status(HttpStatus.CREATED).build() }
    }

}