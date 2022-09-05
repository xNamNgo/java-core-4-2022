package exercise.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.repository.AssignmentBuildingRepository;
import exercise.repository.JdbcRepository;
import exercise.repository.entity.AssignmentBuildingEntity;
import exercise.utils.GetConnectionUtil;

public class AssignmentBuildingRepositoryImpl extends JdbcRepositoryImpl<AssignmentBuildingEntity>
		implements AssignmentBuildingRepository {

	// lấy danh sách nhân viên đang quản lý tòa nhà id .
	@Override
	public List<Long> getCurrentStaffByBuildingId(Long id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Long> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from assignmentbuilding " + " join user on user.id = assignmentbuilding.staffid"
					+ " join user_role on user_role.userid = user.id "
					+ " join role on role.id = user_role.roleid where buildingid = " + id;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				results.add(rs.getLong("assignmentbuilding.staffid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

}
