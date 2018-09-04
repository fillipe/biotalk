package com.biotalk.biotalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pic_parks")
public class PicParks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pic_park_id")
	private Integer picParksId;
	
	@Column(name = "park_photo")
	private byte[] parkPhoto;
	
	@OneToOne(mappedBy = "picPark")
    private Parks parks;

	public Integer getPicParksId() {
		return picParksId;
	}

	public void setPicParksId(Integer picParksId) {
		this.picParksId = picParksId;
	}

	public byte[] getParkPhoto() {
		return parkPhoto;
	}

	public void setParkPhoto(byte[] parkPhoto) {
		this.parkPhoto = parkPhoto;
	}

	public Parks getParks() {
		return parks;
	}

	public void setParks(Parks parks) {
		this.parks = parks;
	}

}
