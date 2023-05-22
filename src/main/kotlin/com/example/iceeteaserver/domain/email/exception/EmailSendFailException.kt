package com.example.iceeteaserver.domain.email.exception

import com.example.iceeteaserver.global.error.ErrorCode
import com.example.iceeteaserver.global.error.exceptions.IceTeaException

class EmailSendFailException : IceTeaException(ErrorCode.MAIL_SEND_FAIL)