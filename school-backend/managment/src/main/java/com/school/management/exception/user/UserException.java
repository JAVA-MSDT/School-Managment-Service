package com.school.management.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserException extends ResponseStatusException {

    public UserException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }
}
