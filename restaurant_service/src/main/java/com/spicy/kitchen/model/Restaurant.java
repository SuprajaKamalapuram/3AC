package com.spicy.kitchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")

public class Restaurant {
	
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)	
@Column(name = "id")
private Integer id;

 @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
    
    @Column(name = "location")
    private String location;

    @Column(name = "speciality")
    private String speciality;

    
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Restaurant(Integer id, String name, String description, String city, String country, String location,
			String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.city = city;
		this.country = country;
		this.location = location;
		this.speciality = speciality;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
	
}
