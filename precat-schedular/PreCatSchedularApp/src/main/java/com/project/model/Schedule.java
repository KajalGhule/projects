package com.project.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "batch_id", nullable = false)
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;  

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleType scheduleType;

    @Column(nullable = false)
    private LocalDate scheduleDate;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    public enum ScheduleType {
        LECTURE, LAB
    }

    @PrePersist
    @PreUpdate
    private void validateSchedule() {
        if (scheduleType == ScheduleType.LECTURE && faculty == null) {
            throw new IllegalArgumentException("Lecture must have a faculty assigned.");
        }
        
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
    }
}
