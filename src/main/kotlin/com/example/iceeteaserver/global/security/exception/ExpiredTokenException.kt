package com.example.iceeteaserver.global.security.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class ExpiredTokenException: BusinessException(ErrorCode.EXPIRATION_TOKEN)