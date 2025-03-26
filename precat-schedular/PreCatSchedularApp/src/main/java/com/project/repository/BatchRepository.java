package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
}
