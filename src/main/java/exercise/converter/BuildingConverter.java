package exercise.converter;

import exercise.model.output.BuildingOutput;
import exercise.repository.DistrictRepository;
import exercise.repository.entity.BuildingEntity;
import exercise.repository.entity.DistrictEntity;
import exercise.repository.impl.DistrictRepositoryImpl;

public class BuildingConverter {
	DistrictRepository districtRepository = new DistrictRepositoryImpl();
	public BuildingOutput convertEntityToDTO(BuildingEntity item) {
		BuildingOutput buildingOutput = new BuildingOutput();
		buildingOutput.setName(item.getName());
		buildingOutput.setFloorArea(item.getFloorArea());
		DistrictEntity district = districtRepository.findById(item.getDistrictId()); // dùng findbyId thay vì tạo map.
		buildingOutput.setAddress(district.getName() + " - " + item.getWard() + " - " + item.getStreet());
		buildingOutput.setNumberOfBasement(item.getNumberOfBasement());
		buildingOutput.setDirection(item.getDirection());
		buildingOutput.setLevel(item.getLevel());
		buildingOutput.setRentPrice(item.getRentPrice());
		return buildingOutput;
	}
}
