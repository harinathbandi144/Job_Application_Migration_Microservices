package com.jobapplication.company.company.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<Job> jobs;
    private Long jobId;


//    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    private List<Review> reviews;

    private String Reviews;

}
