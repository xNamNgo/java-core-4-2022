package exercise.repository;

import java.util.List;
import java.util.Map;

import exercise.repository.entity.AssignmentBuildingEntity;
import exercise.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findBuiding(Map<String,Object> fields);
}
