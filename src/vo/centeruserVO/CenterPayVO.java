package vo.centeruserVO;

public class CenterPayVO {
	String ms_date, ms_pay_amount, ms_deposit, ms_tax, pay_date, pay_status, pt_no;
	int ms_no, pay_no;
	
	String ss_no, nu_id, ss_date, ss_sumsal, ss_tax, ss_fee, ss_receipt, ss_paydate, ss_paystatus;
	
	String dp_bank, dp_virtual;

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

	public int getPay_no() {
		return pay_no;
	}

	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}

	public CenterPayVO() {

	}

	public CenterPayVO(String ms_date, String ms_pay_amount, String ms_deposit, String ms_tax) {
		this.ms_date = ms_date;
		this.ms_pay_amount = ms_pay_amount;
		this.ms_deposit = ms_deposit;
		this.ms_tax = ms_tax;
	}

	public String getMs_date() {
		return ms_date;
	}

	public void setMs_date(String ms_date) {
		this.ms_date = ms_date;
	}

	public String getMs_pay_amount() {
		return ms_pay_amount;
	}

	public void setMs_pay_amount(String ms_pay_amount) {
		this.ms_pay_amount = ms_pay_amount;
	}

	public String getMs_deposit() {
		return ms_deposit;
	}

	public void setMs_deposit(String ms_deposit) {
		this.ms_deposit = ms_deposit;
	}

	public String getMs_tax() {
		return ms_tax;
	}

	public void setMs_tax(String ms_tax) {
		this.ms_tax = ms_tax;
	}

	public String getPt_no() {
		return pt_no;
	}

	public void setPt_no(String pt_no) {
		this.pt_no = pt_no;
	}

	public int getMs_no() {
		return ms_no;
	}

	public void setMs_no(int ms_no) {
		this.ms_no = ms_no;
	}

	public String getSs_no() {
		return ss_no;
	}

	public void setSs_no(String ss_no) {
		this.ss_no = ss_no;
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

	public String getDp_bank() {
		return dp_bank;
	}

	public void setDp_bank(String dp_bank) {
		this.dp_bank = dp_bank;
	}

	public String getDp_virtual() {
		return dp_virtual;
	}

	public void setDp_virtual(String dp_virtual) {
		this.dp_virtual = dp_virtual;
	}
	
	

}
