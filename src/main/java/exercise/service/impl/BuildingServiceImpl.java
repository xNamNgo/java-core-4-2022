package exercise.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import exercise.converter.BuildingConverter;
import exercise.model.input.BuildingAssignmentInput;
import exercise.model.output.BuildingOutput;
import exercise.repository.AssignmentBuildingRepository;
import exercise.repository.BuildingRepository;
import exercise.repository.DistrictRepository;
import exercise.repository.RentAreaRepository;
import exercise.repository.RentTypeRepository;
import exercise.repository.UserRepository;
import exercise.repository.entity.AssignmentBuildingEntity;
import exercise.repository.entity.BuildingEntity;
import exercise.repository.entity.DistrictEntity;
import exercise.repository.entity.RenttypeEntity;
import exercise.repository.impl.AssignmentBuildingRepositoryImpl;
import exercise.repository.impl.BuildingRepositoryImpl;
import exercise.repository.impl.DistrictRepositoryImpl;
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
	AssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepositoryImpl();
	

	// tìm kiếm tòa nhà .
	@Override
	public List<BuildingOutput> findBuliding(Map<String, Object> fields) {
		List<BuildingOutput> results = new ArrayList<>();
		List<BuildingEntity> buildingEnities = buildingRepository.findBuiding(fields);
		
		for (BuildingEntity item : buildingEnities) {
			BuildingConverter buildingConverter = new BuildingConverter();
			BuildingOutput buildingOutput =  buildingConverter.convertEntityToDTO(item);
			
			// set rentarea
			List<Long> rentAreaEntities = rentAreaRepository.getRentAreaByBulidingId(item.getId());
			List<String> rentAreas = new ArrayList<>(); 
			if (rentAreaEntities.size() > 0) {
				for (Long intValue : rentAreaEntities) {
					rentAreas.add(String.valueOf(intValue));
				}
				buildingOutput.setRentArea(String.join(",", rentAreas));
			}

			// set tên nhân viên
			List<String> staff = userRepository.getStaffName(item.getId());
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
				List<Long> listStaffToAdd = findItemOfSourceButNotInTarget(staffIdView, staffIdDatabase);
				List<Long> listStaffToDelete = findItemOfSourceButNotInTarget(staffIdDatabase, staffIdView);
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

	private List<Long> findItemOfSourceButNotInTarget(List<Long> idToAdd, List<Long> idToCompare) {
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
