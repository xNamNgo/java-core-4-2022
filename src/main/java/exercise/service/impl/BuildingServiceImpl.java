package exercise.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercise.model.dto.BuildingDTO;
import exercise.model.input.BuildingAssignmentInput;
import exercise.model.output.BuildingOutput;
import exercise.repository.AssignmentBuildingRepository;
import exercise.repository.BuildingRepository;
import exercise.repository.RentAreaRepository;
import exercise.repository.RentTypeRepository;
import exercise.repository.UserRepository;
import exercise.repository.entity.AssignmentBuildingEntity;
import exercise.repository.entity.BuildingEntity;
import exercise.repository.entity.RentAreaEntity;
import exercise.repository.entity.RenttypeEntity;
import exercise.repository.impl.AssignmentBuildingRepositoryImpl;
import exercise.repository.impl.BuildingRepositoryImpl;
import exercise.repository.impl.RentAreaRepositoryImpl;
import exercise.repository.impl.RentTypeRepositoryImpl;
import exercise.repository.impl.UserRepositoryImpl;
import exercise.service.BuildingService;
import exercise.utils.GetDistrictNameUtils;
import exercise.utils.GetFieldsMapUtils;

public class BuildingServiceImpl implements BuildingService {
	BuildingRepository buildingRepository = new BuildingRepositoryImpl();
	RentAreaRepository rentAreaRepository = new RentAreaRepositoryImpl();
	UserRepository userRepository = new UserRepositoryImpl();
	RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
	AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepositoryImpl();

	// tìm kiếm tòa nhà .
	@Override
	public List<BuildingOutput> findBuliding(BuildingDTO buildingDTO) {
		List<BuildingOutput> results = new ArrayList<>();
		Map<String, Object> fields = GetFieldsMapUtils.getFieldsMap(buildingDTO);

		List<BuildingEntity> buildingEnities = buildingRepository.findBuiding(fields);
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



	// lấy string của district
	private String getDisctrictType(Integer districtId) {
		Map<Integer, String> districtTypeMap = GetDistrictNameUtils.getDistrictName();
		return districtTypeMap.get(districtId);
	}

	// giao tòa nhà cho nhân viên quản lý
	@Override
	public void buildingAssignment(BuildingAssignmentInput input) {
		if (input != null) {
			List<Long> staffIdView = input.getStaffId();
			List<Long> staffIdDatabase = assignmentBuildingRepository
					.getCurrentStaffByBuildingId(input.getBuildingId());

			Collections.sort(staffIdView);
			Collections.sort(staffIdDatabase);
			if (staffIdDatabase.size() == 0) { // ở db hiện tại không có staff nào quản lý
				for (Long staffId : staffIdView) {
					AssignmentBuildingEntity assignmentBuildingEntity = getObjectAssignmentBuilding(
							input.getBuildingId(), staffId);
					assignmentBuildingRepository.insert(assignmentBuildingEntity);
				}
			} else {
				List<Long> listStaffToAdd = listAdd(staffIdView, staffIdDatabase);
				List<Long> listStaffToDelete = listAdd(staffIdDatabase, staffIdView);
				for (Long staffId : listStaffToAdd) {
					AssignmentBuildingEntity assignmentBuildingEntity = getObjectAssignmentBuilding(
							input.getBuildingId(), staffId);
					assignmentBuildingRepository.insert(assignmentBuildingEntity);
				}
				for (Long staffId : listStaffToDelete) {
					assignmentBuildingRepository.delete(staffId);
				}
			}

		} else {
			System.out.println("Chưa nhập input!");
		}

	}

	private AssignmentBuildingEntity getObjectAssignmentBuilding(Long buildingId, Long staffId) {
		return new AssignmentBuildingEntity(buildingId, staffId);
	}

	private List<Long> listAdd(List<Long> idToAdd, List<Long> idToCompare) {
		List<Long> listAdd = new ArrayList<>();
		boolean flag = false; // list id add
		for (int i = 0; i < idToAdd.size(); i++) {
			Long idAdd = idToAdd.get(i);
			for (int j = 0; j < idToCompare.size(); j++) {
				Long idCompare = idToCompare.get(j);
				if (idAdd != idCompare) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				listAdd.add(idAdd);
			}
		}
		return listAdd;
	}

}
