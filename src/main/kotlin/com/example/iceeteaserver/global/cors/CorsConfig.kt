package com.example.iceeteaserver.global.cors

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig : WebMvcConfigurer {
//
//    override
//    fun addCorsMappings(registry: CorsRegistry) {
//        registry.addMapping("/**")
//            .allowedOrigins("http://localhost:3000")
//            .allowedMethods(
//                HttpMethod.GET.name,
//                HttpMethod.POST.name,
//                HttpMethod.PUT.name,
//                HttpMethod.DELETE.name
//            )
//    }
}