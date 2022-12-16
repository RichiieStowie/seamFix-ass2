package com.example.seamfixass2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends MongoRepository<String, ResponseDto> {
}
