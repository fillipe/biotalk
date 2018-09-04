package com.biotalk.biotalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address_park")
public class AddressParks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "address_park_id")
	private int addressParkId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "num")
	private String num;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "region")
	private String region;
	
	@OneToOne(mappedBy = "addressParks")
    private Parks parks;

	public int getAddressParkId() {
		return addressParkId;
	}

	public void setAddressParkId(int addressParkId) {
		this.addressParkId = addressParkId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Parks getParks() {
		return parks;
	}

	public void setParks(Parks parks) {
		this.parks = parks;
	}
	
}
