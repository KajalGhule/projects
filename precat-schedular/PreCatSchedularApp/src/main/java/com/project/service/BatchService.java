package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Schedule;
import com.project.model.Batch;
import com.project.repository.BatchRepository;


@Service
public class BatchService {
	
	@Autowired
	private BatchRepository batchRepository;
	public Batch createBatch(Batch batch) {
		return batchRepository.save(batch);
	}
	public Schedule scheduleBatch(String batchName) {
		// check batch is already schedule or not 
		//if yes show sms already scheduled
		// if not 
		//1.select subjects and faculty check faculty are free or not
		
		return null;
	}
	


}
