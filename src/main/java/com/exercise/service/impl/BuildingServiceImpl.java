package com.exercise.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.exercise.constant.SystemConstant;
import com.exercise.dao.BuildingDao;
import com.exercise.dao.entity.BuildingEntity;
import com.exercise.dao.impl.BuildingDaoImpl;
import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.input.BuildingSearchInput;
import com.exercise.model.output.BuildingOutput;
import com.exercise.service.BuildingService;
import com.exercise.utils.BuildingTypeUtils;

public class BuildingServiceImpl implements BuildingService {
	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
		List<BuildingOutput> results = new ArrayList<BuildingOutput>();
		List<BuildingEntity> buildingEntities = buildingDao.findBuilding(buildingSearchInput.getName(),
				buildingSearchInput.getStreet(), buildingSearchInput.getWard(), buildingSearchInput.getDistrict(),
				buildingSearchInput.getFloorArea());
		for (BuildingEntity item : buildingEntities) {
			BuildingOutput buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setAddress(item.getStreet() + " - " + item.getWard() + " - " + item.getDistrict());
			buildingOutput.setFloorarea(item.getFloorarea());
			StringBuilder type = getType(item.getType());
			buildingOutput.setType(type.toString());
			results.add(buildingOutput);
		}
		return results;
	}
	public static StringBuilder getType(String type) {
		Map<String, String> hashMapType = BuildingTypeUtils.getBuildingType();
		String[] typeSplit = type.split(",");
		StringBuilder results = new StringBuilder();
		for (int i = 0; i < typeSplit.length; i++) {
			results.append(hashMapType.get(typeSplit[i]));
			if(i < (typeSplit.length - 1)) {
				results.append(" , ");
			}
		}
		return results;
		
	}
}
