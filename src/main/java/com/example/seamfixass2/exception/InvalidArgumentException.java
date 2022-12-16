package com.example.seamfixass2.exception;

public class InvalidArgumentException extends RuntimeException{
    public  String statusCode;
    public String data;

    public InvalidArgumentException(String message, String statusCode, String data) {
        super(message);
        this.statusCode = statusCode;
        this.data = data;
    }
}
