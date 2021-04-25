package com.example.users.controller.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@JacksonXmlRootElement(localName = "request")
public class Request {
    @JacksonXmlProperty(localName = "request-type")
    private RequestType type;
    @JacksonXmlElementWrapper(localName = "extra", useWrapping = false)
    private List<ExtraField> extra;

    public String getLogin() {
        return getFieldValue("login");
    }

    public String getPassword() {
        return getFieldValue("password");
    }

    private String getFieldValue(String name) {
        return extra.stream()
            .filter(extraField -> Objects.equals(name, extraField.getName()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Not found extra field [" + name + "]"))
            .getValue();
    }
}
