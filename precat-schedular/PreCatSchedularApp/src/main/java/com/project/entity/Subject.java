package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int duration; // Number of days

    // Constructors
    public Subject() {}

    public Subject(Long id,String name, int duration) {
    	this.id = id;
        this.name = name;
        this.duration = duration;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", name='" + name + '\'' + ", duration=" + duration + '}';
    }
}
