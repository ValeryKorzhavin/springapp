package com.company.springapp.controller.exception;

public class RoleNotFoundException extends RuntimeException {

    private static final String ROLE_NOT_FOUND = "Role with id=%s not found";

    private String message;

    public RoleNotFoundException(Long id) {
        super(String.format(ROLE_NOT_FOUND, id));
        message = String.format(ROLE_NOT_FOUND, id);
    }

    @Override
    public String getMessage() {
        return message;
    }

}