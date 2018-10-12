package com.biotalk.biotalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


//	@ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            }, mappedBy = "medicinalIndication")
//	private Set<MedicinalPlants> medicinalPlants = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "plant_id")
	private MedicinalPlants medicinalPlants;

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

	public MedicinalPlants getMedicinalPlants() {
		return medicinalPlants;
	}

	public void setMedicinalPlants(MedicinalPlants medicinalPlants) {
		this.medicinalPlants = medicinalPlants;
	}

}
