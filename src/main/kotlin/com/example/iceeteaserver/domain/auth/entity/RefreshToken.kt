package com.example.iceeteaserver.domain.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.concurrent.TimeUnit
import javax.persistence.Column

@RedisHash(value = "refreshToken", timeToLive = 60L * 60 * 24 * 7)
class RefreshToken(
    @Id
    val email: String,
    @Column(name = "refreshToken")
    val refreshToken: String,
    @TimeToLive(unit = TimeUnit.SECONDS)
    val expiredTime: Long
)