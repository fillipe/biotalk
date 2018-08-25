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
@Table(name = "tb_authorities")
public class Authorities implements Serializable {
	
	private static final long serialVersionUID = 1332019228909380314L;

	@Id
	@Column(name = "id_authority")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAuthority;
	
	@Column(name = "authority")
	private String authority;
	
	@OneToMany(mappedBy = "auth", cascade = CascadeType.ALL)
    private Set<Login> login;

	public Long getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(Long idAuthority) {
		this.idAuthority = idAuthority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Set<Login> getLogin() {
		return login;
	}

	public void setLogin(Set<Login> login) {
		this.login = login;
	}
	
}
