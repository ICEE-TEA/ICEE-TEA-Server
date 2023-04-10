package com.example.iceeteaserver.domain.auth.repository

import com.example.iceeteaserver.domain.auth.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String> {
    fun findByToken(token: String): RefreshToken?
}