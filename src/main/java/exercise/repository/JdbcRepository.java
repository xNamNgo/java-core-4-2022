package exercise.repository;

public interface JdbcRepository<T> {
	void insert(Object object);
	void delete(Long id);
}
