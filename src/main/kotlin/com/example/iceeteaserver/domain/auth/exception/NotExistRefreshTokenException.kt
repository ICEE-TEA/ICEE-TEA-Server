package com.example.iceeteaserver.domain.auth.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class NotExistRefreshTokenException : BusinessException(ErrorCode.NOT_EXIST_REFRESHTOKEN)