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
import com.vco.project.model.DepartmentDTO;
import com.vco.project.repository.DepartmentRepository;

@RestController              //This annotation will specify the creation of RESTFUL web services.
@RequestMapping("/api/v1")    // This annotation can be used both at the class and at the method level. In most cases, at the method level applications willprefer to use one of the HTTP method specific variants

public class DepartmentController {
    @Autowired               //This annotation is used to inject the object dependency implicitly
    private DepartmentRepository deptRepository;
 
    //Get all the departments
    
    @GetMapping("/departments")
    public List<DepartmentDTO> getAllDepartments() {
        return deptRepository.findAll();
    }
 //Get the particular department
    
    @GetMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable(value = "id") Integer departmentId)
        throws ResourceNotFoundException {
    	DepartmentDTO department = deptRepository.findById(departmentId)
          .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
        return ResponseEntity.ok().body(department);
    }
    //Insert the Department details
    
    @PostMapping("/departments")
    public DepartmentDTO createDepartment(@Valid @RequestBody DepartmentDTO department) {
        return deptRepository.save(department);
    }
 
    //Update the departmentDetails
    @PutMapping("/departments/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable(value = "id") Integer departmentId,
         @Valid @RequestBody DepartmentDTO departmentDetails) throws ResourceNotFoundException {
    	DepartmentDTO department = deptRepository.findById(departmentId)
        .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
    	System.out.println("put is working"+ departmentId);

    	//department.setDepartmentId(departmentDetails.getDepartmentId());
    	department.setDepartmentCode(departmentDetails.getDepartmentCode());
    	department.setDepartmentName(departmentDetails.getDepartmentName());
        final DepartmentDTO updatedDepartment = deptRepository.save(department);
        System.out.println("successfully saved in department");
        return ResponseEntity.ok(updatedDepartment);
    }
    // Delete the department with particular id
    @DeleteMapping("/departments/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Integer departmentId)
         throws ResourceNotFoundException {
    	DepartmentDTO department = deptRepository.findById(departmentId)
       .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));

    	deptRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}