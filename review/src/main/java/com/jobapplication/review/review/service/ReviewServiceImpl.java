package com.jobapplication.review.review.service;


import com.jobapplication.review.review.dao.Review;
import com.jobapplication.review.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewServiceImpl implements RevieService{

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean postAReview(Review review, Long companyId) {
//        Company company =companyService.getCompanyById(id);

        if (companyId!=null && review !=null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public Review getReviewByCompanyId(Integer reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Review review, Integer reviewId) {

        Review review1 = reviewRepository.findById(reviewId).orElse(null);

       if (review1 != null){

           review1.setTitle(review.getTitle());
           review1.setDescription(review.getDescription());
           review1.setRating(review.getRating());
           review1.setCompanyId(review.getCompanyId());
           reviewRepository.save(review1);

           return true;
       }
       return false;
    }
}
