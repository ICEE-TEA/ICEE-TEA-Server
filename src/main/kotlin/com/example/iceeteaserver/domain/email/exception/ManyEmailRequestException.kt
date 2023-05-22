package com.example.iceeteaserver.domain.email.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class ManyEmailRequestException : IceTeaException(ErrorCode.MANY_REQUEST_EMAIL)