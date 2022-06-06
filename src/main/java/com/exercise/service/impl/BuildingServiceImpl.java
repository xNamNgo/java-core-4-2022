package com.exercise.service.impl;

import java.util.ArrayList;

import com.exercise.constant.SystemConstant;
import com.exercise.dao.BuildingDao;
import com.exercise.dao.entity.BuildingEntity;
import com.exercise.dao.impl.BuildingDaoImpl;
import com.exercise.model.dto.BuildingDTO;
import com.exercise.model.output.BuildingOutput;
import com.exercise.service.BuildingService;

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
			StringBuilder typeBuilding = getTypesBuilding(item.getType());
			buildingOutput.setType(typeBuilding.toString());
			results.add(buildingOutput);
		}
		return results;
	}

	public static StringBuilder getTypesBuilding(String typeBuilding) {
		String[] typeBuildingSplit = typeBuilding.split(",");
		StringBuilder results = new StringBuilder();
		for (int i = 0; i < typeBuildingSplit.length; i++) {
			if (typeBuildingSplit[i].equals(SystemConstant.TANG_TRET_CODE)) {
				results.append(SystemConstant.TANG_TRET);
			}
			if (typeBuildingSplit[i].equals(SystemConstant.NGUYEN_CAN_CODE)) {
				results.append(SystemConstant.NGUYEN_CAN);
			}
			if (typeBuildingSplit[i].equals(SystemConstant.NOI_THAT_CODE)) {
				results.append(SystemConstant.NOI_THAT);
			}
			if (i < (typeBuildingSplit.length - 1)) {
				results.append(" , ");
			}
		}
		return results;
	}

}
