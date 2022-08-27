package exercise.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.constant.SystemConstant;
import exercise.repository.RentTypeRepository;
import exercise.repository.entity.RenttypeEntity;
import exercise.utils.GetConnectionUtil;

public class RentTypeRepositoryImpl implements RentTypeRepository {

	@Override
	public List<RenttypeEntity> findByBuildingId(Long bulidingId) {
		List<RenttypeEntity> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			StringBuilder sql = new StringBuilder("select renttype.name from buildingrenttype "
					+ "as bRenttype join renttype on bRenttype.renttypeid = renttype.id"
					+ " join building on building.id = bRenttype.buildingid where building.id = " + bulidingId);
			rs = stmt.executeQuery(sql.toString());
			while (rs.next()) {
				RenttypeEntity rentTypeEntity = new RenttypeEntity();
				rentTypeEntity.setName(rs.getString("name"));
				results.add(rentTypeEntity);
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
