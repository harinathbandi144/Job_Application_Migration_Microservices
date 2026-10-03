package com.jobapplication.company.company.service;


import com.jobapplication.company.company.dao.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    String createNewCompany(List<Company> company);

    boolean updateCompany(Company company, Integer id);

    boolean deleteCompany(Integer id);

    Company getCompanyById(Integer id);
}
