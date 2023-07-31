package com.example.OrderManagement.Mine.advisor;

import com.example.OrderManagement.Mine.exception.NotFoundException;
import com.example.OrderManagement.Mine.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new StandardResponse(404,"Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
