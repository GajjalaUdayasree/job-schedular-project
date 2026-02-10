package com.jobs.JobSchedular.repository;

import org.springframework.data.jpa.repository.*;
import com.jobs.JobSchedular.model.Job;


public interface JobRepository extends JpaRepository <Job,Long> {

}
