package com.hotel.room.entities;



import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    
    @Id
    private Long id;

    private String roomType;
    private BigDecimal roomPrice;
}

