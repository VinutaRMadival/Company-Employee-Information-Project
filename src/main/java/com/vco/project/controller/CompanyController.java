package com.vco.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vco.project.exception.ResourceNotFoundException;
import com.vco.project.model.CompanyDTO;

import com.vco.project.repository.CompanyRepository;


@RestController              //This annotation will specify the creation of RESTFUL web services.
@RequestMapping("/api/v1")    // This annotation can be used both at the class and at the method level. In most cases, at the method level applications willprefer to use one of the HTTP method specific variants

public class CompanyController {
    @Autowired               //This annotation is used to inject the object dependency implicitly
    private CompanyRepository companyRepository;
 
    //Get all the departments
    
    @GetMapping("/company")
    public List<CompanyDTO> getAllCompany() {
        return companyRepository.findAll();
    }
 //Get the particular department
    
    @GetMapping("/company/{id}")
    public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable(value = "id") Integer companyId)
        throws ResourceNotFoundException {
    	CompanyDTO company = companyRepository.findById(companyId)
          .orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));
        return ResponseEntity.ok().body(company);
    }
    //Insert the Department details
    
    @PostMapping("/company")
    public CompanyDTO createCompany(@Valid @RequestBody CompanyDTO company) {
        return companyRepository.save(company);
    }
 
    //Update the departmentDetails
    @PutMapping("/company/{id}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable(value = "id") Integer companyId,
         @Valid @RequestBody CompanyDTO companyDetails) throws ResourceNotFoundException {
    	CompanyDTO company = companyRepository.findById(companyId)
        .orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));

    	//company.setCompanyId(companyDetails.getCompanyId());
    	company.setCompanyName(companyDetails.getCompanyName());
    	company.setCompanyEmail(companyDetails.getCompanyEmail());
    	company.setCompanyPhoneNo(companyDetails.getCompanyPhoneNo());
    	//company.setEmployee(companyDetails.getEmployee());
        final CompanyDTO updatedCompany = companyRepository.save(company);
        return ResponseEntity.ok(updatedCompany);
    }
    // Delete the department with particular id
    @DeleteMapping("/company/{id}")
    public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") Integer companyId)
         throws ResourceNotFoundException {
    	CompanyDTO company = companyRepository.findById(companyId)
       .orElseThrow(() -> new ResourceNotFoundException("Company not found for this id :: " + companyId));

    	companyRepository.delete(company);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}