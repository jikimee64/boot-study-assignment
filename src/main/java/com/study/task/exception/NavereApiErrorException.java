package com.study.task.exception;

public class NavereApiErrorException extends RuntimeException{

    public NavereApiErrorException() {
        super(ErrorCode.NAVER_API_ERROR.getMessage());
    }

    public NavereApiErrorException(Exception ex) {
        super(ex);
    }
}
