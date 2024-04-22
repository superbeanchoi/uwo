package vo.nurseuserVO;

public class NurseMypageInfoVO {
	String imgPath, id, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal, work;
	String careerField, startDate, endDate, detail;
	String certiDate;
	int certiField, certiName, certiNum;
	int skillField, skillName, skillNum;
	
	String ptname, ptsex, ptdiagname, ptcrno, ptcondition, ptmeal, pturine, ptparal, ptexercise, ptbedsore, ptsuction;
	
	public NurseMypageInfoVO() {
		// TODO Auto-generated constructor stub
	}
	
	public NurseMypageInfoVO(String imgPath, String pw, String name, String jumin, String sex, String from, String tel, String add, String bank, String bankNum, String criminal, String work) {
		// TODO Auto-generated constructor stub
		this.imgPath=imgPath;
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
		this.work=work;
	}
	
	public void setCareer(String careerField, String startDate, String endDate, String detail) {
		this.careerField=careerField;
		this.startDate=startDate;
		this.endDate=endDate;
		this.detail=detail;
	}
	
	public void setCerti(int certiNum, String certiDate) {
		this.certiNum=certiNum;
		this.certiDate=certiDate;
	}
	
	public void setSkill(int skillNum) {
		this.skillNum=skillNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
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

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
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

	public String getCertiDate() {
		return certiDate;
	}

	public void setCertiDate(String certiDate) {
		this.certiDate = certiDate;
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

	public int getCertiNum() {
		return certiNum;
	}

	public void setCertiNum(int certiNum) {
		this.certiNum = certiNum;
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

	public int getSkillNum() {
		return skillNum;
	}

	public void setSkillNum(int skillNum) {
		this.skillNum = skillNum;
	}

	public String getPtname() {
		return ptname;
	}

	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	public String getPtsex() {
		return ptsex;
	}

	public void setPtsex(String ptsex) {
		this.ptsex = ptsex;
	}

	public String getPtdiagname() {
		return ptdiagname;
	}

	public void setPtdiagname(String ptdiagname) {
		this.ptdiagname = ptdiagname;
	}

	public String getPtcrno() {
		return ptcrno;
	}

	public void setPtcrno(String ptcrno) {
		this.ptcrno = ptcrno;
	}

	public String getPtcondition() {
		return ptcondition;
	}

	public void setPtcondition(String ptcondition) {
		this.ptcondition = ptcondition;
	}

	public String getPtmeal() {
		return ptmeal;
	}

	public void setPtmeal(String ptmeal) {
		this.ptmeal = ptmeal;
	}

	public String getPturine() {
		return pturine;
	}

	public void setPturine(String pturine) {
		this.pturine = pturine;
	}

	public String getPtparal() {
		return ptparal;
	}

	public void setPtparal(String ptparal) {
		this.ptparal = ptparal;
	}

	public String getPtexercise() {
		return ptexercise;
	}

	public void setPtexercise(String ptexercise) {
		this.ptexercise = ptexercise;
	}

	public String getPtbedsore() {
		return ptbedsore;
	}

	public void setPtbedsore(String ptbedsore) {
		this.ptbedsore = ptbedsore;
	}

	public String getPtsuction() {
		return ptsuction;
	}

	public void setPtsuction(String ptsuction) {
		this.ptsuction = ptsuction;
	}
	
}
