package com.hotel.management.model.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hotel.management.model.enums.Availability;
import com.hotel.management.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomRequestDto {
    private Long id;
    private RoomType roomType;
    private RoomType type;
    private Integer capacity;
    private BigDecimal pricePerNight;
    private Availability availability;
}
