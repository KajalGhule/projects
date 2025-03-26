package com.project.customexception;

public class DuplicateSubjectException extends RuntimeException {
    public DuplicateSubjectException(String message) {
        super(message);
    }
}