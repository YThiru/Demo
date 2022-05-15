package com.project.demo.exception;

import com.project.demo.Util.Constants;
import com.project.demo.response.StoreLocationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
@RestController
public class DemoExceptionHandler {

    @ExceptionHandler({MissingServletRequestParameterException.class, ConstraintViolationException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<StoreLocationResponse> handleRequestParameterValid(Exception ex) {
        return new ResponseEntity(StoreLocationResponse.of(Constants.FAILURE_OUTCOME, null,
                ErrorInfo.of(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex.getMessage(), null)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DemoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<StoreLocationResponse> handleDemoException(DemoException ex) {
        return new ResponseEntity(StoreLocationResponse.of(Constants.FAILURE_OUTCOME, null,
                ErrorInfo.of(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ex.getMessage(), null)), HttpStatus.BAD_REQUEST);
    }
}
