package com.example.iceeteaserver.domain.email.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class MismatchAuthkeyException : BusinessException(ErrorCode.MISMATCH_AUTHKEY) {
}