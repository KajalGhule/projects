package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Subject;
import com.project.service.SubjectService;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	@PostMapping("/addSubject")
	public ResponseEntity<String> addSubject(@RequestBody Subject subject) {
		Subject sub = subjectService.addSubject(subject);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Subject Added Successfully!!!");
	}
	@GetMapping("/getsubjects")
	public ResponseEntity<ArrayList<Subject>> getSubject() {
		ArrayList<Subject> sub = subjectService.getSubject();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(sub);
	}
}
