package com.jobapplication.job.job.repository;

import com.jobapplication.job.job.dao.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {


}
