package com.jobapplication.job.job.service;


import com.jobapplication.job.job.clients.CompanyClient;
import com.jobapplication.job.job.clients.ReviewClient;
import com.jobapplication.job.job.dao.Job;
import com.jobapplication.job.job.dto.JobDTO;
import com.jobapplication.job.job.external.Company;
import com.jobapplication.job.job.external.Review;
import com.jobapplication.job.job.repository.JobRepository;
import com.jobapplication.job.mapper.JobMapper;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;
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
    private final JobRepository repository;

    @Autowired
    RestTemplate restTemplate;

    int attempt = 0;
    private final CompanyClient companyClient;

    private final ReviewClient reviewClient;

//    @Override
//    @CircuitBreaker(
//            name = "companyBreaker",
//            fallbackMethod = "companyBreakerFallback"
//    )
//    @Override
//    @Retry(name = "companyBreaker",fallbackMethod = "companyBreakerFallback")

    @Override
    @RateLimiter(name = "companyBreaker",fallbackMethod = "companyBreakerFallback")
    public List<JobDTO> getAllJobs() {
        System.out.println("Retry count "+ ++attempt);
        List<Job> jobs = repository.findAll();
        return jobs.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<String> companyBreakerFallback(Exception e){
        List<String> list = new ArrayList<>();
        list.add("Dummy");
        return list;
    }
    @Override
    public String createJobs(List<Job> job) {
        repository.saveAll(job);
        return "Job Created Successfully";
    }

    private JobDTO convertToDTO(Job job){

        Company company = companyClient.getCompany(job.getCompanyId());
        List<Review> reviews = reviewClient.getReview(job.getCompanyId());
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
