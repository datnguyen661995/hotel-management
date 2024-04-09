package com.hotel.management.service;

import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.request.SearchRequestDto;
import com.hotel.management.model.dto.response.BookingInformationResponseDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    BookingResponseDto getBooking(Long id);
    Long create(BookingRequestDto bookingRequestDto);
    Long update(Long id, BookingRequestDto bookingRequestDto);
    Boolean cancel(Long id, Boolean isCancel);
    Page<BookingInformationResponseDto> search(String search, Pageable pageable);
}
