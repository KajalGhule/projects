package com.project.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.customexception.DuplicateSubjectException;
import com.project.model.Subject;
import com.project.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
//	public Subject addSubject(Subject subjectObj) {
//		Optional<Subject> subject = subjectRepository.findBySubjectName(subjectObj.getSubjectName());
//		if(subject.isPresent()) throw new RuntimeException("Subject already exists!");;
//		return subjectRepository.save(subjectObj);
//	}
	
	public Subject addSubject(Subject subjectObj) {
	    if (subjectRepository.findBySubjectName(subjectObj.getSubjectName()).isPresent()) {
	        throw new DuplicateSubjectException("Subject already exists!");
	    }
	    return subjectRepository.save(subjectObj);
	}

	public ArrayList<Subject> getSubject() {
		ArrayList<Subject> subjects = (ArrayList<Subject>) subjectRepository.findAll();
		if(subjects.isEmpty()) return null;
		return subjects;
	}

}
