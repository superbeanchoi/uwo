package vo.guardianuserVO;

public class GuardianPaymentVO {
	String ms_date, ms_pay_amount, ms_deposit, ms_tax, pay_date, pay_status;
	int pt_no, ms_no, pay_no;
	
	public GuardianPaymentVO(String ms_date, String ms_pay_amount, String ms_deposit, String ms_tax) {
		this.ms_date = ms_date;
		this.ms_pay_amount = ms_pay_amount;
		this.ms_deposit = ms_deposit;
		this.ms_tax = ms_tax;
	}
	
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

	public int getPt_no() {
		return pt_no;
	}

	public void setPt_no(int pt_no) {
		this.pt_no = pt_no;
	}

	public int getMs_no() {
		return ms_no;
	}

	public void setMs_no(int ms_no) {
		this.ms_no = ms_no;
	}
	
	
}
