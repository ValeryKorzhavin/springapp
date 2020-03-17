package com.company.springapp.controller.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String USER_NOT_FOUND = "User with id=%s not found";

    private String message;

    public UserNotFoundException(Long id) {
        super(String.format(USER_NOT_FOUND, id));
        message = String.format(USER_NOT_FOUND, id);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
