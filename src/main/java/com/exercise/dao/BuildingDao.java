package com.exercise.dao;

import java.util.ArrayList;

import com.exercise.dao.entity.BuildingEntity;

public interface BuildingDao {
	public ArrayList<BuildingEntity> findBuilding(String id, String name, String street, String ward, String district,
			Integer floorarea);

}
