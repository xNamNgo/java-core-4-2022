package exercise.model.dto;

import java.util.List;

// input
public class BuildingDTO {
	private String name;
	private Integer floorArea;
	private Integer districtId;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer fromRentArea;
	private Integer toRentArea;
	private Long fromRentPrice;
	private Long toRentPrice;
	private String staffName;
	private String staffPhoneNumber;
	private List<String> rentType;

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

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public Integer getFromRentArea() {
		return fromRentArea;
	}

	public void setFromRentArea(Integer fromRentArea) {
		this.fromRentArea = fromRentArea;
	}

	public Integer getToRentArea() {
		return toRentArea;
	}

	public void setToRentArea(Integer toRentArea) {
		this.toRentArea = toRentArea;
	}

	public Long getFromRentPrice() {
		return fromRentPrice;
	}

	public void setFromRentPrice(Long fromRentPrice) {
		this.fromRentPrice = fromRentPrice;
	}

	public Long getToRentPrice() {
		return toRentPrice;
	}

	public void setToRentPrice(Long toRentPrice) {
		this.toRentPrice = toRentPrice;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPhoneNumber() {
		return staffPhoneNumber;
	}

	public void setStaffPhoneNumber(String staffPhoneNumber) {
		this.staffPhoneNumber = staffPhoneNumber;
	}

	public List<String> getRentType() {
		return rentType;
	}

	public void setRentType(List<String> rentType) {
		this.rentType = rentType;
	}

}
