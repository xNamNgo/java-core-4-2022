package exercise.repository;

import java.util.List;

import exercise.repository.entity.AssignmentBuildingEntity;
import exercise.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findBuiding(String name, Integer floorArea, Integer districtId, String ward, String street,
			Integer numberOfBasement, String direction, String level, Long fromRentPrice, Long toRentPrice,List<String> rentType,String staffName);
}
