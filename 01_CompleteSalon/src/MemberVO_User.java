
public class MemberVO_User {
	
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String phoneNumber; // 전화번호

	public MemberVO_User(String id, String password, String name, String phoneNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getid() {
		return id;
	}

	public String getpassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
}
