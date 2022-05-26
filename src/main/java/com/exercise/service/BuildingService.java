package com.exercise.service;

import java.util.ArrayList;

import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.output.BuildingOutput;

public interface BuildingService {
	public ArrayList<BuildingOutput> findBuilding(BuildingDTO buildingDTO);

}
