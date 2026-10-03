package com.jobapplication.company.company.repository;

import com.jobapplication.company.company.dao.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> getCompanyById(Integer id);
}
