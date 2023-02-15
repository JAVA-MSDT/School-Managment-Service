package com.school.management.exception.training;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TrainingException extends ResponseStatusException {

    public TrainingException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }

}
