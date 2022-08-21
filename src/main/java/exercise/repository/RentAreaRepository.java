package exercise.repository;

import java.util.List;

public interface RentAreaRepository {
	List<Integer> getRentArea(Long id,Integer fromRentArea,Integer toRentArea);
}
