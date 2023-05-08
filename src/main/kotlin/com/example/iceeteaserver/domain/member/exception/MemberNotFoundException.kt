package com.example.iceeteaserver.domain.member.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class MemberNotFoundException : BusinessException(ErrorCode.MEMBER_NOT_FOUND)