package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.constant.SystemConstant;
import exercise.repository.BuildingRepository;
import exercise.repository.entity.BuildingEntity;
import exercise.utils.GetConnectionUtil;

public class BuildingRepositoryImpl implements BuildingRepository {

	@Override
	public List<BuildingEntity> findBuiding(String name, Integer floorArea, Integer districtId, String ward,
			String street, Integer numberOfBasement, String direction, String level, Long fromRentPrice,
			Long toRentPrice) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BuildingEntity> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("select * from building where " + SystemConstant.ONE_EQUAL_ONE);
			if (name != null && name.compareTo("") == 0) {
				sql.append(" and name like %" + name + "%");
			}
			if (floorArea != null) {
				sql.append(" and floorarea = " + floorArea);
			}
			if (districtId != null) {
				sql.append(" and districtid = " + districtId);
			}
			if (ward != null && ward.compareTo("") == 0) {
				sql.append(" and ward like %" + ward + "%");
			}
			if (street != null && street.compareTo("") == 0) {
				sql.append(" and street like %" + street + "%");
			}
			if (numberOfBasement != null) {
				sql.append(" and numberofbasement = " + numberOfBasement);
			}
			if (direction != null && direction.compareTo("") == 0) {
				sql.append(" and direction like %" + direction + "%");
			}
			if (level != null && level.compareTo("") == 0) {
				sql.append(" and level like %" + level + "%");
			}

			if (fromRentPrice != null) {
				sql.append(" and rentprice >= " + fromRentPrice);
			}
			if (toRentPrice != null) {
				sql.append(" and rentprice <= " + toRentPrice);
			}
			rs = stmt.executeQuery(sql.toString());
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setFloorArea(rs.getInt("floorarea"));
				buildingEntity.setDistrictId(rs.getInt("districtid"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setNumberOfBasement(rs.getInt("numberofbasement"));
				buildingEntity.setDirection(rs.getString("direction"));
				buildingEntity.setLevel(rs.getString("level"));
				buildingEntity.setRentPrice(rs.getLong("rentprice"));
				results.add(buildingEntity);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return results;
	}
}
