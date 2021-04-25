package com.example.users.exception;

public class IncorrectUserPasswordException extends RuntimeException {

    public IncorrectUserPasswordException(String login) {
        super("Unable authorize user [" + login + "] with specified password");
    }
}
