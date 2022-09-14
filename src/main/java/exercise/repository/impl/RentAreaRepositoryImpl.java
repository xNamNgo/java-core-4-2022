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
	public List<Long> getRentAreaByBulidingId(Long id) {
		List<Long> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			String sql = SystemConstant.SELECT_FROM_RENTAREA + " where buildingid = " + id;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				results.add(rs.getLong("value"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

}
