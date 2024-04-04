package com.hotel.management.model.dto.response;

import com.hotel.management.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInformationResponseDto {
    private String hotelName;
    private String name;
    private String email;
    private String phone;
    private RoomType roomType;

}
