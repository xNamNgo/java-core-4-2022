package exercise.model.input;

import java.util.List;

public class BuildingAssignmentInput {
	private Long buildingId;
	private List<Long> staffId;

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public List<Long> getStaffId() {
		return staffId;
	}

	public void setStaffId(List<Long> staffId) {
		this.staffId = staffId;
	}

}
