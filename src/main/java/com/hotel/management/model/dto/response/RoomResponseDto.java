package com.hotel.management.model.dto.response;

import com.hotel.management.model.enums.Availability;
import com.hotel.management.model.enums.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {
    private Long id;
    private RoomType type;
    private Integer capacity;
    private BigDecimal pricePerNight;
    private Availability availability;
}
