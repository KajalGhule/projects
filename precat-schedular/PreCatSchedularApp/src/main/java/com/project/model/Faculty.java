package com.project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;


@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;
    
    @NotNull(message = "Faculty name can't be blank")
    @Column(nullable = false)
    private String facultyName;
    
    @NotNull(message = "facultyEmployeeId can't be blank")
    @Column(nullable = false, unique = true)
    private int facultyEmployeeId;

    @NotNull(message = "FacultyType can't be blank")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FacultyType facultyType;  // LECTURER, LAB_FACULTY, BOTH

    @ManyToMany
    @JoinTable(
        name = "faculty_subject",
        joinColumns = @JoinColumn(name = "faculty_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )

    private List<Subject> subjects;  // Stores subject IDs instead of names

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

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", facultyEmployeeId="
				+ facultyEmployeeId + ", facultyType=" + facultyType + ", subjects=" + subjects + "]";
	}
    
    

}
