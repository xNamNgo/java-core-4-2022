package exercise.repository.entity;

import exercise.annotation.Column;
import exercise.annotation.Table;

@Table(name = "district")
public class DistrictEntity extends BaseEntity {
	
	@Column(fieldName = "name")
	private String name;
	
	@Column(fieldName = "code")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
