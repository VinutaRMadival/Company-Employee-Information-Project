package com.vco.project.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity          
@Table(name="employee") 
public class EmployeeDTO { //the Employee class is now Entity class Entity class is a class which will get mapped to a table.
	@Id    // it will make the employeeId behaves like the PK attribute.
	@GeneratedValue(strategy=GenerationType.AUTO) //The primary key generation strategy that the persistence 
	  
	@Column(name="emp_id") //provider must use to generate the annotated entity primary key
	private int employeeId;        
	
	@Column(name="emp_firstname ") 
	private String employeeFirstName;

	@Column(name="emp_middlename ") 
	private String employeeMiiddleName;
	
	@Column(name="emp_lastname ") 
	private String employeeLastName;

	@Column(name="emp_phoneno ") 
	private int employeePhoneno;
	
	@Column(name="emp_email ") 
	private String employeeEmail;
	
	@Column(name="emp_ctc ") 
	private int employeeCTC;
	
	@Column(name="emp_address ") 
	private String employeeAddress1;
	
	@Column(name="emp_locality ") 
	private String employeeLocality;
	
	@Column(name="emp_city ") 
	private String employeeCity;
	
	@Column(name="emp_doj ") 
	private Date employeeDoj;
	
	@Column(name="emp_dob ") 
	private Date employeeDob ;
	
	@Column(name="emp_gender ") 
	private String employeeGender;
	
	@Column(name="emp_job ") 
	private String employeeJob;
	
	@Column(name="employment_type ") 
	private String employmentType;
	
	//private int departmentId;
	
	//private int locationId;
	
	//private int companyId;
	
	//private int projectId;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private CompanyDTO company;
	
	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private DepartmentDTO department;
	
	
	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pro_id")
    @JsonIgnore
    private ProjectDTO project;
	
	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "loc_id")
    @JsonIgnore
    private LocationDTO location;

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeMiiddleName() {
		return employeeMiiddleName;
	}

	public void setEmployeeMiiddleName(String employeeMiiddleName) {
		this.employeeMiiddleName = employeeMiiddleName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public int getEmployeePhoneno() {
		return employeePhoneno;
	}

	public void setEmployeePhoneno(int employeePhoneno) {
		this.employeePhoneno = employeePhoneno;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public int getEmployeeCTC() {
		return employeeCTC;
	}

	public void setEmployeeCTC(int employeeCTC) {
		this.employeeCTC = employeeCTC;
	}

	public String getEmployeeAddress1() {
		return employeeAddress1;
	}

	public void setEmployeeAddress1(String employeeAddress1) {
		this.employeeAddress1 = employeeAddress1;
	}

	public String getEmployeeLocality() {
		return employeeLocality;
	}

	public void setEmployeeLocality(String employeeLocality) {
		this.employeeLocality = employeeLocality;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public Date getEmployeeDoj() {
		return employeeDoj;
	}

	public void setEmployeeDoj(Date employeeDoj) {
		this.employeeDoj = employeeDoj;
	}

	public Date getEmployeeDob() {
		return employeeDob;
	}

	public void setEmployeeDob(Date employeeDob) {
		this.employeeDob = employeeDob;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeJob() {
		return employeeJob;
	}

	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}

	public String getEmploymenType() {
		return employmentType;
	}

	public void setEmploymenType(String employmentType) {
		this.employmentType = employmentType;
	}

	
    
}
