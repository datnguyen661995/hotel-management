package com.hotel.management.repository;

import com.hotel.management.model.entity.BookingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    Page<BookingEntity> findByCustomerEntityIdOrCustomerEntityEmailOrCustomerEntityPhone(String name, String email, String phone, Pageable pageable);
}
