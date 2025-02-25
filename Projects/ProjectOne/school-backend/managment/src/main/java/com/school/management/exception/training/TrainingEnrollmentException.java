package com.school.management.exception.training;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TrainingEnrollmentException extends ResponseStatusException {

    public TrainingEnrollmentException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }

}
