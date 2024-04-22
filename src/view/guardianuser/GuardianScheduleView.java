package view.guardianuser;

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
import javax.swing.JButton;
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

import dao.guardianuserDAO.GuardianScheduleDAO;
import view.centeruser.MatchingNurseInfoView;
import vo.guardianuserVO.GuardianScheduleVO;

public class GuardianScheduleView extends JPanel implements ActionListener {
	String id, nuid;
	int mg_no;
	GuardianScheduleDAO dao;
	GuardianScheduleVO vo;
	Matchingtable matchinglist;
	JPanel panel_1;
	private JTable matchingtable;
	private String selectedDate;
	private JTextField textField, textField_1, textField_2;
	private JButton btnNewButton, btnRegisterSchedule_1;
	private JLabel dateLabel;
	JPanel calendarPanel;
	JLabel yearLabel, monthLabel;
	Nursetable nursetable;
	JTable nurselist;
	String matchingCode;

	/**
	 * Create the panel.
	 */

	public GuardianScheduleView(String mg_id) {
		id = mg_id;
		initialize();

	}

	public void initialize() {
		// DB 연결
		try {
			dao = new GuardianScheduleDAO();
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

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC2A4\uCF00\uC904 \uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(10, 560, 570, 180);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uCE6D \uCF54\uB4DC");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 30, 120, 30);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC694\uC591 \uC77C\uC790");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 80, 120, 30);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC694\uC591 \uC2DC\uAC04");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(20, 130, 120, 30);
		panel_2.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField.setBounds(140, 30, 120, 30);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_1.setBounds(140, 80, 120, 30);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_2.setBounds(140, 130, 120, 30);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		btnRegisterSchedule_1 = new JButton("\uC77C\uC815 \uB4F1\uB85D");
		btnRegisterSchedule_1.setBounds(370, 68, 160, 50);
		panel_2.add(btnRegisterSchedule_1);
		btnRegisterSchedule_1.setForeground(Color.WHITE);
		btnRegisterSchedule_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnRegisterSchedule_1.setBackground(Color.BLACK);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB9E4\uCE6D \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 90, 570, 300);
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
				"\uC694\uC591\uBCF4\uD638\uC0AC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(10, 410, 570, 130);
		add(panel_3_1);

		JScrollPane nurseScroll = new JScrollPane();
		nurseScroll.setBackground(new Color(255, 228, 225));
		nurseScroll.setBounds(15, 20, 540, 95);
		panel_3_1.add(nurseScroll);
		
		nursetable = new Nursetable();
		nurselist = new JTable(nursetable);
		nurselist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		nurseScroll.setViewportView(nurselist);

		nurselist.setRowHeight(20);
		nurselist.setBackground(Color.WHITE);
		nurselist.setSelectionBackground(new Color(255, 228, 225));
		nurseScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < nurselist.getColumnCount(); i++) {
			nurselist.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		eventProc();
		selectMatchingTable();
	}

	public void eventProc() {
		btnRegisterSchedule_1.addActionListener(this);
		btnNewButton.addActionListener(this);
		matchingtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = matchingtable.getSelectedRow();
				matchingCode = (String) matchingtable.getValueAt(row, 0);
				textField.setText(matchingCode);
				selectNursetable();
			}

		});
		nurselist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = nurselist.getSelectedRow();
				nuid = (String) nurselist.getValueAt(row, 0);
//				textField.setText(matchingCode);
				MatchingNurseInfoView mni = new MatchingNurseInfoView(nuid);
				mni.setVisible(true);
			}

		});
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		int code;
		String sc_date;
		String sc_starttime;
		if (o == btnRegisterSchedule_1) {
			code = Integer.parseInt(textField.getText());
			sc_date = textField_1.getText();
			sc_starttime = textField_2.getText();
			GuardianScheduleVO vo = new GuardianScheduleVO(code, sc_date, sc_starttime);
			try {
				dao.insertSchedule(vo);
				JOptionPane.showMessageDialog(null, "일정이 등록 되었습니다.");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "일정 등록을 실패하였습니다.");
				e2.printStackTrace();
			}
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GuardianScheduleView.this);
			frame.dispose();
		} else if (o == btnNewButton) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GuardianScheduleView.this);
			frame.dispose();
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
			dayLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 클릭한 날짜의 연월일을 textField_1에 설정
					Calendar clickedDate = Calendar.getInstance();
					clickedDate.set(Calendar.YEAR, year);
					clickedDate.set(Calendar.MONTH, month);
					clickedDate.set(Calendar.DAY_OF_MONTH, dayOfMonthClicked);

					int clickedYear = clickedDate.get(Calendar.YEAR);
					int clickedMonth = clickedDate.get(Calendar.MONTH) + 1; // Calendar.MONTH는 0부터 시작하므로 +1
					int clickedDay = clickedDate.get(Calendar.DAY_OF_MONTH);

					textField_1.setText(clickedYear + "-" + String.format("%02d", clickedMonth) + "-"
							+ String.format("%02d", clickedDay));
					
				}
			});

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
