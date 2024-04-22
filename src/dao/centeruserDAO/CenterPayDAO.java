package dao.centeruserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import vo.centeruserVO.CenterPayVO;

public class CenterPayDAO {

	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pxd = "pass";

	Statement stmt = null;
	PreparedStatement ps = null;

	public CenterPayDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pxd);
	}

	public ArrayList allnurseSearch(String cnid) throws Exception {

		String sql = "select n.nu_id, n.nu_name, n.nu_tel, mc.mg_no "
				+ "from nurse n, patient p, meeting mt, matching mc " + "where n.nu_id=mt.nu_id and p.pt_no=mt.pt_no "
				+ "and mt.mt_no=mc.mt_no " + "and mc.MT_SV_CONFIRMATION='Y' and cn_id='" + cnid + "' order by 1";

		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("nu_id"));
			temp.add(rs.getString("nu_name"));
			temp.add(rs.getString("nu_tel"));
			temp.add(rs.getString("mg_no"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList nurseSearch(String cnid, int sel, String text) throws Exception {
		String where = null;
		if (sel == 0) {
			where = "n.nu_id";
		} else if (sel == 1) {
			where = "n.nu_name";
		} else if (sel == 2) {
			where = "n.nu_jumin";
		} else if (sel == 3) {
			where = "n.nu_tel";
		}
		String sql = "select n.nu_id, n.nu_name, n.nu_tel, mc.mg_no "
				+ "from nurse n, patient p, meeting mt, matching mc " + "where n.nu_id=mt.nu_id and p.pt_no=mt.pt_no "
				+ "and mt.mt_no=mc.mt_no " + "and mc.MT_SV_CONFIRMATION='Y' and cn_id='" + cnid + "' and " + where
				+ " like '%" + text + "%' order by 1";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("nu_id"));
			temp.add(rs.getString("nu_name"));
			temp.add(rs.getString("nu_tel"));
			temp.add(rs.getString("mg_no"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList nurseSalSelect(String nuid) throws Exception {
		String sql = "SELECT ss_no, ss_date, ss_sumsal, ss_tax, ss_fee, ss_receipt, ss_paydate, ss_paystatus "
				+ "FROM SAL_STATE WHERE nu_id='" + nuid + "' order by 2 desc";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("ss_no"));
			temp.add(rs.getString("ss_date").substring(0, 7));
			temp.add(rs.getInt("ss_sumsal"));
			temp.add(rs.getInt("ss_tax"));
			temp.add(rs.getInt("ss_fee"));
			temp.add(rs.getInt("ss_receipt"));
			temp.add(rs.getString("ss_paydate").substring(0, 10));
			list.add(temp);
		}

		return list;
	}

	public void nursePayInsert(CenterPayVO vo) throws Exception {
		String sql = "INSERT INTO SAL_STATE(SS_NO, NU_ID, SS_DATE, SS_SUMSAL, SS_TAX, SS_FEE, SS_RECEIPT, SS_PAYDATE, SS_PAYSTATUS) "
				+ "values (sq_sal_state.nextval, ?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getNu_id());
		ps.setString(2, vo.getSs_date());
		ps.setString(3, vo.getSs_sumsal());
		ps.setString(4, vo.getSs_tax());
		ps.setString(5, vo.getSs_fee());
		ps.setString(6, vo.getSs_receipt());
		ps.setString(7, vo.getSs_paydate());
		ps.setString(8, vo.getSs_paystatus());
		ps.executeUpdate();
		ps.close();
	}

	public void nursePayModify(CenterPayVO vo, String ssno) throws Exception {
		String sql = "UPDATE SAL_STATE SET ss_date = ?, ss_sumsal = ?, ss_tax = ?, "
				+ "ss_fee = ?, ss_receipt  = ?, ss_paydate = ?, ss_paystatus = ? WHERE ss_no =" + ssno;
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getSs_date());
		ps.setString(2, vo.getSs_sumsal());
		ps.setString(3, vo.getSs_tax());
		ps.setString(4, vo.getSs_fee());
		ps.setString(5, vo.getSs_receipt());
		ps.setString(6, vo.getSs_paydate());
		ps.setString(7, vo.getSs_paystatus());
		ps.executeUpdate();
		ps.close();
	}

	public CenterPayVO nursePayget(String ssno) throws SQLException {
		String sql = "SELECT * FROM SAL_STATE WHERE ss_no =" + ssno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		CenterPayVO vo = new CenterPayVO();
		while (rs.next()) {
			vo.setNu_id(rs.getString("nu_id"));
			vo.setSs_date(rs.getString("ss_date"));
			vo.setSs_sumsal(rs.getString("ss_sumsal"));
			vo.setSs_tax(rs.getString("ss_tax"));
			vo.setSs_fee(rs.getString("ss_fee"));
			vo.setSs_receipt(rs.getString("ss_receipt"));
			vo.setSs_paydate(rs.getString("ss_paydate"));
			vo.setSs_paystatus(rs.getString("ss_paystatus"));
		}
		return vo;
	}

	public void nursePayDelete(String ssno) throws Exception {
		String sql = "DELETE FROM SAL_STATE WHERE ss_no=" + ssno;
		stmt = conn.createStatement();
		stmt.executeQuery(sql);
		stmt.close();
	}

	public ArrayList allpatientSearch(String cnid) throws Exception {
		String sql = "select p.pt_no, p.pt_name, mg.mg_id, mg.mg_name, mg.mg_tel, mc.mg_no "
				+ "from patient p, main_guardian mg, meeting mt, matching mc "
				+ "where p.mg_id=mg.mg_id and p.pt_no=mt.pt_no " + "and mt.mt_no=mc.mt_no "
				+ "and mc.MT_SV_CONFIRMATION='Y' and cn_id='" + cnid + "' order by 1";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("pt_no"));
			temp.add(rs.getString("pt_name"));
			temp.add(rs.getString("mg_id"));
			temp.add(rs.getString("mg_name"));
			temp.add(rs.getString("mg_tel"));
			temp.add(rs.getString("mg_no"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList patientSearch(String cnid, int sel, String text) throws Exception {
		String where = null;
		if (sel == 0) {
			where = "p.pt_no";
		} else if (sel == 1) {
			where = "p.pt_name";
		} else if (sel == 2) {
			where = "p.pt_jumin";
		} else if (sel == 3) {
			where = "p.pt_tel";
		}
		String sql = "select p.pt_no, p.pt_name, mg.mg_id, mg.mg_name, mg.mg_tel, mc.mg_no "
				+ "from patient p, main_guardian mg, meeting mt, matching mc "
				+ "where p.mg_id=mg.mg_id and p.pt_no=mt.pt_no " + "and mt.mt_no=mc.mt_no "
				+ "and mc.MT_SV_CONFIRMATION='Y' and cn_id='" + cnid + "' and " + where + " like '%" + text
				+ "%' order by 1";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("pt_no"));
			temp.add(rs.getString("pt_name"));
			temp.add(rs.getString("mg_id"));
			temp.add(rs.getString("mg_name"));
			temp.add(rs.getString("mg_tel"));
			temp.add(rs.getString("mg_no"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList patientPaySelect(String ptno) throws Exception {
		String sql = "SELECT ms_no, pt_no, ms_date, ms_pay_amount, ms_tax, ms_deposit "
				+ "FROM MONTHLY_STATE WHERE pt_no=" + ptno + " order by 3 desc";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("ms_no"));
			temp.add(rs.getInt("pt_no"));
			temp.add(rs.getString("ms_date").substring(0, 7));
			temp.add(rs.getString("ms_pay_amount"));
			temp.add(rs.getString("ms_tax"));
			temp.add(rs.getString("ms_deposit").substring(0, 10));
			list.add(temp);
		}

		return list;
	}

	public CenterPayVO getPatientBankInfo(String ptno) throws Exception {
		CenterPayVO vo = new CenterPayVO();
		String sql = "SELECT dp_bank, dp_virtual " + "FROM DEPOSIT WHERE pt_no=" + ptno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setDp_bank(rs.getString("dp_bank"));
			vo.setDp_virtual(rs.getString("dp_virtual"));

		}
		return vo;
	}

	public void patientPayInsert(CenterPayVO vo) throws Exception {
		String sql = "INSERT INTO MONTHLY_STATE(ms_no, pt_no, ms_date, ms_pay_amount, ms_deposit, ms_tax)"
				+ "VALUES (sq_monthly_state.nextval, ?, ?, ?, ?, ?) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getPt_no());
		ps.setString(2, vo.getMs_date());
		ps.setString(3, vo.getMs_pay_amount());
		ps.setString(4, vo.getMs_deposit());
		ps.setString(5, vo.getMs_tax());
		ps.executeUpdate();
		ps.close();
	}

	public void patientPayModify(CenterPayVO vo, String msno) throws Exception {
		String sql = "UPDATE MONTHLY_STATE " 
				+ "SET ms_date = ?, ms_pay_amount = ?, ms_deposit = ?, ms_tax = ? "
				+ "WHERE ms_no = '" + msno + "'";
		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getMs_date());
		ps.setString(2, vo.getMs_pay_amount());
		ps.setString(3, vo.getMs_deposit());
		ps.setString(4, vo.getMs_tax());
		ps.executeUpdate();
		ps.close();
	}
	
	public CenterPayVO patientPayget(String msno) throws SQLException {
		String sql = "SELECT * FROM MONTHLY_STATE WHERE ms_no =" + msno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		CenterPayVO vo = new CenterPayVO();
		while (rs.next()) {
			vo.setPt_no(rs.getString("pt_no"));
			vo.setMs_date(rs.getString("ms_date"));
			vo.setMs_pay_amount(rs.getString("ms_pay_amount"));
			vo.setMs_deposit(rs.getString("ms_deposit"));
			vo.setMs_tax(rs.getString("ms_tax"));
		}
		return vo;
	}
	
	public void patientpaydelete(String ms_no) throws Exception {
		String sql = "DELETE MONTHLY_STATE WHERE MS_NO = " + ms_no;
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public ArrayList patientPayCompleteSelect(String msno) throws Exception {
		String sql = "SELECT pay_no, ms_no, pay_date, pay_status "
				+ "FROM payment WHERE ms_no=" + msno;
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("pay_no"));
			temp.add(rs.getInt("ms_no"));
			temp.add(rs.getString("pay_date").substring(0, 10));
			temp.add(rs.getString("pay_status"));
			list.add(temp);
		}
		return list;
	}
	
	public void patientPayComplete(String msno) throws Exception {
		String sql = "INSERT INTO PAYMENT(pay_no, ms_no, pay_date, pay_status) "
				+ "VALUES (sq_payment.nextval, " + msno + ", SYSDATE, 'Y')";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	

}
