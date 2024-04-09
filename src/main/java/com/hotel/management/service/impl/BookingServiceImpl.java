package com.hotel.management.service.impl;

import com.hotel.management.model.dto.mapper.BookingMapper;
import com.hotel.management.model.dto.mapper.CustomerMapper;
import com.hotel.management.model.dto.mapper.RoomMapper;
import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.request.SearchRequestDto;
import com.hotel.management.model.dto.response.BookingInformationResponseDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.repository.CustomerRepository;
import com.hotel.management.repository.RoomRepository;
import com.hotel.management.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;
    private final RoomMapper roomMapper;
    private final CustomerMapper customerMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, CustomerRepository customerRepository, RoomRepository roomRepository, BookingMapper bookingMapper, RoomMapper roomMapper, CustomerMapper customerMapper) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
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
        var customerEntity = customerRepository.save(customerMapper.toEntity(bookingRequestDto.getCustomerRequestDto()));
        var bookingEntity = bookingMapper.toEntity(bookingRequestDto);
        bookingEntity.setCustomerEntity(customerEntity);
        var result = bookingRepository.save(bookingEntity);
        return result.getId();
    }

    @Override
    public Long update(Long id, BookingRequestDto request) {
        var bookingEntity = bookingRepository.findById(id);
        if (bookingEntity.isPresent()) {
            var entity = bookingEntity.get();
            if (Objects.nonNull(request.getRoomRequestDto())) {
                var roomEntity = roomRepository.findById(request.getRoomRequestDto().getId()).orElse(null);
                entity.setRoomEntity(roomEntity);
            }
            if (Objects.nonNull(request.getCustomerRequestDto())) {
                var customerRequestDto = request.getCustomerRequestDto();
                var customerEntity = customerRepository.save(customerMapper.toEntity(customerRequestDto));
                entity.setCustomerEntity(customerEntity);
            }
            bookingRepository.save(entity);
        }
        return id;
    }

    @Override
    public Boolean cancel(Long id, Boolean isCancel) {
        var bookingEntity = bookingRepository.findById(id);
        if (bookingEntity.isPresent()) {
            var entity = bookingEntity.get();
            entity.setCancel(isCancel);
            bookingRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public Page<BookingInformationResponseDto> search(String search, Pageable pageable) {
        var entities = customerRepository.findAllByNameLike(search, pageable);
        var customerEntities = entities.getContent();
        var result = new ArrayList<BookingInformationResponseDto>();
        customerEntities.stream().forEach(o -> {
            o.getBookingEntities().stream().forEach(ob -> {
                result.add(new BookingInformationResponseDto(ob.getRoomEntity().getHotelEntity().getName(), ob.getCustomerEntity().getName(),ob.getCustomerEntity().getEmail(), ob.getCustomerEntity().getPhone(), ob.getRoomEntity().getType()));
            });
        });
        return new PageImpl<>(result, pageable, entities.getTotalElements());
    }
}
