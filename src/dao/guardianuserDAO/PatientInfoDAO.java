package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import vo.guardianuserVO.PatientInfoVO;

public class PatientInfoDAO {
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";

	// constructor
	public PatientInfoDAO() throws Exception {
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

	public void PatientInfo(PatientInfoVO vo, String mg_id) throws SQLException {
		String sql1 = "insert into patient(pt_no, cn_id, mg_id, pt_name, pt_jumin, pt_add, pt_tel, pt_sex, "
				+ "pt_height, pt_weight, pt_diagname, cr_no, "
				+ "pt_condition, pt_meal, pt_urine, pt_paral, pt_exercise, pt_bedsore, pt_suction, mg_relation) "
				+ "values (sq_patient.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql1);
		pstmt.setString(1, null);
		pstmt.setString(2, mg_id);
		pstmt.setString(3, vo.getPt_name());
		pstmt.setString(4, vo.getPt_jumin());
		pstmt.setString(5, vo.getPt_add());
		pstmt.setString(6, vo.getPt_tel());
		pstmt.setString(7, vo.getPt_sex());
		pstmt.setString(8, vo.getPt_height());
		pstmt.setString(9, vo.getPt_weight());
		pstmt.setString(10, vo.getPt_diagname());
		pstmt.setString(11, vo.getCr_no());
		pstmt.setString(12, vo.getPt_condition());
		pstmt.setString(13, vo.getPt_meal());
		pstmt.setString(14, vo.getPt_urine());
		pstmt.setString(15, vo.getPt_paral());
		pstmt.setString(16, vo.getPt_exercise());
		pstmt.setString(17, vo.getPt_bedsore());
		pstmt.setString(18, vo.getPt_suction());
		pstmt.setString(19, vo.getMg_relation());
		pstmt.executeUpdate();

		int ptno = selectPatientCode(vo);
		int num = (ptno%4)+1;
		String sql2 = "update patient set cn_id=? where PT_JUMIN=?";
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		if (num==1) {
			pstmt2.setString(1, "bean");
		} else if(num==2) {
			pstmt2.setString(1, "supreme");
		} else if(num==3) {
			pstmt2.setString(1, "kdh");
		} else {
			pstmt2.setString(1, "le");
		}
		pstmt2.setString(2, vo.getPt_jumin());
		pstmt2.executeUpdate();

		String virtualAccount = virtualAccount();
		String sql3 = "insert into DEPOSIT(DP_VIRTUAL, PT_NO, DP_BANK) "
				+ "values(?, ?, ?)";
		PreparedStatement pstmt3 = conn.prepareStatement(sql3);
		pstmt3.setString(1, virtualAccount);
		pstmt3.setInt(2, ptno);
		if (num==1) {
			pstmt3.setString(3, "우리은행");
		} else if(num==2) {
			pstmt3.setString(3, "국민은행");
		} else if(num==3) {
			pstmt3.setString(3, "신한은행");
		} else {
			pstmt3.setString(3, "하나은행");
		}
		pstmt3.executeUpdate();
		
		pstmt.close();
		pstmt2.close();
		pstmt3.close();
	}

	public int selectPatientCode(PatientInfoVO vo) throws SQLException {
		int code = 0;
		String sql = "select pt_no from patient where PT_JUMIN=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPt_jumin());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			code = rs.getInt("pt_no");
		}
		rs.close();
		pstmt.close();
		return code;
	}

    private static String virtualAccount() {
        Random random = new Random();
        int AAASection = random.nextInt(900) + 100;
        int BBBBSection = random.nextInt(9000) + 1000;
        int CCCSection = random.nextInt(900) + 100;
        String virtualAccount = String.format("%03d-%04d-%04d-%03d", AAASection, BBBBSection, BBBBSection, CCCSection);
        return virtualAccount;
    }
	
	public PatientInfoVO selectPatientInfo(int code) throws SQLException {
		String sql = "select PT_NAME, PT_JUMIN, PT_ADD, PT_TEL, PT_SEX, PT_HEIGHT, PT_WEIGHT, PT_DIAGNAME, CR_NO, "
				+ "PT_CONDITION, PT_MEAL, PT_URINE, PT_PARAL, PT_EXERCISE, PT_BEDSORE, PT_SUCTION, MG_RELATION "
				+ "from PATIENT where PT_NO=" + code;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		PatientInfoVO vo = new PatientInfoVO();
		if (rs.next()) {
			vo.setPt_name(rs.getString("PT_NAME"));
			vo.setPt_jumin(rs.getString("PT_JUMIN"));
			vo.setPt_add(rs.getString("PT_ADD"));
			vo.setPt_tel(rs.getString("PT_TEL"));
			vo.setPt_sex(rs.getString("PT_SEX"));
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
			vo.setMg_relation(rs.getString("MG_RELATION"));
		}
		rs.close();
		stmt.close();
		return vo;
	}

	public void updatePatientInfo(PatientInfoVO vo, int code) throws SQLException {
		String sql = "UPDATE patient SET pt_name=?, pt_jumin=?, pt_add=?, pt_tel=?, pt_sex=?, "
				+ "pt_height=?, pt_weight=?, pt_diagname=?, cr_no=?, "
				+ "pt_condition=?, pt_meal=?, pt_urine=?, pt_paral=?, pt_exercise=?, pt_bedsore=?, pt_suction=?, "
				+ "mg_relation=?"
				+ "WHERE pt_no="+code;

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getPt_name());
		pstmt.setString(2, vo.getPt_jumin());
		pstmt.setString(3, vo.getPt_add());
		pstmt.setString(4, vo.getPt_tel());
		pstmt.setString(5, vo.getPt_sex());
		pstmt.setString(6, vo.getPt_height());
		pstmt.setString(7, vo.getPt_weight());
		pstmt.setString(8, vo.getPt_diagname());
		pstmt.setString(9, vo.getCr_no());
		pstmt.setString(10, vo.getPt_condition());
		pstmt.setString(11, vo.getPt_meal());
		pstmt.setString(12, vo.getPt_urine());
		pstmt.setString(13, vo.getPt_paral());
		pstmt.setString(14, vo.getPt_exercise());
		pstmt.setString(15, vo.getPt_bedsore());
		pstmt.setString(16, vo.getPt_suction());
		pstmt.setString(17, vo.getMg_relation());

		pstmt.executeUpdate(); // 배치 실행
		pstmt.close();
}

}
