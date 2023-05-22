package com.example.iceeteaserver.domain.email.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class EmailNotFoundException : IceTeaException(ErrorCode.EMAIL_NOT_FOUND)