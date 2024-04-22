package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.guardianuserVO.PatientInfoVO;
import vo.guardianuserVO.SubGuardianInfoVO;

public class SubGuardianInfoDAO {
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";

	// constructor
	public SubGuardianInfoDAO() throws Exception {
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

	public void insertSubGuardianInfo(SubGuardianInfoVO vo) throws SQLException {
		// 등록을 위한 SQL 문
		String sql = "INSERT INTO sub_guardian (sg_no, PT_NO, sg_name, sg_birth, sg_tel, sg_add, sg_relation) "
				+ "VALUES (sq_sub_guardian.nextval, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 매개변수 설정
			pstmt.setInt(1, Integer.parseInt(vo.getPt_no()));
			pstmt.setString(2, vo.getSg_name());
			pstmt.setString(3, vo.getSg_birth());
			pstmt.setString(4, vo.getSg_tel());
			pstmt.setString(5, vo.getSg_add());
			pstmt.setString(6, vo.getSg_relation());
			pstmt.executeUpdate();
		} finally {

		}
	}

	public void updateSubGuardianInfo(int code, SubGuardianInfoVO vo) throws SQLException {
		// 수정을 위한 SQL 문
		String sql = "update sub_guardian set pt_no=?, sg_name=?, sg_birth=?, sg_tel=?, sg_add=?, sg_relation=? "
				+ "where sg_no="+code;
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 매개변수 설정
		pstmt.setString(1, vo.getPt_no());
		pstmt.setString(2, vo.getSg_name());
		pstmt.setString(3, vo.getSg_birth());
		pstmt.setString(4, vo.getSg_tel());
		pstmt.setString(5, vo.getSg_add());
		pstmt.setString(6, vo.getSg_relation());

		// SQL 문 실행
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	public ArrayList patientInfoSelect(String id) throws Exception {
		String sql = "select p.PT_NO, p.PT_NAME, p.PT_JUMIN, p.MG_RELATION, c.CN_NAME " + "from PATIENT p, CENTER c "
				+ "where p.CN_ID=c.CN_ID and p.MG_ID='" + id + "' order by 1";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("PT_JUMIN"));
			temp.add(rs.getString("MG_RELATION"));
			temp.add(rs.getString("CN_NAME"));
			list.add(temp);
		}
		return list;
	}
	
	public SubGuardianInfoVO selectSubGuardianInfo(int code) throws SQLException {
		String sql = "select SG_NAME, SG_BIRTH, SG_TEL, SG_ADD, SG_RELATION "
				+ "from SUB_GUARDIAN "
				+ "where SG_NO=" + code;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		SubGuardianInfoVO vo = new SubGuardianInfoVO();
		if (rs.next()) {
			vo.setSg_name(rs.getString("SG_NAME"));
			vo.setSg_birth(rs.getString("SG_BIRTH"));
			vo.setSg_tel(rs.getString("SG_TEL"));
			vo.setSg_add(rs.getString("SG_ADD"));
			vo.setSg_relation(rs.getString("SG_RELATION"));
		}
		rs.close();
		stmt.close();
		return vo;
	}
}