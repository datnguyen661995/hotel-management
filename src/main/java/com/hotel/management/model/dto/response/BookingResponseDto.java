package com.hotel.management.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hotel.management.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponseDto {
    private Long id;
    private Date checkInDate;
    private Date checkOutDate;
    private BigDecimal totalAmount;
    private Status status;
    private RoomResponseDto roomResponseDto;
    private CustomerResponseDto customerResponseDto;
}
