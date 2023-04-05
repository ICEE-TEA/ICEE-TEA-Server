package com.example.iceeteaserver.global.security.jwt.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class RoleNotExistException : BusinessException(ErrorCode.MAIL_SEND_FAIL) {
}