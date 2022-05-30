package com.exercise.service.impl;

import java.util.ArrayList;

import com.exercise.dao.BuildingDao;
import com.exercise.dao.entity.BuildingEntity;
import com.exercise.dao.impl.BuildingDaoImpl;
import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.output.BuildingOutput;
import com.exercise.service.BuildingService;
import com.exercise.utils.TypeBuildingUtils;

public class BuildingServiceImpl implements BuildingService {
	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public ArrayList<BuildingOutput> findBuilding(BuildingDTO buildingDTO) {
		ArrayList<BuildingOutput> results = new ArrayList<BuildingOutput>();
		ArrayList<BuildingEntity> buildingEntities = buildingDao.findBuilding(buildingDTO.getId(),
				buildingDTO.getName(), buildingDTO.getStreet(), buildingDTO.getWard(), buildingDTO.getDistrict(),
				buildingDTO.getFloorarea());
		for (BuildingEntity item : buildingEntities) {
			BuildingOutput buildingOutput = new BuildingOutput();
			buildingOutput.setId(item.getId());
			buildingOutput.setName(item.getName());
			buildingOutput.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingOutput.setFloorarea(item.getFloorarea());
			StringBuilder type = TypeBuildingUtils.formatType(item.getType());
			buildingOutput.setType(type.toString());
			results.add(buildingOutput);
		}
		return results;
	}


}
