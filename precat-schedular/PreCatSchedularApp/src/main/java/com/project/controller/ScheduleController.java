package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Faculty;
import com.project.entity.Schedule;
import com.project.entity.Subject;
import com.project.model.Batch;
import com.project.service.BatchService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private BatchService batchService;

    @PostMapping("/assign")
    public ResponseEntity<Schedule> assignSubject(@RequestParam String batchName) {
    	Schedule scheduleBatch = batchService.scheduleBatch(batchName);
         return ResponseEntity.ok(scheduleBatch); 
    }
}
