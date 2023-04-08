package com.example.iceeteaserver.global.error

enum class ErrorCode(
    val message : String,
    val status : Int
) {

    ROLE_NOT_FOUND("역할이 존재하지 않습니다",404),
    NOT_EXIST_REFRESHTOKEN("존재하지 않은 refreshToken입니다.",404),

    DUPLICATE_EMAIL("중복된 이메일 입니다",409),
    MANY_REQUEST_EMAIL("이메일 요청이 5번을 초과했습니다",429),
    MAIL_SEND_FAIL("이메일 요청에 실패하셨습니다",400),

    TOKEN_EXPIRE("토큰이 만료되었습니다",403),
    IVALID_TOKEN("토큰이 유효하지 않습니다",403),

    MEMBER_NOT_FOUND("유저를 찾지 못했습니다",404),
    EMAIL_NOT_FOUND("이메일이 존재하지 않습니다",404),

    MISMATCH_AUTHKEY("인증번호가 일치하지 않습니다.",400),
    NOT_VERIFY_EMAIL("인증되지 않은 이메일입니다",401),

    MISMATCH_PASSWORD("비밀번호가 일치하지 않습니다.",400),

    ALREADY_EXIST_EMAIL("이미 존재하는 이메일입니다",400),
    NOT_EXIST_BUYER("아직 구매자가 없습니다.",404)



    ;
}

