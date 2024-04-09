package com.hotel.management.service.impl;

import com.hotel.management.model.dto.mapper.RoomMapper;
import com.hotel.management.model.dto.request.RoomRequestDto;
import com.hotel.management.model.dto.response.RoomResponseDto;
import com.hotel.management.model.entity.RoomEntity;
import com.hotel.management.repository.RoomRepository;
import com.hotel.management.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomResponseDto get(Long id) {
        var result = roomRepository.findById(id).orElse(null);
        return roomMapper.toDto(result);
    }

    @Override
    public RoomResponseDto create(RoomRequestDto roomRequestDto) {
        var entity = roomRepository.save(roomMapper.toEntity(roomRequestDto));
        return roomMapper.toDto(entity);
    }

    @Override
    public RoomResponseDto update(Long id, RoomRequestDto roomRequestDto) {
        var entity = new RoomEntity();
        if (null != id) {
            entity = roomRepository.findById(id).orElse(null);
        }
        if (Objects.nonNull(entity)) {
            return roomMapper.toDto(roomRepository.save(roomMapper.toEntity(roomRequestDto)));
        }
        return null;
    }

    @Override
    public Boolean delete(Long id, Boolean isDelete) {
        var entity = roomRepository.findById(id).orElse(null);
        if (Objects.nonNull(entity)) {
            entity.setIsDelete(isDelete);
            return isDelete;
        }
        return Boolean.FALSE;
    }
}
