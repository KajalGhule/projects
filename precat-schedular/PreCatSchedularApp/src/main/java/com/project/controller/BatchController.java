package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Batch;
import com.project.service.BatchService;

@RestController
@RequestMapping("/batches")
public class BatchController {
    
    @Autowired
    private BatchService batchService;
    
    @PostMapping
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch) {
        Batch savedBatch = batchService.createBatch(batch);
        return ResponseEntity.ok(savedBatch);
    }
}
