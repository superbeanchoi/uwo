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
		// DB ����
		try {
			dao = new GuardianScheduleDAO();
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

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC2A4\uCF00\uC904 \uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(10, 560, 570, 180);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uCE6D \uCF54\uB4DC");
		lblNewLabel_1.setFont(new Font("���� ���", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(20, 30, 120, 30);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC694\uC591 \uC77C\uC790");
		lblNewLabel_2.setFont(new Font("���� ���", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(20, 80, 120, 30);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uC694\uC591 \uC2DC\uAC04");
		lblNewLabel_3.setFont(new Font("���� ���", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(20, 130, 120, 30);
		panel_2.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField.setBounds(140, 30, 120, 30);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_1.setBounds(140, 80, 120, 30);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_2.setBounds(140, 130, 120, 30);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		btnRegisterSchedule_1 = new JButton("\uC77C\uC815 \uB4F1\uB85D");
		btnRegisterSchedule_1.setBounds(370, 68, 160, 50);
		panel_2.add(btnRegisterSchedule_1);
		btnRegisterSchedule_1.setForeground(Color.WHITE);
		btnRegisterSchedule_1.setFont(new Font("���� ���", Font.BOLD, 20));
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
		nurselist.setFont(new Font("���� ���", Font.PLAIN, 12));
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
				JOptionPane.showMessageDialog(null, "������ ��� �Ǿ����ϴ�.");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "���� ����� �����Ͽ����ϴ�.");
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
			dayLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// Ŭ���� ��¥�� �������� textField_1�� ����
					Calendar clickedDate = Calendar.getInstance();
					clickedDate.set(Calendar.YEAR, year);
					clickedDate.set(Calendar.MONTH, month);
					clickedDate.set(Calendar.DAY_OF_MONTH, dayOfMonthClicked);

					int clickedYear = clickedDate.get(Calendar.YEAR);
					int clickedMonth = clickedDate.get(Calendar.MONTH) + 1; // Calendar.MONTH�� 0���� �����ϹǷ� +1
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
