package com.example.iceeteaserver.domain.purchase.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.BusinessException

class NotExistBuyerException : BusinessException(ErrorCode.NOT_EXIST_BUYER) {
}