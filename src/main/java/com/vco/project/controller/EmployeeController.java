package com.vco.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.vco.project.model.EmployeeDTO;
import com.vco.project.repository.CompanyRepository;
import com.vco.project.repository.EmployeeRepository;

@RestController              //This annotation will specify the creation of RESTFUL web services.
@RequestMapping("/api/v1")    // This annotation can be used both at the class and at the method level. In most cases, at the method level applications willprefer to use one of the HTTP method specific variants

public class EmployeeController {
    @Autowired               //This annotation is used to inject the object dependency implicitly
    private EmployeeRepository employeeRepository;
 
    //Get all the departments
    
    @GetMapping("/employee")
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll();
    }
 //Get the particular department
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> getCompanyById(@PathVariable(value = "id") Integer employeeId)
        throws ResourceNotFoundException {
    	//System.out.println(employeeId+"get method");
    	//Integer i=new Integer(Integer.parseInt(employeeId));
    	Integer i=employeeId;
    	//System.out.println("converting to integer"+i);
    	Optional<EmployeeDTO> employee = employeeRepository.findById(5);
          employee.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }
    //Insert the Department details
    
    @PostMapping("/employee")
    public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        return employeeRepository.save(employee);
    }
 
    //Update the departmentDetails
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(value = "id") Integer employeeId,
         @Valid @RequestBody EmployeeDTO employeeDetails) throws ResourceNotFoundException {
    	//Integer i=new Integer(Integer.parseInt(employeeId));
    	EmployeeDTO employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        System.out.println("employee");
    	employee.setEmployeeId(employeeDetails.getEmployeeId());
    	employee.setEmployeeFirstName(employeeDetails.getEmployeeFirstName());
    	employee.setEmployeeMiiddleName(employeeDetails.getEmployeeMiiddleName());
    	employee.setEmployeeLastName(employeeDetails.getEmployeeLastName());
    	employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
        employee.setEmployeePhoneno(employeeDetails.getEmployeePhoneno());
    	employee.setEmployeeAddress1(employeeDetails.getEmployeeAddress1());
    	employee.setEmployeeCity(employeeDetails.getEmployeeCity());
    	employee.setEmployeeDob(employeeDetails.getEmployeeDob());
    	employee.setEmployeeDoj(employeeDetails.getEmployeeDoj());
    	employee.setEmployeeGender(employeeDetails.getEmployeeGender());
    	employee.setEmployeeCTC(employeeDetails.getEmployeeCTC());
    	employee.setEmployeeJob(employeeDetails.getEmployeeJob());
    	employee.setEmployeeLocality(employeeDetails.getEmployeeLocality());
    	employee.setEmploymenType(employeeDetails.getEmploymenType());
    	employee.setCompany(employeeDetails.getCompany());
    	employee.setDepartment(employeeDetails.getDepartment());
    	employee.setLocation(employeeDetails.getLocation());
    	employee.setProject(employeeDetails.getProject());
        final EmployeeDTO updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
    // Delete the department with particular id
    @DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") Integer employeeId)
         throws ResourceNotFoundException {
    	//Integer i=new Integer(Integer.parseInt(employeeId));
    	EmployeeDTO employee = employeeRepository.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

    	employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}