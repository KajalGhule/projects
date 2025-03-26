package com.project.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

    @Query("SELECT CASE WHEN COUNT(b) = 0 THEN TRUE ELSE FALSE END " +
           "FROM Batch b WHERE (b.lectureVenue.id = :venueId OR b.labVenue.id = :venueId) " +
           "AND ((b.startDate BETWEEN :startDate AND :endDate) OR " +
           "(b.endDate BETWEEN :startDate AND :endDate))")
    boolean isAvailable(@Param("venueId") Long venueId, 
                        @Param("startDate") LocalDate startDate, 
                        @Param("endDate") LocalDate endDate);
}
