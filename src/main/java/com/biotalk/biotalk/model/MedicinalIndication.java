package com.biotalk.biotalk.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medicial_indication")
public class MedicinalIndication {

	@Id
	@Column(name = "medicinal_indication_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer medicinalIndicationId;

	@Column(name = "indication")
	private String indication;

	@OneToMany(mappedBy = "medicinalIndication", cascade = CascadeType.ALL)
	private Set<MedicinalPlants> medicinalPlants;

	public Integer getMedicinalIndicationId() {
		return medicinalIndicationId;
	}

	public void setMedicinalIndicationId(Integer medicinalIndicationId) {
		this.medicinalIndicationId = medicinalIndicationId;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public Set<MedicinalPlants> getMedicinalPlants() {
		return medicinalPlants;
	}

	public void setMedicinalPlants(Set<MedicinalPlants> medicinalPlants) {
		this.medicinalPlants = medicinalPlants;
	}

}
