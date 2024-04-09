package com.hotel.management.model.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS("success"),
    ERROR("error");

    private final String value;

    StatusCode(String value) {
        this.value = value;
    }
}
