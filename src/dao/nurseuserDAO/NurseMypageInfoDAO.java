package dao.nurseuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.nurseuserVO.NurseMypageInfoVO;

public class NurseMypageInfoDAO {
	
	public NurseMypageInfoDAO() throws Exception {
		// TODO Auto-generated constructor stub
		connectDB();
	}
	
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pxd = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;
	
	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pxd);
	}
	
	public NurseMypageInfoVO infoSelect(String id) throws Exception {
		String sql = "select * from NURSE where NU_ID='"+id+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String imgPath, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal, work;
		NurseMypageInfoVO vo=null;
		if(rs.next()) {
			pw=rs.getString("NU_PW");
			name=rs.getString("NU_NAME");
			jumin=rs.getString("NU_JUMIN");
			sex=rs.getString("NU_SEX");
			from=rs.getString("NU_COUNTRY");
			tel=rs.getString("NU_TEL");
			add=rs.getString("NU_ADD");
			criminal=rs.getString("NU_CRIMAL");
			bank=rs.getString("NU_BANK");
			bankNum=rs.getString("NU_ACCNO");
			work=rs.getString("SV_TYPE");
			imgPath=rs.getString("NU_PICTURE");
			vo = new NurseMypageInfoVO(imgPath, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal, work);
		}
		rs.close();
		stmt.close();
		return vo;
	}
	
	public void infoUpdate(String id, NurseMypageInfoVO vo) throws Exception {
		String sql = "update NURSE "
				+ "set NU_PW=?, NU_NAME=?, NU_JUMIN=?, NU_SEX=?, "
				+ "NU_COUNTRY=?, NU_TEL=?, NU_ADD=?, NU_CRIMAL=?, "
				+ "NU_BANK=?, NU_ACCNO=?, SV_TYPE=?, NU_PICTURE=? "
				+ "where NU_ID='"+id+"'";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getPw());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getJumin());
		ps.setString(4, vo.getSex());
		ps.setString(5, vo.getFrom());
		ps.setString(6, vo.getTel());
		ps.setString(7, vo.getAdd());
		ps.setString(8, vo.getCriminal());
		ps.setString(9, vo.getBank());
		ps.setString(10, vo.getBankNum());
		ps.setString(11, vo.getWork());
		ps.setString(12, vo.getImgPath());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList careerselect(String id) throws Exception {
		String sql = "select CA_FIELD, CA_STARTDATE, CA_ENDDATE, CA_DETAILWORK"
				+ " from CAREER where NU_ID='"+id+"' order by 2";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("CA_FIELD"));
			temp.add(rs.getString("CA_STARTDATE").substring(0,10));
			temp.add(rs.getString("CA_ENDDATE").substring(0,10));
			temp.add(rs.getString("CA_DETAILWORK"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList certiselect(String id) throws Exception {
		String sql = "select ct.CT_NAME, ci.CI_NAME, cr.CR_ACQDATE "
				+ "from CERTIFICATE_RETENTION cr, CERTIFICATE_INFO ci, CERTIFICATE_TYPE ct "
				+ "where ci.CT_NO=ct.CT_NO and cr.CI_NO=ci.CI_NO and cr.NU_ID='"+id+"' order by 3";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("CT_NAME"));
			temp.add(rs.getString("CI_NAME"));
			temp.add(rs.getString("CR_ACQDATE").substring(0,10));
			list.add(temp);
		}
		return list;
	}
	
	public ArrayList skillselect(String id) throws Exception {
		String sql = "select tt.TT_NAME, td.TD_NAME "
				+ "from NUSKILL_INFO ni, TECHNICAL_DETAIL td, TECHNO_TYPE tt "
				+ "where tt.TT_NO=td.TT_NO and td.TD_NO=ni.TD_NO and ni.NU_ID='"+id+"' order by 1, 2";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("TT_NAME"));
			temp.add(rs.getString("TD_NAME"));
			list.add(temp);
		}
		return list;
	}
	
	public void careerDelete(String id, String careerFiledName) throws Exception {
		String sql = "delete CAREER where NU_ID='"+id+"' and CA_FIELD='"+careerFiledName+"'";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public void certiDelete(String id, String certiName) throws Exception {
		String sql = "delete CERTIFICATE_RETENTION where CI_NO in "
				+ "(select cr.CI_NO from CERTIFICATE_RETENTION cr, CERTIFICATE_INFO ci "
				+ "where cr.CI_NO=ci.CI_NO and cr.NU_ID='"+id+"' and CI_NAME='"+certiName+"')";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public void skillDelete(String id, String skillName) throws Exception {
		String sql = "delete NUSKILL_INFO where TD_NO in "
				+ "(select ni.TD_NO from NUSKILL_INFO ni, TECHNICAL_DETAIL td "
				+ "where ni.TD_NO=td.TD_NO and ni.NU_ID='"+id+"' and td.TD_NAME='"+skillName+"')";
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public void careerModi(int code, NurseMypageInfoVO vo) throws Exception {
		String sql = "update CAREER "
				+ "set CA_FIELD=?, CA_DETAILWORK=?, CA_STARTDATE=?, CA_ENDDATE=? "
				+ "where CA_NO="+code;
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getCareerField());
		ps.setString(2, vo.getDetail());
		ps.setString(3, vo.getStartDate());
		ps.setString(4, vo.getEndDate());
		ps.executeUpdate();
		ps.close();
	}
	
	public void certiModi(int code, NurseMypageInfoVO vo) throws Exception {
		String sql = "update CERTIFICATE_RETENTION "
				+ "set CI_NO=?, CR_ACQDATE=? "
				+ "where CR_NO="+code;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getCertiNum());
		ps.setString(2, vo.getCertiDate());
		ps.executeUpdate();
		ps.close();
	}

	public void skillModi(int code, NurseMypageInfoVO vo) throws Exception {
		String sql = "update NUSKILL_INFO set TD_NO=? where INFO_NO="+code;
		ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getSkillNum());
		ps.executeUpdate();
		ps.close();
	}
	
	public int chooseCareer(String myId, String careerFieldName, String startDate, String endDate, String detail) throws Exception {
		int code=0;
		String sql = "select CA_NO from CAREER "
				+ "where NU_ID='"+myId+"' and CA_FIELD='"+careerFieldName+"' "
				+ "and CA_DETAILWORK='"+detail+"' "
				+ "and CA_STARTDATE='"+startDate+"' and CA_ENDDATE='"+endDate+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			code=rs.getInt("CA_NO");
		}
		rs.close();
		stmt.close();
		return code;
	}
	
	public int chooseCerti(String myId, String name) throws Exception {
		int code=0;
		String sql = "select CR_NO from CERTIFICATE_RETENTION cr, CERTIFICATE_INFO ci "
				+ "where cr.CI_NO=ci.CI_NO and "
				+ "cr.NU_ID='"+myId+"' and ci.CI_NAME='"+name+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			code=rs.getInt("CR_NO");
		}
		rs.close();
		stmt.close();
		return code;
	}
	
	public int chooseSkill(String myId, String name) throws Exception {
		int code=0;
		String sql = "select INFO_NO from NUSKILL_INFO ni, TECHNICAL_DETAIL td "
				+ "where ni.TD_NO=td.TD_NO and ni.NU_ID='"+myId+"' and td.TD_NAME='"+name+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			code=rs.getInt("INFO_NO");
		}
		rs.close();
		stmt.close();
		return code;
	}
	
	public ArrayList meetingInfoSelect(String nu_id) throws Exception {
		String sql = "select m.MT_NO, m.PT_NO, p.PT_NAME, c.CN_NAME, c.CN_TEL, m.MT_REQDATE "
				+ "from MEETING m, PATIENT p, CENTER c "
				+ "where m.PT_NO=p.PT_NO and p.CN_ID=c.CN_ID and m.NU_ID='"+nu_id+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("MT_NO"));
			temp.add(rs.getString("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("CN_NAME"));
			temp.add(rs.getString("CN_TEL"));
			temp.add(rs.getString("MT_REQDATE").substring(0,10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public NurseMypageInfoVO meetingPatientDetailSelect(String patientCode) throws Exception {
		String sql = "select PT_NAME, PT_SEX, PT_DIAGNAME, CR_NO, "
				+ "PT_CONDITION, PT_MEAL, PT_URINE, PT_PARAL, PT_EXERCISE, PT_BEDSORE, PT_SUCTION "
				+ "from PATIENT "
				+ "where PT_NO="+patientCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		NurseMypageInfoVO vo = new NurseMypageInfoVO();
		if(rs.next()) {
			vo.setPtname(rs.getString("PT_NAME"));
			vo.setPtsex(rs.getString("PT_SEX"));
			vo.setPtdiagname(rs.getString("PT_DIAGNAME"));
			vo.setPtcrno(rs.getString("CR_NO"));
			vo.setPtcondition(rs.getString("PT_CONDITION"));
			vo.setPtmeal(rs.getString("PT_MEAL"));
			vo.setPturine(rs.getString("PT_URINE"));
			vo.setPtparal(rs.getString("PT_PARAL"));
			vo.setPtexercise(rs.getString("PT_EXERCISE"));
			vo.setPtbedsore(rs.getString("PT_BEDSORE"));
			vo.setPtsuction(rs.getString("PT_SUCTION"));
		}
		return vo;
	}
	
}
