package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String batchType;  // Regular or Crash


    @ManyToOne
    @JoinColumn(name = "lecture_venue_id")
    private Venue lectureVenue;

    @ManyToOne
    @JoinColumn(name = "lab_venue_id")
    private Venue labVenue;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BatchSubject> batchSubjects;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Venue getLectureVenue() { return lectureVenue; }
    public void setLectureVenue(Venue lectureVenue) { this.lectureVenue = lectureVenue; }

    public Venue getLabVenue() { return labVenue; }
    public void setLabVenue(Venue labVenue) { this.labVenue = labVenue; }

    public List<BatchSubject> getBatchSubjects() { return batchSubjects; }
    public void setBatchSubjects(List<BatchSubject> batchSubjects) { this.batchSubjects = batchSubjects; }
    
    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

}
