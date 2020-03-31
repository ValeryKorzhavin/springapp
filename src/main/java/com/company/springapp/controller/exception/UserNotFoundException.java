package com.company.springapp.controller.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String USER_NOT_FOUND = "User with id=%s not found";
    private static final String USERNAME_NOT_FOUND = "User with username=%s not found";

    private String message;

    public UserNotFoundException(long id) {
        super(String.format(USER_NOT_FOUND, id));
        message = String.format(USER_NOT_FOUND, id);
    }

    public UserNotFoundException(String username) {
        super(String.format(USERNAME_NOT_FOUND, username));
        message = String.format(USERNAME_NOT_FOUND, username);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
