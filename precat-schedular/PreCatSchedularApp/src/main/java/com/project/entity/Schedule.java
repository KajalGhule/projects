package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Batch batch;
    
    @ManyToOne
    private Subject subject;
    
    @ManyToOne
    private Faculty faculty;
    
    private LocalDate startDate;
    private LocalDate endDate;

    // Constructors
    public Schedule() {}

    public Schedule(Batch batch, Subject subject, Faculty faculty, LocalDate startDate, LocalDate endDate) {
        this.batch = batch;
        this.subject = subject;
        this.faculty = faculty;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Batch getBatch() { return batch; }
    public void setBatch(Batch batch) { this.batch = batch; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public Faculty getFaculty() { return faculty; }
    public void setFaculty(Faculty faculty) { this.faculty = faculty; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", batch=" + batch.getBatchName() + ", subject=" + subject.getName() + 
               ", faculty=" + faculty.getName() + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
}
