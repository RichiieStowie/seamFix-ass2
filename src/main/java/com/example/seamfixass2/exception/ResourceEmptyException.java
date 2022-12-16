package com.example.seamfixass2.exception;

public class ResourceEmptyException extends RuntimeException{
    public final String statusCode = "400";
    public String data ;

    public ResourceEmptyException(String message, String data) {
        super(message);
        this.data = data;
    }
}
