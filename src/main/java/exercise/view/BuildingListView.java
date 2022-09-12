package exercise.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exercise.controller.BuildingController;
import exercise.model.dto.BuildingDTO;
import exercise.model.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		// --------------------------------------------FIND
		// BUILDING----------------------------------------
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
		int toRentArea = 300;
		long fromRentPrice = 10;
		long toRentPrice = 20;
		String staffName = "nguyen van";
		String staffPhoneNumber = null;
		List<String> rentType = new ArrayList<>();
		rentType.add("noi-that");
		rentType.add("nguyen-can");
//		rentType.add("noi-that");

		BuildingDTO buildingDTO = new BuildingDTO();
		buildingDTO.setName(name);
//		buildingDTO.setFloorArea(floorArea);
//		buildingDTO.setDistrictId(districtId);
//		buildingDTO.setWard(ward);
//		buildingDTO.setStreet(street);
//		buildingDTO.setNumberOfBasement(numberOfBasement);
//		buildingDTO.setDirection(direction);
//		buildingDTO.setLevel(level);
//		buildingDTO.setFromRentArea(fromRentArea);
//		buildingDTO.setToRentArea(toRentArea);
//		buildingDTO.setFromRentPrice(fromRentPrice);
//		buildingDTO.setToRentPrice(toRentPrice);
//		buildingDTO.setStaffName(staffName);
//		buildingDTO.setStaffPhoneNumber(staffPhoneNumber);
		buildingDTO.setRentType(rentType);
		BuildingController buildingController = new BuildingController();
		Map<String, Object> fields = getFieldsMap(buildingDTO);
		List<BuildingOutput> results = buildingController.findBuilding(fields);
		if (results != null) {
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
				System.out.println("========================================");
			}
		} else {
			System.out.println("Không tìm thấy kết quả");
		}
	}

	// map các fields để truyền map này
	// xuống repo để không vi phạm quy tắc quá 3 tham số trong 1 method.
	private static Map<String, Object> getFieldsMap(BuildingDTO buildingDTO) {
		Map<String, Object> result = new HashMap<>();
		result.put("name", buildingDTO.getName());
		result.put("floorArea", buildingDTO.getFloorArea());
		result.put("districtId", buildingDTO.getDistrictId());
		result.put("ward", buildingDTO.getWard());
		result.put("street", buildingDTO.getStreet());
		result.put("numberOfBasement", buildingDTO.getNumberOfBasement());
		result.put("direction", buildingDTO.getDirection());
		result.put("level", buildingDTO.getLevel());
		result.put("fromRentPrice", buildingDTO.getFromRentPrice());
		result.put("toRentPrice", buildingDTO.getToRentPrice());
		result.put("rentType", buildingDTO.getRentType());
		result.put("fromRentArea", buildingDTO.getFromRentArea());
		result.put("toRentArea", buildingDTO.getToRentArea());
		result.put("staffName", buildingDTO.getStaffName());
		return result;
	}
}
