package dao.loginDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.loginVO.GuardianNewMemVO;

public class GuardianNewMemDAO {
	public GuardianNewMemDAO() throws Exception {
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
	
	public void insert(GuardianNewMemVO vo) throws Exception {
		String sql = "insert into MAIN_GUARDIAN(MG_ID, MG_PW, MG_NAME, MG_BIRTH, MG_SEX, MG_TEL, MG_ADD) "
				+ " values(?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getBirth());
		ps.setString(5, vo.getSex());
		ps.setString(6, vo.getTel());
		ps.setString(7, vo.getAdd());
		ps.executeUpdate();
		ps.close();
	}
	
	public boolean select(String id) throws Exception {
		String sql = "select MG_ID from MAIN_GUARDIAN where MG_ID='"+id+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
}
