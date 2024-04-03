package com.hotel.management.service;

import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.response.BookingInformationResponseDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    BookingResponseDto getBooking(Long id);
    Long create(BookingRequestDto bookingRequestDto);
    void update(Long id, BookingRequestDto bookingRequestDto);
    void cancel(Long id);
    Page<BookingInformationResponseDto> search(BookingRequestDto bookingRequestDto, Pageable pageable);
}
