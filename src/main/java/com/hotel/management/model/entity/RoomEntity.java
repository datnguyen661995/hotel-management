package com.hotel.management.model.entity;

import com.hotel.management.model.enums.Availability;
import com.hotel.management.model.enums.RoomType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "room",schema = "hotel-management-service")
public class RoomEntity extends BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RoomType type;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "price")
    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability")
    private Availability availability;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotelEntity;

    @OneToMany(mappedBy = "roomEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookingEntity> bookingEntities = new ArrayList<>();
}
