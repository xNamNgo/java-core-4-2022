package exercise.controller;

import java.util.List;

import exercise.model.dto.BuildingDTO;
import exercise.model.output.BuildingOutput;
import exercise.service.BuildingService;
import exercise.service.impl.BuildingServiceImpl;

public class BuildingController {
	BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingOutput> findBuilding(BuildingDTO buildingDTO){
		List<BuildingOutput> results = buildingService.findBuliding(buildingDTO);
		return results.size() > 0 ? results : null;
	}
	
	public void buildingAssignment(Long buildingId,List<Long> staffId) {
		buildingService.buildingAssignment(buildingId, staffId);
	}
}
