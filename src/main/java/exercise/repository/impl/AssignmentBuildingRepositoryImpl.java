package exercise.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.repository.AssignmentBuildingRepository;
import exercise.repository.entity.AssignmentBuildingEntity;
import exercise.utils.GetConnectionUtil;

public class AssignmentBuildingRepositoryImpl implements AssignmentBuildingRepository {

	// lấy danh sách nhân viên đang quản lý tòa nhà id .
	@Override
	public List<Long> getIdCurrentStaff(Long buildingId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Long> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from assignmentbuilding " + " join user on user.id = assignmentbuilding.staffid"
					+ " join user_role on user_role.userid = user.id "
					+ " join role on role.id = user_role.roleid where buildingid = " + buildingId;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				results.add(rs.getLong("assignmentbuilding.staffid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public void removeStaffById(Long id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from assignmentbuilding where staffid = " + id;
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertStaffById(Long buildingId,Long staffId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = GetConnectionUtil.getConnection();
			pstmt = conn.prepareStatement("insert into assignmentbuilding(staffid,buildingId) values (?,?)");
			pstmt.setLong(1, staffId);
			pstmt.setLong(2, buildingId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
