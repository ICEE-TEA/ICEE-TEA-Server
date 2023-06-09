package com.example.iceeteaserver.domain.admin.presentation.dto.response

import com.example.iceeteaserver.domain.member.presentation.dto.response.MemberResponse

data class GetBuyerListResponse(
    val flavor: String,
    val size: Long,
    val pay: String,
    val member: MemberResponse
)
