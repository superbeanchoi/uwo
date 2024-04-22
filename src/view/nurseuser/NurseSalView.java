package view.nurseuser;

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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.nurseuserDAO.NurseSalDAO;
import javax.swing.border.TitledBorder;

public class NurseSalView extends JPanel {
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
	private JTable nursesaltable;
	Nursesaltable nusallist;
	String id;
	NurseSalDAO dao;

	private JButton okbtn;

	/**
	 * Create the panel.
	 */

	public NurseSalView(String nu_id) {
		id = nu_id;
		initialize();
	}

	public void initialize() {

		try {
			dao = new NurseSalDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		setLayout(null);
		setBackground(new Color(255, 255, 255));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(691, 100, 489, 620);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uAE09\uC5EC \uBA85\uC138\uC11C");
		lblNewLabel.setBounds(189, 50, 110, 40);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_11 = new JLabel("\uBA85\uC138\uC11C \uCF54\uB4DC");
		lblNewLabel_11.setBounds(79, 150, 150, 30);
		lblNewLabel_11.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_2 = new JLabel("\uD574\uB2F9 \uB144\uC6D4");
		lblNewLabel_2.setBounds(79, 200, 150, 30);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uCD1D \uAE09\uC5EC");
		lblNewLabel_3.setBounds(79, 250, 150, 30);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uC138\uAE08");
		lblNewLabel_4.setBounds(79, 300, 150, 30);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\uC911\uAC1C \uC218\uC218\uB8CC");
		lblNewLabel_5.setBounds(79, 350, 150, 30);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\uC2E4\uC218\uB839\uC561");
		lblNewLabel_6.setBounds(79, 400, 150, 30);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\uC9C0\uAE09 \uC77C\uC790");
		lblNewLabel_7.setBounds(79, 450, 150, 30);
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\uC9C0\uAE09 \uC5EC\uBD80");
		lblNewLabel_8.setBounds(79, 500, 150, 30);
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_8);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_1.setBounds(229, 150, 180, 30);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_2.setBounds(229, 200, 180, 30);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_3.setEditable(false);
		textField_3.setBounds(229, 250, 140, 30);
		textField_3.setColumns(10);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_4.setEditable(false);
		textField_4.setBounds(229, 300, 140, 30);
		textField_4.setColumns(10);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_5.setEditable(false);
		textField_5.setBounds(229, 350, 140, 30);
		textField_5.setColumns(10);
		panel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_6.setEditable(false);
		textField_6.setBounds(229, 400, 140, 30);
		textField_6.setColumns(10);
		panel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_7.setBounds(229, 450, 180, 30);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		panel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 255, 255));
		textField_8.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_8.setBounds(229, 500, 180, 30);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		panel.add(textField_8);
		
		JLabel lblNewLabel_3_1 = new JLabel(" \uC6D0");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(369, 250, 40, 30);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel(" \uC6D0");
		lblNewLabel_3_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(369, 300, 40, 30);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel(" \uC6D0");
		lblNewLabel_3_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1.setBounds(369, 350, 40, 30);
		panel.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel(" \uC6D0");
		lblNewLabel_3_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3_1_1_1_1.setBounds(369, 400, 40, 30);
		panel.add(lblNewLabel_3_1_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\uBA85\uC138\uC11C \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 100, 650, 620);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 20, 620, 580);
		panel_1.add(scrollPane);

		nursesaltable = new JTable();
		nusallist = new Nursesaltable();
		nursesaltable.setModel(nusallist);
		scrollPane.setViewportView(nursesaltable);

		nursesaltable.setRowHeight(20);
		nursesaltable.setBackground(Color.WHITE);
		nursesaltable.setSelectionBackground(new Color(255, 228, 225));
		scrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < nursesaltable.getColumnCount(); i++) {
			nursesaltable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(0, 0, 1200, 70);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("    \uAE09\uC5EC \uC870\uD68C");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 1200, 70);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		panel_3.setBounds(0, 780, 1200, 120);
		add(panel_3);
		panel_3.setLayout(null);
		
		okbtn = new JButton("\uD655\uC778");
		okbtn.setBounds(520, 35, 160, 50);
		panel_3.add(okbtn);
		okbtn.setForeground(Color.WHITE);
		okbtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		okbtn.setBackground(Color.BLACK);
		okbtn.addActionListener(e -> {
			// 여기에 확인 버튼을 눌렀을 때 수행되어야 할 코드 추가
			// 예를 들어, 창을 닫는 코드를 작성할 수 있습니다.
			closeWindow();
		});

		selectnusalSearchTable();
		eventProc();

	}

	public void eventProc() {
		nursesaltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = nursesaltable.getSelectedRow();
				if (row >= 0) {
					Object[] rowData = new Object[nusallist.getColumnCount()];
					for (int col = 0; col < nusallist.getColumnCount(); col++) {
						rowData[col] = nursesaltable.getValueAt(row, col);
					}
					updateTextFields(rowData);
				}
			}
		});
	}

	public void closeWindow() {
		// 현재 패널이 속한 상위 프레임 또는 다이얼로그를 닫는 코드를 작성합니다.
		// 예를 들어, 다음과 같이 작성할 수 있습니다.
		SwingUtilities.getWindowAncestor(this).dispose();
	}

	private void updateTextFields(Object[] rowData) {
		textField_1.setText(String.valueOf(rowData[0]));
		textField_2.setText(String.valueOf(rowData[1]));
		textField_3.setText(formatNumber(Integer.parseInt(rowData[2]+"")));
		textField_4.setText(formatNumber(Integer.parseInt(rowData[3]+"")));
		textField_5.setText(formatNumber(Integer.parseInt(rowData[4]+"")));
		textField_6.setText(formatNumber(Integer.parseInt(rowData[5]+"")));
		textField_7.setText(String.valueOf(rowData[6]));
		textField_8.setText(String.valueOf(rowData[7]));
	}

    private String formatNumber(int number) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return numberFormat.format(number);
    }
	
	void selectnusalSearchTable() {
		try {
			ArrayList<ArrayList> list = dao.nusalSearch(id); // 여러 명의 환자 정보를 담도록 수정
			nusallist.data = list;
			nursesaltable.setModel(nusallist);
			nusallist.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	class Nursesaltable extends AbstractTableModel {
		ArrayList<ArrayList> data; // 여러 명의 환자 정보를 담을 수 있도록 수정

		String[] columnNames = { "명세서 코드", "해당년월", "총급여", "세금", "중개수수료 ", "실수령액", "지급일자", "지급여부" };

		public Nursesaltable() {
			this.data = new ArrayList<>(); // ArrayList 초기화
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
