
public class MemberVO_User {
	
	private String id; // ���̵�
	private String password; // ��й�ȣ
	private String name; // �̸�
	private String phoneNumber; // ��ȭ��ȣ

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
