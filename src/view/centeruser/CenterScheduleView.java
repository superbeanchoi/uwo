package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.centeruserDAO.CenterScheduleDAO;
import vo.centeruserVO.CenterScheduleVO;
import vo.guardianuserVO.GuardianScheduleVO;

public class CenterScheduleView extends JPanel implements ActionListener {
	String id, nuid, ptcode;
	int mg_no;
	CenterScheduleDAO dao;
	CenterScheduleVO vo;
	Matchingtable matchinglist;
	JPanel panel_1;
	private JTable matchingtable;
	private String selectedDate;
	private JTextField textField, textField_1, textField_2;
	private JButton btnNewButton;
	private JLabel dateLabel;
	JPanel calendarPanel;
	JLabel yearLabel, monthLabel;
	Nursetable nursetable;
	JTable nurselist;
	Patienttable patienttable;
	JTable patientlist;
	String matchingCode;
	private JPanel panel_3_2;
	private JScrollPane nurseScroll_1;
	private JComboBox searchComboBox;
	private JTextField searchText;

	/**
	 * Create the panel.
	 */

	public CenterScheduleView(String cnid) {
		this.id = cnid;
		initialize();

	}

	public void initialize() {
		// DB 연결
		try {
			dao = new CenterScheduleDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("    \uC2A4\uCF00\uC904 \uC815\uBCF4");
		lblNewLabel.setBounds(0, 0, 1200, 70);
		add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 228, 225));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 780, 1200, 120);
		add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setBounds(520, 35, 160, 50);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));

		panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(610, 90, 570, 650);
		add(panel_1);

		calendarPanel = new JPanel(new GridLayout(0, 7));
		calendarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendarPanel.setBackground(new Color(255, 255, 255));
		calendarPanel.setBounds(0, 50, 570, 600);
		panel_1.setLayout(null);

		yearLabel = new JLabel("", JLabel.CENTER);
		yearLabel.setForeground(new Color(255, 255, 255));
		yearLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		yearLabel.setBackground(new Color(255, 228, 225));
		yearLabel.setBounds(0, 0, 285, 50);

		monthLabel = new JLabel("", JLabel.CENTER);
		monthLabel.setForeground(new Color(255, 255, 255));
		monthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		monthLabel.setBackground(new Color(255, 228, 225));
		monthLabel.setBounds(285, 0, 285, 50);
		panel_1.add(monthLabel);

		// 요일 표시
		String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
		for (String day : dayOfWeek) {
			JLabel dayLabel = new JLabel(day, JLabel.CENTER);
			dayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			dayLabel.setForeground(Color.BLUE);
			if (day.equals("월") || day.equals("화") || day.equals("수") || day.equals("목") || day.equals("금")) {
				dayLabel.setForeground(Color.BLACK); // 월~금은 검정색
			} else if (day.equals("일")) {
				dayLabel.setForeground(Color.RED); // 일요일은 빨간색
			} else if (day.equals("토")) {
				dayLabel.setForeground(Color.BLUE); // 토요일은 파란색
			}

			calendarPanel.add(dayLabel);
		}

		updateCalendar(yearLabel, monthLabel, calendarPanel);
		panel_1.add(yearLabel);
		panel_1.add(calendarPanel);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uB9E4\uCE6D \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 200, 570, 300);
		add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 20, 540, 260);
		panel_3.add(scrollPane);
		scrollPane.setBackground(new Color(255, 228, 225));

		matchinglist = new Matchingtable();
		matchingtable = new JTable();
		matchingtable.setModel(matchinglist);
		matchingtable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(matchingtable);

		matchingtable.setRowHeight(20);
		matchingtable.setBackground(Color.WHITE);
		matchingtable.setSelectionBackground(new Color(255, 228, 225));
		scrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < matchingtable.getColumnCount(); i++) {
			matchingtable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uD658\uC790 \uBC0F \uC8FC\uBCF4\uD638\uC790 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(10, 520, 570, 100);
		add(panel_3_1);

		JScrollPane patientScroll = new JScrollPane();
		patientScroll.setBackground(new Color(255, 228, 225));
		patientScroll.setBounds(15, 20, 540, 65);
		panel_3_1.add(patientScroll);

		patienttable = new Patienttable();
		patientlist = new JTable(patienttable);
		patientlist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		patientScroll.setViewportView(patientlist);

		patientlist.setRowHeight(20);
		patientlist.setBackground(Color.WHITE);
		patientlist.setSelectionBackground(new Color(255, 228, 225));
		patientScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patientlist.getColumnCount(); i++) {
			patientlist.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC694\uC591\uBCF4\uD638\uC0AC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(10, 640, 570, 100);
		add(panel_3_2);

		nurseScroll_1 = new JScrollPane();
		nurseScroll_1.setBackground(new Color(255, 228, 225));
		nurseScroll_1.setBounds(15, 20, 540, 65);
		panel_3_2.add(nurseScroll_1);
		
		nursetable = new Nursetable();
		nurselist = new JTable(nursetable);
		nurselist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		nurseScroll_1.setViewportView(nurselist);

		nurselist.setRowHeight(20);
		nurselist.setBackground(Color.WHITE);
		nurselist.setSelectionBackground(new Color(255, 228, 225));
		nurseScroll_1.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < nurselist.getColumnCount(); i++) {
			nurselist.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"\uB9E4\uCE6D \uCF54\uB4DC", "\uD658\uC790 \uCF54\uB4DC", "\uD658\uC790 \uC774\uB984", "\uC8FC\uBCF4\uD638\uC790 \uC774\uB984", "\uC694\uC591\uBCF4\uD638\uC0AC \uC774\uB984"}));
		searchComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchComboBox.setBackground(Color.WHITE);
		searchComboBox.setBounds(140, 130, 150, 30);
		add(searchComboBox);

		searchText = new JTextField();
		searchText.setToolTipText("");
		searchText.setText((String) null);
		searchText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		searchText.setColumns(10);
		searchText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchText.setBackground(Color.WHITE);
		searchText.setBounds(300, 130, 150, 30);
		add(searchText);

		eventProc();
		selectMatchingTable();
	}

	public void eventProc() {
		btnNewButton.addActionListener(this);
		matchingtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = matchingtable.getSelectedRow();
				matchingCode = (String) matchingtable.getValueAt(row, 0);
				selectNursetable();
				selectPatienttable();
			}

		});
		nurselist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = nurselist.getSelectedRow();
				nuid = (String) nurselist.getValueAt(row, 0);
				MatchingNurseInfoView mni = new MatchingNurseInfoView(nuid);
				mni.setVisible(true);
			}

		});
		patientlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = patientlist.getSelectedRow();
				ptcode = (String) patientlist.getValueAt(row, 0);
				MatchingPatientInfoView mpi = new MatchingPatientInfoView(ptcode);
				mpi.setVisible(true);
			}

		});
		searchText.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		int code;
		String sc_date;
		String sc_starttime;
		if (o == btnNewButton) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CenterScheduleView.this);
			frame.dispose();
		} else if (o==searchText) {
			matchingSearch();
		}
	}

	private void updateCalendar(JLabel yearLabel, JLabel monthLabel, JPanel calendarPanel) {
		// 현재 날짜를 가져옵니다.
		Calendar calendar = Calendar.getInstance();

		// 연도, 월, 날짜 설정
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

		// 달력의 텍스트를 설정
		yearLabel.setText(year + "년");
		monthLabel.setText((month + 1) + "월");

		// 현재 월의 첫째 날로 설정
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		// 해당 월의 마지막 날짜 구하기
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		// 비어있는 날짜를 현재 월의 1일 앞까지 채우기
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
			calendarPanel.add(new JLabel(""));
		}

		// 날짜를 그리드에 추가
		for (int i = 1; i <= lastDay; i++) {
			final int dayOfMonthClicked = i; // 변수를 final로 선언

			JLabel dayLabel = new JLabel(String.valueOf(i), JLabel.CENTER);
			dayLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			dayLabel.setBorder(null);

			// 해당 날짜에 등록된 일정이 있으면 배경색 변경
			try {
				int year1 = calendar.get(Calendar.YEAR);
				int month1 = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH는 0부터 시작하므로 +1
				List<GuardianScheduleVO> scheduleList = dao.getScheduleForDate(year1, month1, dayOfMonthClicked, id);
				dayLabel.setToolTipText(null);

				Set<Integer> uniqueMgNos = new HashSet<>(); // 매칭 번호를 저장할 Set
				if (!scheduleList.isEmpty()) {
					dayLabel.setOpaque(true);
					dayLabel.setBackground(new Color(255, 228, 225)); // 배경색 설정

					// 해당 날짜에 대한 일정 내용을 가져와서 dayLabel에 추가합니다.
					StringBuilder tooltipText = new StringBuilder("<html><b>[ 일정 목록 ]</b><br>");
					for (GuardianScheduleVO schedule : scheduleList) {
						if (uniqueMgNos.add(schedule.getMg_no())) { // Set에 매칭 번호를 추가하고, 중복된 값이면 false 반환
							tooltipText.append("매칭 코드: ").append(schedule.getMg_no()).append("<br>");
							tooltipText.append("요양 시간: ").append(schedule.getSc_starttime()).append("<br>");
						}
					}
					tooltipText.append("</html>");
					dayLabel.setToolTipText(tooltipText.toString());

				} else {
					// Set이 비어있지 않으면 배경색을 흰색으로 설정
					dayLabel.setOpaque(true);
					dayLabel.setBackground(Color.WHITE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// 예외 처리
			}

			// 현재 날짜라면 스타일 변경
			if (i == dayOfMonth) {
				dayLabel.setBackground(Color.WHITE);
				dayLabel.setForeground(new Color(0, 120, 215));
				dayLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215)));
				dayLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			}

			// 날짜 라벨에 마우스 클릭 이벤트 추가
