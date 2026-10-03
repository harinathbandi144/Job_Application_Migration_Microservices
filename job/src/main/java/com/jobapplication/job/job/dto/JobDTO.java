package com.jobapplication.job.job.dto;

import com.jobapplication.job.job.external.Company;
import com.jobapplication.job.job.external.Review;
import lombok.Data;

import java.util.List;

@Data
public class JobDTO {
    private Integer id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String locations;
    private Company company;
    private List<Review> review;


}
