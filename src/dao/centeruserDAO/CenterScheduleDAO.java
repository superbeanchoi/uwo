package dao.centeruserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.guardianuserVO.GuardianScheduleVO;

public class CenterScheduleDAO {

	public CenterScheduleDAO() throws Exception {
		connectDB();
	}

	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;

	private Connection conn = null;
	// ###########################################################
	// DB control method

	void connectDB() throws Exception {
//		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
//			System.out.println("성공적으로 DB연결 및 로딩됨");
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
//			System.out.println("드라이버를 찾을 수 없습니다");
//		} catch (SQLException e) {
//			System.out.println("DB 명령이 잘못되었습니다");
//		}
	}

	public void insertSchedule(GuardianScheduleVO vo) throws SQLException {
		String sql = "INSERT INTO SCHEDULE (sc_no, mg_no ,sc_date, sc_starttime) VALUES ( sq_schedule.nextval,?,?,?)";

		ps = conn.prepareStatement(sql);
		try {
			ps.setInt(1, vo.getMg_no());
			ps.setString(2, vo.getSc_date());
			ps.setString(3, vo.getSc_starttime());
			ps.executeUpdate();
			System.out.println("일정 등록 성공!");
		} catch (SQLException e) {
			System.out.println("일정 등록 중 오류 발생: " + e.getMessage());
			throw e; // 예외를 다시 던져서 상위 호출자에게 전달
		} finally {
			// 자원 해제 코드
			if (ps != null) {
				ps.close();
			}
		}
	}

	public List<GuardianScheduleVO> getScheduleForDate(int year, int month, int dayOfMonth, String cn_id)
			throws SQLException {
		List<GuardianScheduleVO> scheduleList = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM SCHEDULE s, matching mg, meeting mt, patient p, main_guardian m "
				+ "WHERE s.mg_no = mg.mg_no AND mg.mt_no = mt.mt_no AND mt.pt_no = p.pt_no "
				+ "AND p.cn_id = ? AND SC_DATE = TO_DATE(?, 'YYYY-MM-DD')";
		try {
			ps = conn.prepareStatement(sql);

			// 날짜 문자열을 'yyyy-mm-dd' 형식으로 구성합니다.
			String dateString = String.format("%04d-%02d-%02d", year, month, dayOfMonth);

			// 쿼리에서 mg_no와 SC_DATE 매개변수를 설정합니다.
			ps.setString(1, cn_id);
			ps.setString(2, dateString);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					// SchduleVO가 적절한 생성자와 setter를 가졌다고 가정합니다.
					GuardianScheduleVO schedule = new GuardianScheduleVO(rs.getInt("MG_NO"), rs.getString("SC_DATE"),
							rs.getString("SC_STARTTIME")
					// 필요한 경우 다른 필드를 추가합니다.
					);

					scheduleList.add(schedule);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 처리
			throw e;
		}
		return scheduleList;
	}

	public ArrayList MatchingInfoSelect(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select mg.mg_no, p.pt_no, mg.mt_no, s.sv_typename, mg.mt_number_of_times, mg.mt_sv_startdate, n.nu_name, n.nu_tel, p.pt_name "
				+ "from matching mg, patient p, nurse n, meeting m, survice s "
				+ "where p.pt_no=m.pt_no and mg.sv_type = s.sv_type and n.nu_id= m.nu_id and m.mt_no = mg.mt_no and p.cn_id ='"
				+ id + "' order by 1";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("mg_no"));
			temp.add(rs.getString("pt_no"));
			temp.add(rs.getString("pt_name"));
			temp.add(rs.getString("sv_typename"));
			temp.add(rs.getString("mt_number_of_times"));
			temp.add(rs.getString("mt_sv_startdate").substring(0, 10));

			list.add(temp);
		}
		return list;
	}
	
	public ArrayList MatchingNurseInfoSelect(String matchingCode) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select n.NU_ID, n.NU_NAME, n.NU_TEL, n.NU_ADD "
				+ "from MATCHING mg, MEETING mt, NURSE n "
				+ "where mg.MT_NO=mt.MT_NO and mt.NU_ID=n.NU_ID and mg.MG_NO="+matchingCode;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("NU_ID"));
			temp.add(rs.getString("NU_NAME"));
			temp.add(rs.getString("NU_TEL"));
			temp.add(rs.getString("NU_ADD"));

			list.add(temp);
		}
		return list;
	}
	
	public ArrayList MatchingPatientInfoSelect(String matchingCode) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select p.PT_NO, p.PT_NAME, mgd.MG_ID, mgd.MG_NAME, mgd.MG_TEL, mgd.MG_ADD "
				+ "from MATCHING mg, MEETING mt, PATIENT p, MAIN_GUARDIAN mgd "
				+ "where mg.MT_NO=mt.MT_NO and mt.PT_NO=p.PT_NO and p.MG_ID=mgd.MG_ID "
				+ "and mg.MG_NO="+matchingCode;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("PT_NO"));
			temp.add(rs.getString("PT_NAME"));
			temp.add(rs.getString("MG_ID"));
			temp.add(rs.getString("MG_NAME"));
			temp.add(rs.getString("MG_TEL"));
			temp.add(rs.getString("MG_ADD"));

			list.add(temp);
		}
		return list;
	}
	
	public ArrayList matchingSearch(String cnid, int colindex, String text) throws Exception {
		String colName="";
		if(colindex==0) {
			colName = "mc.MG_NO";
		} else if(colindex==1) {
			colName = "p.PT_NO";
		} else if(colindex==2) {
			colName = "p.PT_NAME";
		} else if(colindex==3) {
			colName = "mg.MG_NAME";
		} else if(colindex==4) {
			colName = "n.NU_NAME";
		}
		
		String sql = "select mc.mg_no, p.pt_no, p.pt_name, s.sv_typename, mc.mt_number_of_times, mc.mt_sv_startdate "
				+ "from MATCHING mc, MEETING mt, NURSE n, PATIENT p, MAIN_GUARDIAN mg, SURVICE s "
				+ "where mc.MT_NO=mt.MT_NO and mt.NU_ID=n.NU_ID and mt.PT_NO=p.PT_NO and p.MG_ID=mg.MG_ID and mc.SV_TYPE=s.SV_TYPE "
				+ "and p.CN_ID='"+cnid+"' and "+colName+" like '%"+text+"%'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("mg_no"));
			temp.add(rs.getString("pt_no"));
			temp.add(rs.getString("pt_name"));
			temp.add(rs.getString("sv_typename"));
			temp.add(rs.getString("mt_number_of_times"));
			temp.add(rs.getString("mt_sv_startdate").substring(0, 10));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}
}