package com.exercise.controller;

import java.util.ArrayList;

import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.output.BuildingOutput;
import com.exercise.service.BuildingService;
import com.exercise.service.impl.BuildingServiceImpl;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl();

	public ArrayList<BuildingOutput> findBuilding(BuildingDTO buildingDTO) {
		ArrayList<BuildingOutput> results = buildingService.findBuilding(buildingDTO);
		return results;
	}

}
