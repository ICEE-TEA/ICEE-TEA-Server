package com.example.iceeteaserver.domain.auth.util

import com.example.iceeteaserver.domain.auth.presentation.dto.MemberDto
import com.example.iceeteaserver.domain.auth.presentation.dto.type.ValidatorType

interface AccountValidator {
    fun validate(validatorType: ValidatorType, memberDto: MemberDto)
}