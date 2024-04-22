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
		// DB ����
		try {
			dao = new CenterScheduleDAO();
			System.out.println("DB���� ����");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB���� ����\n"+e.getMessage());
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
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 228, 225));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 780, 1200, 120);
		add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setBounds(520, 35, 160, 50);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 20));
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
		yearLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		yearLabel.setBackground(new Color(255, 228, 225));
		yearLabel.setBounds(0, 0, 285, 50);

		monthLabel = new JLabel("", JLabel.CENTER);
		monthLabel.setForeground(new Color(255, 255, 255));
		monthLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		monthLabel.setBackground(new Color(255, 228, 225));
		monthLabel.setBounds(285, 0, 285, 50);
		panel_1.add(monthLabel);

		// ���� ǥ��
		String[] dayOfWeek = { "��", "��", "ȭ", "��", "��", "��", "��" };
		for (String day : dayOfWeek) {
			JLabel dayLabel = new JLabel(day, JLabel.CENTER);
			dayLabel.setFont(new Font("���� ���", Font.BOLD, 15));
			dayLabel.setForeground(Color.BLUE);
			if (day.equals("��") || day.equals("ȭ") || day.equals("��") || day.equals("��") || day.equals("��")) {
				dayLabel.setForeground(Color.BLACK); // ��~���� ������
			} else if (day.equals("��")) {
				dayLabel.setForeground(Color.RED); // �Ͽ����� ������
			} else if (day.equals("��")) {
				dayLabel.setForeground(Color.BLUE); // ������� �Ķ���
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
		matchingtable.setFont(new Font("���� ���", Font.PLAIN, 12));
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
		patientlist.setFont(new Font("���� ���", Font.PLAIN, 12));
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
		nurselist.setFont(new Font("���� ���", Font.PLAIN, 12));
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
		searchComboBox.setFont(new Font("���� ���", Font.PLAIN, 15));
		searchComboBox.setBackground(Color.WHITE);
		searchComboBox.setBounds(140, 130, 150, 30);
		add(searchComboBox);

		searchText = new JTextField();
		searchText.setToolTipText("");
		searchText.setText((String) null);
		searchText.setFont(new Font("���� ���", Font.PLAIN, 15));
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
		// ���� ��¥�� �����ɴϴ�.
		Calendar calendar = Calendar.getInstance();

		// ����, ��, ��¥ ����
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

		// �޷��� �ؽ�Ʈ�� ����
		yearLabel.setText(year + "��");
		monthLabel.setText((month + 1) + "��");

		// ���� ���� ù° ���� ����
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		// �ش� ���� ������ ��¥ ���ϱ�
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		// ����ִ� ��¥�� ���� ���� 1�� �ձ��� ä���
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
			calendarPanel.add(new JLabel(""));
		}

		// ��¥�� �׸��忡 �߰�
		for (int i = 1; i <= lastDay; i++) {
			final int dayOfMonthClicked = i; // ������ final�� ����

			JLabel dayLabel = new JLabel(String.valueOf(i), JLabel.CENTER);
			dayLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
			dayLabel.setBorder(null);

			// �ش� ��¥�� ��ϵ� ������ ������ ���� ����
			try {
				int year1 = calendar.get(Calendar.YEAR);
				int month1 = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH�� 0���� �����ϹǷ� +1
				List<GuardianScheduleVO> scheduleList = dao.getScheduleForDate(year1, month1, dayOfMonthClicked, id);
				dayLabel.setToolTipText(null);

				Set<Integer> uniqueMgNos = new HashSet<>(); // ��Ī ��ȣ�� ������ Set
				if (!scheduleList.isEmpty()) {
					dayLabel.setOpaque(true);
					dayLabel.setBackground(new Color(255, 228, 225)); // ���� ����

					// �ش� ��¥�� ���� ���� ������ �����ͼ� dayLabel�� �߰��մϴ�.
					StringBuilder tooltipText = new StringBuilder("<html><b>[ ���� ��� ]</b><br>");
					for (GuardianScheduleVO schedule : scheduleList) {
						if (uniqueMgNos.add(schedule.getMg_no())) { // Set�� ��Ī ��ȣ�� �߰��ϰ�, �ߺ��� ���̸� false ��ȯ
							tooltipText.append("��Ī �ڵ�: ").append(schedule.getMg_no()).append("<br>");
							tooltipText.append("��� �ð�: ").append(schedule.getSc_starttime()).append("<br>");
						}
					}
					tooltipText.append("</html>");
					dayLabel.setToolTipText(tooltipText.toString());

				} else {
					// Set�� ������� ������ ������ ������� ����
					dayLabel.setOpaque(true);
					dayLabel.setBackground(Color.WHITE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// ���� ó��
			}

			// ���� ��¥��� ��Ÿ�� ����
			if (i == dayOfMonth) {
				dayLabel.setBackground(Color.WHITE);
				dayLabel.setForeground(new Color(0, 120, 215));
				dayLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 215)));
				dayLabel.setFont(new Font("���� ���", Font.PLAIN, 20));
			}

			// ��¥ �󺧿� ���콺 Ŭ�� �̺�Ʈ �߰�
//			dayLabel.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					// Ŭ���� ��¥�� �������� textField_1�� ����
//					Calendar clickedDate = Calendar.getInstance();
//					clickedDate.set(Calendar.YEAR, year);
//					clickedDate.set(Calendar.MONTH, month);
//					clickedDate.set(Calendar.DAY_OF_MONTH, dayOfMonthClicked);
//
//					int clickedYear = clickedDate.get(Calendar.YEAR);
//					int clickedMonth = clickedDate.get(Calendar.MONTH) + 1; // Calendar.MONTH�� 0���� �����ϹǷ� +1
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
				// �ش� ��¥�� ���� ���� ������ �����ͼ� �������� ǥ��
				StringBuilder tooltipText = new StringBuilder("<html><b>[ ���� ��� ]</b><br>");
				for (GuardianScheduleVO schedule : scheduleList) {
					tooltipText.append(schedule.getSc_starttime()).append("<br>");
				}
				tooltipText.append("</html>");
				dayLabel.setToolTipText(tooltipText.toString());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			// ���� ó��
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
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
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
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
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
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
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
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}

	class Matchingtable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "��Ī �ڵ�", "ȯ�� �ڵ�", "ȯ�� �̸�", "���� ����", "���̿�Ƚ��", "���� ����" };

		public Matchingtable() {
			this.data = new ArrayList(); // �� �κ��� �߰��Ͽ� ArrayList �ʱ�ȭ
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
		String[] columnNames = { "ȯ�� �ڵ�", "ȯ�� �̸�", "�ֺ�ȣ�� ���̵�", "�ֺ�ȣ�� �̸�", "�ֺ�ȣ�� ��ȭ��ȣ", "�ֺ�ȣ�� �ּ�" };

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
		String[] columnNames = { "��纸ȣ�� ���̵�", "��纸ȣ�� �̸�", "��纸ȣ�� ��ȭ��ȣ", "��纸ȣ�� �ּ�" };

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
