CREATE TABLE IF NOT EXISTS users (
    login       text,
    password    text NOT NULL,
    balance     numeric(10,2) NOT NULL,
    PRIMARY KEY(login)
);