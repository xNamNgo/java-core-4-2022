package com.exercise.dao;

import java.util.ArrayList;
import java.util.List;

import com.exercise.dao.entity.BuildingEntity;

public interface BuildingDao {
	public List<BuildingEntity> findBuilding(String name, String street, String ward, String district,
			Integer floorarea);

}
