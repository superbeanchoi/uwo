package vo.guardianuserVO;

public class GuardianMypageInfoVO {
	String mg_id, mg_pw, mg_name, mg_birth, mg_sex, mg_tel, mg_add, mg_relation;
	String nu_picture, nu_name, nu_sex, sv_type, mt_content;
	
	public GuardianMypageInfoVO() {

	}

	public GuardianMypageInfoVO(String mg_id, String mg_pw, String mg_name, String mg_birth, String mg_sex,
			String mg_tel, String mg_add) {
		this.mg_id = mg_id;
		this.mg_pw = mg_pw;
		this.mg_name = mg_name;
		this.mg_birth = mg_birth;
		this.mg_sex = mg_sex;
		this.mg_tel = mg_tel;
		this.mg_add = mg_add;

	}
	
	public void setMeetingDetailInfo(String nu_picture, String nu_name, String nu_sex, String sv_type, String mt_content) {
		this.nu_picture = nu_picture;
		this.nu_name = nu_name;
		this.nu_sex = nu_sex;
		this.sv_type = sv_type;
		this.mt_content = mt_content;
	}

	public String getMg_id() {
		return mg_id;
	}

	public void setMg_id(String mg_id) {
		this.mg_id = mg_id;
	}

	public String getMg_pw() {
		return mg_pw;
	}

	public void setMg_pw(String mg_pw) {
		this.mg_pw = mg_pw;
	}

	public String getMg_name() {
		return mg_name;
	}

	public void setMg_name(String mg_name) {
		this.mg_name = mg_name;
	}

	public String getMg_birth() {
		return mg_birth;
	}

	public void setMg_birth(String mg_birth) {
		this.mg_birth = mg_birth;
	}

	public String getMg_sex() {
		return mg_sex;
	}

	public void setMg_sex(String mg_sex) {
		this.mg_sex = mg_sex;
	}

	public String getMg_tel() {
		return mg_tel;
	}

	public void setMg_tel(String mg_tel) {
		this.mg_tel = mg_tel;
	}

	public String getMg_add() {
		return mg_add;
	}

	public void setMg_add(String mg_add) {
		this.mg_add = mg_add;
	}

	public String getMg_relation() {
		return mg_relation;
	}

	public void setMg_relation(String mg_relation) {
		this.mg_relation = mg_relation;
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

	public String getSv_type() {
		return sv_type;
	}

	public void setSv_type(String sv_type) {
		this.sv_type = sv_type;
	}

	public String getMt_content() {
		return mt_content;
	}

	public void setMt_content(String mt_content) {
		this.mt_content = mt_content;
	}
	
}
