package com.hotel.management.service.impl;

import com.hotel.management.model.dto.mapper.BookingMapper;
import com.hotel.management.model.dto.request.BookingRequestDto;
import com.hotel.management.model.dto.response.BookingInformationResponseDto;
import com.hotel.management.model.dto.response.BookingResponseDto;
import com.hotel.management.repository.BookingRepository;
import com.hotel.management.repository.CustomerRepository;
import com.hotel.management.repository.HotelRepository;
import com.hotel.management.repository.RoomRepository;
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
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository, CustomerRepository customerRepository, BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingResponseDto getBooking(Long id) {
        var result = bookingRepository.findById(id);
        return bookingMapper.toDto(result.get());
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
            if (Objects.nonNull(request.getRoomResponseDto())) {
                entity.getRoomEntity().setType(request.getRoomResponseDto().getType());
                entity.getRoomEntity().setCapacity(request.getRoomResponseDto().getCapacity());
                entity.getRoomEntity().setPricePerNight(request.getRoomResponseDto().getPricePerNight());
            }
            if (Objects.nonNull(request.getCustomerRequestDto())) {
                entity.getCustomerEntity().setName(request.getName());
                entity.getCustomerEntity().setEmail(request.getEmail());
                entity.getCustomerEntity().setPhone(request.getPhone());
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
        var entities = bookingRepository.findAllByCustomerEntity_NameOrCustomerEntity_EmailOrCustomerEntity_PhoneOrCustomerEntity(bookingRequestDto.getName(), bookingRequestDto.getEmail(),bookingRequestDto.getPhone(), pageable);
        var result = entities.stream().map(ob -> {
            var booking =  new BookingInformationResponseDto( ob.getRoomEntity().getHotelEntity().getName(),ob.getCustomerEntity().getName(), ob.getCustomerEntity().getEmail(), ob.getCustomerEntity().getPhone(), ob.getRoomEntity().getType());
            return booking;
        }).collect(Collectors.toList());
        return new PageImpl<>(result, pageable, entities.getTotalElements());
    }
}
