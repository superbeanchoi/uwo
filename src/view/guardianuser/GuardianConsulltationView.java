package view.guardianuser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.guardianuserDAO.GuardianConsulltationDAO;
import vo.guardianuserVO.GuardianConsulltationVO;

public class GuardianConsulltationView extends JPanel implements ActionListener {
	GuardianMypageView parentView;
	private JTable patienttable;
	private JTextField codeText, dateText;
	JTextArea detailText;
	JButton sendBtn, closeBtn;
	GuardianConsulltationDAO dao;
	patientTable patientlist;
	String id;

	/**
	 * Create the panel.
	 */

	public GuardianConsulltationView() {
		// TODO Auto-generated constructor stub
		initialize();
	}

	public GuardianConsulltationView(GuardianMypageView parentView, String mg_id) {
		// TODO Auto-generated constructor stub
		this.parentView=parentView;
		this.id = mg_id;
		initialize();
	}

	public void initialize() {
		// DB 연결
		try {
			dao = new GuardianConsulltationDAO();
			System.out.println("[ 보호자 상담테이블 DB 연결에 성공하였습니다. ]");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "[ 보호자 상담테이블 DB 연결에 실패하였습니다. ]\n" + e.getMessage());
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		setBackground(new Color(0, 0, 0));
		setLayout(null);

		JLabel headLabel = new JLabel("     \uC0C1\uB2F4 \uC694\uCCAD");
		headLabel.setBounds(0, 0, 1200, 70);
		add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		headLabel.setBackground(new Color(255, 228, 225));

		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBackground(new Color(0, 0, 0));
		closeBtn.setBounds(615, 800, 160, 50);
		add(closeBtn);

		sendBtn = new JButton("\uC0C1\uB2F4 \uC694\uCCAD");
		sendBtn.setForeground(Color.WHITE);
		sendBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		sendBtn.setBackground(Color.BLACK);
		sendBtn.setBounds(415, 800, 160, 50);
		add(sendBtn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 95, 1200, 640);
		add(panel);
		panel.setLayout(null);

		JPanel patientPanel = new JPanel();
		patientPanel.setBorder(new TitledBorder(null, "\uD658\uC790 \uC815\uBCF4 \uC870\uD68C", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		patientPanel.setBackground(new Color(255, 255, 255));
		patientPanel.setBounds(30, 30, 1140, 250);
		panel.add(patientPanel);
		patientPanel.setLayout(null);

		JScrollPane patientscrollPane = new JScrollPane();
		patientscrollPane.setBounds(15, 25, 1110, 200);
		patientPanel.add(patientscrollPane);
		patientscrollPane.setViewportView(patienttable);

		patientlist = new patientTable();
		patienttable = new JTable(patientlist);
		patienttable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		patientscrollPane.setViewportView(patienttable);

		patienttable.setRowHeight(20);
		patienttable.setBackground(Color.WHITE);
		patienttable.setSelectionBackground(new Color(255, 228, 225));
		patientscrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patienttable.getColumnCount(); i++) {
			patienttable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JLabel codeLabel = new JLabel("\uD658\uC790 \uCF54\uB4DC");
		codeLabel.setForeground(Color.BLACK);
		codeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		codeLabel.setBackground(Color.WHITE);
		codeLabel.setBounds(30, 300, 120, 30);
		panel.add(codeLabel);

		codeText = new JTextField();
		codeText.setEditable(false);
		codeText.setToolTipText("");
		codeText.setText((String) null);
		codeText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		codeText.setColumns(10);
		codeText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		codeText.setBackground(Color.WHITE);
		codeText.setBounds(150, 300, 300, 30);
		panel.add(codeText);

		detailText = new JTextArea();
		detailText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				detailText.setText("");
			}
		});
		detailText.setText(" \uC694\uCCAD \uB0B4\uC6A9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		detailText.setToolTipText("");
		detailText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		detailText.setLineWrap(true);
		detailText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		detailText.setBounds(30, 350, 1140, 250);
		panel.add(detailText);

		JLabel dateLabel = new JLabel("\uC0C1\uB2F4 \uC77C\uC790");
		dateLabel.setForeground(Color.BLACK);
		dateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dateLabel.setBackground(Color.WHITE);
		dateLabel.setBounds(500, 300, 120, 30);
		panel.add(dateLabel);

		dateText = new JTextField();
		dateText.setToolTipText("");
		LocalDate date = LocalDate.now();
		DateTimeFormatter dateFormate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String today = date.format(dateFormate);
		dateText.setText(today);
		dateText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dateText.setEditable(false);
		dateText.setColumns(10);
		dateText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateText.setBackground(Color.WHITE);
		dateText.setBounds(620, 300, 200, 30);
		panel.add(dateText);

		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 760, 1200, 140);
		add(footLabel);

		selectPatientTable();
		eventProc();
	}

	public void eventProc() {
		sendBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		patienttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = patienttable.getSelectedRow();
				String patientCode = (String) patienttable.getValueAt(row, 0);
				codeText.setText(patientCode);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		String code, consultingText;
		if (o == sendBtn) {
			code = codeText.getText();
			consultingText = detailText.getText();
			GuardianConsulltationVO vo = new GuardianConsulltationVO(code, consultingText);
			try {
				dao.consultinginsert(vo);
				JOptionPane.showMessageDialog(null, "[ 상담이 요청되었습니다. 빠른 시일 내에 담당자를 통해 연락 드리겠습니다. ]");
				parentView.consultingTable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "[ 상담 요청이 실패하였습니다. ]\n" + e2.getMessage());
			}
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GuardianConsulltationView.this);
			frame.dispose();
		} else if (o == closeBtn) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GuardianConsulltationView.this);
			frame.dispose();
		}
	}

	void selectPatientTable() {
		try {
			ArrayList list = dao.patientInfoSelect(id);
			patientlist.data = list;
			patienttable.setModel(patientlist);
			patientlist.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "[ 조회 내용이 존재하지 않습니다. ]\n" + e.getMessage());
		}
	}

	class patientTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "환자 코드", "환자 이름", "주민 번호", "보호자와의 관계", "담당자 명" };

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
