package com.hotel.management.model.enums;

import lombok.Getter;

@Getter
public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    TRIPLE("Triple"),
    QUAD("Quad"),
    QUEEN("Queen"),
    KING("King");

    private final String value;

    RoomType(String value) {
        this.value = value;
    }
}
