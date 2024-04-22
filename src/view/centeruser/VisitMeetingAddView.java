package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.centeruserDAO.CenterMypageDAO;
import vo.centeruserVO.CenterMypageVO;

public class VisitMeetingAddView extends JPanel implements ActionListener {
	CenterMypageView parentView;
	private JTextField codeText, dateText;
	JTextArea detailText;
	JButton sendBtn, closeBtn;
	JComboBox patientSearchBox;
	String id;
	private JTextField patientSearchText;
	PatientSimpleListTable patientSimpleList;
	JTable patientSimpleTable;
	CenterMypageDAO dao;

	/**
	 * Create the panel.
	 */
	
	public VisitMeetingAddView() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public VisitMeetingAddView(CenterMypageView parentView, String cnid) {
		// TODO Auto-generated constructor stub
		this.parentView=parentView;
		id=cnid;
		initialize();
	}
	
	public void initialize() {
		//DB 연결
		try {
			dao = new CenterMypageDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		setBackground(new Color(0, 0, 0));
		setLayout(null);

		JLabel headLabel = new JLabel("     \uBC29\uBB38 \uC0C1\uB2F4");
		headLabel.setBounds(0, 0, 1200, 70);
		add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));

		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBackground(new Color(0, 0, 0));
		closeBtn.setBounds(615, 800, 160, 50);
		add(closeBtn);

		sendBtn = new JButton("\uC791\uC131");
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
		detailText.setText(" \uC0C1\uB2F4 \uB0B4\uC6A9\uC744 \uC791\uC131\uD558\uC138\uC694.");
		detailText.setToolTipText("");
		detailText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		detailText.setLineWrap(true);
		detailText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		detailText.setBounds(30, 350, 1140, 250);
		panel.add(detailText);

		JLabel dateLabel = new JLabel("\uBC29\uBB38 \uC77C\uC790");
		dateLabel.setForeground(Color.BLACK);
		dateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dateLabel.setBackground(Color.WHITE);
		dateLabel.setBounds(500, 300, 120, 30);
		panel.add(dateLabel);

		dateText = new JTextField();
		dateText.setToolTipText("YYYY-MM-DD");
		dateText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		dateText.setColumns(10);
		dateText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateText.setBackground(Color.WHITE);
		dateText.setBounds(620, 300, 200, 30);
		panel.add(dateText);
		
		dateText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dateText.setText("");
			}
		});
		
		patientSearchBox = new JComboBox();
		patientSearchBox.setModel(new DefaultComboBoxModel(new String[] {"\uD658\uC790 \uCF54\uB4DC", "\uD658\uC790 \uC774\uB984"}));
		patientSearchBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		patientSearchBox.setBackground(Color.WHITE);
		patientSearchBox.setBounds(30, 25, 150, 30);
		panel.add(patientSearchBox);
		
		patientSearchText = new JTextField();
		patientSearchText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		patientSearchText.setColumns(10);
		patientSearchText.setBounds(190, 25, 220, 30);
		panel.add(patientSearchText);
		
		JPanel patientsimpleInfoPanel = new JPanel();
		patientsimpleInfoPanel.setLayout(null);
		patientsimpleInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB2F4\uB2F9 \uD658\uC790 \uC815\uBCF4 \uC870\uD68C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		patientsimpleInfoPanel.setBackground(Color.WHITE);
		patientsimpleInfoPanel.setBounds(30, 75, 1140, 200);
		panel.add(patientsimpleInfoPanel);
		
		JScrollPane patientsimpleInfoScroll = new JScrollPane();
		patientsimpleInfoScroll.setBounds(20, 25, 1100, 160);
		patientsimpleInfoPanel.add(patientsimpleInfoScroll);

		patientSimpleList = new PatientSimpleListTable();
		patientSimpleTable = new JTable(patientSimpleList);
		patientSimpleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		patientsimpleInfoScroll.setViewportView(patientSimpleTable);
		
		patientSimpleTable.setRowHeight(20);
		patientSimpleTable.setBackground(Color.WHITE);
		patientSimpleTable.setSelectionBackground(new Color(255, 228, 225));
		patientsimpleInfoScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patientSimpleTable.getColumnCount(); i++) {
			patientSimpleTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 760, 1200, 140);
		add(footLabel);
		
		patientSimpleTable();
		eventProc();
	}
	
	public void eventProc() {
		sendBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		patientSearchText.addActionListener(this);
		patientSimpleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = patientSimpleTable.getSelectedRow();
				String patientCode = String.valueOf(patientSimpleTable.getValueAt(row, 0));
				codeText.setText(patientCode);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		String code, visitMeetingText, visitdateText;
		if(o==sendBtn) {
			code = codeText.getText();
			visitdateText = dateText.getText();
			visitMeetingText = detailText.getText();
			CenterMypageVO vo = new CenterMypageVO();
			vo.setCnid(id);
			vo.setPtno(code);
			vo.setCstdate(visitdateText);
			vo.setCstcontent(visitMeetingText);
			try {
				dao.visitmeetinginsert(vo);
				JOptionPane.showMessageDialog(null,"방문 상담 내역이 작성되였습니다.");
				parentView.visitMeetingTable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "상담 내역 작성이 실패하였습니다.");
				e2.printStackTrace();
			}
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(VisitMeetingAddView.this);
			frame.dispose();
		} else if(o==closeBtn) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(VisitMeetingAddView.this);
			frame.dispose();
		} else if(o==patientSearchText) {
			patientSearch();
		}
	}
	
	void patientSimpleTable() {
		try {
			ArrayList list = dao.patientSimpleSelect(id);
			patientSimpleList.data = list;
			patientSimpleTable.setModel(patientSimpleList);
			patientSimpleList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void patientSearch() {
		int colindex = patientSearchBox.getSelectedIndex();
		String text = patientSearchText.getText();
		try {
			ArrayList list = dao.patientSearch(id, colindex, text);
			patientSimpleList.data = list;
			patientSimpleTable.setModel(patientSimpleList);
			patientSimpleList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	class PatientSimpleListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"환자 코드", "환자 이름", "환자 주소", "환자 전화번호", "주요 진단명"};
		public int getColumnCount() { 
	        return columnNames.length; 
	    } 
	    public int getRowCount() { 
	        return data.size(); 
	    } 
	    public Object getValueAt(int row, int col) { 
	    	ArrayList temp = (ArrayList)data.get(row);
	    	return temp.get(col); 
	    }   
	    public String getColumnName(int col) { 
			return columnNames[col];
	    } 
	}
}
