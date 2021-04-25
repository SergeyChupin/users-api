package com.example.users.controller.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum RequestType {
    @XmlEnumValue("CREATE-AGT")
    CREATE_USER,
    @XmlEnumValue("GET-BALANCE")
    GET_USER_BALANCE
}
