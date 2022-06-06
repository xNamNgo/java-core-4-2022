package com.exercise.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.exercise.constant.SystemConstant;
import com.exercise.dao.BuildingDao;
import com.exercise.dao.entity.BuildingEntity;
import com.exercise.utils.ConnectionUtils;

public class BuildingDaoImpl implements BuildingDao {
	public ArrayList<BuildingEntity> findBuilding(String id, String name, String street, String ward, String district,
			Integer floorarea) {
		ArrayList<BuildingEntity> results = new ArrayList<BuildingEntity>();
		try {
			Connection conn = ConnectionUtils.getConnection();
			Statement stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("select * from building where " + SystemConstant.ONE_EQUAL_ONE);
			if (id != null && !id.equals("")) {
				sql.append(" and id = '" + id + "'");
			}
			if (name != null && !name.equals("")) {
				sql.append(" and name like '%" + name + "%'");
			}
			if (street != null && !street.equals("")) {
				sql.append(" and street like '%" + street + "%'");
			}
			if (ward != null && !ward.equals("")) {
				sql.append(" and ward like '%" + ward + "%'");
			}
			if (district != null && !district.equals("")) {
				sql.append(" and district like '%" + district + "%'");
			}
			if (floorarea != null && floorarea != 0) {
				sql.append(" and floorarea = '" + floorarea + "'");
			}
			String sqlDebug = sql.toString();
			ResultSet rs = stmt.executeQuery(sqlDebug);
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getString("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrict(rs.getString("district"));
				buildingEntity.setFloorarea(rs.getInt("floorarea"));
				buildingEntity.setType(rs.getString("type"));
				results.add(buildingEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

}
