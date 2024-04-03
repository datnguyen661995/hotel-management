package com.hotel.management.model.enums;

import lombok.Getter;

@Getter
public enum Status {
    CONFIRMED("confirmed"),
    CANCELLED("cancelled"),
    PENDING("pending");

    private final String value;

    Status(String value) {
        this.value = value;
    }
}
