package vo.guardianuserVO;

public class PatientInfoVO {
	String pt_name, pt_jumin, pt_add, pt_tel, pt_sex, pt_height, pt_weight, pt_diagname, cr_no,
		pt_condition, pt_meal, pt_urine, pt_paral, pt_exercise, pt_bedsore, pt_suction
		, mg_relation;
	int pt_no;
	
	public PatientInfoVO() {}
	
	public PatientInfoVO(String pt_name,String pt_jumin, String pt_add, String pt_tel, String pt_sex, 
			String pt_height, String pt_weight, String pt_diagname, String cr_no,
			String pt_condition, String pt_meal, String pt_urine, String pt_paral, String pt_exercise, String pt_bedsore, String pt_suction
			, String mg_relation) {
		this.pt_name = pt_name;
		this.pt_jumin = pt_jumin;
		this.pt_add = pt_add;
		this.pt_tel = pt_tel;
		this.pt_sex = pt_sex;
		this.pt_height = pt_height;
		this.pt_weight = pt_weight;
		this.pt_diagname = pt_diagname;
		this.cr_no = cr_no;
		this.pt_condition = pt_condition;
		this.pt_meal = pt_meal;
		this.pt_urine = pt_urine;
		this.pt_paral = pt_paral;
		this.pt_exercise = pt_exercise;
		this.pt_bedsore = pt_bedsore;
		this.pt_suction = pt_suction;
		this.mg_relation = mg_relation;
	}
	
	public int getPt_no() {
		return pt_no;
	}

	public void setPt_no(int pt_no) {
		this.pt_no = pt_no;
	}

	public String getPt_name() {
		return pt_name;
	}

	public void setPt_name(String pt_name) {
		this.pt_name = pt_name;
	}

	public String getPt_jumin() {
		return pt_jumin;
	}

	public void setPt_jumin(String pt_jumin) {
		this.pt_jumin = pt_jumin;
	}

	public String getPt_add() {
		return pt_add;
	}

	public void setPt_add(String pt_add) {
		this.pt_add = pt_add;
	}

	public String getPt_tel() {
		return pt_tel;
	}

	public void setPt_tel(String pt_tel) {
		this.pt_tel = pt_tel;
	}

	public String getPt_sex() {
		return pt_sex;
	}

	public void setPt_sex(String pt_sex) {
		this.pt_sex = pt_sex;
	}

	public String getPt_height() {
		return pt_height;
	}

	public void setPt_height(String pt_height) {
		this.pt_height = pt_height;
	}

	public String getPt_weight() {
		return pt_weight;
	}

	public void setPt_weight(String pt_weight) {
		this.pt_weight = pt_weight;
	}

	public String getPt_diagname() {
		return pt_diagname;
	}

	public void setPt_diagname(String pt_diagname) {
		this.pt_diagname = pt_diagname;
	}

	public String getCr_no() {
		return cr_no;
	}

	public void setCr_no(String cr_no) {
		this.cr_no = cr_no;
	}

	public String getPt_condition() {
		return pt_condition;
	}

	public void setPt_condition(String pt_condition) {
		this.pt_condition = pt_condition;
	}

	public String getPt_meal() {
		return pt_meal;
	}

	public void setPt_meal(String pt_meal) {
		this.pt_meal = pt_meal;
	}

	public String getPt_urine() {
		return pt_urine;
	}

	public void setPt_urine(String pt_urine) {
		this.pt_urine = pt_urine;
	}

	public String getPt_paral() {
		return pt_paral;
	}

	public void setPt_paral(String pt_paral) {
		this.pt_paral = pt_paral;
	}

	public String getPt_exercise() {
		return pt_exercise;
	}

	public void setPt_exercise(String pt_exercise) {
		this.pt_exercise = pt_exercise;
	}

	public String getPt_bedsore() {
		return pt_bedsore;
	}

	public void setPt_bedsore(String pt_bedsore) {
		this.pt_bedsore = pt_bedsore;
	}

	public String getPt_suction() {
		return pt_suction;
	}

	public void setPt_suction(String pt_suction) {
		this.pt_suction = pt_suction;
	}

	public String getMg_relation() {
		return mg_relation;
	}

	public void setMg_relation(String mg_relation) {
		this.mg_relation = mg_relation;
	}
	
}
