package exercise.service;

import java.util.List;

import exercise.model.dto.BuildingDTO;
import exercise.model.output.BuildingOutput;

public interface BuildingService {
	List<BuildingOutput> findBuliding(BuildingDTO buildingDTO);
}
