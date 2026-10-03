package com.jobapplication.review.review.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private double rating;

//    @JsonIgnore
//    @ManyToOne
//    private Company company;

    private Long companyId;
}
