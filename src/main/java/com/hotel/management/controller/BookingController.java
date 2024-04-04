package com.hotel.management.controller;

import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.response.BaseResponseDto;
import com.hotel.management.model.dto.response.BookingInformationResponseDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import com.hotel.management.service.BookingService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
@RequestMapping(value = "/booking")
@Slf4j
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<BookingResponseDto>> getBooking(@PathVariable("id") @NotNull Long id) {
        var result = this.bookingService.getBooking(id);
        return ResponseEntity.ok(new BaseResponseDto<>(result));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<Page<BookingInformationResponseDto>>> getAllBookings(
            @RequestParam(name = "search", defaultValue = "") BookingRequestDto search,
            @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "saDeadline") String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = "DESC") Sort.Direction sortOrder) {
        var pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortOrder, sortBy));
        var result = this.bookingService.search(search, pageRequest);
        return ResponseEntity.ok(new BaseResponseDto<>(result));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<?>> create(
            @NotNull @RequestBody BookingRequestDto requestDto
    ) {
        var result = this.bookingService.create(requestDto);
        return ResponseEntity.ok(new BaseResponseDto<>(result));
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponseDto<?>> update(@RequestBody BookingRequestDto bookingRequestDto, @PathVariable("id")Long id) {
        var result = this.bookingService.update(id, bookingRequestDto);
        return ResponseEntity.ok(new BaseResponseDto<>(result));
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable("id")Long id) {
        this.bookingService.cancel(id);
    }

}
