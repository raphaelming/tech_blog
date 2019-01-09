package com.raphael.blog.techblog.Config;


import com.raphael.blog.techblog.Model.ExceptionPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ApiExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionPojo> unExpectedExceptionHandler(Exception e) {
        logger.error("API Exception (UnExpected Exception) - {}", e);
        return new ResponseEntity<>(new ExceptionPojo(500,"UnExpected Exception", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
