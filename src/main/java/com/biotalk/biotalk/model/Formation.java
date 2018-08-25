package com.biotalk.biotalk.model;

import java.io.Serializable;
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
@Table(name = "tb_formation")
public class Formation implements Serializable {
	
	private static final long serialVersionUID = 8295811593978730127L;

	@Id
	@Column(name = "id_formation")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFormation;
	
	@Column(name = "academic_degree")
	private String academicDegree;

	@Column(name = "course")
	private String course;
	
	@Column(name = "institution")
	private String institution;
	
	@OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private Set<User> user;

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
	
}
