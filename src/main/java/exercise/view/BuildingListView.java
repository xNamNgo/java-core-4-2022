package exercise.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exercise.controller.BulidingController;
import exercise.model.dto.BuildingDTO;
import exercise.model.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
		String name = "building";
		int floorArea = 500;
		int districtId = 1;
		String ward = "phường";
		String street = "phan xích long";
		int numberOfBasement = 2;
		String direction = null;
		String level = null;
		int fromRentArea = 100;
		int toRentArea = 200;
		long fromRentPrice = 10;
		long toRentPrice = 20;
		String staffName = "nguyen van";
		String staffPhoneNumber = null;
		List<String> rentType = new ArrayList<>();
		rentType.add("noi-that");
/*		rentType.add("nguyen-can");
		rentType.add("noi-that");*/
		
		BuildingDTO buildingDTO = new BuildingDTO();
		buildingDTO.setName(name);
		buildingDTO.setFloorArea(floorArea);
		buildingDTO.setDistrictId(districtId);
		buildingDTO.setWard(ward);
		buildingDTO.setStreet(street);
		buildingDTO.setNumberOfBasement(numberOfBasement);
		buildingDTO.setDirection(direction);
		buildingDTO.setLevel(level);
		buildingDTO.setFromRentArea(fromRentArea);
		buildingDTO.setToRentArea(toRentArea);
		buildingDTO.setFromRentPrice(fromRentPrice);
		buildingDTO.setToRentPrice(toRentPrice);
		buildingDTO.setStaffName(staffName);
		buildingDTO.setStaffPhoneNumber(staffPhoneNumber);
		buildingDTO.setRentType(rentType);
		BulidingController buildingController = new BulidingController();
		List<BuildingOutput> results = buildingController.findBuilding(buildingDTO);
		for (BuildingOutput item : results) {
			System.out.println("Tên sản phẩm : " + item.getName());
			System.out.println("Diện tích sàn : " + item.getFloorArea());
			System.out.println("Địa chỉ : " + item.getAddress());
			System.out.println("Số tầng hầm : " + item.getNumberOfBasement());
			System.out.println("Hướng : " + item.getDirection());
			System.out.println("Hạng : " + item.getLevel());
			System.out.println("Diện tích : " + item.getRentArea());
			System.out.println("Giá thuê : " + item.getRentPrice());
			System.out.println("Tên quản lý : " + item.getStaffName());
			System.out.println("Số điện thoại quản lý : " + item.getStaffPhoneNumber());
			System.out.println("Loại tòa nhà : " + item.getBuildingRenttype());
		}
		System.out.println("hello");
	}
}
