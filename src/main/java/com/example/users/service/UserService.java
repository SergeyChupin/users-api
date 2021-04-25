package com.example.users.service;

import com.example.users.domain.User;
import com.example.users.exception.IncorrectUserPasswordException;
import com.example.users.exception.NotFoundUserException;
import com.example.users.exception.UserAlreadyExistsException;
import com.example.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(String login, String password) {
        try {
            userRepository.save(
                User.builder()
                    .login(login)
                    .password(password)
                    .build()
            );
        } catch (DuplicateKeyException e) {
            throw new UserAlreadyExistsException(login);
        }
    }

    public BigDecimal getUserBalance(String login, String password) {
        var user = userRepository.findByLogin(login)
            .orElseThrow(() -> new NotFoundUserException(login));

        if (!Objects.equals(password, user.getPassword())) {
            throw new IncorrectUserPasswordException(login);
        }

        return user.getBalance();
    }
}
