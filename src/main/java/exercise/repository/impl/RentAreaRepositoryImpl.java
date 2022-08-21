package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.constant.SystemConstant;
import exercise.repository.RentAreaRepository;
import exercise.repository.entity.RentAreaEntity;
import exercise.utils.GetConnectionUtil;

public class RentAreaRepositoryImpl implements RentAreaRepository {

	@Override
	public List<Integer> getRentArea(Long buildingId, Integer fromRentArea, Integer toRentArea) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Integer> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("select * from rentarea where buildingid = " + buildingId);
			if(fromRentArea != null) {
				sql.append(" and value >= " + fromRentArea);
			} 
			if(toRentArea != null) {
				sql.append(" and value <= " + toRentArea);
			}
			rs = stmt.executeQuery(sql.toString());
			while(rs.next()) {
				results.add(rs.getInt("value"));
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
