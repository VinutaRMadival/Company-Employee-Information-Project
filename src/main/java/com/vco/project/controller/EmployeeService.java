package com.vco.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.vco.project.model.CompanyDTO;
import com.vco.project.model.DepartmentDTO;
import com.vco.project.model.EmployeeDTO;
import com.vco.project.model.LocationDTO;
import com.vco.project.model.ProjectDTO;
import com.vco.project.payload.ResponsePayload;
import com.vco.project.repository.CompanyRepository;
import com.vco.project.repository.DepartmentRepository;
import com.vco.project.repository.EmployeeRepository;
import com.vco.project.repository.LocationRepository;
import com.vco.project.repository.ProjectRepository;

@Service    //indicate that a class is a "Business Service Facade"
	public class EmployeeService {
		
		@Autowired    //Marks a constructor, field, setter method, or config method as to be autowired by
		                             //Spring's dependency injection facilities.
		private EmployeeRepository employeeRepository;
		@Autowired
		private CompanyRepository companyRepository;
		@Autowired
		private DepartmentRepository deptRepository;
		@Autowired
		private LocationRepository locationRepository;
		@Autowired
		private ProjectRepository projectRepository;

		public Object saveEmployee(int comId,EmployeeDTO employee,int deptId,int locId,int projId) {
			EmployeeDTO a1=null;
			try {
				Optional<CompanyDTO>t=companyRepository.findById(comId);
				// possibility 1 :::  data is there , extract the ENTIRE details of the teacher
				// possibility 2 :::  data is NOT there , it will hold null
				CompanyDTO t1=t.get(); // if null is there is there then it will throw NoSuchElementException
				System.out.println("*** COMPANY**** name "+t1.getCompanyId()+"  "+t1.getCompanyName()+" "+t1.getCompanyAddress());
				employee.setCompany(t1);
				t1.getEmployee().add(employee);
				
				Optional<DepartmentDTO>s=deptRepository.findById(deptId);
				DepartmentDTO s1=s.get();
				employee.setDepartment(s1);
				System.out.println("*** DEPT **** name "+s1.getDepartmentId()+"  "+s1.getDepartmentCode()+" "+s1.getDepartmentName());
				s1.getEmployee().add(employee);
				// it means that there is a Set and that set holds object of employee class
				//  employee class has  name/title  , grade 
				//a1=employeeRepository.save(employee);
			
	 
				
				Optional<LocationDTO>s2=locationRepository.findById(locId);
				LocationDTO s3=s2.get();
				employee.setLocation(s3);
				System.out.println("*** LOCATION **** name "+s3.getLocationId()+"  "+s3.getLocationName()+" "+s3.getLocationState()+" "+s3.getLocationCountry());
				s3.getEmployee().add(employee);
				// it means that there is a Set and that set holds object of employee class
			
				//a1=employeeRepository.save(employee);
				
				Optional<ProjectDTO>v=projectRepository.findById(projId);
				ProjectDTO v1=v.get();
				employee.setProject(v1);;
				System.out.println("*** PROJECT **** name "+v1.getPro_id()+" "+v1.getProjectCode()+" "+v1.getProjectName()+" "+v1.getProjectPrimaryTechnology());
				v1.getEmployee().add(employee);
				// it means that there is a Set and that set holds object of employee class
			
				a1=employeeRepository.save(employee);
			
	 
			}catch(Exception ex) {
				System.out.println("Excetpion is " + ex);
				return new ResponsePayload(HttpStatus.BAD_REQUEST.value(), "Failed", ex.getMessage());
			}
			return new ResponsePayload(HttpStatus.ACCEPTED.value(), "SUCCESS", a1);
		}



		
	}



