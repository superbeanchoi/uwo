package vo.guardianuserVO;

public class MeetingVO {
	String mt_content, mt_reqdate, mg_id, nu_id;
	int pt_no;
	public MeetingVO() {
		
	}
	
	public MeetingVO(String nu_id, int code, String mt_content) {
		this.nu_id = nu_id;
		this.pt_no = code;
		this.mt_content = mt_content;
	}

	public String getMt_content() {
		return mt_content;
	}

	public void setMt_content(String mt_content) {
		this.mt_content = mt_content;
	}

	public String getMt_reqdate() {
		return mt_reqdate;
	}

	public void setMt_reqdate(String mt_reqdate) {
		this.mt_reqdate = mt_reqdate;
	}

	public String getMg_id() {
		return mg_id;
	}

	public void setMg_id(String mg_id) {
		this.mg_id = mg_id;
	}

	public String getNu_id() {
		return nu_id;
	}

	public void setNu_id(String nu_id) {
		this.nu_id = nu_id;
	}

	public int getPt_no() {
		return pt_no;
	}

	public void setPt_no(int pt_no) {
		this.pt_no = pt_no;
	}


}
