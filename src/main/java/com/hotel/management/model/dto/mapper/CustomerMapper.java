package com.hotel.management.model.dto.mapper;

import com.hotel.management.model.dto.request.CustomerRequestDto;
import com.hotel.management.model.entity.BookingEntity;
import com.hotel.management.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {BookingEntity.class})
public interface CustomerMapper {
    CustomerEntity toEntity(CustomerRequestDto customerRequestDto);
}
