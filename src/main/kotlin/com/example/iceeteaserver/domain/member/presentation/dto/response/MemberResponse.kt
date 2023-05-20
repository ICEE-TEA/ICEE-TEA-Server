package com.example.iceeteaserver.domain.member.presentation.dto.response

import java.util.UUID

data class MemberResponse(
    val idx : UUID,
    val name : String
)