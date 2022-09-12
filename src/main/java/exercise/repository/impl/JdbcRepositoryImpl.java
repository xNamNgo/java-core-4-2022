package exercise.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exercise.annotation.Column;
import exercise.annotation.Id;
import exercise.annotation.Table;
import exercise.constant.SystemConstant;
import exercise.mapper.MapperResultSet;
import exercise.repository.JdbcRepository;
import exercise.utils.GetConnectionUtil;

public class JdbcRepositoryImpl<T> implements JdbcRepository<T> {

	private Class<T> tClass;

	public JdbcRepositoryImpl() {
		tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void insert(Object object) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = GetConnectionUtil.getConnection();
			StringBuilder sql = createSQLInsert();
			pstmt = conn.prepareStatement(sql.toString());
			Class<?> zClass = object.getClass();
			int parameterIndex = 1;
			for (Field field : zClass.getDeclaredFields()) {
				field.setAccessible(true);
				pstmt.setObject(parameterIndex, field.get(object));
				parameterIndex++;
			}
//			get field parent
//			Class<?> parentClass = zClass.getSuperclass();
//			while (parentClass != null && parentClass != Object.class) {
//				for (Field field : zClass.getDeclaredFields()) {
//					field.setAccessible(true);
//					pstmt.setObject(parameterIndex, field.get(object));
//					parameterIndex++;
//				}
//				parentClass = parentClass.getSuperclass();
//			}
			pstmt.executeUpdate();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	// lấy câu query insert
	private StringBuilder createSQLInsert() {
		String tableName = "";
		StringBuilder fields = new StringBuilder("");
		StringBuilder values = new StringBuilder("");
		StringBuilder query = new StringBuilder("");

		if (tClass.isAnnotationPresent(Table.class)) {
			Table table = tClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		for (Field field : tClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(" , ");
				values.append(" , ");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.fieldName());
				values.append("?");
			}
		}
		
//				get field parent
//		Class<?> parentClass = tClass.getSuperclass();
//		while (parentClass != Object.class && parentClass != null) {
//			for (Field field : parentClass.getDeclaredFields()) {
//				if (fields.length() > 1) {
//					fields.append(" , ");
//					values.append(" , ");
//				}
//				if (field.isAnnotationPresent(Column.class)) {
//					Column column = field.getAnnotation(Column.class);
//					fields.append(column.fieldName());
//					values.append("?");
//				}
//			}
//			parentClass = parentClass.getSuperclass();
//		}

		query.append("insert into " + tableName + "(" + fields.toString() + ") values(" + values.toString() + ")");
				
		return query;
	}

	@Override
	public void delete(Long id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			String tableName = "";
			if (tClass.isAnnotationPresent(Table.class)) {
				Table table = tClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			StringBuilder sql = new StringBuilder(
					"delete from " + tableName + " where " + SystemConstant.ONE_EQUAL_ONE);
			
			if(tClass.isAnnotationPresent(Id.class)) {
				Id idTable = tClass.getAnnotation(Id.class);
				sql.append(" and ").append(idTable.idTable()).append(" = " + id);
			}
			stmt.executeUpdate(sql.toString());
		} catch (SQLException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	@Override
	public T findById(Long id) {
		List<T> results = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = GetConnectionUtil.getConnection();
			stmt = conn.createStatement();
			String tableName = null;
			if(tClass.isAnnotationPresent(Table.class)) {
				Table table = tClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "select * from " + tableName + " where id = " + id;
			rs = stmt.executeQuery(sql);
			MapperResultSet<T> mapperResultSet = new MapperResultSet<>();
			results = mapperResultSet.mapRow(rs, tClass);
			return results.size() > 0 ? results.get(0) : null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
