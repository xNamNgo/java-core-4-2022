package exercise.service;

import java.util.List;
import java.util.Map;

import exercise.model.dto.BuildingDTO;
import exercise.model.input.BuildingAssignmentInput;
import exercise.model.output.BuildingOutput;

public interface BuildingService {
	List<BuildingOutput> findBuliding(Map<String, Object> fields);
	void buildingAssignment(BuildingAssignmentInput input);
}
