package com.exercise.model.output;

public class BuildingOutput {

	private String id;
	private String name;
	private String address;
//	private String street;
//	private String ward;
//	private String district;
	private Integer floorarea;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}