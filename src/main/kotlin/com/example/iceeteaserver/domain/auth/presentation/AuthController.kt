package com.example.iceeteaserver.domain.auth.presentation

import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserLoginRequest
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.service.UserLoginService
import com.example.iceeteaserver.domain.auth.service.UserSignupService
import com.example.iceeteaserver.domain.auth.service.impl.TokenReissuanceService
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/auth")
class AuthController(
    private val userSignupService: UserSignupService,
    private val userLoginService: UserLoginService,
    private val tokenReissuanceService: TokenReissuanceService,
    private val accountConverter: AccountConverter
) {

    @PostMapping("/signup")
    fun signup(@RequestBody userSignupRequest: UserSignupRequest) : ResponseEntity<Void>{
        accountConverter.todo(userSignupRequest)
            .let { userSignupService.execute(it) }
            .let { return ResponseEntity.status(HttpStatus.CREATED).build() }
    }

    @PostMapping("/login")
    fun login(@RequestBody userLoginRequest: UserLoginRequest) : ResponseEntity<TokenResponse>{
        accountConverter.todo(userLoginRequest)
            .let { userLoginService.execute(it) }
            .let { return ResponseEntity.ok(it) }
    }

    @PatchMapping
    fun reIssueToken(@RequestHeader("RefreshToken") refreshToken : String) : ResponseEntity<TokenResponse>{
        tokenReissuanceService.execute(refreshToken)
            .let { return ResponseEntity.ok(it) }

    }

}