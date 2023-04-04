package com.example.iceeteaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties
class IceeTeaServerApplication

fun main(args: Array<String>) {
    runApplication<IceeTeaServerApplication>(*args)
}
