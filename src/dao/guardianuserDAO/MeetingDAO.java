package dao.guardianuserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vo.guardianuserVO.MeetingVO;

public class MeetingDAO {
	private String url = "jdbc:oracle:thin:@192.168.0.93:1521:campdb";
	private String user = "nurse";
	private String pw = "pass";
	PreparedStatement ps = null;
	Statement stmt = null;

	// constructor
	public MeetingDAO() throws Exception {
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
	public ArrayList patientInfoSelect(String id) throws Exception {
		String sql = "select p.PT_NO, p.PT_NAME, p.PT_JUMIN, p.MG_RELATION, c.CN_NAME "
				+ "from PATIENT p, CENTER c "
				+ "where p.CN_ID=c.CN_ID and p.MG_ID='"+id+"' order by 1";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList list = new ArrayList();
		while(rs.next()) {
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
	
	public void meetinginsert(MeetingVO vo) throws Exception {
		String sql = "insert into meeting (mt_NO, pt_no, nu_id, mt_reqdate, mt_CONTENT) "
				+ " values( sq_meeting.nextval, ?, ?, sysdate ,?)";
		ps = conn.prepareStatement(sql);         
		ps.setInt(1, vo.getPt_no());
		ps.setString(2, vo.getNu_id());
		ps.setString(3, vo.getMt_content());
		ps.executeUpdate();
		ps.close();
	}
}