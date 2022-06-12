package com.exercise.model.input;

public class BuildingSearchInput {
	private String name;
	private String street;
	private String ward;
	private String district;
	private Integer FloorArea;

	public Integer getFloorArea() {
		return FloorArea;
	}

	public void setFloorArea(Integer floorArea) {
		FloorArea = floorArea;
	}

	public String getName() {
		return name;
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

}
