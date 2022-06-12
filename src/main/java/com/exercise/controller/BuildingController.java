package com.exercise.controller;

import java.util.ArrayList;
import java.util.List;

import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.input.BuildingSearchInput;
import com.exercise.model.output.BuildingOutput;
import com.exercise.service.BuildingService;
import com.exercise.service.impl.BuildingServiceImpl;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl();

	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
		List<BuildingOutput> results = buildingService.findBuilding(buildingSearchInput);
		return results;
	}

}
