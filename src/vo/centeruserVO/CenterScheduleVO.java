package vo.centeruserVO;

public class CenterScheduleVO {

	String sc_date, sc_starttime, mg_id;

	public String getMg_id() {
		return mg_id;
	}

	public void setMg_id(String mg_id) {
		this.mg_id = mg_id;
	}

	int mg_no, sc_no;

	public CenterScheduleVO() {

	}

	public CenterScheduleVO(int code, String sc_date, String sc_starttime) {
		this.sc_no = sc_no;
		this.mg_no = code;
		this.sc_date = sc_date;
		this.sc_starttime = sc_starttime;
	}

	public int getSc_no() {
		return sc_no;
	}

	public void setSc_no(int sc_no) {
		this.sc_no = sc_no;
	}

	public int getMg_no() {
		return mg_no;
	}

	public void setMg_no(int mg_no) {
		this.mg_no = mg_no;
	}

	public String getSc_date() {
		return sc_date;
	}

	public void setSc_date(String sc_date) {
		this.sc_date = sc_date;
	}

	public String getSc_starttime() {
		return sc_starttime;
	}

	public void setSc_starttime(String sc_starttime) {
		this.sc_starttime = sc_starttime;
	}
}