//			dayLabel.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					// 클릭한 날짜의 연월일을 textField_1에 설정
//					Calendar clickedDate = Calendar.getInstance();
//					clickedDate.set(Calendar.YEAR, year);
//					clickedDate.set(Calendar.MONTH, month);
//					clickedDate.set(Calendar.DAY_OF_MONTH, dayOfMonthClicked);
//
//					int clickedYear = clickedDate.get(Calendar.YEAR);
//					int clickedMonth = clickedDate.get(Calendar.MONTH) + 1; // Calendar.MONTH는 0부터 시작하므로 +1
//					int clickedDay = clickedDate.get(Calendar.DAY_OF_MONTH);
//
//					textField_1.setText(clickedYear + "-" + String.format("%02d", clickedMonth) + "-"
//							+ String.format("%02d", clickedDay));
//
//				}
//			});

			calendarPanel.add(dayLabel);
		}
	}

	private void showSchedulePopup(int year, int month, int dayOfMonth, JLabel dayLabel) {
		try {
			List<GuardianScheduleVO> scheduleList = dao.getScheduleForDate(year, month, dayOfMonth, id);
			if (!scheduleList.isEmpty()) {
				// 해당 날짜에 대한 일정 내용을 가져와서 툴팁으로 표시
				StringBuilder tooltipText = new StringBuilder("<html><b>[ 일정 목록 ]</b><br>");
				for (GuardianScheduleVO schedule : scheduleList) {
					tooltipText.append(schedule.getSc_starttime()).append("<br>");
				}
				tooltipText.append("</html>");
				dayLabel.setToolTipText(tooltipText.toString());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// 예외 처리
		}
	}

	void selectMatchingTable() {
		try {
			ArrayList list = dao.MatchingInfoSelect(id);
			matchinglist.data = list;
			matchingtable.setModel(matchinglist);
			matchinglist.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void selectPatienttable() {
		try {
			ArrayList list = dao.MatchingPatientInfoSelect(matchingCode);
			patienttable.data = list;
			patientlist.setModel(patienttable);
			patienttable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void selectNursetable() {
		try {
			ArrayList list = dao.MatchingNurseInfoSelect(matchingCode);
			nursetable.data = list;
			nurselist.setModel(nursetable);
			nursetable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void matchingSearch() {
		int colindex = searchComboBox.getSelectedIndex();
		String text = searchText.getText();
		try {
			ArrayList list = dao.matchingSearch(id, colindex, text);
			matchinglist.data = list;
			matchingtable.setModel(matchinglist);
			matchinglist.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	class Matchingtable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "매칭 코드", "환자 코드", "환자 이름", "서비스 유형", "월이용횟수", "시작 일자" };

		public Matchingtable() {
			this.data = new ArrayList(); // 이 부분을 추가하여 ArrayList 초기화
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	
	class Patienttable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "환자 코드", "환자 이름", "주보호자 아이디", "주보호자 이름", "주보호자 전화번호", "주보호자 주소" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	class Nursetable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "요양보호사 아이디", "요양보호사 이름", "요양보호사 전화번호", "요양보호사 주소" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
