package exercise.repository;

import java.util.List;

public interface UserRepository {
	public List<String> getNameStaff(Long buildingId,String staffName);
}
