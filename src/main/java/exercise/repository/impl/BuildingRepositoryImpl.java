package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercise.constant.SystemConstant;
import exercise.repository.BuildingRepository;
import exercise.repository.entity.BuildingEntity;
import exercise.utils.GetConnectionUtil;

public class BuildingRepositoryImpl implements BuildingRepository {

	@Override
	public List<BuildingEntity> findBuiding(Map<String, Object> fields) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BuildingEntity> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			
			// build câu query
			StringBuilder sql = new StringBuilder(SystemConstant.SELECT_FROM_BUILDING);
			StringBuilder joinQuery = new StringBuilder();
			StringBuilder whereQuery = new StringBuilder();
			buildingQueryWithJoin(fields, joinQuery, whereQuery); 
			buildingQueryWithoutJoin(fields, whereQuery);
			sql.append(joinQuery).append(SystemConstant.WHERE_ONE_EQUAL_ONE).append(whereQuery)
					.append(SystemConstant.GROUP_BY_BUILDING_ID);
			rs = stmt.executeQuery(sql.toString());
			
			// REPO trả về cho service
			while (rs.next()) {
				BuildingEntity buildingEntity = getBuildingEntityObj(rs);
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

	// build câu query các field join table khác liên quan  .
	public void buildingQueryWithJoin(Map<String, Object> fields, StringBuilder joinQuery, StringBuilder whereQuery) {
		List<String> rentType = (List<String>) fields.get("rentType");
		String staffName = (String) fields.get("staffName");
		String phone = (String) fields.get("phone");
		Long fromRentArea = (Long) fields.get("fromRentArea");
		Long toRentArea = (Long) fields.get("toRentArea");

		if (fromRentArea != null || toRentArea != null) {
			joinQuery.append(" join rentarea on rentarea.buildingid = b.id");
			if (fromRentArea != null) {
				whereQuery.append(" and rentarea.value >= " + fromRentArea);
			}
			if (toRentArea != null) {
				whereQuery.append(" and rentprice <= " + toRentArea);
			}
		}
		if (rentType.size() > 0) {
			joinQuery.append(" join buildingrenttype bRenttype on bRenttype.buildingid = b.id")
					.append(" join renttype on bRenttype.renttypeid = renttype.id");
			whereQuery.append(" and (renttype.code = '" + rentType.get(0) + "'");
			for (int i = 1; i < rentType.size(); i++) {
				whereQuery.append(" or renttype.code = '" + rentType.get(i) + "'");
			}
			whereQuery.append(")");
		}

		if (staffName != null || phone != null) {
			joinQuery.append(" join assignmentbuilding aBuilding on aBuilding.buildingid = b.id")
					.append(" join user on user.id = aBuilding.staffid")
					.append(" join user_role on user_role.userid = user.id")
					.append(" join role on role.id = user_role.roleid");
			if (staffName != null) {
				whereQuery.append(" and user.fullname like '%" + staffName + "%'").append(" and role.code = 'staff'");
			}
			if (phone != null) {
				whereQuery.append(" and user.phone = " + phone);
			}
		}

	}

	// build câu query các field không join table khác . các field liên quan đến table "building"
	public void buildingQueryWithoutJoin(Map<String, Object> fields, StringBuilder whereQuery) {
		String name = (String) fields.get("name");
		Long floorArea = (Long) fields.get("floorArea");
		Long districtId = (Long) fields.get("districtId");
		String ward = (String) fields.get("ward");
		String street = (String) fields.get("street");
		Long numberOfBasement = (Long) fields.get("numberOfBasement");
		String direction = (String) fields.get("direction");
		String level = (String) fields.get("level");
		Long fromRentPrice = (Long) fields.get("fromRentPrice");
		Long toRentPrice = (Long) fields.get("toRentPrice");

		if (name != null) {
			whereQuery.append(" and b.name like '%" + name + "%'");
		}
		if (floorArea != null) {
			whereQuery.append(" and floorarea = " + floorArea);
		}
		if (districtId != null) {
			whereQuery.append(" and districtid = " + districtId);
		}
		if (ward != null) {
			whereQuery.append(" and ward like '%" + ward + "%'");
		}
		if (street != null) {
			whereQuery.append(" and street like '%" + street + "%'");
		}
		if (numberOfBasement != null) {
			whereQuery.append(" and numberofbasement = " + numberOfBasement);
		}
		if (direction != null) {
			whereQuery.append(" and direction like '%" + direction + "%'");
		}
		if (level != null) {
			whereQuery.append(" and level like '%" + level + "%'");
		}
		if (fromRentPrice != null) {
			whereQuery.append(" and rentprice >= " + fromRentPrice);
		}
		if (toRentPrice != null) {
			whereQuery.append(" and rentprice <= " + toRentPrice);
		}
	}

	public static BuildingEntity getBuildingEntityObj(ResultSet rs) throws SQLException {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(rs.getLong("id"));
		buildingEntity.setName(rs.getString("name"));
		buildingEntity.setFloorArea(rs.getLong("floorarea"));
		buildingEntity.setDistrictId(rs.getLong("districtid"));
		buildingEntity.setWard(rs.getString("ward"));
		buildingEntity.setStreet(rs.getString("street"));
		buildingEntity.setNumberOfBasement(rs.getLong("numberofbasement"));
		buildingEntity.setDirection(rs.getString("direction"));
		buildingEntity.setLevel(rs.getString("level"));
		buildingEntity.setRentPrice(rs.getLong("rentprice"));
		return buildingEntity;
	}
}
