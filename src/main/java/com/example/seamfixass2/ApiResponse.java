package com.example.seamfixass2;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    public T message;
    public String status;
    public ResponseDto responseDto;
}
