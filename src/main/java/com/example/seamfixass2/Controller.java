package com.example.seamfixass2;

import com.example.seamfixass2.exception.InvalidArgumentException;
import com.example.seamfixass2.exception.ResourceEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bv-service/svalidate/wrapper")
public class Controller {
public  Service service;

    public Controller(Service service) {
        this.service = service;
    }
    @PostMapping("/")
    public ResponseEntity<ApiResponse<?>> validateRequest(@RequestBody RequestDto requestDto){
        ResponseDto responseDto = service.getDetails(requestDto.bvn);
        ApiResponse response = new ApiResponse();
        response.responseDto = responseDto;
        return new ResponseEntity<ApiResponse<?>>(response, HttpStatus.OK);
    }

}
