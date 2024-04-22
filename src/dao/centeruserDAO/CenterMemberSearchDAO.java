package dao.centeruserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.centeruserVO.CenterMemberSearchVO;

public class CenterMemberSearchDAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pxd = "pass";

	Statement stmt = null;

	public CenterMemberSearchDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pxd);
	}

	public ArrayList allpatientSearch() throws Exception {
		String sql = "select PT_NO, PT_NAME, PT_JUMIN, CN_NAME, CN_TEL " + "from PATIENT p, CENTER c "
				+ "where p.CN_ID=c.CN_ID order by 1";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("PT_JUMIN"));
			temp.add(rs.getString("CN_NAME"));
			temp.add(rs.getString("CN_TEL"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList patientSearch(int sel, String text) throws Exception {
		String[] selCol = { "pt_no", "pt_name", "pt_jumin", "pt_tel" };
		String sql = "select PT_NO, PT_NAME, PT_JUMIN, CN_NAME, CN_TEL " + "from PATIENT p, CENTER c "
				+ "where p.CN_ID=c.CN_ID and " + selCol[sel] + " like '%" + text + "%' order by 1";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("PT_JUMIN"));
			temp.add(rs.getString("CN_NAME"));
			temp.add(rs.getString("CN_TEL"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public CenterMemberSearchVO allPatientInfoSelect(String ptno) throws Exception {
		CenterMemberSearchVO vo = new CenterMemberSearchVO();
		String sql = "select PT_NO, PT_NAME, PT_JUMIN, PT_SEX, CR_NO, PT_TEL, PT_ADD, CN_NAME, CN_TEL, "
				+ "m.MG_ID, MG_NAME, MG_BIRTH, MG_SEX, MG_TEL, MG_ADD, MG_RELATION "
				+ "from PATIENT p, CENTER c, MAIN_GUARDIAN m " + "where p.CN_ID=c.CN_ID and p.MG_ID=m.MG_ID and PT_NO="
				+ ptno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setPt_no(rs.getString("PT_NO"));
			vo.setPt_name(rs.getString("PT_NAME"));
			vo.setPt_jumin(rs.getString("PT_JUMIN"));
			vo.setPt_sex(rs.getString("PT_SEX"));
			vo.setCr_no(rs.getString("CR_NO"));
			vo.setPt_tel(rs.getString("PT_TEL"));
			vo.setPt_add(rs.getString("PT_ADD"));
			vo.setCn_name(rs.getString("CN_NAME"));
			vo.setCn_tel(rs.getString("CN_TEL"));
			vo.setMg_id(rs.getString("MG_ID"));
			vo.setMg_name(rs.getString("MG_NAME"));
			vo.setMg_birth(rs.getString("MG_BIRTH"));
			vo.setMg_sex(rs.getString("MG_SEX"));
			vo.setMg_tel(rs.getString("MG_TEL"));
			vo.setMg_add(rs.getString("MG_ADD"));
			vo.setMg_relation(rs.getString("MG_RELATION"));
		}
		return vo;
	}

	public ArrayList subGuardianSearch(String ptno) throws Exception {
		String sql = "select SG_NO, SG_NAME from SUB_GUARDIAN where PT_NO=" 
				+ ptno + " order by 1";
		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("SG_NO"));
			temp.add(rs.getString("SG_NAME"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public CenterMemberSearchVO detailPatientInfoSelect(String ptno) throws Exception {
		CenterMemberSearchVO vo = new CenterMemberSearchVO();
		String sql = "select pt_diagname, pt_height, pt_weight, "
				+ "pt_condition, pt_meal, pt_urine, pt_paral, pt_exercise, pt_bedsore, pt_suction "
				+ "from patient where pt_no=" + ptno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setPt_diagname(rs.getString("pt_diagname"));
			vo.setPt_height(rs.getString("pt_height"));
			vo.setPt_weight(rs.getString("pt_weight"));
			vo.setPt_condition(rs.getString("pt_condition"));
			vo.setPt_meal(rs.getString("pt_meal"));
			vo.setPt_urine(rs.getString("pt_urine"));
			vo.setPt_paral(rs.getString("pt_paral"));
			vo.setPt_exercise(rs.getString("pt_exercise"));
			vo.setPt_bedsore(rs.getString("pt_bedsore"));
			vo.setPt_suction(rs.getString("pt_suction"));
		}
		return vo;
	}

	public CenterMemberSearchVO detailsubGuradianInfoSelect(String sgno) throws Exception {
		CenterMemberSearchVO vo = new CenterMemberSearchVO();
		String sql = "select sg_name, sg_birth, sg_tel, sg_add, sg_relation " 
				+ "from sub_guardian where sg_no=" + sgno;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setSg_name(rs.getString("sg_name"));
			vo.setSg_birth(rs.getString("sg_birth"));
			vo.setSg_tel(rs.getString("sg_tel"));
			vo.setSg_add(rs.getString("sg_add"));
			vo.setSg_relation(rs.getString("sg_relation"));
		}
		return vo;
	}

	public ArrayList allnurseSearch() throws Exception {

		String sql = "SELECT nu_id, nu_name, nu_jumin, nu_tel " 
				+ "FROM NURSE order by 1";

		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("nu_id"));
			temp.add(rs.getString("nu_name"));
			temp.add(rs.getString("nu_jumin"));
			temp.add(rs.getString("nu_tel"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList nurseSearch(int sel, String text) throws Exception {

		String[] selCol = { "nu_id", "nu_name", "nu_jumin", "nu_tel" };
		String sql = "SELECT nu_id, nu_name, nu_jumin, nu_tel FROM NURSE " 
				+ "where "+selCol[sel]+" like '%"+text+"%'";

		ArrayList list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("nu_id"));
			temp.add(rs.getString("nu_name"));
			temp.add(rs.getString("nu_jumin"));
			temp.add(rs.getString("nu_tel"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
	
	public CenterMemberSearchVO allnurseInfoSelect(String nuid) throws Exception {
		CenterMemberSearchVO vo = new CenterMemberSearchVO();
		String sql = "select nu_id, nu_picture, nu_name, nu_jumin, nu_sex, nu_country, nu_tel, nu_add, nu_crimal, sv_typename, nu_bank, nu_accno "
				+ "from NURSE n, SURVICE s " 
				+ "where n.sv_type=s.sv_type and nu_id='"
				+ nuid+"'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			vo.setNu_id(rs.getString("nu_id"));
			vo.setNu_picture(rs.getString("nu_picture"));
			vo.setNu_name(rs.getString("nu_name"));
			vo.setNu_jumin(rs.getString("nu_jumin"));
			vo.setNu_sex(rs.getString("nu_sex"));
			vo.setNu_country(rs.getString("nu_country"));
			vo.setNu_tel(rs.getString("nu_tel"));
			vo.setNu_add(rs.getString("nu_add"));
			vo.setNu_crimal(rs.getString("nu_crimal"));
			vo.setSv_typename(rs.getString("sv_typename"));
			vo.setNu_bank(rs.getString("nu_bank"));
			vo.setNu_accno(rs.getString("nu_accno"));
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

}
