package vo.guardianuserVO;

public class GuardianConsulltationVO {
	String code, consultingDate, consultingText;
	
	public GuardianConsulltationVO() {
		// TODO Auto-generated constructor stub
	}
	
	public GuardianConsulltationVO(String code, String consultingText) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.consultingText=consultingText;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getConsultingDate() {
		return consultingDate;
	}

	public void setConsultingDate(String consultingDate) {
		this.consultingDate = consultingDate;
	}

	public String getConsultingText() {
		return consultingText;
	}

	public void setConsultingText(String consultingText) {
		this.consultingText = consultingText;
	}
	
	
}
