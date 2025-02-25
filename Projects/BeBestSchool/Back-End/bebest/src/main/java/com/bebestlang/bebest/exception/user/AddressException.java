package com.bebestlang.bebest.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddressException extends ResponseStatusException {

    public AddressException(String message, HttpStatus httpStatus) {
        super(httpStatus, message);
    }
}
