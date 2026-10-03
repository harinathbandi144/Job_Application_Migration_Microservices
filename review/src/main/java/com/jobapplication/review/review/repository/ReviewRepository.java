package com.jobapplication.review.review.repository;

import com.jobapplication.review.review.dao.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByCompanyId(Long companyId);

    void findAllById(Integer reviewId);
}
