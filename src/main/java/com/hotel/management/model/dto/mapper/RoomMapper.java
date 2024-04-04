package com.hotel.management.model.dto.mapper;

import com.hotel.management.model.dto.response.RoomResponseDto;
import com.hotel.management.model.entity.BookingEntity;
import com.hotel.management.model.entity.HotelEntity;
import com.hotel.management.model.entity.RoomEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {HotelEntity.class, BookingEntity.class})
public interface RoomMapper {
    RoomEntity toEntity(RoomResponseDto roomResponseDto);
}
