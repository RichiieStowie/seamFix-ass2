package com.example.seamfixass2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "response")
public class ResponseDto {
    @Id
    public String id;
    public String imageDetail;
    public String basicDetail;
}
