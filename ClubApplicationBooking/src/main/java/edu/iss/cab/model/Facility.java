package edu.iss.cab.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "facility")
public class Facility {

	@Id
	@Column(name = "facility_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String facilityId;
	@Basic(optional = false)
	@Column(name = "facility_name")
	private String facilityName;
	private String description;
	@Basic(optional = false)
	@Range(min = 1, max = 100000)
	private Integer price;
	private boolean status;

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facility_name) {
		this.facilityName = facility_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStaus(boolean status) {
		this.status = status;
	}
}
