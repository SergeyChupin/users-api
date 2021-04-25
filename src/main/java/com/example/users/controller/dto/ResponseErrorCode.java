package com.example.users.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseErrorCode {
    USER_ALREADY_EXISTS(1),
    INTERNAL_ERROR(2),
    NOT_FOUND_USER(3),
    INCORRECT_USER_PASSWORD(4);

    private final int code;
}
