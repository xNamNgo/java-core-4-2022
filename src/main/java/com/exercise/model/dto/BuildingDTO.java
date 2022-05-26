package com.exercise.model.dto;

public class BuildingDTO {

	private String id;
	private String name;
	private String street;
	private String ward;
	private String district;
	private Integer floorarea;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer flooarea) {
		this.floorarea = flooarea;
	}

}
