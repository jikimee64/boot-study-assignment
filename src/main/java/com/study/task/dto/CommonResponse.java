package com.study.task.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommonResponse {
    private String code;

    private String message;

    private Object data;

}
