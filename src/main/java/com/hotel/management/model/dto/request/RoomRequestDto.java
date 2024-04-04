package com.hotel.management.model.dto.request;

import com.hotel.management.model.enums.Availability;
import com.hotel.management.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDto {
    private String name;
    private RoomType roomType;
    private BigDecimal pricePerNight;
    private Availability availability;
}
