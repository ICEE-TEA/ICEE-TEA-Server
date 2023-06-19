package com.example.iceeteaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
class IceeTeaServerApplication
fun main(args: Array<String>) {
    runApplication<IceeTeaServerApplication>(*args)
}
