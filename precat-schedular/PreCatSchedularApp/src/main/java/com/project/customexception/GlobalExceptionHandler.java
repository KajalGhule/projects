package com.project.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateSubjectException.class)
    public ResponseEntity<String> handleDuplicateSubjectException(DuplicateSubjectException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(DuplicateFacultyException.class)
    public ResponseEntity<String> handleDuplicateFacultyException(DuplicateFacultyException ex) {
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}