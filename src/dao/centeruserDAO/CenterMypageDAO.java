package dao.centeruserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.centeruserVO.CenterMypageVO;
import vo.guardianuserVO.GuardianConsulltationVO;
import vo.guardianuserVO.SubGuardianInfoVO;
import vo.nurseuserVO.NurseMypageInfoVO;

public class CenterMypageDAO {

	public CenterMypageDAO() throws Exception {
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
	
	public CenterMypageVO getCenterInfo(String id) throws SQLException {
		String sql = "select CN_PW, CN_NAME, CN_TEL from center "
				+ "where cn_id='"+id+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		CenterMypageVO vo = new CenterMypageVO();
		if(rs.next()) {
			vo.setCnpw(rs.getString("CN_PW"));
			vo.setCnname(rs.getString("CN_NAME"));
			vo.setCntel(rs.getString("CN_TEL"));
		}
		rs.close();
		stmt.close();
		return vo;
	}
	
	public void infoUpdate(CenterMypageVO vo) throws Exception {
		String sql = "update CENTER set CN_PW=?, CN_NAME=?, CN_TEL=? "
				+ "where CN_ID=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getCnpw());
		ps.setString(2, vo.getCnname());
		ps.setString(3, vo.getCntel());
		ps.setString(4, vo.getCnid());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList patientSimpleSelect(String cnid) throws Exception {
		String sql = "select PT_NO, PT_NAME, PT_ADD, PT_TEL, PT_DIAGNAME "
				+ "from PATIENT "
				+ "where CN_ID='"+cnid+"' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("PT_ADD"));
			temp.add(rs.getString("PT_TEL"));
			temp.add(rs.getString("PT_DIAGNAME"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList guardianSimpleSelect(String cnid) throws Exception {
		String sql = "select p.PT_NO, mg.MG_NAME, mg.MG_ADD, mg.MG_TEL, p.MG_RELATION "
				+ "from MAIN_GUARDIAN mg, PATIENT p "
				+ "where mg.MG_ID=p.MG_ID and p.CN_ID='"+cnid+"' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("MG_NAME"));
			temp.add(rs.getString("MG_ADD"));
			temp.add(rs.getString("MG_TEL"));
			temp.add(rs.getString("MG_RELATION"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList subGuardianSimpleSelect(String cnid) throws Exception {
		String sql = "select p.PT_NO, sg.SG_NAME, sg.SG_ADD, sg.SG_TEL, sg.SG_RELATION "
				+ "from SUB_GUARDIAN sg, PATIENT p "
				+ "where sg.PT_NO=p.PT_NO and p.CN_ID='"+cnid+"' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			list.add(temp);
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("SG_NAME"));
			temp.add(rs.getString("SG_ADD"));
			temp.add(rs.getString("SG_TEL"));
			temp.add(rs.getString("SG_RELATION"));
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList patientSearch(String id, int colindex, String text) throws Exception {
		String[] colName = {"PT_NO","PT_NAME"};
		String sql = "select PT_NO, PT_NAME, PT_ADD, PT_TEL, PT_DIAGNAME "
				+ "from PATIENT "
				+ "where CN_ID='"+id+"' and "+colName[colindex]+" like '%"+text+"%'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("PT_ADD"));
			temp.add(rs.getString("PT_TEL"));
			temp.add(rs.getString("PT_DIAGNAME"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList guardianSearch(String patientCode) throws Exception {
		String sql = "select p.PT_NO, mg.MG_NAME, mg.MG_ADD, mg.MG_TEL, p.MG_RELATION "
				+ "from MAIN_GUARDIAN mg, PATIENT p "
				+ "where mg.MG_ID=p.MG_ID and p.PT_NO='"+patientCode+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("MG_NAME"));
			temp.add(rs.getString("MG_ADD"));
			temp.add(rs.getString("MG_TEL"));
			temp.add(rs.getString("MG_RELATION"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList subGuardianSearch(String patientCode) throws Exception {
		String sql = "select p.PT_NO, sg.SG_NAME, sg.SG_ADD, sg.SG_TEL, sg.SG_RELATION "
				+ "from SUB_GUARDIAN sg, PATIENT p "
				+ "where sg.PT_NO=p.PT_NO and p.PT_NO='"+patientCode+"'"
				+ "";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			list.add(temp);
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("SG_NAME"));
			temp.add(rs.getString("SG_ADD"));
			temp.add(rs.getString("SG_TEL"));
			temp.add(rs.getString("SG_RELATION"));
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList consultingSelect(String id) throws Exception {
		String sql = "select c.CS_NO, c.PT_NO, p.PT_NAME, mg.MG_NAME, mg.MG_TEL, c.CS_DATE "
				+ "from COUNSELING c, PATIENT p, CENTER ct, MAIN_GUARDIAN mg "
				+ "where c.PT_NO=p.PT_NO and p.CN_ID=ct.CN_ID and p.MG_ID=mg.MG_ID "
				+ "and p.CN_ID='"+id+"' order by 1 desc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("CS_NO"));
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("MG_NAME"));
			temp.add(rs.getString("MG_TEL"));
			temp.add(rs.getString("CS_DATE").substring(0, 10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public String consultingDetailSelect(String consultingCode) throws Exception {
		String sql ="select CS_CONTENT from COUNSELING where CS_NO="+consultingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String content="";
		if(rs.next()) {
			content = rs.getString("CS_CONTENT");
		}
		return content;
	}
	
	public ArrayList visitMeetingSelect(String id) throws Exception {
		String sql = "select c.CST_NO, c.PT_NO, p.PT_NAME, p.PT_ADD, mg.MG_NAME, c.CST_DATE "
				+ "from CONSULTATION c, PATIENT p, MAIN_GUARDIAN mg "
				+ "where c.PT_NO=p.PT_NO and p.CN_ID=c.CN_ID and p.MG_ID=mg.MG_ID "
				+ "and p.CN_ID='"+id+"' order by 1 desc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("CST_NO"));
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("PT_ADD"));
			temp.add(rs.getString("MG_NAME"));
			temp.add(rs.getString("CST_DATE").substring(0, 10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public String visitMeetingDetailSelect(String visitMeetingCode) throws Exception {
		String sql ="select CST_CONTENT from consultation where CST_NO="+visitMeetingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String content="";
		if(rs.next()) {
			content = rs.getString("CST_CONTENT");
		}
		return content;
	}
	
	public void visitmeetinginsert(CenterMypageVO vo) throws Exception {
		String sql = "insert into consultation(CST_NO, CN_ID, PT_NO, CST_DATE, CST_CONTENT) "
				+ " values(sq_consultation.nextval, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getCnid());
		ps.setString(2, vo.getPtno());
		ps.setString(3, vo.getCstdate());
		ps.setString(4, vo.getCstcontent());
		ps.executeUpdate();
		ps.close();
	}
	
	public CenterMypageVO selectvisitMeetingInfo(String visitMeetingCode) throws SQLException {
		String sql = "select PT_NO, CST_DATE, CST_CONTENT "
				+ "from CONSULTATION "
				+ "where CST_NO="+visitMeetingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		CenterMypageVO vo = new CenterMypageVO();
		if (rs.next()) {
			vo.setPtno(rs.getString("PT_NO"));
			vo.setCstdate(rs.getString("CST_DATE"));
			vo.setCstcontent(rs.getString("CST_CONTENT"));
		}
		rs.close();
		stmt.close();
		return vo;
	}
	
	public void visitmeetingupdate(CenterMypageVO vo) throws Exception {
		String sql = "update consultation set CN_ID=?, PT_NO=?, CST_DATE=?, CST_CONTENT=? "
				+ "where CST_NO=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getCnid());
		ps.setString(2, vo.getPtno());
		ps.setString(3, vo.getCstdate());
		ps.setString(4, vo.getCstcontent());
		ps.setString(5, vo.getCstno());
		ps.executeUpdate();
		ps.close();
	}
	
	public void visitmeetingDelete(String visitMeetingCode) throws Exception {
		String sql = "delete consultation where CST_NO="+visitMeetingCode;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
}
