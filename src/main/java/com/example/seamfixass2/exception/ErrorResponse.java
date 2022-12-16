package com.example.seamfixass2.exception;

import com.example.seamfixass2.ResponseDto;

public class ErrorResponse<T> {
    public T message;
    public String status;
    public String data;
}
