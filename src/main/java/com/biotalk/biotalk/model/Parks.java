package com.biotalk.biotalk.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.biotalk.biotalk.enums.Status;

@Entity
@Table(name = "tb_parks")
public class Parks {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "park_id")
	private Integer parksId;
	
	@Column(name = "status")
	private Status status;
	
	@Column(name = "park_name")
	private String parksName;
	
	@Column(name = "park_description")
	private String parksDescription;
	
	@Column(name = "plant_one")
	private String plantOne;
	
	@Column(name = "plant_two")
	private String plantTwo;
	
	@Column(name = "plant_tree")
	private String plantTree;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pic_park_id")
    private PicParks picPark;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_parks_id")
	private AddressParks addressParks;

	public Integer getParksId() {
		return parksId;
	}

	public void setParksId(Integer parksId) {
		this.parksId = parksId;
	}

	public String getParksName() {
		return parksName;
	}

	public void setParksName(String parksName) {
		this.parksName = parksName;
	}

	public String getParksDescription() {
		return parksDescription;
	}

	public void setParksDescription(String parksDescription) {
		this.parksDescription = parksDescription;
	}

	public String getPlantOne() {
		return plantOne;
	}

	public void setPlantOne(String plantOne) {
		this.plantOne = plantOne;
	}

	public String getPlantTwo() {
		return plantTwo;
	}

	public void setPlantTwo(String plantTwo) {
		this.plantTwo = plantTwo;
	}

	public String getPlantTree() {
		return plantTree;
	}

	public void setPlantTree(String plantTree) {
		this.plantTree = plantTree;
	}

	public AddressParks getAddressParks() {
		return addressParks;
	}

	public void setAddressParks(AddressParks addressParks) {
		this.addressParks = addressParks;
	}

	public PicParks getPicPark() {
		return picPark;
	}

	public void setPicPark(PicParks picPark) {
		this.picPark = picPark;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
