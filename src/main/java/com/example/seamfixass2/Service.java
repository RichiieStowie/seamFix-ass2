package com.example.seamfixass2;

import com.example.seamfixass2.exception.InvalidArgumentException;
import com.example.seamfixass2.exception.ResourceEmptyException;
@org.springframework.stereotype.Service
public class Service {
    public ResponseRepository responseRepository;

    public Service(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public ResponseDto getDetails(String bvn) {
        String response = "";
        if (bvn.isBlank() || bvn.isEmpty() || !validateRegex(bvn)) {
            throw new ResourceEmptyException("One or More of your request parameter failed again. Please try again", bvn);
        }
        if (validateBvnLength(bvn) && validateRegex(bvn)) {
          response = responseRepository.save(bvn);
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.id = bvn;
        return responseDto;
    }

    private boolean validateBvnLength(String bvn) {
        if (bvn.length() < 11) {
            throw new InvalidArgumentException("The searched BVN is invalid", "01", bvn);
        }
        return true;
    }

    private boolean validateRegex(String bvn) {
        String regex = "\\d+";
        if (!bvn.matches(regex)) {
            throw new InvalidArgumentException("The searched BVN is invalid", "02", bvn);
        }
        return true;
    }
}


