package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.repository.UserRepository;
import exercise.utils.GetConnectionUtil;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<String> getStaffName(Long buildingId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("select * from user"
					+ " join assignmentbuilding aBuilding on aBuilding.staffid = user.id "
					+ " join building on building.id = aBuilding.buildingid where building.id =  " + buildingId);
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				results.add(rs.getString("user.fullname"));
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
