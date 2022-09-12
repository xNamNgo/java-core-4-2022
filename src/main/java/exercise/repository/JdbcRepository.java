package exercise.repository;

public interface JdbcRepository<T> {
	void insert(Object object);
	void delete(Long id);
	T findById(Long id);
}
