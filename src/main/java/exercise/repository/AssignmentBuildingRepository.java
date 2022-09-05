package exercise.repository;

import java.util.List;

import exercise.model.input.BuildingAssignmentInput;
import exercise.repository.entity.AssignmentBuildingEntity;

public interface AssignmentBuildingRepository extends JdbcRepository<AssignmentBuildingEntity> {
	public List<Long> getCurrentStaffByBuildingId(Long id);
}
