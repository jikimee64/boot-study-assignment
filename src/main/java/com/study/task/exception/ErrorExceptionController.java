package com.study.task.exception;

import com.study.task.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class ErrorExceptionController {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> naverApiUnauthorizedExceptionHandler(NaverApiUnauthorizedException ex) {
        return new ResponseEntity<>(
            CommonResponse.builder()
                .code("500")
                .message(ErrorCode.NAVER_API_UNAUTHORIZED.getMessage()).build(),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<?> naverApiErrorExceptionHandler(NavereApiErrorException e) {
        return new ResponseEntity<>(
            CommonResponse.builder()
                .code("500")
                .message(ErrorCode.NAVER_API_ERROR.getMessage()).build(),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<?> badRequestQueryEmptyExceptionHandler(BadRequestQueryEmptyException e) {
        return new ResponseEntity<>(
            CommonResponse.builder()
                .code("400")
                .message(ErrorCode.BAD_REQUEST_QUERY_EMPTY.getMessage()).build(),
            HttpStatus.BAD_REQUEST);
    }

}
