package com.example.iceeteaserver.domain.auth.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class NotVerifyEmailException : BusinessException(ErrorCode.NOT_VERIFY_EMAIL) {
}