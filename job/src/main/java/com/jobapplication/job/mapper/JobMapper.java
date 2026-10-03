package com.jobapplication.job.mapper;

import com.jobapplication.job.job.dao.Job;
import com.jobapplication.job.job.dto.JobDTO;
import com.jobapplication.job.job.external.Company;
import com.jobapplication.job.job.external.Review;

import java.util.List;

public class JobMapper {

    public static JobDTO mapToCompanyDtos(Job job, Company company, List<Review> reviews){
        JobDTO jobWithCompanyDTO = new JobDTO();
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocations(job.getLocations());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReview(reviews);

        return jobWithCompanyDTO;
    }
}
