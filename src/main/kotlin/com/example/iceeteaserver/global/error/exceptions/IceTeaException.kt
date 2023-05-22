package com.example.iceeteaserver.global.error.exceptions

import com.example.iceeteaserver.global.error.ErrorCode

open class IceTeaException(val errorCode: ErrorCode): RuntimeException(errorCode.message)
