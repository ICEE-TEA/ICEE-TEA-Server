package com.example.iceeteaserver.domain.email.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class ManyEmailRequestException : BusinessException(ErrorCode.MANY_REQUEST_EMAIL) {
}