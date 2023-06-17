package com.example.iceeteaserver.domain.purchase.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class NotExistFlavorException : IceTeaException(ErrorCode.NOT_EXIST_FLAVOR)