# Users API

Сервис предоставляет REST API для работы с клиентами.

## Конфигурация

| Переменная | Значение по умолчанию | Описание |
|------------|:---------------------:|----------|
database.name       | users         | название бд               |
database.host       | 127.0.0.1     | адрес бд                  |
database.port       | 5432          | порт бд                   |
database.username   | postgres      | логин пользователя бд     |
database.password   | admin         | пароль пользователя бд    |

## Как запустить?

Ниже все команды подразумевают запуск из корня проекта.

#### Без docker'а

```bash
$ ./mvnw clean install spring-boot:run
```

Для этого случая, на хосте должен быть доступен postgresql на порту 5432.

#### C использованием docker'а

```bash
$ ./mvnw clean install && docker-compose up --build
```

## REST API

По умолчанию приложение будет доступно на порту 8080.

### Регистрация клиента

#### Request

`POST /api/users`

    curl -i -H 'Accept: application/xml' -H 'Content-Type: application/xml' http://localhost:8080/api/users --data-raw \
    '<?xml version="1.0" encoding="utf-8"?>
    <request>
      <request-type>CREATE-AGT</request-type>
      <extra name="login">123456</extra>
      <extra name="password">pwd1</extra>
    </request>'

#### Response

    HTTP/1.1 200 
    Content-Type: application/xml
    Date: Sun, 25 Apr 2021 08:05:54 GMT

    <?xml version='1.0' encoding='UTF-8'?>
    <response>
      <result-code>0</result-code>
    </response>

### Запрос клиентом своего баланса

#### Request

`POST /api/users`

    curl -i -H 'Accept: application/xml' -H 'Content-Type: application/xml' http://localhost:8080/api/users --data-raw \
    '<?xml version="1.0" encoding="utf-8"?>
    <request>
      <request-type>GET-BALANCE</request-type>
      <extra name="login">123456</extra>
      <extra name="password">pwd1</extra>
    </request>'

#### Response

    HTTP/1.1 200 
    Content-Type: application/xml
    Date: Sun, 25 Apr 2021 08:05:54 GMT

    <?xml version='1.0' encoding='UTF-8'?>
    <response>
      <extra name="balance">0.00</extra>
      <result-code>0</result-code>
    </response>

### Коды ошибок

| Код        | Описание |
|------------|----------|
1 | пользователь с таким логином уже существует |
2 | техническая ошибка                          |
3 | пользователь не существует                  |
4 | пароль не верен                             |
