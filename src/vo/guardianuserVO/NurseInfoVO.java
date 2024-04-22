package vo.guardianuserVO;

public class NurseInfoVO {
	String nu_picture,  id, pw, nu_name, nu_sex, nu_country,  nu_tel, sv_typename, nu_add;
	int survice;
	String careerField, startDate, endDate, detail;
	String certiDate;
	int certiField, certiName, certiNum;
	int skillField, skillName, skillNum;
	

	public NurseInfoVO() {
		
	}
	public NurseInfoVO(String nu_picture, String nu_name, String nu_sex, String nu_country, String nu_tel, String sv_typename) {
	    this.nu_picture = nu_picture;
		this.nu_name = nu_name;
	    this.nu_sex = nu_sex;
	    this.nu_country = nu_country;
	    this.nu_tel = nu_tel;
	    this.sv_typename = sv_typename;
	}
	
	public void setCareer(String id, String careerField, String startDate, String endDate, String detail) {
		this.id=id;
		this.careerField=careerField;
		this.startDate=startDate;
		this.endDate=endDate;
		this.detail=detail;
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
	public void setCerti(String id, int certiNum, String certiDate) {
		this.id=id;
		this.certiNum=certiNum;
		this.certiDate=certiDate;
	}
	
	public void setSkill(String id, int skillNum) {
		this.id=id;
		this.skillNum=skillNum;
	}
	public String getNu_picture() {
		return nu_picture;
	}
	public void setNu_picture(String nu_picture) {
		this.nu_picture = nu_picture;
	}
	public String getNu_name() {
		return nu_name;
	}
	public void setNu_name(String nu_name) {
		this.nu_name = nu_name;
	}
	public String getNu_sex() {
		return nu_sex;
	}
	public void setNu_sex(String nu_sex) {
		this.nu_sex = nu_sex;
	}
	public String getNu_country() {
		return nu_country;
	}
	public void setNu_country(String nu_country) {
		this.nu_country = nu_country;
	}
	public String getNu_tel() {
		return nu_tel;
	}
	public void setNu_tel(String nu_tel) {
		this.nu_tel = nu_tel;
	}

	public String getSv_typename() {
		return sv_typename;
	}
	public void setSv_typename(String sv_typename) {
		this.sv_typename = sv_typename;
	}
	public String getNu_add() {
		return nu_add;
	}
	public void setNu_add(String nu_add) {
		this.nu_add = nu_add;
	}
	
	
	
//	@Override
//	public String toString() {
//	    return "이름: " + nu_name + ", 성별: " + nu_sex + ", 국적: " + nu_country + ", 서비스 유형: " + sv_typename;
//	}

}