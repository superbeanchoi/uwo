package vo.nurseuserVO;

public class NurseSalVO {
	String nu_id, ss_date, ss_sumsal, ss_tax,  ss_fee, ss_receipt, ss_paydate, ss_paystatus;
	int ss_no;

	public NurseSalVO(int ss_no, String ss_date, String ss_sumsal, String ss_tax, String ss_fee, String ss_receipt, String ss_paydate, String ss_paystatus) {
		this.ss_no= ss_no;
		this.nu_id = nu_id;
		this.ss_date = ss_date;
		this.ss_sumsal = ss_sumsal;
		this.ss_tax= ss_tax;
		this.ss_fee = ss_fee;
		this.ss_receipt = ss_receipt;
		this.ss_paydate = ss_paydate;
		this.ss_paystatus = ss_paystatus;
	}

	public String getNu_id() {
		return nu_id;
	}

	public void setNu_id(String nu_id) {
		this.nu_id = nu_id;
	}

	public String getSs_date() {
		return ss_date;
	}

	public void setSs_date(String ss_date) {
		this.ss_date = ss_date;
	}

	public String getSs_sumsal() {
		return ss_sumsal;
	}

	public void setSs_sumsal(String ss_sumsal) {
		this.ss_sumsal = ss_sumsal;
	}

	public String getSs_tax() {
		return ss_tax;
	}

	public void setSs_tax(String ss_tax) {
		this.ss_tax = ss_tax;
	}

	public String getSs_fee() {
		return ss_fee;
	}

	public void setSs_fee(String ss_fee) {
		this.ss_fee = ss_fee;
	}

	public String getSs_receipt() {
		return ss_receipt;
	}

	public void setSs_receipt(String ss_receipt) {
		this.ss_receipt = ss_receipt;
	}

	public String getSs_paydate() {
		return ss_paydate;
	}

	public void setSs_paydate(String ss_paydate) {
		this.ss_paydate = ss_paydate;
	}

	public String getSs_paystatus() {
		return ss_paystatus;
	}

	public void setSs_paystatus(String ss_paystatus) {
		this.ss_paystatus = ss_paystatus;
	}

	public int getSs_no() {
		return ss_no;
	}

	public void setSs_no(int ss_no) {
		this.ss_no = ss_no;
	}
	
}