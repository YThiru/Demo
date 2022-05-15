package com.project.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

    int errorCode;
    HttpStatus errorStatus;
    String errorMessage;
    String errorPath;

    public static ErrorInfo of(int errorCode, HttpStatus errorStatus, String errorMessage, String errorPath) {
        return new ErrorInfo(errorCode, errorStatus, errorMessage, errorPath);
    }
}
