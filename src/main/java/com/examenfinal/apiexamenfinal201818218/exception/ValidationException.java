package com.examenfinal.apiexamenfinal201818218.exception;

public class ValidationException extends RuntimeException{
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}
