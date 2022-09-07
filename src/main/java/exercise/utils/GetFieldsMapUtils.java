package exercise.utils;

import java.util.HashMap;
import java.util.Map;

import exercise.model.dto.BuildingDTO;

public class GetFieldsMapUtils {

	// map các fields để truyền map này
	// xuống repo để không vi phạm quy tắc quá 3 tham số trong 1 method.
	public static Map<String, Object> getFieldsMap(BuildingDTO buildingDTO) {
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
		result.put("staffName", buildingDTO.getStaffName());
		return result;
	}
}
