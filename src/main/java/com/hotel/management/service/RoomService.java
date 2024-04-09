package com.hotel.management.service;

import com.hotel.management.model.dto.request.RoomRequestDto;
import com.hotel.management.model.dto.response.RoomResponseDto;

public interface RoomService {
    RoomResponseDto get(Long id);
    RoomResponseDto create(RoomRequestDto roomRequestDto);
    RoomResponseDto update(Long id, RoomRequestDto roomRequestDto);
    Boolean delete(Long id, Boolean isDelete);
}
