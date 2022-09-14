package exercise.controller;

import java.util.List;
import java.util.Map;

import exercise.model.input.BuildingAssignmentInput;
import exercise.model.output.BuildingOutput;
import exercise.service.BuildingService;
import exercise.service.impl.BuildingServiceImpl;

public class BuildingController {
	BuildingService buildingService = new BuildingServiceImpl();
	
	
	// tìm kiếm tòa nhà 
	public List<BuildingOutput> findBuilding(Map<String, Object> fields){
		List<BuildingOutput> results = buildingService.findBuliding(fields);
		return results.size() > 0 ? results : null;
	}
	
	// giao tòa nhà cho nhân viên quản lý
	public void buildingAssignment(BuildingAssignmentInput input) {
		buildingService.buildingAssignment(input);
	}
}
