package exercise.model.output;

import java.util.List;

public class BuildingOutput {
	private String name;
	private Integer floorArea;
	private String address; // quận - phường đường
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private List<Integer> rentArea;
	private Long rentPrice;
	private List<String> staffName;
	private List<String> staffPhoneNumber;
	private List<String> buildingRenttype;

	public List<String> getBuildingRenttype() {
		return buildingRenttype;
	}

	public void setBuildingRenttype(List<String> buildingRenttype) {
		this.buildingRenttype = buildingRenttype;
	}

	public List<String> getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(List<String> staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Integer> getRentArea() {
		return rentArea;
	}

	public void setRentArea(List<Integer> rentArea) {
		this.rentArea = rentArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public List<String> getStaffName() {
		return staffName;
	}

	public void setStaffName(List<String> staffName) {
		this.staffName = staffName;
	}

}
