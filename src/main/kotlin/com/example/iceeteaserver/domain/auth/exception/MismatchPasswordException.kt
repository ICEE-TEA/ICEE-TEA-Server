package com.example.iceeteaserver.domain.auth.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class MismatchPasswordException : IceTeaException(ErrorCode.PASSWORD_NOT_CORRECT)