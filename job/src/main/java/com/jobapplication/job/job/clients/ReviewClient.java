package com.jobapplication.job.job.clients;

import com.jobapplication.job.job.external.Review;
import jakarta.ws.rs.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEW")
public interface ReviewClient {

    @GetMapping("reviews")
    List<Review> getReview(@RequestParam("companyId") Long companyId);
}
