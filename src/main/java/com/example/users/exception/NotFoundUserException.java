package com.example.users.exception;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String login) {
        super("Unable find user with login + [" + login + "]");
    }
}
