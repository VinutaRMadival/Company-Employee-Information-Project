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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "company")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Annotation that can be used to either suppress serialization of
                                                              // properties (during serialization), or ignore processing of
                                                                  //JSON properties read (during deserialization).
public class CompanyDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="company_id")
		private int companyId;
		
		@Column(name="company_name")
		private String companyName;
		
		@Column(name="company_email")
		private String companyEmail;
		
		@Column(name="company_phoneno")
		private int companyPhoneNo;
		
		@Column(name="company_address")
		private String companyAddress;
		
	  @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
	 
	    private Set<EmployeeDTO> employee;
		
		
	    public CompanyDTO() {
			super();
		}
		

     public CompanyDTO(int companyId, String companyName, String companyEmail, int companyPhoneNo,
				String companyAddress) {
			super();
			this.companyId = companyId;
			this.companyName = companyName;
			this.companyEmail = companyEmail;
			this.companyPhoneNo = companyPhoneNo;
			this.companyAddress = companyAddress;
			//this.employee = employee;
		}


	public Integer getCompanyId() {
			return companyId;
		}
		public void setCompanyId(int companyId) {
			this.companyId = companyId;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getCompanyEmail() {
			return companyEmail;
		}
		public void setCompanyEmail(String companyEmail) {
			this.companyEmail = companyEmail;
		}
		public int getCompanyPhoneNo() {
			return companyPhoneNo;
		}
		public void setCompanyPhoneNo(int companyPhoneNo) {
			this.companyPhoneNo = companyPhoneNo;
		}
		
		public String getCompanyAddress() {
			return companyAddress;
		}


		public void setCompanyAddress(String companyAddress) {
			this.companyAddress = companyAddress;
		}


		public Set<EmployeeDTO> getEmployee() {
		return employee;
		}
		public void setEmployee(Set<EmployeeDTO> employee) {
			this.employee = employee;
		}
		
		
	

}
