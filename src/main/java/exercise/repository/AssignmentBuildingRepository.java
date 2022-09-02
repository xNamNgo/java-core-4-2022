package exercise.repository;

import java.util.List;

import exercise.repository.entity.AssignmentBuildingEntity;

public interface AssignmentBuildingRepository {
	public List<Long> getIdCurrentStaff(Long buildingId);
	public void removeStaffById(Long id);
	public void	insertStaffById(Long buildingId,Long id);
}
