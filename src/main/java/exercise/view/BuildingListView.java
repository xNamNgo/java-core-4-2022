package exercise.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exercise.controller.BuildingController;
import exercise.model.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		BuildingController buildingController = new BuildingController();
		List<String> rentType = new ArrayList<>();
		rentType.add("noi-that");
		rentType.add("nguyen-can");
		rentType.add("noi-that");
		Map<String, Object> fields = getFieldsMap(rentType);
		List<BuildingOutput> results = buildingController.findBuilding(fields);
		if (results != null) {
			for (BuildingOutput item : results) {
				System.out.println("Tên sản phẩm : " + item.getName());
				System.out.println("Địa chỉ : " + item.getAddress());
				System.out.println("Tên quản lý : " + item.getStaffName());
				System.out.println("Số điện thoại quản lý : " + item.getStaffPhoneNumber());
				System.out.println("Diện tích sàn : " + item.getFloorArea());
				System.out.println("Diện tích thuê : " + item.getRentArea());
				System.out.println("Giá thuê : " + item.getRentPrice());
				System.out.println("Số tầng hầm : " + item.getNumberOfBasement());
				System.out.println("Hướng : " + item.getDirection());
				System.out.println("Hạng : " + item.getLevel());
				System.out.println("Loại tòa nhà : " + item.getBuildingRenttype());
				System.out.println("========================================");
			}
		} else {
			System.out.println("Không tìm thấy kết quả");
		}
	}

	private static Map<String, Object> getFieldsMap(List<String> rentType) {
		Map<String, Object> result = new HashMap<>();
		result.put("name", "building");
		result.put("floorArea", 500l);
		result.put("districtId", 1l);
		result.put("ward", "phường");
		result.put("street", "phan xích long");
		result.put("numberOfBasement", 2l);
		result.put("direction",null);
		result.put("level", null);
		result.put("fromRentArea",100L);
		result.put("toRentArea", 300L);
		result.put("fromRentPrice", 10L);
		result.put("toRentPrice", 20L);
		result.put("rentType", rentType);
		result.put("staffName","nguyen van b");
		result.put("phone", null);
		return result;
	}
}

