package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exercise.constant.SystemConstant;
import exercise.repository.BuildingRepository;
import exercise.repository.entity.AssignmentBuildingEntity;
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
			
			// lấy fields
			List<String> rentType = (List<String>) fields.get("rentType");
			String name = (String) fields.get("name");
			Integer floorArea = (Integer) fields.get("floorArea");
			Integer districtId = (Integer) fields.get("districtId");
			String ward = (String) fields.get("ward");
			String street = (String) fields.get("street");
			Integer numberOfBasement = (Integer) fields.get("numberOfBasement");
			String direction = (String) fields.get("direction");
			String level = (String) fields.get("level");
			Long fromRentPrice = (Long) fields.get("fromRentPrice");
			Long toRentPrice = (Long) fields.get("toRentPrice");
			String staffName = (String) fields.get("staffName");
			
			//sql query
			StringBuilder sql = new StringBuilder("select * from building");

			// kiểm tra để join bảng
			boolean flag = false;

			// sau khi join xong dựa vào flag_1,flag_2 để thực hiện query tiếp theo.
			boolean flag_1 = false; // kiểm tra renttype đã join chưa
			boolean flag_2 = false; // kiểm tra staffname đã join chưa
			
			if (rentType != null) {
				flag = true;
				flag_1 = true;
				sql.append(" join buildingrenttype bRenttype on bRenttype.buildingid = building.id"
						+ " join renttype on renttype.id = bRenttype.renttypeid ");
			}

			if (staffName != null) {
				flag = true;
				flag_2 = true;
				sql.append(" join assignmentbuilding aBuilding on aBuilding.buildingid = building.id"
						+ " join user on user.id = aBuilding.staffid join user_role on user_role.userid = user.id "
						+ " join role on role.id = user_role.roleid");
			}
			
			if(districtId != null) {
				flag = true;
				sql.append(" join district on district.id = building.districtid");
			}

			// sau khi join các bảng xong thì dựa vào flag để append câu query
			if (flag) {
				if (flag_1) {
					sql.append(" where renttype.code = '" + rentType.get(0) + "'");
					for (int i = 1; i < rentType.size(); i++) {
						sql.append(" or renttype.code  = ' " + rentType.get(i) + "'");
					}
				}
				if (flag_2) {
					sql.append(" and user.fullname like '%" + staffName + "%'");
				}
				sql.append(" group by building.id");
			} else {
				sql.append(" where " + SystemConstant.ONE_EQUAL_ONE);
			}

			if (name != null) {
				sql.append(" and building.name like '%" + name + "%'");
			}
			if (floorArea != null) {
				sql.append(" and floorarea = " + floorArea);
			}
			if (districtId != null) {
				sql.append(" and districtid = " + districtId);
			}
			if (ward != null) {
				sql.append(" and ward like '%" + ward + "%'");
			}
			if (street != null) {
				sql.append(" and street like '%" + street + "%'");
			}
			if (numberOfBasement != null) {
				sql.append(" and numberofbasement = " + numberOfBasement);
			}
			if (direction != null) {
				sql.append(" and direction like '%" + direction + "%'");
			}
			if (level != null) {
				sql.append(" and level like '%" + level + "%'");
			}

			if (fromRentPrice != null) {
				sql.append(" and rentprice >= " + fromRentPrice);
			}
			if (toRentPrice != null) {
				sql.append(" and rentprice <= " + toRentPrice);
			}

			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setFloorArea(rs.getInt("floorarea"));
				buildingEntity.setDistrictId(rs.getLong("districtid"));
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
