package exercise.repository.entity;

import exercise.annotation.Column;

public class BaseEntity {
	
	@Column(fieldName = "id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
