package com.jobapplication.review.review.service;

import com.jobapplication.review.review.dao.Review;

import java.util.List;

public interface RevieService {

    List<Review> getAllReviews(Long companyId);

    boolean postAReview(Review review, Long companyId);

    Review getReviewByCompanyId(Integer reviewId);

    boolean updateReview(Review review, Integer reviewId);
}
