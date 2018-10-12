package com.biotalk.biotalk.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medicial_contraindication")
public class MedicalContraindication {

	@Id
	@Column(name = "medicinal_contraindication_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer medicinalContraindicationId;

	@Column(name = "contraindication")
	private String contraindication;

	// @OneToMany(mappedBy = "medicalContraindication", cascade =
	// CascadeType.ALL)

	// @ManyToMany(mappedBy = "medicalContraindication")
	// private Set<MedicinalPlants> medicinalPlants = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "plant_id")
	private MedicinalPlants medicinalPlants;

	public Integer getMedicinalContraindicationId() {
		return medicinalContraindicationId;
	}

	public void setMedicinalContraindicationId(Integer medicinalContraindicationId) {
		this.medicinalContraindicationId = medicinalContraindicationId;
	}

	public String getContraindication() {
		return contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

	public MedicinalPlants getMedicinalPlants() {
		return medicinalPlants;
	}

	public void setMedicinalPlants(MedicinalPlants medicinalPlants) {
		this.medicinalPlants = medicinalPlants;
	}

}
