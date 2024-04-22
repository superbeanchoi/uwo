package vo.loginVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class GuardianNewMemVO {
	String id, pw, name, birth, sex, tel, add;

	public GuardianNewMemVO() {
		// TODO Auto-generated constructor stub
	}
	
	public GuardianNewMemVO(String id, String pw, String name, String birth, String sex, String tel, String add) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.birth=birth;
		this.sex=sex;
		this.tel=tel;
		this.add=add;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
}
