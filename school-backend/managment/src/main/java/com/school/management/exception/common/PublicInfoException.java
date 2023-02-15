package com.school.management.exception.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PublicInfoException extends ResponseStatusException {

    public PublicInfoException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }
}
