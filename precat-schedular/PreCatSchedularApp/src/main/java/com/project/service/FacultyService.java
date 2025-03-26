package com.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.customexception.DuplicateFacultyException;
import com.project.customexception.DuplicateSubjectException;
import com.project.dto.FacultyDTO;
import com.project.model.Faculty;
import com.project.model.Subject;
import com.project.repository.FacultyRepository;
import com.project.repository.SubjectRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;


@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Faculty saveFaculty(Faculty facultyDetails) {
		Optional<Faculty> existingFaculty = facultyRepository.findByFacultyEmployeeId(facultyDetails.getFacultyEmployeeId());
	    if (existingFaculty.isPresent()) {
	    	throw new DuplicateFacultyException("Faculty already exists with same Employee Id!"+facultyDetails.getFacultyEmployeeId()); 
	    }
	    if (facultyDetails.getSubjects() != null && !facultyDetails.getSubjects().isEmpty()) {
	        List<Long> subjectIds = checkSubjectIds(facultyDetails);

	        List<Subject> existingSubjects = subjectRepository.findAllById(subjectIds);

	        if (existingSubjects.size() != subjectIds.size()) {
	            return null;
	        }

	        facultyDetails.setSubjects(existingSubjects);
	    }
		return facultyRepository.save(facultyDetails);
	}

	@Transactional
    public Faculty updateFacultyById(Long id, Faculty facultyDetails) {
		 
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);

        if (facultyOptional.isEmpty()) {
            return null; // Handle in the controller
        }
        
        Faculty existingFaculty = facultyOptional.get();
        
        boolean updateFacultyType = facultyDetails.getFacultyType() != null;
        boolean updateSubjects = facultyDetails.getSubjects() != null && !facultyDetails.getSubjects().isEmpty();

        if (!updateFacultyType && !updateSubjects) {
            return null; // No valid fields to update
        }

        if (updateFacultyType) {
            existingFaculty.setFacultyType(facultyDetails.getFacultyType());
        }

        if (updateSubjects) {
            List<Long> subjectIds = checkSubjectIds(facultyDetails);
            List<Subject> existingSubjects = subjectRepository.findAllById(subjectIds);

            // Check if all provided subjects exist
            if (existingSubjects.size() != subjectIds.size()) {
                return null; // Handle missing subjects in the controller
            }

            existingFaculty.setSubjects(existingSubjects);
        }

        return facultyRepository.save(existingFaculty);
    }
	
	public List<Long> checkSubjectIds(Faculty faculty) {
		List<Long> subjectIds = faculty.getSubjects()
    			.stream()
    			.map(Subject::getSubjectId)
    			.collect(Collectors.toList());
		if(subjectIds.isEmpty()) return null;
		
		return subjectIds;
	}

//	public Faculty deleteFaculty(int facultyEmployeeId) {
//		Optional<Faculty> faculty = facultyRepository.findById(facultyEmployeeId);
//	    if (faculty.isPresent()) {
//	        facultyRepository.deleteById(facultyEmployeeId);
//	        return faculty.get();
//	    }
//	    return null;
//	}
	
	@Transactional
	public Faculty deleteFaculty(int facultyEmployeeId) {
        Optional<Faculty> faculty = facultyRepository.findByFacultyEmployeeId(facultyEmployeeId);
        
        if (faculty.isPresent()) {
            facultyRepository.deleteByFacultyEmployeeId(facultyEmployeeId);
            return faculty.get();
        }
        return null; 
    }
	
	@PersistenceContext
    private EntityManager entityManager;

	@Transactional
    public List<FacultyDTO> getAllFaculty() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GetAllFaculty", Faculty.class);
        List<Faculty> faculties = query.getResultList();
        return faculties.stream().map(FacultyDTO::new).collect(Collectors.toList());
    }

}
