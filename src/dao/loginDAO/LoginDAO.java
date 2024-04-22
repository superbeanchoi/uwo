package dao.loginDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	
	public LoginDAO() throws Exception {
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
	
	public boolean guardianSelect(String id, String pw) throws Exception {
		String sql = "select MG_ID from MAIN_GUARDIAN where MG_ID='"+id+"' and MG_PW='"+pw+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean nurseSelect(String id, String pw) throws Exception {
		String sql = "select NU_ID from NURSE where NU_ID='"+id+"' and NU_PW='"+pw+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean centerSelect(String id, String pw) throws Exception {
		String sql = "select CN_ID from CENTER where CN_ID='"+id+"' and CN_PW='"+pw+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
	
}
