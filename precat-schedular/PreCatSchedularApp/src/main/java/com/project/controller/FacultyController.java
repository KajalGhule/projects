package com.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.FacultyDTO;
import com.project.model.Faculty;
import com.project.service.FacultyService;

import jakarta.validation.Valid;

//@Slf4j
@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "http://localhost:3000")
public class FacultyController {
	
	private static final Logger logger = LoggerFactory.getLogger(FacultyController.class);

	@Autowired
	private FacultyService facultyService;

	@PostMapping("/addfaculty")
	public ResponseEntity<String> addFaculty(@Valid @RequestBody Faculty facultyDetails) {
		logger.info("addFaculty methos call");
		Faculty savedFaculty =  facultyService.saveFaculty(facultyDetails);
		if (savedFaculty == null) {
			logger.info("Faculty is already present");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("One or more subjects do not exist!");
	    }
		
		logger.info("Faculty is added successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body("Faculty Add SuccessFully");
	}
//	
//	@PatchMapping("/updatefaculty/{id}")
//	public ResponseEntity<String> updateFaculty(@PathVariable Long id, @RequestBody Faculty facultyDetails) {
//	    Faculty updatedFaculty = facultyService.updateFacultyById(id, facultyDetails);
//
//	    if (updatedFaculty == null) {
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Faculty ID or Subjects do not exist!");
//	    }
//
//	    return ResponseEntity.status(HttpStatus.OK).body("Faculty updated successfully!");
//	}


	@PatchMapping("/updatefaculty")
	public ResponseEntity<String> updateFaculty(@RequestParam Long id, @RequestBody Faculty facultyDetails) {
	    Faculty updatedFaculty = facultyService.updateFacultyById(id, facultyDetails);

	    if (updatedFaculty == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Faculty ID or Subjects do not exist!");
	    }

	    return ResponseEntity.status(HttpStatus.OK).body("Faculty updated successfully!");
	}
	
	@DeleteMapping("/deletefaculty/{facultyEmployeeId}")
	public ResponseEntity<String> deleteFAculty(@PathVariable int facultyEmployeeId) {
		Faculty deletedFacutlty = facultyService.deleteFaculty(facultyEmployeeId);
		if(deletedFacutlty == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Faculty ID");
		}
		return ResponseEntity.status(HttpStatus.OK).body("Faculty Deleted Successfully Emploree Id "+deletedFacutlty.getFacultyEmployeeId());
	}
	
	 @GetMapping("/all")
	    public ResponseEntity<List<FacultyDTO>> getAllFaculty() {
	        return ResponseEntity.ok(facultyService.getAllFaculty());
	    }

}
