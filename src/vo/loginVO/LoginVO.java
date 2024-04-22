package vo.loginVO;

public class LoginVO {
	String id, pw;
	
	public LoginVO() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginVO(String id, String pw) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.pw=pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
