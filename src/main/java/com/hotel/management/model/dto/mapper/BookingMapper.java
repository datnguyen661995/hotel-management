package com.hotel.management.model.dto.mapper;

import com.hotel.management.model.dto.response.BookingResponseDto;
import com.hotel.management.model.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingResponseDto toDto(BookingEntity bookingEntity);
}
