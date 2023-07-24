package com.example.webaappfilmtest1.response.exception;

import com.example.webaappfilmtest1.response.constants.Code;

import lombok.Builder;
import lombok.Data;

import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommonException extends Exception{
    private final Code code;
    private final String message;
    private final HttpStatus httpStatus;
}
