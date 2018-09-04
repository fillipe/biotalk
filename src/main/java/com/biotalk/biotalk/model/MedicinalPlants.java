package com.biotalk.biotalk.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.biotalk.biotalk.enums.Status;

@Entity
@Table(name = "tb_plants")
public class MedicinalPlants {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plant_id")
	private Integer plantsId;

	@Column(name = "status")
	private Status status;

	@Column(name = "scientific_name")
	private String scientificName;

	@Column(name = "other_name")
	private String otherName;

	@Column(name = "species")
	private String species;

	@Column(name = "group_plant")
	private String group;

	@Column(name = "state")
	private String state;

	@Column(name = "region")
	private String region;

	@Column(name = "plant_description")
	private String plantDescription;

	@Column(name = "park_one")
	private String parkOne;

	@Column(name = "park_two")
	private String parkTwo;

	@Column(name = "park_tree")
	private String parkTree;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "medicinal_indication_id")
	private MedicinalIndication medicinalIndication;

	@ManyToOne
	@JoinColumn(name = "medicinal_contraindication_id")
	private MedicalContraindication medicalContraindication;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pic_plant_id")
	private PicPlants picPlants;

	public Integer getPlantsId() {
		return plantsId;
	}

	public void setPlantsId(Integer plantsId) {
		this.plantsId = plantsId;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public String getParkOne() {
		return parkOne;
	}

	public void setParkOne(String parkOne) {
		this.parkOne = parkOne;
	}

	public String getParkTwo() {
		return parkTwo;
	}

	public void setParkTwo(String parkTwo) {
		this.parkTwo = parkTwo;
	}

	public String getParkTree() {
		return parkTree;
	}

	public void setParkTree(String parkTree) {
		this.parkTree = parkTree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MedicinalIndication getMedicalIndication() {
		return medicinalIndication;
	}

	public void setMedicinalIndication(MedicinalIndication medicinalIndication) {
		this.medicinalIndication = medicinalIndication;
	}

	public MedicalContraindication getMedicinalContraindication() {
		return medicalContraindication;
	}

	public void setMedicalContraindication(MedicalContraindication medicalContraindication) {
		this.medicalContraindication = medicalContraindication;
	}

	public PicPlants getPicPlants() {
		return picPlants;
	}

	public void setPicPlants(PicPlants picPlants) {
		this.picPlants = picPlants;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
