package com.example.users.repository;

import com.example.users.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private static final String SAVE_SQL = "INSERT INTO users(login, password, balance) VALUES (:login, :password, :balance)";
    private static final String FIND_BY_LOGIN_SQL = "SELECT * FROM users WHERE login = :login";
    private static final String LOGIN_FIELD = "login";
    private static final String PASSWORD_FIELD = "password";
    private static final String BALANCE_FIELD = "balance";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Transactional
    public void save(User user) {
        jdbcTemplate.update(
            SAVE_SQL,
            Map.of(
                LOGIN_FIELD, user.getLogin(),
                PASSWORD_FIELD, user.getPassword(),
                BALANCE_FIELD, user.getBalance()
            )
        );
    }

    @Transactional(readOnly = true)
    public Optional<User> findByLogin(String login) {
        try {
            return Optional.ofNullable(
                jdbcTemplate.queryForObject(
                    FIND_BY_LOGIN_SQL,
                    Map.of(LOGIN_FIELD, login),
                    (rs, __) ->
                        User.builder()
                            .login(rs.getString(LOGIN_FIELD))
                            .password(rs.getString(PASSWORD_FIELD))
                            .balance(rs.getBigDecimal(BALANCE_FIELD))
                            .build()
                )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
