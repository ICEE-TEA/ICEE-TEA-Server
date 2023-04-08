package com.example.iceeteaserver.domain.member.converter

import com.example.iceeteaserver.domain.member.entity.Member
import com.example.iceeteaserver.domain.member.presentation.dto.response.MemberResponse
import org.springframework.stereotype.Component

@Component
class MemberConverter {
    fun toPurchaseResponse(member: Member) =
        MemberResponse(member.id,member.name)

}