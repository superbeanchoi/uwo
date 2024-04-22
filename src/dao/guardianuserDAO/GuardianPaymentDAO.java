package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GuardianPaymentDAO {

	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pxd = "pass";

	Statement stmt = null;

	public GuardianPaymentDAO() throws Exception {
		Class.forName(driver);
		conn= DriverManager.getConnection(url, user, pxd);
	}



	public ArrayList patientSearch (String id) throws Exception{
		String sql = "SELECT pt_no, pt_name, pt_jumin, pt_diagname, pt_tel FROM PATIENT  where  mg_id ='"+id+"' order by 1";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("pt_no"));
			temp.add(rs.getString("pt_name"));
			temp.add(rs.getString("pt_jumin"));
			temp.add(rs.getString("pt_diagname"));
			temp.add(rs.getString("pt_tel"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;


	}
	
	public ArrayList monthlySearch (String pt_no) throws Exception{
		String sql ="select ms.ms_no, ms.pt_no, ms.ms_date, ms.ms_pay_amount, ms.ms_deposit, ms.ms_tax, d.dp_bank, d.dp_virtual from monthly_state ms, deposit d, patient p"
				+ " where p.pt_no = ms.pt_no and p.pt_no = d.pt_no and p.pt_no ='" + pt_no + "' order by 1";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("ms_no"));
			temp.add(rs.getInt("pt_no"));
			temp.add(rs.getString("ms_date").substring(0, 7));
			temp.add(rs.getString("ms_pay_amount"));
			temp.add(rs.getString("ms_deposit").substring(0, 10));
			temp.add(rs.getString("ms_tax"));
			temp.add(rs.getString("dp_bank"));
			temp.add(rs.getString("dp_virtual"));
			
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;


	}
	
	


	public void patientpaycomplete(int pcode) throws Exception{
		String sql = "INSERT INTO PAYMENT(pay_no, ms_no, pay_date, pay_status) VALUES (sq_payment.nextval, " + pcode + ", SYSDATE, 'Y')";

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e4) {
			JOptionPane.showMessageDialog(null, "[ 명세서 결제완료에 실패했습니다. ]\n" + e4.getMessage());
		}
	}
}










