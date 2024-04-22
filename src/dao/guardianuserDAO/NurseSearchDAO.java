package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.guardianuserVO.NurseSearchVO;

public class NurseSearchDAO {
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";

	// constructor
	public NurseSearchDAO() throws Exception {
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

	public List<NurseSearchVO> nurseSearch(String nu_sex, String nu_country, String sv_typename) {
		List<NurseSearchVO> searchResult = new ArrayList<>();
		// 여기에 검색 로직 추가
		// 필터에 따라 WHERE 절을 동적으로 생성하여 쿼리 수행
		String sql = "SELECT  n.nu_name, n.nu_sex, n.nu_country, s.sv_typename FROM nurse n, survice s  WHERE  n.SV_TYPE = s.SV_TYPE";
		List<String> conditions = new ArrayList<>();

		// 각 필터에 따라 조건 추가

		if (!"성별".equals(nu_sex)) {
			conditions.add("nu_sex = '" + nu_sex + "'");
		}
		if (!"국적".equals(nu_country)) {
			conditions.add("nu_country = '" + nu_country + "'");
		}
		if (!"서비스 유형".equals(sv_typename)) {
			conditions.add("sv_typename = '" + sv_typename + "'");
		}

		// 조건들을 AND로 연결하여 WHERE 절 완성
		if (!conditions.isEmpty()) {
			sql += " AND (" + String.join(" AND ", conditions) + ")";
		}
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// 쿼리 실행 및 결과 처리
			try (ResultSet resultSet = pstmt.executeQuery()) {
				while (resultSet.next()) {
					NurseSearchVO nurse = new NurseSearchVO(
							resultSet.getString("nu_name"), 
							resultSet.getString("nu_sex"),
							resultSet.getString("nu_country"), 
							resultSet.getString("sv_typename"));
					searchResult.add(nurse);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return searchResult;
	}

}