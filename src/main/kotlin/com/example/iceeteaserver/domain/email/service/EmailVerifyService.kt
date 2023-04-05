package com.example.iceeteaserver.domain.email.service

interface EmailVerifyService {
    fun execute(email : String, authKey : String)
}