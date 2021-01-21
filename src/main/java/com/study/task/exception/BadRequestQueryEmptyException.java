package com.study.task.exception;

public class BadRequestQueryEmptyException extends RuntimeException{

    public BadRequestQueryEmptyException() {
        super(ErrorCode.BAD_REQUEST_QUERY_EMPTY.getMessage());
    }

    public BadRequestQueryEmptyException(Exception ex) {
        super(ex);
    }
}
