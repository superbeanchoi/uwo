package vo.guardianuserVO;

public class SubGuardianInfoVO {
	String sg_name, sg_birth, sg_tel, sg_add, sg_relation, pt_no; 
	int sg_no;
	public SubGuardianInfoVO() {
		
	}
	public SubGuardianInfoVO(String sg_name,String sg_birth,String sg_tel, String sg_add, String sg_relation) {
		this.sg_name = sg_name;
		this.sg_birth = sg_birth;
		this.sg_tel = sg_tel;
		this.sg_add = sg_add;
		this.sg_relation = sg_relation;
	}
	public String getSg_name() {
		return sg_name;
	}
	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}
	public String getSg_birth() {
		return sg_birth;
	}
	public void setSg_birth(String sg_birth) {
		this.sg_birth = sg_birth;
	}
	public String getSg_tel() {
		return sg_tel;
	}
	public String getPt_no() {
		return pt_no;
	}
	public void setPt_no(String pt_no) {
		this.pt_no = pt_no;
	}
	
	public int getSg_no() {
		return sg_no;
	}
	public void setSg_no(int sg_no) {
		this.sg_no = sg_no;
	}
	public void setSg_tel(String sg_tel) {
		this.sg_tel = sg_tel;
	}
	public String getSg_add() {
		return sg_add;
	}
	public void setSg_add(String sg_add) {
		this.sg_add = sg_add;
	}
	public String getSg_relation() {
		return sg_relation;
	}
	public void setSg_relation(String sg_relation) {
		this.sg_relation = sg_relation;
	}
}
