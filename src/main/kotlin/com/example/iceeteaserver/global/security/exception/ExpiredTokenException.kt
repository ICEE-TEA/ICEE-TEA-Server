package com.example.iceeteaserver.global.security.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class ExpiredTokenException : IceTeaException(ErrorCode.EXPIRATION_TOKEN)