package com.example.iceeteaserver.domain.email.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class MismatchAuthkeyException : IceTeaException(ErrorCode.AUTHKEY_NOT_CORRECT)