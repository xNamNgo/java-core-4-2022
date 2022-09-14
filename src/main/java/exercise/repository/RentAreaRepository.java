package exercise.repository;

import java.util.List;

import exercise.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	List<Long> getRentAreaByBulidingId(Long id);
}
