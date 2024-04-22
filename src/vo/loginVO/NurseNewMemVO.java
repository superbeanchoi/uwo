package vo.loginVO;

public class NurseNewMemVO {
	String imgText, id, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal;
	int survice;
	String careerField, startDate, endDate, detail;
	String certiDate;
	int certiField, certiName, certiNum;
	int skillField, skillName, skillNum;
	
	public NurseNewMemVO() {
		// TODO Auto-generated constructor stub
	}
	
	public NurseNewMemVO(String imgText, String id, String pw, String name, String jumin, String sex, String from, String tel, String add, String bank, String bankNum, String criminal, int survice) {
		// TODO Auto-generated constructor stub
		this.imgText=imgText;
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.jumin=jumin;
		this.sex=sex;
		this.from=from;
		this.tel=tel;
		this.add=add;
		this.bank=bank;
		this.bankNum=bankNum;
		this.criminal=criminal;
		this.survice=survice;
	}

	public void setCareer(String id, String careerField, String startDate, String endDate, String detail) {
		this.id=id;
		this.careerField=careerField;
		this.startDate=startDate;
		this.endDate=endDate;
		this.detail=detail;
	}
	
	public void setCerti(String id, int certiNum, String certiDate) {
		this.id=id;
		this.certiNum=certiNum;
		this.certiDate=certiDate;
	}
	
	public void setSkill(String id, int skillNum) {
		this.id=id;
		this.skillNum=skillNum;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getCriminal() {
		return criminal;
	}

	public void setCriminal(String criminal) {
		this.criminal = criminal;
	}

	public int getSurvice() {
		return survice;
	}

	public void setSurvice(int survice) {
		this.survice = survice;
	}

	public String getImgPath() {
		return imgText;
	}

	public void setImgPath(String imgText) {
		this.imgText = imgText;
	}

	public String getImgText() {
		return imgText;
	}

	public void setImgText(String imgText) {
		this.imgText = imgText;
	}

	public String getCareerField() {
		return careerField;
	}

	public void setCareerField(String careerField) {
		this.careerField = careerField;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getCertiField() {
		return certiField;
	}

	public void setCertiField(int certiField) {
		this.certiField = certiField;
	}

	public int getCertiName() {
		return certiName;
	}

	public void setCertiName(int certiName) {
		this.certiName = certiName;
	}

	public String getCertiDate() {
		return certiDate;
	}

	public void setCertiDate(String certiDate) {
		this.certiDate = certiDate;
	}

	public int getSkillField() {
		return skillField;
	}

	public void setSkillField(int skillField) {
		this.skillField = skillField;
	}

	public int getSkillName() {
		return skillName;
	}

	public void setSkillName(int skillName) {
		this.skillName = skillName;
	}

	public int getCertiNum() {
		return certiNum;
	}

	public void setCertiNum(int certiNum) {
		this.certiNum = certiNum;
	}

	public int getSkillNum() {
		return skillNum;
	}

	public void setSkillNum(int skillNum) {
		this.skillNum = skillNum;
	}
	
	

}
