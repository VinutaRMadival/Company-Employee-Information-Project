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

@Entity          //the LocationDTO class is now Entity class Entity class is a class which will get mapped to a table. 
@Table(name="location")        //will help us to map a particular table
public class LocationDTO 
{
	@Id    // it will make the locationId behaves like the PK attribute.
	@GeneratedValue(strategy=GenerationType.AUTO)//The primary key generation strategy that the persistence 
	//provider must use to generate the annotated entity primary key 
	
	@Column(name="loc_id")
	private int locationId;      

	@Column(name="loc_code")
	private String locationCode;

	@Column(name="loc_name")
	private String locationName;

	@Column(name="loc_address")
	private String locationAddress;

	@Column(name="loc_city")
	private String locationCity;

	@Column(name="loc_state")
	private String locationState;

	@Column(name="loc_country")
	private String locationCountry;

	@Column(name="loc_zip")
	private int locationZip;

	@Column(name="contact_phone")
	private int contactPhone;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_name")
	private String contactName;

	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(mappedBy = "location",fetch = FetchType.LAZY)
	private Set<EmployeeDTO> employee;



	public Set<EmployeeDTO> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<EmployeeDTO> employee) {
		this.employee = employee;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	public int getLocationZip() {
		return locationZip;
	}

	public void setLocationZip(int locationZip) {
		this.locationZip = locationZip;
	}

	public int getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(int contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}





}
