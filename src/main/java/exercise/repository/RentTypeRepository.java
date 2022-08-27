package exercise.repository;

import java.util.List;

import exercise.repository.entity.RenttypeEntity;

public interface RentTypeRepository {
	public List<RenttypeEntity> findByBuildingId(Long bulidingId);
}
