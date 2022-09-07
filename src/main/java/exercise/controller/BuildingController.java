package exercise.controller;

import java.util.List;
import java.util.Map;

import exercise.model.dto.BuildingDTO;
import exercise.model.input.BuildingAssignmentInput;
import exercise.model.output.BuildingOutput;
import exercise.service.BuildingService;
import exercise.service.impl.BuildingServiceImpl;

public class BuildingController {
	BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingOutput> findBuilding(Map<String, Object> fields){
		List<BuildingOutput> results = buildingService.findBuliding(fields);
		return results.size() > 0 ? results : null;
	}
	
	public void buildingAssignment(BuildingAssignmentInput input) {
		buildingService.buildingAssignment(input);
	}
}
