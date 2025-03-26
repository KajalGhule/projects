package com.project.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.project.model.Faculty;
import com.project.model.FacultyType;
import com.project.model.Subject;


public class FacultyDTO {
    private Long facultyId;
    private String facultyName;
    private int facultyEmployeeId;
    private FacultyType facultyType;  // LECTURER, LAB_FACULTY, BOTH
    private List<String> subjects;

    // Constructor to map Faculty entity to DTO
    public FacultyDTO(Faculty faculty) {
        this.facultyId = faculty.getFacultyId();
        this.facultyName = faculty.getFacultyName();
        this.facultyEmployeeId = faculty.getFacultyEmployeeId();
        this.facultyType = faculty.getFacultyType();
        this.subjects = faculty.getSubjects()
                               .stream()
                               .map(Subject::getSubjectName)  // Subject has a getSubjectName() method
                               .collect(Collectors.toList());
    }

    // Getters and Setters
    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getFacultyEmployeeId() {
        return facultyEmployeeId;
    }

    public void setFacultyEmployeeId(int facultyEmployeeId) {
        this.facultyEmployeeId = facultyEmployeeId;
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public void setFacultyType(FacultyType facultyType) {
        this.facultyType = facultyType;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
