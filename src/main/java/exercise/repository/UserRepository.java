package exercise.repository;

import java.util.List;

public interface UserRepository {
	public List<String> getStaffName(Long buildingId,String staffName);
}
