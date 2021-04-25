package com.example.users.controller.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@JacksonXmlRootElement(localName = "response")
public class Response {

    private static final int SUCCESS_RESPONSE_CODE = 0;

    @JacksonXmlProperty(localName = "result-code")
    private final int code;
    @JacksonXmlElementWrapper(localName = "extra", useWrapping = false)
    private final List<ExtraField> extra;

    public static Response success(ExtraField... extraFields) {
        return Response.builder()
            .code(SUCCESS_RESPONSE_CODE)
            .extra(List.of(extraFields))
            .build();
    }

    public static Response failed(ResponseErrorCode errorCode) {
        return Response.builder()
            .code(errorCode.getCode())
            .build();
    }
}
