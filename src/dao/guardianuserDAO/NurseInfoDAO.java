package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.guardianuserVO.NurseInfoVO;
import vo.guardianuserVO.NurseSearchVO;

public class NurseInfoDAO {
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";
	Statement stmt = null;
	PreparedStatement ps = null;

	// constructor
	public NurseInfoDAO() throws Exception {
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

	public NurseSearchVO nurseinfo(String nu_name) throws SQLException {
		NurseSearchVO vo = new NurseSearchVO();
		PreparedStatement psmt = null;
		String sql = "SELECT n.nu_picture, n.nu_name, n.nu_sex, n.nu_country, n.nu_tel, s.sv_typename "
				+ "FROM nurse n, survice s " + "WHERE n.nu_name = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nu_name);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					vo = new NurseSearchVO(
						rs.getString("nu_name"), rs.getString("nu_sex"), rs.getString("nu_country"),
						rs.getString("sv_typename"));
				}
			}
		}

		return vo;
	}

	public ArrayList careerselect(String id) throws Exception {
		String sql = "select CA_FIELD, CA_STARTDATE, CA_ENDDATE, CA_DETAILWORK" + " from CAREER where NU_ID='" + id
				+ "' order by 2";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("CA_FIELD"));
			temp.add(rs.getString("CA_STARTDATE").substring(0, 10));
			temp.add(rs.getString("CA_ENDDATE").substring(0, 10));
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
				+ "where ci.CT_NO=ct.CT_NO and cr.CI_NO=ci.CI_NO and cr.NU_ID='" + id + "' order by 3";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("CT_NAME"));
			temp.add(rs.getString("CI_NAME"));
			temp.add(rs.getString("CR_ACQDATE").substring(0, 10));
			list.add(temp);
		}
		return list;
	}

	public ArrayList skillselect(String id) throws Exception {
		String sql = "select tt.TT_NAME, td.TD_NAME " + "from NUSKILL_INFO ni, TECHNICAL_DETAIL td, TECHNO_TYPE tt "
				+ "where tt.TT_NO=td.TT_NO and td.TD_NO=ni.TD_NO and ni.NU_ID='" + id + "' order by 1, 2";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("TT_NAME"));
			temp.add(rs.getString("TD_NAME"));
			list.add(temp);
		}
		return list;
	}

	public NurseInfoVO infoSelect(String nu_name, String nu_sex, String nu_country, String sv_typename)
			throws Exception {

		String sql = "SELECT n.NU_ID, n.NU_PICTURE, n.NU_NAME, n.NU_SEX, n.NU_COUNTRY, n.NU_TEL, s.SV_TYPENAME "
				+ "FROM nurse n JOIN survice s ON n.SV_TYPE = s.SV_TYPE " + "WHERE n.NU_NAME ='" + nu_name
				+ "' AND n.NU_SEX ='" + nu_sex + "' AND n.NU_COUNTRY ='" + nu_country + "' AND s.SV_TYPENAME ='"
				+ sv_typename + "'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		String id, imgPath, name, sex, tel, country, typename;
		NurseInfoVO vo = new NurseInfoVO();
		if (rs.next()) {
			id = rs.getString("nu_id");
			name = rs.getString("nu_name");
			sex = rs.getString("nu_sex");
			country = rs.getString("nu_country");
			tel = rs.getString("nu_tel");
			typename = rs.getString("sv_typename");
			imgPath = rs.getString("nu_picture");
//			vo = new NurseInfoVO(imgPath, nu_name, nu_sex, tel, nu_country, sv_typename);
			vo.setNu_picture(imgPath);
			vo.setNu_name(name);
			vo.setNu_sex(sex);
			vo.setNu_country(country);
			vo.setNu_tel(tel);
			vo.setSv_typename(typename);
			vo.setId(id);
		}
		rs.close();
		stmt.close();
		return vo;
	}
}