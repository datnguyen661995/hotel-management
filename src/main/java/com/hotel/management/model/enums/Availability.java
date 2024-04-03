package com.hotel.management.model.enums;

import lombok.Getter;

@Getter
public enum Availability {
    AVAILABLE("Available"),
    BOOKED("Booked");

    private final String value;
    Availability(String value) {
        this.value = value;
    }
}
