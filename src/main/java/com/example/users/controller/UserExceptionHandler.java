package com.example.users.controller;

import com.example.users.controller.dto.Response;
import com.example.users.controller.dto.ResponseErrorCode;
import com.example.users.exception.IncorrectUserPasswordException;
import com.example.users.exception.NotFoundUserException;
import com.example.users.exception.UserAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGlobalException(Exception e) {
        return handleError(e, ResponseErrorCode.INTERNAL_ERROR);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Response> handleUserAlreadyExistsException(Exception e) {
        return handleError(e, ResponseErrorCode.USER_ALREADY_EXISTS);
    }

    @ExceptionHandler(IncorrectUserPasswordException.class)
    public ResponseEntity<Response> handleIncorrectUserPasswordException(Exception e) {
        return handleError(e, ResponseErrorCode.INCORRECT_USER_PASSWORD);
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<Response> handleNotFoundUserException(Exception e) {
        return handleError(e, ResponseErrorCode.NOT_FOUND_USER);
    }

    private ResponseEntity<Response> handleError(Exception e, ResponseErrorCode errorCode) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_XML)
            .body(
                Response.failed(errorCode)
            );
    }
}
