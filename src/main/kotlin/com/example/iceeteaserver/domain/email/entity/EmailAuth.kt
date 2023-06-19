package com.example.iceeteaserver.domain.email.entity

import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "emailAuth", timeToLive = 60 * 30)
class EmailAuth(

    @Id
    val email: String,
    var randomValue: String,
    var authentication: Boolean,
    @ColumnDefault("1")
    var attemptCount: Int
) {

    fun updateAuthentication(authentication: Boolean) {
        this.authentication = authentication
    }

    fun updateRandomValue(randomValue: String) {
        this.randomValue = randomValue
    }

    fun increaseAttemptCount() {
        this.attemptCount += 1
    }
}