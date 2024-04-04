package com.hotel.management.model.dto.mapper;

import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import com.hotel.management.model.entity.BookingEntity;
import com.hotel.management.model.entity.CustomerEntity;
import com.hotel.management.model.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {RoomEntity.class, CustomerEntity.class})
public interface BookingMapper {
    @Mapping(source = "bookingEntity.roomEntity", target = "roomResponseDto")
    @Mapping(source = "bookingEntity.customerEntity", target = "customerResponseDto")
    BookingResponseDto toDto(BookingEntity bookingEntity);


    BookingEntity toEntity(BookingRequestDto bookingRequestDto);
}
