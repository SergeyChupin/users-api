package com.example.users.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@RequiredArgsConstructor
public class User {
    @NonNull
    private final String login;
    @NonNull
    private final String password;
    @NonNull
    @Builder.Default
    private final BigDecimal balance = BigDecimal.ZERO;
}
