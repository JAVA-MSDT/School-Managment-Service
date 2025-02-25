package com.school.management.exception.training;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SubjectException extends ResponseStatusException {

    public SubjectException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }

}
