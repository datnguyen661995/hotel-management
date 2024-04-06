package com.hotel.management.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 0, max = 20)
    private String name;
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Phone cannot be empty")
    @Size(min = 0, max = 20)
    private String phone;
    private RoomRequestDto roomRequestDto;
    private CustomerRequestDto customerRequestDto;

}
