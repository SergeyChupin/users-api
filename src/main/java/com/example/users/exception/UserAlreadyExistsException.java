package com.example.users.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String login) {
        super("Unable create user with login [" + login + "] that already exists");
    }
}
