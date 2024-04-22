package view.guardianuser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.guardianuserDAO.GuardianPaymentDAO;

public class GuradianPaymentView extends JPanel {
	public JTextField textField;

	int pcode, row;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable patienttable;
	Monthlytable monthlylist;
	Patienttable patientlist;
	String id;
	GuardianPaymentDAO dao;
	String patientcode;

	private JButton okbtn;
	private JTable monthlytable;

	/**
	 * Create the panel.
	 */

	public GuradianPaymentView(String mg_id) {
		setBackground(new Color(255, 255, 255));
		id = mg_id;
		initialize();
	}

	public void initialize() {

		try {
			dao = new GuardianPaymentDAO();
			System.out.println("DB���� ����");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB���� ����\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setLayout(null);
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(0, 0, 1200, 70);
		add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "\uD658\uC790 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(20, 100, 650, 300);
		add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 20, 620, 265);
		panel_4.add(scrollPane);
				
		patienttable = new JTable();
		patientlist = new Patienttable();
		patienttable.setModel(patientlist);
		scrollPane.setViewportView(patienttable);
		
		patienttable.setRowHeight(20);
		patienttable.setBackground(Color.WHITE);
		patienttable.setSelectionBackground(new Color(255, 228, 225));
		scrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patienttable.getColumnCount(); i++) {
			patienttable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uBA85\uC138\uC11C \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 420, 650, 300);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane MonthlyPane_1 = new JScrollPane();
		MonthlyPane_1.setBounds(15, 20, 620, 265);
		panel_1.add(MonthlyPane_1);

		monthlytable = new JTable();
		monthlylist = new Monthlytable();
		monthlytable.setModel(monthlylist);
		MonthlyPane_1.setViewportView(monthlytable);

