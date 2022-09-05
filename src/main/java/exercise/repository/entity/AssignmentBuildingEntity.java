package exercise.repository.entity;

import java.util.List;

import exercise.annotation.Column;
import exercise.annotation.Table;

@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity extends BaseEntity {

	@Column(fieldName = "buildingid")
	private Long buildingId;

	@Column(fieldName = "staffid")
	private Long staffId;

	public AssignmentBuildingEntity(Long buildingId, Long staffId) {
		super();
		this.buildingId = buildingId;
		this.staffId = staffId;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

}
