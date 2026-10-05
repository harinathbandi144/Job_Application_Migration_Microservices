package com.jobapplication.job.job.clients;

import com.jobapplication.job.job.external.Company;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY", url = "${company.url}")
public interface CompanyClient {

    @GetMapping("company/{companyId}")
    Company getCompany(@PathVariable("companyId") Long id);
}
