package com.study.task.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NAVER_API_UNAUTHORIZED("네이버 오픈 API 통신 인증 에러"),
    NAVER_API_ERROR("네이버 오픈 API 통신 알수 없는 에러"),

    BAD_REQUEST_QUERY_EMPTY("Query 정보가 없음");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
