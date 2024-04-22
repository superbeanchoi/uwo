package dao.loginDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.loginVO.NurseNewMemVO;

public class NurseNewMemDAO {
	public NurseNewMemDAO() throws Exception {
		// TODO Auto-generated constructor stub
		connectDB();
	}
	
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdB";
	private String user = "nurse";
	private String pxd = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;
	
	void connectDB() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pxd);
	}
	
	public void insert(NurseNewMemVO vo) throws Exception {
		String sql = "insert into NURSE(NU_ID, NU_PW, NU_NAME, NU_JUMIN, NU_SEX, NU_COUNTRY, "
				+ "NU_TEL, NU_ADD, NU_CRIMAL, NU_BANK, NU_ACCNO, SV_TYPE, NU_PICTURE) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getJumin());
		ps.setString(5, vo.getSex());
		ps.setString(6, vo.getFrom());
		ps.setString(7, vo.getTel());
		ps.setString(8, vo.getAdd());
		ps.setString(9, vo.getCriminal());
		ps.setString(10, vo.getBank());
		ps.setString(11, vo.getBankNum());
		ps.setInt(12, vo.getSurvice());
		ps.setString(13, vo.getImgPath());
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
			temp.add(rs.getString("CA_STARTDATE"));
			temp.add(rs.getString("CA_ENDDATE"));
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
			temp.add(rs.getString("CR_ACQDATE"));
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
	
	public void careerinsert(NurseNewMemVO vo) throws Exception {
		String sql = "insert into CAREER(CA_NO, NU_ID, CA_FIELD, CA_DETAILWORK, CA_STARTDATE, CA_ENDDATE) "
				+ " values(sq_career.nextval, ?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getCareerField());
		ps.setString(3, vo.getDetail());
		ps.setString(4, vo.getStartDate());
		ps.setString(5, vo.getEndDate());
		ps.executeUpdate();
		ps.close();
	}
	
	public void certiinsert(NurseNewMemVO vo) throws Exception {
		String sql = "insert into CERTIFICATE_RETENTION(CR_NO, NU_ID, CI_NO, CR_ACQDATE)"
				+ " values(sq_certificate_retention.nextval, ?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setInt(2, vo.getCertiNum());
		ps.setString(3, vo.getCertiDate());
		ps.executeUpdate();
		ps.close();
	}
	
	public void skillinsert(NurseNewMemVO vo) throws Exception {
		String sql = "insert into NUSKILL_INFO(INFO_NO, NU_ID, TD_NO)"
				+ " values(sq_nuskill_info.nextval, ?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setInt(2, vo.getSkillNum());
		ps.executeUpdate();
		ps.close();
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
	
	public boolean select(String id) throws Exception {
		String sql = "select NU_ID from NURSE where NU_ID='"+id+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
}
