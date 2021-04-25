package com.example.users.controller;

import com.example.users.controller.dto.Request;
import com.example.users.controller.dto.Response;
import com.example.users.controller.handler.RequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
public class UserController {

    private final List<RequestHandler> requestHandlers;

    @PostMapping
    public Response acceptRequest(@RequestBody Request request) {
        return requestHandlers.stream()
            .filter(requestHandler -> Objects.equals(requestHandler.getType(), request.getType()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Not supported request type [" + request.getType() + "]"))
            .handle(request);
    }
}
