package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.repository.RentTypeRepository;
import exercise.utils.GetConnectionUtil;

public class RentTypeRepositoryImpl implements RentTypeRepository {

	@Override
	public List<String> getRentType(Long bulidingId, List<String> rentType) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> results = new ArrayList<>();
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("");
			if (rentType.size() > 0) {
				sql.append("select * from buildingrenttype as bRenttype "
						+ "join renttype on bRenttype.renttypeid = renttype.id "
						+ "join building on building.id = bRenttype.buildingid where building.id = " + bulidingId);
				for (String item : rentType) {
					sql.append(" and '" + item + "' in ('tang-tret','nguyen-can','noi-that')");
				}
			} else {
				return null;
			}
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				results.add(rs.getString("renttype.name"));
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
