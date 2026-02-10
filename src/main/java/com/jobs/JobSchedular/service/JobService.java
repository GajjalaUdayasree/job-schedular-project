package com.jobs.JobSchedular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.JobSchedular.model.*;
import com.jobs.JobSchedular.repository.*;

@Service
public class JobService {

    @Autowired
    private JobRepository repo;

    // create job
    public Job saveJob(Job job){
        job.setStatus("PENDING");
        return repo.save(job);
    }

    // get all jobs
    public List<Job> getAllJobs(){
        return repo.findAll();
    }

    // get job by id
    public Job getJobById(Long id){
        return repo.findById(id).orElse(null);
    }

    // run job
    public Job runJob(Long id) throws Exception{
        Job job = repo.findById(id).orElse(null);

        if(job!=null){
            job.setStatus("RUNNING");
            repo.save(job);

            Thread.sleep(3000);

            job.setStatus("COMPLETED");
            repo.save(job);
        }

        return job;
    }


//update job
public Job updateJob(Long id, Job job){
 Job existing = repo.findById(id).orElse(null);

 if(existing != null){
     existing.setTaskName(job.getTaskName());
     existing.setPayload(job.getPayload());
     existing.setPriority(job.getPriority());
     existing.setStatus(job.getStatus());
     return repo.save(existing);
 }
 return null;
}

//delete job
public String deleteJob(Long id){
 repo.deleteById(id);
 return "Deleted Successfully";
}

}

