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

import dao.centeruserDAO.MatchingDAO;
import vo.centeruserVO.MatchingVO;

public class MatchingView extends JPanel implements ActionListener {
	String cnId;
	MatchingDAO dao;
	
	JComboBox searchComboBox, surviceComboBox, timeComboBox, ynComboBox;
	private JTextField searchText, meetingcodeText, startText, endText;
	JButton closeBtn, patientInfoBtn, nurseInfoBtn, matchingAddBtn, matchingModiBtn;
	JTextArea detailmeetingText;
	
	meetingListTable meetingListTable;
	JTable meetingTable;
	String meetingCode, ptcode, nuid;
	
	matchingListTable matchingListTable;
	JTable matchingTable;
	String matchingCode;
	private JButton matchingLiveBtn;

	/**
	 * Create the panel.
	 */

	/**
	 * @wbp.parser.constructor
	 */
	
	public MatchingView() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public MatchingView(String cnId) {
		// TODO Auto-generated constructor stub
		this.cnId=cnId;
		initialize();
	}

	public void initialize() {
		// DB ¿¬°á
		try {
			dao = new MatchingDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		setBackground(new Color(0, 0, 0));
		setLayout(null);

		JLabel headLabel = new JLabel("     \uB9E4\uCE6D \uAD00\uB9AC");
		headLabel.setBounds(0, 0, 1200, 70);
		add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));

		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBackground(new Color(0, 0, 0));
		closeBtn.setBounds(520, 825, 160, 50);
		add(closeBtn);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 80, 1200, 710);
		add(panel);
		panel.setLayout(null);
		
		searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"\uBA74\uC811\uC694\uCCAD \uCF54\uB4DC", "\uD658\uC790 \uCF54\uB4DC", "\uD658\uC790 \uC774\uB984", "\uC694\uC591\uBCF4\uD638\uC0AC \uC544\uC774\uB514", "\uC694\uC591\uBCF4\uD638\uC0AC \uC774\uB984"}));
		searchComboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		searchComboBox.setBackground(Color.WHITE);
		searchComboBox.setBounds(160, 40, 150, 30);
		panel.add(searchComboBox);
		
		searchText = new JTextField();
		searchText.setToolTipText("");
		searchText.setText((String) null);
		searchText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		searchText.setColumns(10);
		searchText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchText.setBackground(Color.WHITE);
		searchText.setBounds(320, 40, 150, 30);
		panel.add(searchText);

		JPanel meetingPanel = new JPanel();
		meetingPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uBA74\uC811 \uC694\uCCAD \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		meetingPanel.setBackground(new Color(255, 255, 255));
		meetingPanel.setBounds(20, 100, 570, 340);
		panel.add(meetingPanel);
		meetingPanel.setLayout(null);

		JScrollPane meetingScroll = new JScrollPane();
		meetingScroll.setBounds(15, 25, 540, 300);
		meetingPanel.add(meetingScroll);
		
		meetingListTable = new meetingListTable();
		meetingTable = new JTable(meetingListTable);
		meetingTable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		meetingScroll.setViewportView(meetingTable);

		meetingTable.setRowHeight(20);
		meetingTable.setBackground(Color.WHITE);
		meetingTable.setSelectionBackground(new Color(255, 228, 225));
		meetingScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < meetingTable.getColumnCount(); i++) {
			meetingTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel detailmeetingPanel = new JPanel();
		detailmeetingPanel.setLayout(null);
		detailmeetingPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC0C1\uC138 \uC694\uCCAD \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		detailmeetingPanel.setBackground(Color.WHITE);
		detailmeetingPanel.setBounds(20, 460, 570, 150);
		panel.add(detailmeetingPanel);
		
		detailmeetingText = new JTextArea();
		detailmeetingText.setEditable(false);
		detailmeetingText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		detailmeetingText.setBounds(15, 25, 540, 110);
		detailmeetingPanel.add(detailmeetingText);
		
		JPanel matchingpanel = new JPanel();
		matchingpanel.setLayout(null);
		matchingpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB9E4\uCE6D \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		matchingpanel.setBackground(Color.WHITE);
		matchingpanel.setBounds(610, 50, 570, 560);
		panel.add(matchingpanel);
		
		JScrollPane matchingScroll = new JScrollPane();
		matchingScroll.setBounds(15, 220, 540, 320);
		matchingpanel.add(matchingScroll);
		
		matchingListTable = new matchingListTable();
		matchingTable = new JTable(matchingListTable);
		matchingTable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		matchingScroll.setViewportView(matchingTable);
		
		matchingTable.setRowHeight(20);
		matchingTable.setBackground(Color.WHITE);
		matchingTable.setSelectionBackground(new Color(255, 228, 225));
		matchingScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < matchingTable.getColumnCount(); i++) {
			matchingTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JLabel meetingcodeLabel = new JLabel("\uBA74\uC811 \uC694\uCCAD \uCF54\uB4DC");
		meetingcodeLabel.setForeground(Color.BLACK);
		meetingcodeLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		meetingcodeLabel.setBackground(Color.WHITE);
		meetingcodeLabel.setBounds(15, 25, 130, 30);
		matchingpanel.add(meetingcodeLabel);
		
		meetingcodeText = new JTextField();
		meetingcodeText.setToolTipText("");
		meetingcodeText.setText((String) null);
		meetingcodeText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		meetingcodeText.setEditable(false);
		meetingcodeText.setColumns(10);
		meetingcodeText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		meetingcodeText.setBackground(Color.WHITE);
		meetingcodeText.setBounds(145, 25, 120, 30);
		matchingpanel.add(meetingcodeText);
		
		JLabel surviceLabel = new JLabel("\uC11C\uBE44\uC2A4 \uC774\uC6A9 \uC720\uD615");
		surviceLabel.setForeground(Color.BLACK);
		surviceLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		surviceLabel.setBackground(Color.WHITE);
		surviceLabel.setBounds(15, 75, 130, 30);
		matchingpanel.add(surviceLabel);
		
		surviceComboBox = new JComboBox();
		surviceComboBox.setModel(new DefaultComboBoxModel(new String[] {"4\uC2DC\uAC04", "8\uC2DC\uAC04", "\uC785\uC8FC"}));
		surviceComboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		surviceComboBox.setBackground(Color.WHITE);
		surviceComboBox.setBounds(145, 75, 120, 30);
		matchingpanel.add(surviceComboBox);
		
		JLabel timeLabel = new JLabel("\uC6D4 \uC774\uC6A9 \uD69F\uC218");
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		timeLabel.setBackground(Color.WHITE);
		timeLabel.setBounds(15, 125, 130, 30);
		matchingpanel.add(timeLabel);
		
		timeComboBox = new JComboBox();
		timeComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		timeComboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		timeComboBox.setBackground(Color.WHITE);
		timeComboBox.setBounds(145, 125, 80, 30);
		matchingpanel.add(timeComboBox);
		
		JLabel timeLabell = new JLabel(" \uD68C");
		timeLabell.setForeground(Color.BLACK);
		timeLabell.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		timeLabell.setBackground(Color.WHITE);
		timeLabell.setBounds(225, 125, 50, 30);
		matchingpanel.add(timeLabell);
		
		JLabel startLabel = new JLabel("\uC11C\uBE44\uC2A4 \uAC8C\uC2DC \uC77C\uC790");
		startLabel.setForeground(Color.BLACK);
		startLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		startLabel.setBackground(Color.WHITE);
		startLabel.setBounds(15, 166, 130, 30);
		matchingpanel.add(startLabel);
		
		startText = new JTextField();
		startText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startText.setText("");
			}
		});
		
		startText.setToolTipText("");
		startText.setText(" YYYY-MM-DD");
		startText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		startText.setColumns(10);
		startText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		startText.setBackground(Color.WHITE);
		startText.setBounds(145, 166, 120, 30);
		matchingpanel.add(startText);
		
		JLabel endLabel = new JLabel("\uC11C\uBE44\uC2A4 \uC885\uB8CC \uC77C\uC790");
		endLabel.setForeground(Color.BLACK);
		endLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		endLabel.setBackground(Color.WHITE);
		endLabel.setBounds(295, 165, 130, 30);
		matchingpanel.add(endLabel);
		
		endText = new JTextField();
		endText.setEditable(false);
		endText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				endText.setText("");
			}
		});
		
		endText.setToolTipText("");
		endText.setText(" YYYY-MM-DD");
		endText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		endText.setColumns(10);
		endText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		endText.setBackground(Color.WHITE);
		endText.setBounds(425, 165, 120, 30);
		matchingpanel.add(endText);
		
		JLabel ynLabel = new JLabel("\uC11C\uBE44\uC2A4 \uD655\uC815 \uC5EC\uBD80");
		ynLabel.setForeground(Color.BLACK);
		ynLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ynLabel.setBackground(Color.WHITE);
		ynLabel.setBounds(295, 125, 130, 30);
		matchingpanel.add(ynLabel);
		
		ynComboBox = new JComboBox();
		ynComboBox.setEnabled(false);
		ynComboBox.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		ynComboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ynComboBox.setBackground(new Color(255, 255, 255));
		ynComboBox.setBounds(425, 125, 120, 30);
		matchingpanel.add(ynComboBox);
		
		matchingLiveBtn = new JButton("\uB9E4\uCE6D \uCDE8\uC18C \uD65C\uC131\uD654");
		matchingLiveBtn.setForeground(Color.WHITE);
		matchingLiveBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		matchingLiveBtn.setBackground(Color.BLACK);
		matchingLiveBtn.setBounds(295, 75, 250, 30);
		matchingpanel.add(matchingLiveBtn);
		
		patientInfoBtn = new JButton("\uD658\uC790 \uC0C1\uC138\uC815\uBCF4");
		patientInfoBtn.setForeground(Color.WHITE);
		patientInfoBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		patientInfoBtn.setBackground(Color.BLACK);
		patientInfoBtn.setBounds(20, 630, 280, 50);
		panel.add(patientInfoBtn);
		
		nurseInfoBtn = new JButton("\uC694\uC591\uBCF4\uD638\uC0AC \uC0C1\uC138\uC815\uBCF4");
		nurseInfoBtn.setForeground(Color.WHITE);
		nurseInfoBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		nurseInfoBtn.setBackground(Color.BLACK);
		nurseInfoBtn.setBounds(310, 630, 280, 50);
		panel.add(nurseInfoBtn);
		
		matchingAddBtn = new JButton("\uB9E4\uCE6D \uB4F1\uB85D");
		matchingAddBtn.setForeground(Color.WHITE);
		matchingAddBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		matchingAddBtn.setBackground(Color.BLACK);
		matchingAddBtn.setBounds(610, 630, 280, 50);
		panel.add(matchingAddBtn);
		
		matchingModiBtn = new JButton("\uB9E4\uCE6D \uCDE8\uC18C");
		matchingModiBtn.setForeground(Color.WHITE);
		matchingModiBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		matchingModiBtn.setBackground(Color.BLACK);
		matchingModiBtn.setBounds(900, 630, 280, 50);
		panel.add(matchingModiBtn);
		
		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 800, 1200, 100);
		add(footLabel);

		eventProc();
		meetingTable();
		matchingTable();
	}

	public void eventProc() {
		closeBtn.addActionListener(this);
		searchText.addActionListener(this);
		meetingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = meetingTable.getSelectedRow();
				meetingCode = String.valueOf(meetingTable.getValueAt(row, 0));
				ptcode = String.valueOf(meetingTable.getValueAt(row, 1));
				nuid = String.valueOf(meetingTable.getValueAt(row, 3));
				meetingDetail(meetingCode);
				meetingcodeText.setText(meetingCode);
				surviceComboBox.setSelectedIndex(0);
				timeComboBox.setSelectedIndex(0);
				startText.setText("YYYY-MM-DD");
				endText.setText("YYYY-MM-DD");
			}
		});
		matchingAddBtn.addActionListener(this);
		matchingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = matchingTable.getSelectedRow();
				matchingCode = String.valueOf(matchingTable.getValueAt(row, 0));
				MatchingVO vo = new MatchingVO();
				try {
					vo = dao.matchingDetailSearch(matchingCode);
					meetingcodeText.setText(vo.getMeetingCode());
					String surviceNo = String.valueOf(vo.getSvtype());
					String surviceName=null;
					if(surviceNo.equals("301")) {
						surviceName="4½Ã°£";
					} else if(surviceNo.equals("302")) {
						surviceName="8½Ã°£";
					} else if(surviceNo.equals("303")) {
						surviceName="ÀÔÁÖ";
					}
					surviceComboBox.setSelectedItem(surviceName);
					timeComboBox.setSelectedItem(vo.getSurviceTime());
					startText.setText(vo.getStart().substring(0,10));
					if(vo.getEnd()!=null) {
						endText.setText(vo.getEnd().substring(0,10));
					} else {
						endText.setText("");
					}
					ynComboBox.setSelectedItem(vo.getSurviceYN());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					e2.printStackTrace();
				}
			}
		});
		matchingLiveBtn.addActionListener(this);
		matchingModiBtn.addActionListener(this);
		patientInfoBtn.addActionListener(this);
		nurseInfoBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==closeBtn) {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MatchingView.this);
			frame.dispose();
		} else if(o==searchText) {
			meetingSearch();
		} else if(o==matchingAddBtn) {
			String meetingCode = meetingcodeText.getText();
			int svtype = 0;
			if(surviceComboBox.getSelectedItem().equals("4½Ã°£")) {
				svtype=301;
			} else if(surviceComboBox.getSelectedItem().equals("8½Ã°£")) {
				svtype=302;
			} else if(surviceComboBox.getSelectedItem().equals("ÀÔÁÖ")) {
				svtype=303;
			}
			String surviceTime = (String)timeComboBox.getSelectedItem();
			String start = startText.getText();
			String End = endText.getText();
			String surviceYN = (String)ynComboBox.getSelectedItem();
			
			MatchingVO vo = new MatchingVO(meetingCode, svtype, surviceTime, start, End, surviceYN);
			try {
				dao.matchingInsert(vo);
				JOptionPane.showMessageDialog(null,"¸ÅÄª Á¤º¸°¡ µî·ÏµÇ¾ú½À´Ï´Ù.");
				matchingTable();
				meetingcodeText.setText("");
				surviceComboBox.setSelectedIndex(0);
				timeComboBox.setSelectedIndex(0);
				startText.setText("YYYY-MM-DD");
				endText.setText("YYYY-MM-DD");
				ynComboBox.setSelectedIndex(0);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "¸ÅÄª Á¤º¸ µî·Ï¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
		} else if(o==matchingLiveBtn) {
			ynComboBox.setEnabled(true);
			endText.setEditable(true);
		} else if(o==matchingModiBtn) {
			MatchingVO vo = new MatchingVO();
			vo.setMeetingCode(meetingCode);
			int svtype = 0;
			if(surviceComboBox.getSelectedItem().equals("4½Ã°£")) {
				svtype=301;
			} else if(surviceComboBox.getSelectedItem().equals("8½Ã°£")) {
				svtype=302;
			} else if(surviceComboBox.getSelectedItem().equals("ÀÔÁÖ")) {
				svtype=303;
			}
			vo.setSvtype(svtype);
			vo.setSurviceTime(timeComboBox.getSelectedItem()+"");
			vo.setStart(startText.getText());
			vo.setEnd(endText.getText());
			vo.setSurviceYN(ynComboBox.getSelectedItem()+"");
			try {
				dao.matchingUpdate(matchingCode, vo);
				JOptionPane.showMessageDialog(null,"¸ÅÄª Á¤º¸°¡ ¼öÁ¤µÇ¾ú½À´Ï´Ù.");
				matchingTable();
				meetingcodeText.setText("");
				surviceComboBox.setSelectedIndex(0);
				timeComboBox.setSelectedIndex(0);
				startText.setText("YYYY-MM-DD");
				endText.setText("YYYY-MM-DD");
				ynComboBox.setSelectedIndex(0);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "¸ÅÄª Á¤º¸ ¼öÁ¤¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
			ynComboBox.setEnabled(true);
			endText.setEditable(true);
		} else if(o==patientInfoBtn) {
			MatchingPatientInfoView mpi = new MatchingPatientInfoView(ptcode);
			mpi.setVisible(true);
		} else if(o==nurseInfoBtn) {
			MatchingNurseInfoView mni = new MatchingNurseInfoView(nuid);
			mni.setVisible(true);
		}
		
	}
	
	void meetingTable() {
		try {
			ArrayList list = dao.meetingInfoSelect(cnId);
			meetingListTable.data = list;
			meetingTable.setModel(meetingListTable);
			meetingListTable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void matchingTable() {
		try {
			ArrayList list = dao.matchingInfoSelect(cnId);
			matchingListTable.data = list;
			matchingTable.setModel(matchingListTable);
			matchingListTable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void meetingSearch() {
		int colindex = searchComboBox.getSelectedIndex();
		String text = searchText.getText();
		try {
			ArrayList list = dao.meetingSearch(cnId, colindex, text);
			meetingListTable.data = list;
			meetingTable.setModel(meetingListTable);
			meetingListTable.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void meetingDetail(String meetingCode) {
		try {
			String content = dao.meetingDetailSearch(meetingCode);
			detailmeetingText.setText(content);
			
			ArrayList list = dao.matchingSearch(meetingCode);
			matchingListTable.data = list;
			matchingTable.setModel(matchingListTable);
			matchingListTable.fireTableDataChanged();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	class meetingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "¸éÁ¢ ÄÚµå", "È¯ÀÚ ÄÚµå", "È¯ÀÚ ÀÌ¸§", "¿ä¾çº¸È£»ç ¾ÆÀÌµð", "¿ä¾çº¸È£»ç ÀÌ¸§", "¸éÁ¢ ¿äÃ» ÀÏÀÚ" };

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
	
	class matchingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "¸ÅÄª ÄÚµå", "¸éÁ¢ ÄÚµå", "¼­ºñ½º ÀÌ¿ë À¯Çü", "¿ù ÀÌ¿ë È½¼ö", "¼­ºñ½º È®Á¤ ¿©ºÎ" };

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