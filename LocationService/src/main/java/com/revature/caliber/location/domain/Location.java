package com.revature.caliber.location.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Jason Martinez, Aric Rhodes
 * 
 *         Location bean.
 *
 */

@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name = "company_name")
	String name;

	@Column(name = "city")
	String city;

	@Column(name = "zipcode")
	String zipcode;

	@Column(name = "address")
	String address;

	@Column(name = "state")
	String state;

	@Column(name = "active")
	Boolean active;

	public Location() {
		super();
	}

	public Location(Integer id, String name, String city, String zipcode, String address, String state,
			Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.zipcode = zipcode;
		this.address = address;
		this.state = state;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + address + " " + city + " " + state + " " + zipcode;
	}

}
