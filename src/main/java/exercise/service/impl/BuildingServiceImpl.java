package exercise.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exercise.model.dto.BuildingDTO;
import exercise.model.output.BuildingOutput;
import exercise.repository.BuildingRepository;
import exercise.repository.RentAreaRepository;
import exercise.repository.RentTypeRepository;
import exercise.repository.UserRepository;
import exercise.repository.entity.BuildingEntity;
import exercise.repository.entity.RentAreaEntity;
import exercise.repository.entity.RenttypeEntity;
import exercise.repository.impl.BuildingRepositoryImpl;
import exercise.repository.impl.RentAreaRepositoryImpl;
import exercise.repository.impl.RentTypeRepositoryImpl;
import exercise.repository.impl.UserRepositoryImpl;
import exercise.service.BuildingService;
import exercise.utils.GetDistrictNameUtils;

public class BuildingServiceImpl implements BuildingService {
	BuildingRepository buildingRepository = new BuildingRepositoryImpl();
	RentAreaRepository rentAreaRepository = new RentAreaRepositoryImpl();
	UserRepository userRepository = new UserRepositoryImpl();
	RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();

	@Override
	public List<BuildingOutput> findBuliding(BuildingDTO buildingDTO) {
		List<BuildingOutput> results = new ArrayList<>();

		List<BuildingEntity> buildingEnities = buildingRepository.findBuiding(buildingDTO.getName(),
				buildingDTO.getFloorArea(), buildingDTO.getDistrictId(), buildingDTO.getWard(), buildingDTO.getStreet(),
				buildingDTO.getNumberOfBasement(), buildingDTO.getDirection(), buildingDTO.getLevel(),
				buildingDTO.getFromRentPrice(), buildingDTO.getToRentPrice(), buildingDTO.getRentType(),buildingDTO.getStaffName());
		for (BuildingEntity item : buildingEnities) {
			BuildingOutput buildingOutput = new BuildingOutput();
			buildingOutput.setName(item.getName());
			buildingOutput.setFloorArea(item.getFloorArea());
			String district = getDisctrictType(item.getDistrictId());
			buildingOutput.setAddress(district + " - " + item.getWard() + " - " + item.getStreet());
			buildingOutput.setNumberOfBasement(item.getNumberOfBasement());
			buildingOutput.setDirection(item.getDirection());
			buildingOutput.setLevel(item.getLevel());
			buildingOutput.setRentPrice(item.getRentPrice());

			// set rent area
			List<Integer> rentAreaEntities = rentAreaRepository.getRentArea(item.getId(), buildingDTO.getFromRentArea(),
					buildingDTO.getToRentArea());
			List<String> rentAreas = new ArrayList<>();
			if (rentAreaEntities.size() > 0) {
				for (Integer intValue : rentAreaEntities) {
					rentAreas.add(String.valueOf(intValue));
				}
				buildingOutput.setRentArea(String.join(",", rentAreas));
			}

			// set tên nhân viên
			List<String> staff = userRepository.getStaffName(item.getId(), buildingDTO.getStaffName());
			if (staff.size() > 0) {
				buildingOutput.setStaffName(String.join(" , ", staff));
			}

			// set buliding type
			List<RenttypeEntity> renttypeEntities = rentTypeRepository.findByBuildingId(item.getId());
			List<String> bulidingTypes = new ArrayList<>();
			for (RenttypeEntity item1 : renttypeEntities) {
				bulidingTypes.add(item1.getName());
			}
			buildingOutput.setBuildingRenttype(String.join(" , ", bulidingTypes));

			results.add(buildingOutput);
		}

		return results;
	}

	public String getDisctrictType(Integer districtId) {
		Map<Integer, String> districtTypeMap = GetDistrictNameUtils.getDistrictName();
		return districtTypeMap.get(districtId);
	}

}
