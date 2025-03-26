package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueId;

    @Column(nullable = false)
    private String venueName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocationEnum location;
    
    public enum LocationEnum {
        MARKETYARD, HINJEWADI
    }
}
