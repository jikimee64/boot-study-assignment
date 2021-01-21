package com.study.task.exception;

public class NaverApiUnauthorizedException extends RuntimeException {

    public NaverApiUnauthorizedException() {
        super(ErrorCode.NAVER_API_UNAUTHORIZED.getMessage());
    }

    public NaverApiUnauthorizedException(Exception ex) {
        super(ex);
    }
}
