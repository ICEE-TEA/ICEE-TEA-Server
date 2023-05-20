package com.example.iceeteaserver.global.security.jwt.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("jwt.time")
class JwtExpTimeProperties(
    val accessExp: Long,
    val refreshExp: Long
)