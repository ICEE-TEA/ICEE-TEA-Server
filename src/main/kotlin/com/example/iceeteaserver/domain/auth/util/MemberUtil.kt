package com.example.iceeteaserver.domain.auth.util

import com.example.iceeteaserver.domain.member.entity.Member

interface MemberUtil {
    fun currentMember(): Member
    fun findMemberByEmail(email: String): Member
}