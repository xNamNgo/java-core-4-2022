package exercise.repository.entity;

public class RentAreaEntity extends BaseEntity {
	private Integer value;
	private Integer buildingId;
	private String createddate;
	private String modifieddate;
	private String createdby;
	private String modifiedby;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;	
	}

}
