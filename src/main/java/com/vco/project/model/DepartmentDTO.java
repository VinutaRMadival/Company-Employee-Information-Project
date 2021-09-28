package com.vco.project.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity          //the DepartmentDTO class is now Entity class Entity class is a class which will get mapped to a table. 
@Table (name="department")        //will help us to map a particular table
public class DepartmentDTO
{
	@Id                              //Specifies the primary key of an entity.
	@GeneratedValue(strategy = GenerationType.AUTO)//The primary key generation strategy that the persistence
	 
	@Column(name="department_id")//provider must use to generate the annotated entity primary key
	private int departmentId;//primary attribute of the class
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_code")
	private String departmentCode;
         
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
	private Set<EmployeeDTO> employee;
	


	public Set<EmployeeDTO> getEmployee() {
	return employee;
	}

	public void setEmployee(Set<EmployeeDTO> employee) {
		this.employee = employee;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}


}