		monthlytable.setRowHeight(20);
		monthlytable.setBackground(Color.WHITE);
		monthlytable.setSelectionBackground(new Color(255, 228, 225));
		MonthlyPane_1.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < monthlytable.getColumnCount(); i++) {
			monthlytable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(691, 100, 489, 620);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD658\uC790 \uBCF4\uD638\uBE44 \uBA85\uC138\uC11C");
		lblNewLabel.setBounds(157, 50, 175, 40);
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_11 = new JLabel("\uBA85\uC138\uC11C \uCF54\uB4DC");
		lblNewLabel_11.setBounds(79, 150, 150, 30);
		lblNewLabel_11.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_2 = new JLabel("\uD658\uC790 \uBC88\uD638");
		lblNewLabel_2.setBounds(79, 200, 150, 30);
		lblNewLabel_2.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uD574\uB2F9 \uB144\uC6D4");
		lblNewLabel_3.setBounds(79, 250, 150, 30);
		lblNewLabel_3.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lblNewLabel_4.setBounds(79, 300, 150, 30);
		lblNewLabel_4.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uC785\uAE08 \uAE30\uD55C");
		lblNewLabel_5.setBounds(79, 350, 150, 30);
		lblNewLabel_5.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\uC138\uAE08");
		lblNewLabel_6.setBounds(79, 400, 150, 30);
		lblNewLabel_6.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\uC740\uD589\uBA85");
		lblNewLabel_7.setBounds(79, 450, 150, 30);
		lblNewLabel_7.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\uAC00\uC0C1 \uACC4\uC88C");
		lblNewLabel_8.setBounds(79, 500, 150, 30);
		lblNewLabel_8.setFont(new Font("���� ���", Font.PLAIN, 17));
		panel.add(lblNewLabel_8);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_1.setBounds(229, 150, 180, 30);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_2.setBounds(229, 200, 180, 30);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_3.setEditable(false);
		textField_3.setBounds(229, 250, 180, 30);
		textField_3.setColumns(10);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_4.setEditable(false);
		textField_4.setBounds(229, 300, 140, 30);
		textField_4.setColumns(10);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_5.setEditable(false);
		textField_5.setBounds(229, 350, 180, 30);
		textField_5.setColumns(10);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_6.setEditable(false);
		textField_6.setBounds(229, 400, 140, 30);
		textField_6.setColumns(10);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_7.setBounds(229, 450, 180, 30);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		panel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 255, 255));
		textField_8.setFont(new Font("���� ���", Font.PLAIN, 15));
		textField_8.setBounds(229, 500, 180, 30);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		panel.add(textField_8);
		
		JLabel lblNewLabel_4_1 = new JLabel(" \uC6D0");
		lblNewLabel_4_1.setFont(new Font("���� ���", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(369, 300, 40, 30);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel(" \uC6D0");
		lblNewLabel_4_1_1.setFont(new Font("���� ���", Font.PLAIN, 17));
		lblNewLabel_4_1_1.setBounds(369, 400, 40, 30);
		panel.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_1 = new JLabel("    \uC6D4\uBCC4 \uBA85\uC138\uC11C \uC870\uD68C");
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 1200, 70);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		panel_3.setBounds(0, 780, 1200, 120);
		add(panel_3);
		panel_3.setLayout(null);

		okbtn = new JButton("\uB2EB\uAE30");
		okbtn.setBounds(520, 35, 160, 50);
		panel_3.add(okbtn);
		okbtn.setForeground(Color.WHITE);
		okbtn.setFont(new Font("���� ���", Font.BOLD, 20));
		okbtn.setBackground(Color.BLACK);
		okbtn.addActionListener(e -> {
			// ���⿡ Ȯ�� ��ư�� ������ �� ����Ǿ�� �� �ڵ� �߰�
			// ���� ���, â�� �ݴ� �ڵ带 �ۼ��� �� �ֽ��ϴ�.
			closeWindow();
		});

		selectpatientSearchTable();
		eventProc();
	}

	public void eventProc() {
		patienttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = patienttable.getSelectedRow();
				if (row >= 0) {
					Object patientCodeObj = patienttable.getValueAt(row, 0);
					patientcode = String.valueOf(patientCodeObj);
					selectmonthlySearchTable();
				}
			}
		});

		// monthlytable�� ���콺 Ŭ�� �̺�Ʈ �߰�
		monthlytable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = monthlytable.getSelectedRow();
				if (row >= 0) {
					// ������ ���� ������ ��������
					Object[] rowData = new Object[monthlylist.getColumnCount()];
					for (int col = 0; col < monthlylist.getColumnCount(); col++) {
						rowData[col] = monthlytable.getValueAt(row, col);
					}

					// �ؽ�Ʈ �ʵ忡 ������ ǥ��
					updateTextFields(rowData);
				}
			}
		});
	}

	public void closeWindow() {
		// ���� �г��� ���� ���� ������ �Ǵ� ���̾�α׸� �ݴ� �ڵ带 �ۼ��մϴ�.
		// ���� ���, ������ ���� �ۼ��� �� �ֽ��ϴ�.
		SwingUtilities.getWindowAncestor(this).dispose();
	}

	private void updateTextFields(Object[] rowData) {
		textField_1.setText(String.valueOf(rowData[0])); // ���� ��ȣ
		textField_2.setText(String.valueOf(rowData[1])); // ȯ�� ��ȣ
		textField_3.setText(String.valueOf(rowData[2]));
		textField_4.setText(formatNumber(Integer.parseInt(rowData[3]+""))); // ���� �ݾ�
		textField_5.setText(String.valueOf(rowData[4]));
		textField_6.setText(formatNumber(Integer.parseInt(rowData[5]+""))); // ����
		textField_7.setText(String.valueOf(rowData[6])); // �����
		textField_8.setText(String.valueOf(rowData[7])); // ���� ����
	}
	
    private String formatNumber(int number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return numberFormat.format(number);
    }

	void selectpatientSearchTable() {
		try {
			ArrayList<ArrayList> list = dao.patientSearch(id); // ���� ���� ȯ�� ������ �㵵�� ����
			patientlist.data = list;
			patienttable.setModel(patientlist);
			patientlist.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}

	void selectmonthlySearchTable() {
		try {
			ArrayList<ArrayList> list = dao.monthlySearch(patientcode); // ���� ���� ȯ�� ������ �㵵�� ����

			// ���� �����͸� ����� ���ο� �����͸� �߰��մϴ�.
			monthlylist.data.clear();
			monthlylist.data.addAll(list);
			monthlytable.setModel(monthlylist);
			monthlylist.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}

	class Patienttable extends AbstractTableModel {
		ArrayList<ArrayList> data; // ���� ���� ȯ�� ������ ���� �� �ֵ��� ����

		String[] columnNames = { "ȯ���ڵ�", "ȯ���̸�", "�ֹι�ȣ", "���ܸ�", "��ȭ��ȣ" };

		public Patienttable() {
			this.data = new ArrayList<>(); // ArrayList �ʱ�ȭ
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	class Monthlytable extends AbstractTableModel {
		ArrayList<ArrayList> data; // ���� ���� ȯ�� ������ ���� �� �ֵ��� ����

		String[] columnNames = { "���� �ڵ�", "ȯ�� �ڵ�", "�ش���", "�����ݾ�", "�Աݱ���", "����", "�����", "�������" };

		public Monthlytable() {
			this.data = new ArrayList<>(); // ArrayList �ʱ�ȭ
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
}
