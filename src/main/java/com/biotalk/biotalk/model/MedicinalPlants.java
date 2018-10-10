package com.biotalk.biotalk.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	// @ManyToOne
	// @JoinColumn(name = "medicinal_indication_id")

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "plants_indication", joinColumns = { @JoinColumn(name = "plant_id") }, inverseJoinColumns = {
			@JoinColumn(name = "medicinal_indication_id") })
	private Set<MedicinalIndication> medicinalIndication = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "plants_contraindication", joinColumns = {
			@JoinColumn(name = "plant_id") }, inverseJoinColumns = {
					@JoinColumn(name = "medicinal_contraindication_id") })
	private Set<MedicalContraindication> medicalContraindication = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pic_plant_id")
	private PicPlants picPlants;

	public Integer getPlantsId() {
		return plantsId;
	}

	public void setPlantsId(Integer plantsId) {
		this.plantsId = plantsId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<MedicinalIndication> getMedicinalIndication() {
		return medicinalIndication;
	}

	public void setMedicinalIndication(Set<MedicinalIndication> medicinalIndication) {
		this.medicinalIndication = medicinalIndication;
	}

	public Set<MedicalContraindication> getMedicalContraindication() {
		return medicalContraindication;
	}

	public void setMedicalContraindication(Set<MedicalContraindication> medicalContraindication) {
		this.medicalContraindication = medicalContraindication;
	}

	public PicPlants getPicPlants() {
		return picPlants;
	}

	public void setPicPlants(PicPlants picPlants) {
		this.picPlants = picPlants;
	}

}
