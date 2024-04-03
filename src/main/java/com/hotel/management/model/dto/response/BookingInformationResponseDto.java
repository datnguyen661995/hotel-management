package com.hotel.management.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInformationResponseDto {
    private String name;
    private String email;
    private String phone;
}
