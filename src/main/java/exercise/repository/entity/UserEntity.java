package exercise.repository.entity;

public class UserEntity extends BaseEntity {
	private String username;
	private String password;
	private String fullName;
	private String phone;
	private String email;
	private Integer status;
	private String createddate;
	private String modifieddate;
	private String createdby;
	private String modifiedby;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
