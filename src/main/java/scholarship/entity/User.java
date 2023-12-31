	package scholarship.entity;
	
	/*
	2. 使用者
	+--------+----------+--------------------------+
	| userId | institutionId | userName | password | 
	+--------+----------+--------------------------+
	|  101   | 25575888		 | jojo123  | pass123  |
	|  102   | 25575889		 | Nono456  | pass456  |
	|  103   | 25575881 	 | Kiki789  | pass789  |
	+--------+----------+--------------------------+
*/
	
public class User {
	private Integer userId; // 使用者 id
	private String institutionId; // 機構 id
	private String username; // 使用者名稱
	private String password; // 使用者密碼
	private Institution institution;
	public User() {
		
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public User(Integer userId, String username, String password, String institutionId) {
		this.userId = userId;
		this.username = username;
		this.institutionId = institutionId;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getInstitutionId() {
		return institutionId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
