package com.exercise.service;

import java.util.ArrayList;
import java.util.List;

import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.input.BuildingSearchInput;
import com.exercise.model.output.BuildingOutput;

public interface BuildingService {
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput);

}
