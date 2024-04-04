package com.hotel.management.model.dto.request;

import com.hotel.management.model.dto.response.RoomResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private RoomResponseDto roomResponseDto;
    private CustomerRequestDto customerRequestDto;

}
