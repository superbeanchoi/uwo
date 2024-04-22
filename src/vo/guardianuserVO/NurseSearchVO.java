package vo.guardianuserVO;

public class NurseSearchVO {
	String nu_picture, nu_name, nu_sex, nu_country,  nu_tel, sv_typename, nu_id;
	

	public NurseSearchVO() {
		
	}
	public NurseSearchVO(String nu_name, String nu_sex, String nu_country, String sv_typename) {
	    this.nu_name = nu_name;
	    this.nu_sex = nu_sex;
	    this.nu_country = nu_country;
	    this.sv_typename = sv_typename;
	    
	}
	public String getNu_id() {
		return nu_id;
	}
	public void setNu_id(String nu_id) {
		this.nu_id = nu_id;
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
	@Override
	public String toString() {
	    return "이름: " + nu_name + ", 성별: " + nu_sex + ", 국적: " + nu_country + ", 서비스 유형: " + sv_typename;
	}
}