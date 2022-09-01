package com.bebestlang.bebest.exception.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ImageException extends ResponseStatusException {

    public ImageException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }
}
