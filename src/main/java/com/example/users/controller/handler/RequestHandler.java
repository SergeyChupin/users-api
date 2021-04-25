package com.example.users.controller.handler;

import com.example.users.controller.dto.Request;
import com.example.users.controller.dto.RequestType;
import com.example.users.controller.dto.Response;

public interface RequestHandler {

    Response handle(Request request);

    RequestType getType();
}
