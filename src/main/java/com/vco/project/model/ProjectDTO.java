package com.vco.project.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity          //the ProjectDTO class is now Entity class Entity class is a class which will get mapped to a table. 
@Table(name="project")  //will help us to map a particular table
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProjectDTO implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id    // it will make the projectId behaves like the PK attribute.
	@GeneratedValue(strategy=GenerationType.AUTO)//The primary key generation strategy that the persistence
	@Column(name="pro_id")                                      //provider must use to generate the annotated entity primary key
    private int pro_id;         //primary attribute of the class
	
	@Column(name="pro_code")
	private String projectCode;
	
	@Column(name="pro_name")
	private String projectName;

	@Column(name="pro_client_name")
	private String  projectClient;
	
	@Column(name="pro_industry")
	private String projectIndustry;
	
	@Column(name="pro_startdate")
	private String projectStartDate;

	@Column(name="pro_enddate")
	private String projectEndDate;

	@Column(name="pro_budget")
	private int projectBudget;
	
	@Column(name="pro_primarytechnology ")
	private String projectPrimaryTechnology;

	@Column(name="pro_secondarytechnology ")
	private String projectSecondaryTechnology;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<EmployeeDTO> employee;

	public ProjectDTO() {
		super();
	}

	public ProjectDTO(int pro_id, String projectCode, String projectName, String projectClient, String projectIndustry,
			String projectStartDate, String projectEndDate, int projectBudget, String projectPrimaryTechnology,
			String projectSecondaryTechnology) {
		super();
		this.pro_id = pro_id;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.projectClient = projectClient;
		this.projectIndustry = projectIndustry;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectBudget = projectBudget;
		this.projectPrimaryTechnology = projectPrimaryTechnology;
		this.projectSecondaryTechnology = projectSecondaryTechnology;
		
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectClient() {
		return projectClient;
	}

	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}

	public String getProjectIndustry() {
		return projectIndustry;
	}

	public void setProjectIndustry(String projectIndustry) {
		this.projectIndustry = projectIndustry;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public int getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(int projectBudget) {
		this.projectBudget = projectBudget;
	}

	public String getProjectPrimaryTechnology() {
		return projectPrimaryTechnology;
	}

	public void setProjectPrimaryTechnology(String projectPrimaryTechnology) {
		this.projectPrimaryTechnology = projectPrimaryTechnology;
	}

	public String getProjectSecondaryTechnology() {
		return projectSecondaryTechnology;
	}

	public void setProjectSecondaryTechnology(String projectSecondaryTechnology) {
		this.projectSecondaryTechnology = projectSecondaryTechnology;
	}

	public Set<EmployeeDTO> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeDTO> employee) {
		this.employee = employee;
	}

	
}
	


	
	
	
	



