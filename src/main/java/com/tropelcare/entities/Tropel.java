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
@Table(name = "tropels", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Tropel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String vitalState;

    @Column(nullable = false)
    private Integer energyLevel;

    @Column(nullable = false)
    private Integer chaosIndex;

    @Column(nullable = false)
    private Integer mutationStage;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guardian_id")
    private Guardian guardian;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "tropel")
    private List<TropelSignal> signals;
}
