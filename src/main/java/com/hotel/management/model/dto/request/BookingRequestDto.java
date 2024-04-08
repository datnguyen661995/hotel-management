package com.hotel.management.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hotel.management.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private Long id;

    private Date checkInDate;
    private Date checkOutDate;
    private BigDecimal totalAmount;
    private Status status;

    private boolean isCancel;

    private RoomRequestDto roomRequestDto;
    private CustomerRequestDto customerRequestDto;

}
