package com.hotel.management.service.impl;

import com.hotel.management.model.dto.mapper.BookingMapper;
import com.hotel.management.model.dto.mapper.CustomerMapper;
import com.hotel.management.model.dto.mapper.RoomMapper;
import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.response.BookingInformationResponseDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final RoomMapper roomMapper;
    private final CustomerMapper customerMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, RoomMapper roomMapper, CustomerMapper customerMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.roomMapper = roomMapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public BookingResponseDto getBooking(Long id) {
        var result = bookingRepository.findById(id).orElse(null);
        return bookingMapper.toDto(result);
    }

    @Override
    public Long create(BookingRequestDto bookingRequestDto) {
        var bookingEntity = bookingMapper.toEntity(bookingRequestDto);
        var result = bookingRepository.save(bookingEntity);
        return result.getId();
    }

    @Override
    public Long update(Long id, BookingRequestDto request) {
        var bookingEntity = bookingRepository.findById(id);
        if (bookingEntity.isPresent()) {
            var entity = bookingEntity.get();
            if (Objects.nonNull(request.getRoomRequestDto())) {
                var roomRequestDto = request.getRoomRequestDto();
                entity.setRoomEntity(roomMapper.toEntity(roomRequestDto));
            }
            if (Objects.nonNull(request.getCustomerRequestDto())) {
                var customerRequestDto = request.getCustomerRequestDto();
                entity.setCustomerEntity(customerMapper.toEntity(customerRequestDto));
            }
            bookingRepository.save(entity);
        }
        return id;
    }

    @Override
    public void cancel(Long id, Boolean isCancel) {
        var bookingEntity = bookingRepository.findById(id);
        if (bookingEntity.isPresent()) {
            var entity = bookingEntity.get();
            entity.setCancel(isCancel);
            bookingRepository.save(entity);
        }
    }

    @Override
    public Page<BookingInformationResponseDto> search(BookingRequestDto bookingRequestDto, Pageable pageable) {
        var entities = bookingRepository.findByCustomerEntityIdOrCustomerEntityEmailOrCustomerEntityPhone(bookingRequestDto.getCustomerRequestDto().getName(), bookingRequestDto.getCustomerRequestDto().getEmail(), bookingRequestDto.getCustomerRequestDto().getPhone(), pageable);
        var result = entities.stream()
                .map(ob ->
                        new BookingInformationResponseDto(ob.getRoomEntity().getHotelEntity().getName(), ob.getCustomerEntity().getName(), ob.getCustomerEntity().getEmail(), ob.getCustomerEntity().getPhone(), ob.getRoomEntity().getType())
                )
                .collect(Collectors.toList());
        return new PageImpl<>(result, pageable, entities.getTotalElements());
    }
}
