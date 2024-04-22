package dao.centeruserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.centeruserVO.MatchingVO;
import vo.guardianuserVO.NurseInfoVO;
import vo.guardianuserVO.SubGuardianInfoVO;
import vo.nurseuserVO.NurseMypageInfoVO;

public class MatchingDAO {
	
	public MatchingDAO() throws Exception {
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
	
	public ArrayList meetingInfoSelect(String cnid) throws Exception {
		String sql = "select m.MT_NO, m.PT_NO, p.PT_NAME, n.NU_ID, n.NU_NAME, m.MT_REQDATE "
				+ "from MEETING m, PATIENT p, NURSE n "
				+ "where m.PT_NO=p.PT_NO and m.NU_ID=n.NU_ID and p.CN_ID='"+cnid+"' order by 1 desc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("MT_NO"));
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("NU_ID"));
			temp.add(rs.getString("NU_NAME"));
			temp.add(rs.getString("MT_REQDATE").substring(0, 10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList meetingSearch(String cnid, int colindex, String text) throws Exception {
		String colName="";
		if(colindex==0) {
			colName = "MT_NO";
		} else if(colindex==1) {
			colName = "p.PT_NO";
		} else if(colindex==2) {
			colName = "PT_NAME";
		} else if(colindex==3) {
			colName = "n.NU_ID";
		} else if(colindex==4) {
			colName = "NU_NAME";
		}
		
		String sql = "select m.MT_NO, m.PT_NO, p.PT_NAME, m.NU_ID, n.NU_NAME, m.MT_REQDATE "
				+ "from MEETING m, NURSE n, PATIENT p "
				+ "where m.PT_NO=p.PT_NO and m.NU_ID=n.NU_ID "
				+ "and p.CN_ID='"+cnid+"' and "+colName+" like '%"+text+"%'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("MT_NO"));
			temp.add(rs.getString("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("NU_ID"));
			temp.add(rs.getString("NU_NAME"));
			temp.add(rs.getString("MT_REQDATE").substring(0, 10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public String meetingDetailSearch(String meetingCode) throws Exception {
		String sql = "select MT_CONTENT from MEETING where MT_NO="+meetingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String content="";
		if(rs.next()) {
			content = rs.getString("MT_CONTENT");
		}
		rs.close();
		stmt.close();
		return content;
	}
	
	public ArrayList matchingInfoSelect(String cnid) throws Exception {
		String sql = "select m.MG_NO, m.MT_NO, s.SV_TYPENAME, m.MT_NUMBER_OF_TIMES, m.MT_SV_CONFIRMATION "
				+ "from MATCHING m, SURVICE s, MEETING me, PATIENT p "
				+ "where m.SV_TYPE=s.SV_TYPE and m.MT_NO=me.MT_NO and me.PT_NO=p.PT_NO "
				+ "and p.CN_ID='"+cnid+"' order by MT_SV_CONFIRMATION desc, MG_NO desc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("MG_NO"));
			temp.add(rs.getInt("MT_NO"));
			temp.add(rs.getString("SV_TYPENAME"));
			temp.add(rs.getString("MT_NUMBER_OF_TIMES"));
			temp.add(rs.getString("MT_SV_CONFIRMATION"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList matchingSearch(String meetingCode) throws Exception {
		String sql = "select MG_NO, MT_NO, SV_TYPENAME, MT_NUMBER_OF_TIMES, MT_SV_CONFIRMATION "
				+ "from MATCHING m, SURVICE s "
				+ "where m.SV_TYPE=s.SV_TYPE and MT_NO="+meetingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("MG_NO"));
			temp.add(rs.getInt("MT_NO"));
			temp.add(rs.getString("SV_TYPENAME"));
			temp.add(rs.getString("MT_NUMBER_OF_TIMES"));
			temp.add(rs.getString("MT_SV_CONFIRMATION"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public void matchingInsert(MatchingVO vo) throws Exception {
		String sql = "insert into MATCHING(MG_NO, MT_NO, SV_TYPE, MT_NUMBER_OF_TIMES, MT_SV_STARTDATE, MT_SV_ENDDATE, MT_SV_CONFIRMATION) "
				+ " values(sq_matching.nextval, ?, ?, ?, ?, null, 'Y')";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getMeetingCode());
		ps.setString(2, vo.getSvtype()+"");
		ps.setString(3, vo.getSurviceTime());
		ps.setString(4, vo.getStart());
		ps.executeUpdate();
		ps.close();
	}
	
	public MatchingVO matchingDetailSearch(String matchingCode) throws Exception {
		MatchingVO vo = new MatchingVO();
		String sql = "select MT_NO, SV_TYPE, MT_NUMBER_OF_TIMES, MT_SV_STARTDATE, MT_SV_ENDDATE, MT_SV_CONFIRMATION "
				+ "from MATCHING "
				+ "where MG_NO="+matchingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			vo.setMeetingCode(rs.getString("MT_NO"));
			vo.setSvtype(rs.getInt("SV_TYPE"));
			vo.setSurviceTime(rs.getString("MT_NUMBER_OF_TIMES"));
			vo.setStart(rs.getString("MT_SV_STARTDATE"));
			vo.setEnd(rs.getString("MT_SV_ENDDATE"));
			vo.setSurviceYN(rs.getString("MT_SV_CONFIRMATION"));
		}
		rs.close();
		stmt.close();
		return vo;
	}
	
	public void matchingUpdate(String matchingCode, MatchingVO vo) throws SQLException {
		String sql = "update MATCHING "
				+ "set MG_NO="+matchingCode+", MT_NO=?, SV_TYPE=?, MT_NUMBER_OF_TIMES=?, MT_SV_STARTDATE=?, MT_SV_ENDDATE=?, MT_SV_CONFIRMATION=? "
				+ "where MG_NO="+matchingCode;
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getMeetingCode());
		pstmt.setInt(2, vo.getSvtype());
		pstmt.setString(3, vo.getSurviceTime());
		pstmt.setString(4, vo.getStart());
		pstmt.setString(5, vo.getEnd());
		pstmt.setString(6, vo.getSurviceYN());

		// SQL ¹® ½ÇÇà
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public NurseInfoVO nurseinfoSelect(String nu_id) throws Exception {

		String sql = "SELECT n.NU_ID, n.NU_PICTURE, n.NU_NAME, n.NU_SEX, n.NU_COUNTRY, n.NU_TEL, n.NU_ADD, s.SV_TYPENAME "
				+ "FROM nurse n JOIN survice s ON n.SV_TYPE = s.SV_TYPE " 
				+ "WHERE n.NU_ID ='"+nu_id+"'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		String id, imgPath, name, sex, tel, country, typename, add;
		NurseInfoVO vo = new NurseInfoVO();
		if (rs.next()) {
			id = rs.getString("nu_id");
			name = rs.getString("nu_name");
			sex = rs.getString("nu_sex");
			country = rs.getString("nu_country");
			tel = rs.getString("nu_tel");
			typename = rs.getString("sv_typename");
			imgPath = rs.getString("nu_picture");
			add = rs.getString("NU_ADD");
			vo.setNu_picture(imgPath);
			vo.setNu_name(name);
			vo.setNu_sex(sex);
			vo.setNu_country(country);
			vo.setNu_tel(tel);
			vo.setSv_typename(typename);
			vo.setId(id);
			vo.setNu_add(add);
		}
		rs.close();
		stmt.close();
		return vo;
	}
	
	public MatchingVO patientinfoSelect(String ptcode) throws Exception {
		String sql = "select m.MG_ID, m.MG_NAME, m.MG_BIRTH, m.MG_SEX, m.MG_TEL, m.MG_ADD, "
				+ "p.PT_NO, p.PT_NAME, p.PT_JUMIN, p.PT_SEX, p.PT_TEL, p.PT_ADD, "
				+ "p.PT_HEIGHT, p.PT_WEIGHT, p.PT_DIAGNAME, p.CR_NO, "
				+ "PT_CONDITION, PT_MEAL, PT_URINE, PT_PARAL, PT_EXERCISE, PT_BEDSORE, PT_SUCTION "
				+ "from PATIENT p, MAIN_GUARDIAN m "
				+ "where p.MG_ID=m.MG_ID and p.PT_NO="+ptcode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		MatchingVO vo = new MatchingVO();
		if(rs.next()) {
			vo.setMg_id(rs.getString("MG_ID"));
			vo.setMg_name(rs.getString("MG_NAME"));
			vo.setMg_birth(rs.getString("MG_BIRTH"));
			vo.setMg_sex(rs.getString("MG_SEX"));
			vo.setMg_tel(rs.getString("MG_TEL"));
			vo.setMg_add(rs.getString("MG_ADD"));
			
			vo.setPt_no(rs.getString("PT_NO"));
			vo.setPt_name(rs.getString("PT_NAME"));
			vo.setPt_jumin(rs.getString("PT_JUMIN"));
			vo.setPt_sex(rs.getString("PT_SEX"));
			vo.setPt_tel(rs.getString("PT_TEL"));
			vo.setPt_add(rs.getString("PT_ADD"));
			
			vo.setPt_height(rs.getString("PT_HEIGHT"));
			vo.setPt_weight(rs.getString("PT_WEIGHT"));
			vo.setPt_diagname(rs.getString("PT_DIAGNAME"));
			vo.setCr_no(rs.getString("CR_NO"));
			
			vo.setPt_condition(rs.getString("PT_CONDITION"));
			vo.setPt_meal(rs.getString("PT_MEAL"));
			vo.setPt_urine(rs.getString("PT_URINE"));
			vo.setPt_paral(rs.getString("PT_PARAL"));
			vo.setPt_exercise(rs.getString("PT_EXERCISE"));
			vo.setPt_bedsore(rs.getString("PT_BEDSORE"));
			vo.setPt_suction(rs.getString("PT_SUCTION"));
		}
		return vo;
	}
	
	
}
