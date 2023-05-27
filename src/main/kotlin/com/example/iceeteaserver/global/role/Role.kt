package com.example.iceeteaserver.global.role

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ADMIN, MEMBER;

    override fun getAuthority(): String {
        return name
    }
    
}