package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.guardianuserVO.GuardianMypageInfoVO;

public class GuardianMypageInfoDAO {
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";

	// constructor
	public GuardianMypageInfoDAO() throws Exception {
		connectDB();
	}

	// ###########################################################
	// DB control method
	Connection conn;

	void connectDB() throws Exception {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("성공적으로 DB연결 및 로딩됨");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("드라이버를 찾을 수 없습니다");
		} catch (SQLException e) {
			System.out.println("DB 명령이 잘못되었습니다");
		}
	}

	public void updateMypageInfo(GuardianMypageInfoVO vo) throws SQLException {

		// 등록을 위한 SQL 문
		String sql = "update main_guardian set mg_pw=?, mg_name=?, mg_birth=?, mg_sex=?, mg_tel=?, mg_add=? where mg_id=?";
		try {
			// 준비된 문을 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// 매개변수 설정
			pstmt.setString(1, vo.getMg_pw());
			pstmt.setString(2, vo.getMg_name());
			pstmt.setString(3, vo.getMg_birth());
			pstmt.setString(4, vo.getMg_sex());
			pstmt.setString(5, vo.getMg_tel());
			pstmt.setString(6, vo.getMg_add());
			pstmt.setString(7, vo.getMg_id());
			// SQL 문 실행
			pstmt.executeUpdate();
		} finally {
		}
	}

	public GuardianMypageInfoVO getMypageInfo(String mg_id) throws SQLException {
		GuardianMypageInfoVO vo = new GuardianMypageInfoVO();
		Statement st = null;
		ResultSet rs = null;
//	    try {
		String sql = "SELECT * FROM main_guardian WHERE mg_id = '" + mg_id + "'";
//	        ps = conn.prepareStatement(sql);
//	        ps.setString(1, mg_id);
		st = conn.createStatement();

		// SQL 문 실행하고 결과를 ResultSet으로 받음
		rs = st.executeQuery(sql); // Removed semicolon

		// ResultSet에서 가져온 회원 정보를 MypageInfoVO 객체에 설정
		if (rs.next()) {
			vo.setMg_pw(rs.getString("mg_pw"));
			vo.setMg_name(rs.getString("mg_name"));
			vo.setMg_birth(rs.getString("mg_birth"));
			vo.setMg_sex(rs.getString("mg_sex"));
			vo.setMg_tel(rs.getString("mg_tel"));
			vo.setMg_add(rs.getString("mg_add"));
			// 나머지 필드들도 동일하게 설정
		}
		rs.close();
		st.close();
//        } finally {
//            // close resources if needed
//        }

		return vo;
	}
	
	
	public ArrayList patientInfoSelect(String id) throws Exception {
		String sql = "select p.PT_NO, p.PT_NAME, p.CR_NO, c.CN_NAME, c.CN_TEL "
				+ "from PATIENT p, CENTER c "
				+ "where p.CN_ID=c.CN_ID and p.MG_ID='"+id+"' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("CR_NO"));
			temp.add(rs.getString("CN_NAME"));
			temp.add(rs.getString("CN_TEL"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public void patientInfoDelete(int code) throws Exception {
		String sql = "delete PATIENT where PT_NO="+code;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public ArrayList subGuardianInfoSelect(String id) throws Exception {
		String sql = "select s.SG_NO, s.SG_NAME, s.SG_TEL, s.SG_ADD, p.PT_NAME, s.SG_RELATION "
				+ "from SUB_GUARDIAN s, PATIENT p "
				+ "where s.PT_NO=p.PT_NO and p.MG_ID='"+id+"' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("SG_NO"));
			temp.add(rs.getString("SG_NAME"));
			temp.add(rs.getString("SG_TEL"));
			temp.add(rs.getString("SG_ADD"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("SG_RELATION"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public ArrayList subGuardianInfoSelectMGMatching(String id, String patientCode) throws Exception {
		String sql = "select s.SG_NO, s.SG_NAME, s.SG_TEL, s.SG_ADD, p.PT_NAME, s.SG_RELATION "
				+ "from SUB_GUARDIAN s, PATIENT p "
				+ "where s.PT_NO=p.PT_NO and p.MG_ID='"+id+"' "
				+ "and s.PT_NO="+patientCode+" order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("SG_NO"));
			temp.add(rs.getString("SG_NAME"));
			temp.add(rs.getString("SG_TEL"));
			temp.add(rs.getString("SG_ADD"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("SG_RELATION"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public void subGuardianInfoDelete(int code) throws Exception {
		String sql = "delete sub_guardian where SG_NO="+code;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public ArrayList meetingInfoSelect(String mg_id) throws Exception {
		String sql = "select m.MT_NO, m.PT_NO, p.PT_NAME, n.NU_NAME, m.MT_REQDATE "
				+ "from MEETING m, PATIENT p, NURSE n "
				+ "where m.PT_NO=p.PT_NO and m.NU_ID=n.NU_ID and p.MG_ID='"+mg_id+"' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("MT_NO"));
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("NU_NAME"));
			temp.add(rs.getString("MT_REQDATE").substring(0, 10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
		
	}
	
	public GuardianMypageInfoVO meetingDetailSelect(String meetingCode) throws Exception {
		String sql = "select n.NU_PICTURE, n.NU_NAME, n.NU_SEX, s.SV_TYPENAME, m.MT_CONTENT "
				+ "from MEETING m, NURSE n, SURVICE s "
				+ "where m.NU_ID=n.NU_ID and n.SV_TYPE=s.SV_TYPE "
				+ "and m.MT_NO="+meetingCode;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		GuardianMypageInfoVO vo = new GuardianMypageInfoVO();
		if(rs.next()) {
			vo.setNu_picture(rs.getString("NU_PICTURE"));
			vo.setNu_name(rs.getString("NU_NAME"));
			vo.setNu_sex(rs.getString("NU_SEX"));
			vo.setSv_type(rs.getString("SV_TYPENAME"));
			vo.setMt_content(rs.getString("MT_CONTENT"));
		}
		return vo;
	}
	
	public ArrayList consultingSelect(String mg_id) throws Exception {
		String sql = "select c.CS_NO, c.PT_NO, p.PT_NAME, ct.CN_NAME, c.CS_DATE "
				+ "from COUNSELING c, PATIENT p, CENTER ct "
				+ "where c.PT_NO=p.PT_NO and p.CN_ID=ct.CN_ID "
				+ "and p.MG_ID='"+mg_id+"'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("CS_NO"));
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("CN_NAME"));
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
	
	
}
