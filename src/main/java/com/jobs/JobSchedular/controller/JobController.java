package com.jobs.JobSchedular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobs.JobSchedular.model.*;
import com.jobs.JobSchedular.service.*;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
public class JobController {

    @Autowired
    private JobService service;

    // create job
    @PostMapping
    public Job createJob(@RequestBody Job job){
        return service.saveJob(job);
    }

    // get all jobs
    @GetMapping
    public List<Job> getAll(){
        return service.getAllJobs();
    }

    // get job by id
    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id){
        return service.getJobById(id);
    }

    // run job
    @PostMapping("/run/{id}")
    public Job runJob(@PathVariable Long id) throws Exception{
        return service.runJob(id);
    }
    
    @PutMapping("/jobs/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job){
        return service.updateJob(id, job);
    }
    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable Long id){
        return service.deleteJob(id);
    }

}
