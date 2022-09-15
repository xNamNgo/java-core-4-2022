package exercise.repository;

import java.util.List;

public interface JdbcRepository<T> {
	void insert(Object object);
	void delete(Long id);
	T findById(Long id);
}
