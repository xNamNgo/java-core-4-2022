package exercise.view;

import java.util.ArrayList;
import java.util.List;

import exercise.controller.BuildingController;
import exercise.model.input.BuildingAssignmentInput;

public class BuildingAssignmentView {
	public static void main(String[] args) {
		//--------------------------------------Giao tòa nhà cho nhân viên quản lý -----------------------------------\
		BuildingController buildingController = new BuildingController();
		BuildingAssignmentInput input = new BuildingAssignmentInput();
		List<Long> staffId = new ArrayList<>();
		staffId.add(1l);
		staffId.add(2l);
//		staffId.add(3l);
		
		input.setBuildingId(1l);
		input.setStaffId(staffId);
//		
		buildingController.buildingAssignment(input);
		System.out.println("loading..");
	}

}
