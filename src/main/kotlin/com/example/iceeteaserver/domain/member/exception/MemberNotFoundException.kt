package com.example.iceeteaserver.domain.member.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class MemberNotFoundException : IceTeaException(ErrorCode.MEMBER_NOT_FOUND)