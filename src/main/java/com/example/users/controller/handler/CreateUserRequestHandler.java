package com.example.users.controller.handler;

import com.example.users.controller.dto.Request;
import com.example.users.controller.dto.RequestType;
import com.example.users.controller.dto.Response;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserRequestHandler implements RequestHandler {

    private final UserService userService;

    @Override
    public Response handle(Request request) {
        userService.createUser(
            request.getLogin(), request.getPassword()
        );
        return Response.success();
    }

    @Override
    public RequestType getType() {
        return RequestType.CREATE_USER;
    }
}
