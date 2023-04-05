package com.example.iceeteaserver.global.security.jwt.auth

import com.example.iceeteaserver.domain.member.entity.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val member: Member
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = member.role

    override fun getPassword(): String? = null

    override fun getUsername(): String = member.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = isAccountNonExpired && isAccountNonLocked && isCredentialsNonExpired

}