package exercise.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import exercise.annotation.Column;

public class MapperResultSet<T> {
	public List<T> mapRow(ResultSet rs, Class<T> tClass) {
		List<T> results = new ArrayList<>();
		try {
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			Field[] fields = tClass.getDeclaredFields();
			while (rs.next()) {
				T object = tClass.newInstance();
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
					String sqlColumnName = resultSetMetaData.getColumnName(i + 1);
					Object sqlColumnValue = rs.getObject(i + 1);
					for(Field field : fields) {
						if(field.isAnnotationPresent(Column.class)) {
							Column column = field.getAnnotation(Column.class);
							if(column.fieldName().equals(sqlColumnName)) {
								BeanUtils.setProperty(object, field.getName(), sqlColumnValue);
								break;
							}
						}
					}
				}
				results.add(object);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;
	}
}
