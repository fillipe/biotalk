package com.biotalk.biotalk.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.biotalk.biotalk.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 8849456991928138154L;
	
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;
	
	@Column(name = "name")
	@NotEmpty(message = "*Por favor, insira seu nome!")
	private String name;
	
	@Column(name = "cpf")
	@NotEmpty(message = "*Por favor, insira seu CPF!")
	private String cpf;

	@Column(name = "date_birth")
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateBirth;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "status")
	private Status status;
	
	@Column(name = "date_creation")
	private Date dtCreation;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_login")
	private Login login;
	
	@ManyToOne
    @JoinColumn(name = "id_formation")
	private Formation formation;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
