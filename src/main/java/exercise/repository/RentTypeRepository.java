package exercise.repository;

import java.util.List;

public interface RentTypeRepository {
	public List<String> getRentType(Long bulidingId,List<String> rentType);
}
