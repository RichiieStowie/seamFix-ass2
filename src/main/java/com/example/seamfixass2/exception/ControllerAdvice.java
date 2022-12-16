package com.example.seamfixass2.exception;

import com.example.seamfixass2.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ResourceEmptyException.class)
    @ResponseBody
    public ErrorResponse handleResourceEmptyException(ResourceEmptyException ex){
        ErrorResponse response = new ErrorResponse();
        response.message = ex.getMessage();
        response.status = ex.statusCode;
        response.data = ex.data;

        return response;
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseBody
    public ErrorResponse handleInvalidArgumentException(InvalidArgumentException ex){
        ErrorResponse response = new ErrorResponse();
        response.message = ex.getMessage();
        response.status = ex.statusCode;
        response.data = ex.data;
        return response;
    }
}
