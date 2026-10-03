package com.jobapplication.company.company.controller;

import com.jobapplication.company.company.dao.Company;
import com.jobapplication.company.company.service.CompanyService;
import com.jobapplication.company.company.service.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyServiceImpl companyServiceImpl;
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyServiceImpl.getAllCompanies());
    }

    @PostMapping("/createCompanies")
    public ResponseEntity<String> createNewCompany(@RequestBody List<Company> company){
        String company1 = companyServiceImpl.createNewCompany(company);
        return ResponseEntity.ok(company1);
    }

    @PutMapping("/updateCompany/{id}")
    public ResponseEntity<Boolean> updateCompany(@RequestBody Company company,@PathVariable Integer id){
        boolean company1 = companyServiceImpl.updateCompany(company, id);

        if (company1)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable Integer id){
        boolean company = companyServiceImpl.deleteCompany(id);
        if (company)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer companyId){

        Company company = companyService.getCompanyById(companyId);

        if (company!=null){
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.notFound().build();
    }

}
