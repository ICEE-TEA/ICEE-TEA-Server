package com.example.iceeteaserver.global.error

enum class ErrorCode(
    val message : String,
    val status : Int
) {
    // TOKEN
    EXPIRATION_TOKEN("토큰이 만료됬습니다",403),
    INVALID_TOKEN("토큰이 유효하지 않습니다",403),

    // MEMBER
    MEMBER_NOT_FOUND("유저를 찾을 수 없습니다",404),
    ROLE_NOT_EXIST("역할이 존재하지 않습니다",404),

    // EMAIL
    DUPLICATE_EMAIL("중복된 이메일 입니다",409),
    MANY_REQUEST_EMAIL("이메일 요청이 5번을 초과했습니다",429),
    AUTHKEY_NOT_CORRECT("인증번호가 일치하지 않습니다",400),
    EMAIL_NOT_FOUND("존재하지 않은 이메일 입니다",404),
    NOT_VERIFY_EMAIL("인증되지 않은 이메일 입니다",401),

    // AUTH
    MAIL_SEND_FAIL("이메일 요청에 실패하셨습니다",400),
    PASSWORD_NOT_CORRECT("비밀번호가 일치하지 않습니다",400),


    // APPLICATION
    ALREADY_APPLY_APPLICATION("이미 신청하셨습니다",400),
    NOT_APPLY_APPLICATION("신청하지 않았습니다.",400);
}