package com.tropelcare.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "sectors", uniqueConstraints = {
        @UniqueConstraint(columnNames = "sectorCode")
})
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String sectorCode;

    @Column(nullable = false)
    private String climate;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Integer currentLoad;

    @Column(nullable = false)
    private Integer stabilityLevel;

    @Column(nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "sector")
    private List<Tropel> tropels;
}
