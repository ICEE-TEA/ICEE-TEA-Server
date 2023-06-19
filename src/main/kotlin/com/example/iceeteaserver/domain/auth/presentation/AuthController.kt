package com.example.iceeteaserver.domain.auth.presentation

import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignInRequest
import com.example.iceeteaserver.domain.auth.presentation.dto.request.UserSignupRequest
import com.example.iceeteaserver.domain.auth.presentation.dto.response.TokenResponse
import com.example.iceeteaserver.domain.auth.service.UserSignInService
import com.example.iceeteaserver.domain.auth.service.UserSignupService
import com.example.iceeteaserver.domain.auth.service.impl.TokenReissueService
import com.example.iceeteaserver.domain.auth.util.AccountConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/auth")
class AuthController(
    private val userSignupService: UserSignupService,
    private val userLoginService: UserSignInService,
    private val tokenReissueService: TokenReissueService,
    private val accountConverter: AccountConverter
) {
    @PostMapping("/signup")
    fun signup(@RequestBody userSignupRequest: UserSignupRequest): ResponseEntity<Void> =
        userSignupService.execute(userSignupRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("/signin")
    fun login(@RequestBody userLoginRequest: UserSignInRequest): ResponseEntity<TokenResponse> =
        accountConverter.todo(userLoginRequest)
            .let { userLoginService.execute(it) }
            .let { ResponseEntity.ok(it) }

    @PatchMapping
    fun reIssueToken(@RequestHeader("RefreshToken") refreshToken: String): ResponseEntity<TokenResponse> =
        tokenReissueService.execute(refreshToken)
            .let { ResponseEntity.ok(it) }

}