package com.jobapplication.job.job.service;

import com.jobapplication.job.job.dao.Job;
import com.jobapplication.job.job.dto.JobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> getAllJobs();
    String createJobs(List<Job> job);

    JobDTO getJobById(int id);

    boolean deleteJobs(Integer id);

    boolean updateJobs(Job job, int id);
}
