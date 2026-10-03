package com.jobapplication.job.job.service;


import com.jobapplication.job.job.dao.Job;
import com.jobapplication.job.job.dto.JobDTO;
import com.jobapplication.job.job.external.Company;
import com.jobapplication.job.job.external.Review;
import com.jobapplication.job.job.repository.JobRepository;
import com.jobapplication.job.mapper.JobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<>();
    //private Integer nextId = 1;
    private final JobRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<JobDTO> getAllJobs() {

        List<Job> jobs = repository.findAll();
        List<JobDTO> jobWithCompanyDTOS = new ArrayList<>();

//        for(Job j : jobs){
//            JobWithCompanyDTO jobsDTO = new JobWithCompanyDTO();
//            jobsDTO.setJob(j);
//            Company company =restTemplate.getForObject("http://COMPANY:8091/company/" + j.getCompanyId(), Company.class);
//            jobsDTO.setCompany(company);
//            jobWithCompanyDTOS.add(jobsDTO);
//        }
        return jobs.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String createJobs(List<Job> job) {
//
//        for(Job j:job){
//            j.setId(nextId++);
//        }
        repository.saveAll(job);
        return "Job Created Successfully";
    }

    private JobDTO convertToDTO(Job job){

        Company company = restTemplate.getForObject("http://COMPANY:8091/company/" +job.getCompanyId(), Company.class);

        Review[] reviewArray = restTemplate.getForObject(
                "http://REVIEW:8092/reviews?companyId=" + job.getCompanyId(),
                Review[].class
        );

        List<Review> reviews = Arrays.asList(reviewArray);
        JobDTO jobDTO = JobMapper.mapToCompanyDtos(job, company, reviews);

        return jobDTO;
    }

    @Override
    public JobDTO getJobById(int id) {
        Job job = repository.findById(id).orElse(null);
        return convertToDTO(job);
    }

    @Override
    public boolean deleteJobs(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public boolean updateJobs(Job job, int id) {
        Optional<Job> optionalJob = repository.findById(id);
        if(optionalJob.isPresent()){
            Job job1=optionalJob.get();

            job1.setTitle(job.getTitle());
            job1.setDescription(job.getDescription());
            job1.setMinSalary(job.getMinSalary());
            job1.setMaxSalary(job.getMaxSalary());
            job1.setLocations(job.getLocations());
            return true;
        }
        return false;
    }
}
