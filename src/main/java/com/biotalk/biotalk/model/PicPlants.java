package com.biotalk.biotalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pic_plants")
public class PicPlants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pic_plant_id")
	private Integer picPlantsId;
	
	@Lob
	@Column(name = "plant_photo")
	private byte[] plantPhoto;
	
	@OneToOne(mappedBy = "picPlants")
    private MedicinalPlants medicinalPlants;

	public Integer getPicPlantsId() {
		return picPlantsId;
	}

	public void setPicPlantsId(Integer picPlantsId) {
		this.picPlantsId = picPlantsId;
	}

	public byte[] getPlantPhoto() {
		return plantPhoto;
	}

	public void setPlantPhoto(byte[] plantPhoto) {
		this.plantPhoto = plantPhoto;
	}

	public MedicinalPlants getMedicinalPlants() {
		return medicinalPlants;
	}

	public void setMedicinalPlants(MedicinalPlants medicinalPlants) {
		this.medicinalPlants = medicinalPlants;
	}
	
}
