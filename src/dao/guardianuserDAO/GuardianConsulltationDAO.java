package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.guardianuserVO.GuardianConsulltationVO;

public class GuardianConsulltationDAO {

	public GuardianConsulltationDAO() throws Exception {
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

	public ArrayList patientInfoSelect(String id) throws Exception {
		String sql = "select p.PT_NO, p.PT_NAME, p.PT_JUMIN, p.MG_RELATION, c.CN_NAME " + "from PATIENT p, CENTER c "
				+ "where p.CN_ID=c.CN_ID and p.MG_ID='" + id + "' order by 1";
		stmt = conn.createStatement();
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

	public void consultinginsert(GuardianConsulltationVO vo) throws Exception {
		String sql = "insert into COUNSELING(CS_NO, PT_NO, CS_DATE, CS_CONTENT) "
				+ " values( sq_counseling.nextval, ?, sysdate ,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getCode());
		ps.setString(2, vo.getConsultingText());
		ps.executeUpdate();
		ps.close();
	}
}
