package com.project.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.model.Faculty;

@Repository
public interface f extends JpaRepository<com.project.entity.Faculty, Long> {
    
	@Query("SELECT CASE WHEN COUNT(bs) = 0 THEN TRUE ELSE FALSE END " +
	           "FROM BatchSubject bs WHERE bs.faculty.id = :facultyId " +
	           "AND ((bs.startDate BETWEEN :startDate AND :endDate) OR " +
	           "(bs.endDate BETWEEN :startDate AND :endDate))")
	    boolean isAvailable(@Param("facultyId") Long facultyId, 
	                        @Param("startDate") LocalDate startDate, 
	                        @Param("endDate") LocalDate endDate);
}

