package com.hotel.management.model.dto.mapper;

import com.hotel.management.model.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BookingEntity.class})
public interface CustomerMapper {
}
