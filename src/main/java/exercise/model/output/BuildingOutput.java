package exercise.model.output;

import java.util.List;

public class BuildingOutput {
	private String name;
	private Long floorArea;
	private String address; // quận - phường đường
	private Long numberOfBasement;
	private String direction;
	private String level;
	private String rentArea;
	private Long rentPrice;
	private String staffName;
	private String staffPhoneNumber;
	private String buildingRenttype;

	public String getBuildingRenttype() {
		return buildingRenttype;
	}

	public void setBuildingRenttype(String buildingRenttype) {
		this.buildingRenttype = buildingRenttype;
	}

	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
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

	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

}
