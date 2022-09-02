package exercise.view;

import java.util.ArrayList;
import java.util.List;

import exercise.controller.BuildingController;

public class BuildingAssignmentView {
	public static void main(String[] args) {
		//--------------------------------------Giao tòa nhà cho nhân viên quản lý -----------------------------------\
		BuildingController buildingController = new BuildingController();
		List<Long> staffId = new ArrayList<>();
		
		Long buildingId = 1L;
		staffId.add(1l);
		staffId.add(3l);
		staffId.add(4l);
		
		buildingController.buildingAssignment(buildingId,staffId);
		System.out.println("loading..");
	}

}
