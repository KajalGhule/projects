package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	Optional<Subject> findBySubjectName(String subjectName);
}
