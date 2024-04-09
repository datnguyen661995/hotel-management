package com.hotel.management.controller;

import com.hotel.management.model.dto.request.RoomRequestDto;
import com.hotel.management.model.dto.response.BaseResponseDto;
import com.hotel.management.model.dto.response.RoomResponseDto;
import com.hotel.management.service.RoomService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/room")
@Slf4j
public class RoomController {
    private final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseResponseDto<RoomResponseDto>> get(@PathVariable("id")Long id) {
        var responseDto = this.roomService.get(id);
        return ResponseEntity.ok(new BaseResponseDto<>(responseDto));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<RoomResponseDto>> create(@RequestBody RoomRequestDto roomRequestDto) {
        var responseDto = this.roomService.create(roomRequestDto);
        return ResponseEntity.ok(new BaseResponseDto<>(responseDto));
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<RoomResponseDto>> update(@PathVariable("id") Long id, @RequestBody RoomRequestDto roomRequestDto) {
        var responseDto = this.roomService.update(id, roomRequestDto);
        return ResponseEntity.ok(new BaseResponseDto<>(responseDto));
    }

    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<RoomResponseDto>> delete(@PathVariable("id") Long id, @RequestParam(name = "isDelete")@NotNull Boolean isDelete) {
        var isStatus = this.roomService.delete(id, isDelete);
        return ResponseEntity.ok(new BaseResponseDto<>(isStatus));
    }

}
