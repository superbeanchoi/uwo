package dao.nurseuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NurseSalDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pxd = "pass";

	Statement stmt = null;

	public NurseSalDAO() throws Exception {
		Class.forName(driver);
		conn= DriverManager.getConnection(url, user, pxd);
	}
	public ArrayList nusalSearch (String nu_id) throws Exception{
		String sql ="select s.ss_no, s.ss_date, s.ss_sumsal, s.ss_tax, s.ss_fee, s.ss_receipt, s.ss_paydate, s.ss_paystatus from nurse n , sal_state s "
				+ "where n.nu_id = s.nu_id and s.nu_id = '" + nu_id + "' order by 1";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("ss_no"));
			temp.add(rs.getString("ss_date").substring(0, 7));
			temp.add(rs.getString("ss_sumsal"));
			temp.add(rs.getString("ss_tax"));
			temp.add(rs.getString("ss_fee"));
			temp.add(rs.getString("ss_receipt"));
			temp.add(rs.getString("ss_paydate").substring(0, 10));
			temp.add(rs.getString("ss_paystatus"));
			
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;


	}


}
