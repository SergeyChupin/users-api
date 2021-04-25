package com.example.users.controller.handler;

import com.example.users.controller.dto.ExtraField;
import com.example.users.controller.dto.Request;
import com.example.users.controller.dto.RequestType;
import com.example.users.controller.dto.Response;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetBalanceRequestHandler implements RequestHandler {

    private static final String BALANCE_EXTRA_FIELD = "balance";

    private final UserService userService;

    @Override
    public Response handle(Request request) {
        var balance = userService.getUserBalance(
            request.getLogin(), request.getPassword()
        );
        return Response.success(
            new ExtraField()
                .setName(BALANCE_EXTRA_FIELD)
                .setValue(balance.toPlainString())
        );
    }

    @Override
    public RequestType getType() {
        return RequestType.GET_USER_BALANCE;
    }
}
