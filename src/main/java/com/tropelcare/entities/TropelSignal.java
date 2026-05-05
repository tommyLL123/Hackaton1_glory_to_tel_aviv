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
@Table(name = "tropel_signals")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class TropelSignal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tropel_id")
    private Tropel tropel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guardian_id")
    private Guardian guardian;

    private String senderTag;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String rawContent;

    private String signalType;
    private String severity;
    private String assignedUnit;

    @Column(columnDefinition = "TEXT")
    private String recommendedAction;

    private String status;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @OneToOne(mappedBy = "signal")
    private CareResponse careResponse;

    @OneToMany(mappedBy = "signal")
    private List<NotificationLog> notifications;
}
