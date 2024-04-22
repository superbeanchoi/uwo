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
			System.out.println("���������� DB���� �� �ε���");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("����̹��� ã�� �� �����ϴ�");
		} catch (SQLException e) {
			System.out.println("DB ����� �߸��Ǿ����ϴ�");
		}
	}

	public List<NurseSearchVO> nurseSearch(String nu_sex, String nu_country, String sv_typename) {
		List<NurseSearchVO> searchResult = new ArrayList<>();
		// ���⿡ �˻� ���� �߰�
		// ���Ϳ� ���� WHERE ���� �������� �����Ͽ� ���� ����
		String sql = "SELECT  n.nu_name, n.nu_sex, n.nu_country, s.sv_typename FROM nurse n, survice s  WHERE  n.SV_TYPE = s.SV_TYPE";
		List<String> conditions = new ArrayList<>();

		// �� ���Ϳ� ���� ���� �߰�

		if (!"����".equals(nu_sex)) {
			conditions.add("nu_sex = '" + nu_sex + "'");
		}
		if (!"����".equals(nu_country)) {
			conditions.add("nu_country = '" + nu_country + "'");
		}
		if (!"���� ����".equals(sv_typename)) {
			conditions.add("sv_typename = '" + sv_typename + "'");
		}

		// ���ǵ��� AND�� �����Ͽ� WHERE �� �ϼ�
		if (!conditions.isEmpty()) {
			sql += " AND (" + String.join(" AND ", conditions) + ")";
		}
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			// ���� ���� �� ��� ó��
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