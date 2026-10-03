package com.jobapplication.review.review.controller;

import com.jobapplication.review.review.dao.Review;
import com.jobapplication.review.review.service.RevieService;
import com.jobapplication.review.review.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewServiceImpl reviewServiceImpl;
    private final RevieService revieService;

    @GetMapping
    public ResponseEntity<List<Review>> getALlReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(revieService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> writeAReview(@RequestBody Review review, @RequestParam Long companyId){
        boolean isReviewSaved = revieService.postAReview(review, companyId);

        if (isReviewSaved){
            return new ResponseEntity<>("Review posted", HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("{reviewId}")
    public ResponseEntity<Review> getReviewByCompany(@PathVariable Integer reviewId){
        return new ResponseEntity<>(revieService.getReviewByCompanyId(reviewId), HttpStatus.OK);
    }

    @PutMapping("{reviewId}")
    public ResponseEntity<String> updateReviews(@RequestBody Review review, @PathVariable Integer reviewId)
    {

       boolean isReviews = revieService.updateReview(review, reviewId);
       if (isReviews)
            return new ResponseEntity<>("Review is updated", HttpStatus.OK);
       else
            return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
    }

}
