package view.nurseuser;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.nurseuserDAO.NurseMypageInfoDAO;
import vo.nurseuserVO.NurseMypageInfoVO;

public class NurseMypageInfoView implements ActionListener {

	static NurseMypageInfoView window;
	public JFrame frame;
	private final JPanel menuPanel = new JPanel();
	JPanel memberPanel, matchingPanel;
	JButton memberPanelMemberBtn, memberPanelMatchingbtn, matchingPanelMatchingBtn, matchingPanelMemberBtn;
	JButton schedulebtn, mybtn, logoutbtn, salarybtn;
	private JLabel imgLabel, imgAddLabel, idLabel, pwLabel, nameLabel, juminLabel, sexLabel, fromLabel, telLabel, addLabel, bankLabel, bankNumLabel, criminalLabel, workLabel;
	private JButton imgBtn, MemModiBtn;
	public JTextField idText;
	private JTextField pwText, nameText, juminText, fromText, telText, addText, bankText, bankNumText;
	private JComboBox fromBox, bankBox;
	private JRadioButton manBtn, womanBtn, criminalYBtn, criminalNBtn, work4Btn, work8Btn, workAllbtn;
	private JLabel careerLabel, certiLabel, skillLabel;
	private JScrollPane careerArea, certiArea, skillArea;
	private JButton careerAddBtn, careerDelBtn, certiAddBtn, certiDelBtn, skillAddBtn, skillDelBtn, careerModiBtn, certiModiBtn, skillModiBtn;
	private JPanel simpleinfoPanel;
	private JLabel patientNameLabel, patientSexLabel, patientDiagLabel, patientNoLabel;
	private JTextField patientNameText, patientSexText, patientDiagText, patientNoText;
	private JPanel healthinfoPanel;
	private JLabel conditionLabel, mealLabel, urineLabel, paralLabel, exerciseLabel, bedsoreLabel, suctionLabel;
	private JTextField conditionText, mealText, urineText, paralText, exerciseText, bedsoreText, suctionText;
	NurseMypageInfoDAO dao;
	String myId;
	private JTextField imgPathText;
	CareerListTable careerList;
	CertiListTable certiList;
	SkillListTable skillList;
	JTable careertable, certitable, skilltable;
	JTable meetingTable;
	meetingListTable meetingList;
	String patientCode;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new NurseMypageInfoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public NurseMypageInfoView() {
		initialize();
		idText.setText(myId);
	}
	
	public NurseMypageInfoView(String id) {
		myId=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//DB ¿¬°á
		try {
			dao = new NurseMypageInfoDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		frame = new JFrame();
		frame.setTitle("\uC694\uC591\uBCF4\uD638\uC0AC \uB9C8\uC774\uD398\uC774\uC9C0");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		frame.setForeground(new Color(255, 255, 255));
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1399, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		menuPanel.setBackground(new Color(255, 228, 225));
		menuPanel.setToolTipText("\uC804\uCCB4 \uBA54\uB274");
		menuPanel.setBounds(0, 0, 195, 961);
		frame.getContentPane().add(menuPanel);
		frame.setLocation(570, 250);
		menuPanel.setLayout(null);
		
		Font buttonFont = new Font("¸¼Àº °íµñ", Font.PLAIN, 20);
		Font bf = new Font("¸¼Àº °íµñ", Font.PLAIN, 14);
		
		schedulebtn = new JButton("½ºÄÉÁÙ");
		schedulebtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		schedulebtn.setBounds(0, 235, 195, 70);
		schedulebtn.setForeground(Color.WHITE);
		schedulebtn.setBackground(new Color(0, 0, 0));
		menuPanel.add(schedulebtn);
		
		mybtn = new JButton("¸¶ÀÌÆäÀÌÁö");
		mybtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		mybtn.setForeground(new Color(0, 0, 0));
		mybtn.setBackground(new Color(255, 255, 255));
		mybtn.setBounds(0, 165, 195, 70);
		menuPanel.add(mybtn);
		
		logoutbtn = new JButton("·Î±×¾Æ¿ô");
		logoutbtn.setBounds(0, 851, 195, 70);
		logoutbtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		logoutbtn.setForeground(Color.WHITE);
		logoutbtn.setBackground(Color.BLACK);
		menuPanel.add(logoutbtn);
		
		salarybtn = new JButton("\uAE09\uC5EC\uAD00\uB9AC");
		salarybtn.setBackground(new Color(0, 0, 0));
		salarybtn.setForeground(new Color(255, 255, 255));
		salarybtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		salarybtn.setBounds(0, 305, 195, 70);
		menuPanel.add(salarybtn);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("C:\\workspaces\\img\\NurseLogoMain.png"));
		logoLabel.setBounds(0, 0, 195, 165);
		menuPanel.add(logoLabel);
		
		memberPanel = new JPanel();
		memberPanel.setToolTipText("\uD68C\uC6D0\uC815\uBCF4");
		memberPanel.setBackground(new Color(255, 228, 225));
		memberPanel.setBounds(195, 0, 1188, 961);
		frame.getContentPane().add(memberPanel);
		memberPanel.setLayout(null);
		
		memberPanelMemberBtn = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		memberPanelMemberBtn.setForeground(Color.BLACK);
		memberPanelMemberBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		memberPanelMemberBtn.setBackground(Color.WHITE);
		memberPanelMemberBtn.setBounds(0, 0, 195, 70);
		memberPanel.add(memberPanelMemberBtn);
		
		memberPanelMatchingbtn = new JButton("\uBA74\uC811\uC81C\uC548");
		memberPanelMatchingbtn.setForeground(Color.WHITE);
		memberPanelMatchingbtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		memberPanelMatchingbtn.setBackground(Color.BLACK);
		memberPanelMatchingbtn.setBounds(195, 0, 195, 70);
		memberPanel.add(memberPanelMatchingbtn);
		
		JPanel memberContentsPanel = new JPanel();
		memberContentsPanel.setForeground(new Color(255, 255, 255));
		memberContentsPanel.setBackground(new Color(255, 255, 255));
		memberContentsPanel.setBounds(0, 70, 1188, 850);
		memberPanel.add(memberContentsPanel);
		memberContentsPanel.setLayout(null);
		
		imgLabel = new JLabel("\uC0AC\uC9C4");
		imgLabel.setForeground(Color.BLACK);
		imgLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBounds(72, 95, 120, 30);
		memberContentsPanel.add(imgLabel);
		
		imgAddLabel = new JLabel("");
		imgAddLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgAddLabel.setBackground(Color.WHITE);
		imgAddLabel.setBounds(192, 50, 100, 120);
		memberContentsPanel.add(imgAddLabel);
		
		imgBtn = new JButton("\uBD88\uB7EC\uC624\uAE30");
		imgBtn.setForeground(Color.WHITE);
		imgBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		imgBtn.setBackground(Color.BLACK);
		imgBtn.setBounds(302, 95, 100, 30);
		memberContentsPanel.add(imgBtn);
		
		imgPathText = new JTextField();
		imgPathText.setToolTipText("");
		imgPathText.setForeground(Color.BLACK);
		imgPathText.setFont(new Font("¸¼Àº °íµñ", Font.ITALIC, 12));
		imgPathText.setEditable(false);
		imgPathText.setColumns(10);
		imgPathText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgPathText.setBackground(Color.WHITE);
		imgPathText.setBounds(414, 95, 78, 30);
		memberContentsPanel.add(imgPathText);
		
		idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		idLabel.setBackground(Color.WHITE);
		idLabel.setBounds(72, 180, 120, 30);
		memberContentsPanel.add(idLabel);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setToolTipText("");
		idText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		idText.setColumns(10);
		idText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		idText.setBackground(new Color(220, 220, 220));
		idText.setBounds(192, 180, 300, 30);
		memberContentsPanel.add(idText);
		
		pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setForeground(Color.BLACK);
		pwLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pwLabel.setBackground(Color.WHITE);
		pwLabel.setBounds(72, 220, 120, 30);
		memberContentsPanel.add(pwLabel);
		
		pwText = new JTextField();
		pwText.setToolTipText("");
		pwText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pwText.setColumns(10);
		pwText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pwText.setBackground(Color.WHITE);
		pwText.setBounds(192, 220, 300, 30);
		memberContentsPanel.add(pwText);
		
		nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(72, 260, 120, 30);
		memberContentsPanel.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setToolTipText("");
		nameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nameText.setBackground(Color.WHITE);
		nameText.setBounds(192, 260, 300, 30);
		memberContentsPanel.add(nameText);
		
		juminLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		juminLabel.setForeground(Color.BLACK);
		juminLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		juminLabel.setBackground(Color.WHITE);
		juminLabel.setBounds(72, 300, 120, 30);
		memberContentsPanel.add(juminLabel);
		
		juminText = new JTextField();
		juminText.setToolTipText("");
		juminText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		juminText.setColumns(10);
		juminText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		juminText.setBackground(Color.WHITE);
		juminText.setBounds(192, 300, 300, 30);
		memberContentsPanel.add(juminText);
		
		sexLabel = new JLabel("\uC131\uBCC4");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sexLabel.setBackground(Color.WHITE);
		sexLabel.setBounds(72, 340, 120, 30);
		memberContentsPanel.add(sexLabel);
		
		manBtn = new JRadioButton("\uB0A8\uC790");
		manBtn.setForeground(Color.BLACK);
		manBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		manBtn.setBackground(Color.WHITE);
		manBtn.setBounds(192, 340, 120, 30);
		memberContentsPanel.add(manBtn);
		
		womanBtn = new JRadioButton("\uC5EC\uC790");
		womanBtn.setForeground(Color.BLACK);
		womanBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		womanBtn.setBackground(Color.WHITE);
		womanBtn.setBounds(312, 340, 120, 30);
		memberContentsPanel.add(womanBtn);
		
		fromLabel = new JLabel("\uAD6D\uC801");
		fromLabel.setForeground(Color.BLACK);
		fromLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		fromLabel.setBackground(Color.WHITE);
		fromLabel.setBounds(72, 380, 120, 30);
		memberContentsPanel.add(fromLabel);
		
		fromBox = new JComboBox();
		fromBox.setModel(new DefaultComboBoxModel(new String[] {"\uB300\uD55C\uBBFC\uAD6D", "\uC77C\uBCF8", "\uC911\uAD6D", "\uB300\uB9CC", "\uD64D\uCF69", "\uBCA0\uD2B8\uB0A8", "\uB9D0\uB808\uC774\uC2DC\uC544", "\uC778\uB3C4\uB124\uC2DC\uC544", "\uD0DC\uAD6D", "\uD544\uB9AC\uD540", "\uC778\uB3C4", "\uAE30\uD0C0 \uAD6D\uAC00"}));
		fromBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		fromBox.setBackground(Color.WHITE);
		fromBox.setBounds(192, 380, 300, 30);
		memberContentsPanel.add(fromBox);
		
		telLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telLabel.setForeground(Color.BLACK);
		telLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telLabel.setBackground(Color.WHITE);
		telLabel.setBounds(72, 420, 120, 30);
		memberContentsPanel.add(telLabel);
		
		telText = new JTextField();
		telText.setToolTipText("");
		telText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telText.setColumns(10);
		telText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		telText.setBackground(Color.WHITE);
		telText.setBounds(192, 420, 300, 30);
		memberContentsPanel.add(telText);
		
		addLabel = new JLabel("\uC8FC\uC18C");
		addLabel.setForeground(Color.BLACK);
		addLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		addLabel.setBackground(Color.WHITE);
		addLabel.setBounds(72, 460, 120, 30);
		memberContentsPanel.add(addLabel);
		
		addText = new JTextField();
		addText.setToolTipText("");
		addText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		addText.setColumns(10);
		addText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		addText.setBackground(Color.WHITE);
		addText.setBounds(192, 460, 300, 30);
		memberContentsPanel.add(addText);
		
		bankLabel = new JLabel("\uC740\uD589\uBA85");
		bankLabel.setForeground(Color.BLACK);
		bankLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankLabel.setBackground(Color.WHITE);
		bankLabel.setBounds(72, 500, 120, 30);
		memberContentsPanel.add(bankLabel);
		
		bankBox = new JComboBox();
		bankBox.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC\uC740\uD589", "\uAE30\uC5C5\uC740\uD589", "\uB18D\uD611\uC740\uD589", "\uC2E0\uD55C\uC740\uD589", "\uC6B0\uB9AC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uCE74\uCE74\uC624\uBC45\uD06C", "\uD1A0\uC2A4\uBC45\uD06C"}));
		bankBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankBox.setBackground(Color.WHITE);
		bankBox.setBounds(192, 500, 300, 30);
		memberContentsPanel.add(bankBox);
		
		bankNumLabel = new JLabel("\uACC4\uC88C\uBC88\uD638");
		bankNumLabel.setForeground(Color.BLACK);
		bankNumLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankNumLabel.setBackground(Color.WHITE);
		bankNumLabel.setBounds(72, 540, 120, 30);
		memberContentsPanel.add(bankNumLabel);
		
		bankNumText = new JTextField();
		bankNumText.setToolTipText("");
		bankNumText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankNumText.setColumns(10);
		bankNumText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bankNumText.setBackground(Color.WHITE);
		bankNumText.setBounds(192, 540, 300, 30);
		memberContentsPanel.add(bankNumText);
		
		criminalLabel = new JLabel("\uBC94\uC8C4\uACBD\uB825\uC5EC\uBD80");
		criminalLabel.setForeground(Color.BLACK);
		criminalLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		criminalLabel.setBackground(Color.WHITE);
		criminalLabel.setBounds(72, 580, 120, 30);
		memberContentsPanel.add(criminalLabel);
		
		criminalYBtn = new JRadioButton("\uC788\uC74C");
		criminalYBtn.setForeground(Color.BLACK);
		criminalYBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		criminalYBtn.setBackground(Color.WHITE);
		criminalYBtn.setBounds(192, 580, 120, 30);
		memberContentsPanel.add(criminalYBtn);
		
		criminalNBtn = new JRadioButton("\uC5C6\uC74C");
		criminalNBtn.setSelected(true);
		criminalNBtn.setForeground(Color.BLACK);
		criminalNBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		criminalNBtn.setBackground(Color.WHITE);
		criminalNBtn.setBounds(312, 580, 120, 30);
		memberContentsPanel.add(criminalNBtn);
		
		workLabel = new JLabel("\uD76C\uB9DD\uADFC\uBB34\uC720\uD615");
		workLabel.setForeground(Color.BLACK);
		workLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		workLabel.setBackground(Color.WHITE);
		workLabel.setBounds(72, 620, 120, 30);
		memberContentsPanel.add(workLabel);
		
		work4Btn = new JRadioButton("4\uC2DC\uAC04");
		work4Btn.setForeground(Color.BLACK);
		work4Btn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		work4Btn.setBackground(Color.WHITE);
		work4Btn.setBounds(192, 620, 120, 30);
		memberContentsPanel.add(work4Btn);
		
		work8Btn = new JRadioButton("8\uC2DC\uAC04");
		work8Btn.setForeground(Color.BLACK);
		work8Btn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		work8Btn.setBackground(Color.WHITE);
		work8Btn.setBounds(312, 620, 120, 30);
		memberContentsPanel.add(work8Btn);
		
		workAllbtn = new JRadioButton("\uC785\uC8FC");
		workAllbtn.setForeground(Color.BLACK);
		workAllbtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		workAllbtn.setBackground(Color.WHITE);
		workAllbtn.setBounds(432, 620, 70, 30);
		memberContentsPanel.add(workAllbtn);
		
		careerLabel = new JLabel("\uACBD\uB825 \uC815\uBCF4");
		careerLabel.setForeground(Color.BLACK);
		careerLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		careerLabel.setBackground(Color.WHITE);
		careerLabel.setBounds(562, 60, 150, 40);
		memberContentsPanel.add(careerLabel);
		
		careerArea = new JScrollPane();
		careerArea.setBounds(562, 110, 550, 110);
		memberContentsPanel.add(careerArea);
		
		careerList = new CareerListTable();
		careertable = new JTable(careerList);
		careertable.setBackground(new Color(255, 255, 255));
		careertable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		careerArea.setViewportView(careertable);
		
		careertable.setRowHeight(20);
		careertable.setBackground(Color.WHITE);
		careertable.setSelectionBackground(new Color(255, 228, 225));
		careerArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < careertable.getColumnCount(); i++) {
			careertable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		careerAddBtn = new JButton("+");
		careerAddBtn.setForeground(Color.WHITE);
		careerAddBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		careerAddBtn.setBackground(Color.BLACK);
		careerAddBtn.setBounds(917, 70, 50, 30);
		memberContentsPanel.add(careerAddBtn);
		
		careerModiBtn = new JButton("\uC218\uC815");
		careerModiBtn.setForeground(Color.WHITE);
		careerModiBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		careerModiBtn.setBackground(Color.BLACK);
		careerModiBtn.setBounds(977, 70, 75, 30);
		memberContentsPanel.add(careerModiBtn);
		
		careerDelBtn = new JButton("-");
		careerDelBtn.setForeground(Color.WHITE);
		careerDelBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		careerDelBtn.setBackground(Color.BLACK);
		careerDelBtn.setBounds(1062, 70, 50, 30);
		memberContentsPanel.add(careerDelBtn);
		
		certiLabel = new JLabel("\uC790\uACA9\uC99D \uC815\uBCF4");
		certiLabel.setForeground(Color.BLACK);
		certiLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		certiLabel.setBackground(Color.WHITE);
		certiLabel.setBounds(562, 250, 150, 40);
		memberContentsPanel.add(certiLabel);
		
		certiArea = new JScrollPane();
		certiArea.setBounds(562, 300, 550, 110);
		memberContentsPanel.add(certiArea);
		
		certiList = new CertiListTable();
		certitable = new JTable(certiList);
		certitable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		certiArea.setViewportView(certitable);
		
		certitable.setRowHeight(20);
		certitable.setBackground(Color.WHITE);
		certitable.setSelectionBackground(new Color(255, 228, 225));
		certiArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < certitable.getColumnCount(); i++) {
			certitable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		certiAddBtn = new JButton("+");
		certiAddBtn.setForeground(Color.WHITE);
		certiAddBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		certiAddBtn.setBackground(Color.BLACK);
		certiAddBtn.setBounds(917, 260, 50, 30);
		memberContentsPanel.add(certiAddBtn);
		
		certiModiBtn = new JButton("\uC218\uC815");
		certiModiBtn.setForeground(Color.WHITE);
		certiModiBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		certiModiBtn.setBackground(Color.BLACK);
		certiModiBtn.setBounds(977, 260, 75, 30);
		memberContentsPanel.add(certiModiBtn);
		
		certiDelBtn = new JButton("-");
		certiDelBtn.setForeground(Color.WHITE);
		certiDelBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		certiDelBtn.setBackground(Color.BLACK);
		certiDelBtn.setBounds(1062, 260, 50, 30);
		memberContentsPanel.add(certiDelBtn);
		
		skillLabel = new JLabel("\uAE30\uC220 \uC815\uBCF4");
		skillLabel.setForeground(Color.BLACK);
		skillLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		skillLabel.setBackground(Color.WHITE);
		skillLabel.setBounds(562, 440, 150, 40);
		memberContentsPanel.add(skillLabel);
		
		skillArea = new JScrollPane();
		skillArea.setBounds(562, 490, 550, 110);
		memberContentsPanel.add(skillArea);
		
		skillList = new SkillListTable();
		skilltable = new JTable(skillList);
		skilltable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		skillArea.setViewportView(skilltable);
		
		skilltable.setRowHeight(20);
		skilltable.setBackground(Color.WHITE);
		skilltable.setSelectionBackground(new Color(255, 228, 225));
		skillArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < skilltable.getColumnCount(); i++) {
			skilltable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		skillAddBtn = new JButton("+");
		skillAddBtn.setForeground(Color.WHITE);
		skillAddBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		skillAddBtn.setBackground(Color.BLACK);
		skillAddBtn.setBounds(917, 450, 50, 30);
		memberContentsPanel.add(skillAddBtn);
		
		skillModiBtn = new JButton("\uC218\uC815");
		skillModiBtn.setForeground(Color.WHITE);
		skillModiBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		skillModiBtn.setBackground(Color.BLACK);
		skillModiBtn.setBounds(977, 450, 75, 30);
		memberContentsPanel.add(skillModiBtn);
		
		skillDelBtn = new JButton("-");
		skillDelBtn.setForeground(Color.WHITE);
		skillDelBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		skillDelBtn.setBackground(Color.BLACK);
		skillDelBtn.setBounds(1062, 450, 50, 30);
		memberContentsPanel.add(skillDelBtn);
		
		MemModiBtn = new JButton("\uC218\uC815");
		MemModiBtn.setForeground(Color.WHITE);
		MemModiBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		MemModiBtn.setBackground(Color.BLACK);
		MemModiBtn.setBounds(495, 720, 200, 70);
		memberContentsPanel.add(MemModiBtn);
		
		matchingPanel = new JPanel();
		matchingPanel.setLayout(null);
		matchingPanel.setToolTipText("\uD68C\uC6D0\uC815\uBCF4");
		matchingPanel.setBackground(new Color(255, 228, 225));
		matchingPanel.setBounds(195, 0, 1188, 961);
		frame.getContentPane().add(matchingPanel);
		
		matchingPanelMemberBtn = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		matchingPanelMemberBtn.setForeground(new Color(255, 255, 255));
		matchingPanelMemberBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		matchingPanelMemberBtn.setBackground(new Color(0, 0, 0));
		matchingPanelMemberBtn.setBounds(0, 0, 195, 70);
		matchingPanel.add(matchingPanelMemberBtn);
		
		matchingPanelMatchingBtn = new JButton("\uBA74\uC811\uC81C\uC548");
		matchingPanelMatchingBtn.setForeground(new Color(0, 0, 0));
		matchingPanelMatchingBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		matchingPanelMatchingBtn.setBackground(new Color(255, 255, 255));
		matchingPanelMatchingBtn.setBounds(195, 0, 195, 70);
		matchingPanel.add(matchingPanelMatchingBtn);
		
		JPanel matchingContentsPanel = new JPanel();
		matchingContentsPanel.setBackground(new Color(255, 255, 255));
		matchingContentsPanel.setBounds(0, 70, 1188, 851);
		matchingPanel.add(matchingContentsPanel);
		matchingContentsPanel.setLayout(null);
		
		JLabel meetingLabel = new JLabel("\uBA74\uC811 \uC694\uCCAD \uB0B4\uC5ED");
		meetingLabel.setForeground(Color.BLACK);
		meetingLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		meetingLabel.setBackground(Color.WHITE);
		meetingLabel.setBounds(20, 20, 150, 40);
		matchingContentsPanel.add(meetingLabel);
		
		JScrollPane meetingArea = new JScrollPane();
		meetingArea.setBounds(20, 70, 1148, 200);
		matchingContentsPanel.add(meetingArea);
		
		meetingList = new meetingListTable();
		meetingTable = new JTable(meetingList);
		meetingTable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		meetingArea.setViewportView(meetingTable);
		
		meetingTable.setRowHeight(20);
		meetingTable.setBackground(Color.WHITE);
		meetingTable.setSelectionBackground(new Color(255, 228, 225));
		meetingArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < meetingTable.getColumnCount(); i++) {
			meetingTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JLabel patientLabel = new JLabel("\uBA74\uC811 \uC694\uCCAD \uD658\uC790 \uC815\uBCF4");
		patientLabel.setForeground(Color.BLACK);
		patientLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		patientLabel.setBackground(Color.WHITE);
		patientLabel.setBounds(20, 300, 200, 40);
		matchingContentsPanel.add(patientLabel);
		
		simpleinfoPanel = new JPanel();
		simpleinfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790 \uAE30\uBCF8 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		simpleinfoPanel.setBackground(Color.WHITE);
		simpleinfoPanel.setBounds(20, 360, 380, 460);
		matchingContentsPanel.add(simpleinfoPanel);
		simpleinfoPanel.setLayout(null);
		
		patientNameLabel = new JLabel("\uC774\uB984");
		patientNameLabel.setForeground(Color.BLACK);
		patientNameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientNameLabel.setBackground(Color.WHITE);
		patientNameLabel.setBounds(20, 40, 120, 40);
		simpleinfoPanel.add(patientNameLabel);
		
		patientNameText = new JTextField();
		patientNameText.setToolTipText("");
		patientNameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientNameText.setEditable(false);
		patientNameText.setColumns(10);
		patientNameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientNameText.setBackground(Color.WHITE);
		patientNameText.setBounds(140, 40, 200, 40);
		simpleinfoPanel.add(patientNameText);
		
		patientSexLabel = new JLabel("\uC131\uBCC4");
		patientSexLabel.setForeground(Color.BLACK);
		patientSexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientSexLabel.setBackground(Color.WHITE);
		patientSexLabel.setBounds(20, 100, 120, 40);
		simpleinfoPanel.add(patientSexLabel);
		
		patientSexText = new JTextField();
		patientSexText.setToolTipText("");
		patientSexText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientSexText.setEditable(false);
		patientSexText.setColumns(10);
		patientSexText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientSexText.setBackground(Color.WHITE);
		patientSexText.setBounds(140, 100, 200, 40);
		simpleinfoPanel.add(patientSexText);
		
		patientDiagLabel = new JLabel("\uC8FC\uC694 \uC9C4\uB2E8\uBA85");
		patientDiagLabel.setForeground(Color.BLACK);
		patientDiagLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientDiagLabel.setBackground(Color.WHITE);
		patientDiagLabel.setBounds(20, 160, 120, 40);
		simpleinfoPanel.add(patientDiagLabel);
		
		patientDiagText = new JTextField();
		patientDiagText.setToolTipText("");
		patientDiagText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientDiagText.setEditable(false);
		patientDiagText.setColumns(10);
		patientDiagText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientDiagText.setBackground(Color.WHITE);
		patientDiagText.setBounds(140, 160, 200, 40);
		simpleinfoPanel.add(patientDiagText);
		
		patientNoLabel = new JLabel("\uC694\uC591\uB4F1\uAE09");
		patientNoLabel.setForeground(Color.BLACK);
		patientNoLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientNoLabel.setBackground(Color.WHITE);
		patientNoLabel.setBounds(20, 220, 120, 40);
		simpleinfoPanel.add(patientNoLabel);
		
		patientNoText = new JTextField();
		patientNoText.setToolTipText("");
		patientNoText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientNoText.setEditable(false);
		patientNoText.setColumns(10);
		patientNoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientNoText.setBackground(Color.WHITE);
		patientNoText.setBounds(140, 220, 200, 40);
		simpleinfoPanel.add(patientNoText);
		
		healthinfoPanel = new JPanel();
		healthinfoPanel.setLayout(null);
		healthinfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790 \uAC74\uAC15 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		healthinfoPanel.setBackground(Color.WHITE);
		healthinfoPanel.setBounds(420, 360, 748, 460);
		matchingContentsPanel.add(healthinfoPanel);
		
		conditionLabel = new JLabel("\uC758\uC2DD \uC0C1\uD0DC");
		conditionLabel.setForeground(Color.BLACK);
		conditionLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		conditionLabel.setBackground(Color.WHITE);
		conditionLabel.setBounds(20, 40, 200, 40);
		healthinfoPanel.add(conditionLabel);
		
		conditionText = new JTextField();
		conditionText.setToolTipText("");
		conditionText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		conditionText.setEditable(false);
		conditionText.setColumns(10);
		conditionText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		conditionText.setBackground(Color.WHITE);
		conditionText.setBounds(220, 40, 500, 40);
		healthinfoPanel.add(conditionText);
		
		mealLabel = new JLabel("\uC2DD\uC0AC \uAC00\uB2A5 \uC5EC\uBD80");
		mealLabel.setForeground(Color.BLACK);
		mealLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mealLabel.setBackground(Color.WHITE);
		mealLabel.setBounds(20, 100, 200, 40);
		healthinfoPanel.add(mealLabel);
		
		mealText = new JTextField();
		mealText.setToolTipText("");
		mealText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mealText.setEditable(false);
		mealText.setColumns(10);
		mealText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mealText.setBackground(Color.WHITE);
		mealText.setBounds(220, 100, 500, 40);
		healthinfoPanel.add(mealText);
		
		urineLabel = new JLabel("\uB300\uC18C\uBCC0 \uD574\uACB0 \uAC00\uB2A5 \uC5EC\uBD80");
		urineLabel.setForeground(Color.BLACK);
		urineLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		urineLabel.setBackground(Color.WHITE);
		urineLabel.setBounds(20, 160, 200, 40);
		healthinfoPanel.add(urineLabel);
		
		urineText = new JTextField();
		urineText.setToolTipText("");
		urineText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		urineText.setEditable(false);
		urineText.setColumns(10);
		urineText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		urineText.setBackground(Color.WHITE);
		urineText.setBounds(220, 160, 500, 40);
		healthinfoPanel.add(urineText);
		
		paralLabel = new JLabel("\uB9C8\uBE44 \uC5EC\uBD80");
		paralLabel.setForeground(Color.BLACK);
		paralLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paralLabel.setBackground(Color.WHITE);
		paralLabel.setBounds(20, 220, 200, 40);
		healthinfoPanel.add(paralLabel);
		
		paralText = new JTextField();
		paralText.setToolTipText("");
		paralText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paralText.setEditable(false);
		paralText.setColumns(10);
		paralText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paralText.setBackground(Color.WHITE);
		paralText.setBounds(220, 220, 500, 40);
		healthinfoPanel.add(paralText);
		
		exerciseLabel = new JLabel("\uAC70\uB3D9 \uBC0F \uC6B4\uB3D9 \uC0C1\uD0DC");
		exerciseLabel.setForeground(Color.BLACK);
		exerciseLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		exerciseLabel.setBackground(Color.WHITE);
		exerciseLabel.setBounds(20, 280, 200, 40);
		healthinfoPanel.add(exerciseLabel);
		
		exerciseText = new JTextField();
		exerciseText.setToolTipText("");
		exerciseText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		exerciseText.setEditable(false);
		exerciseText.setColumns(10);
		exerciseText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		exerciseText.setBackground(Color.WHITE);
		exerciseText.setBounds(220, 280, 500, 40);
		healthinfoPanel.add(exerciseText);
		
		bedsoreLabel = new JLabel("\uC695\uCC3D \uC5EC\uBD80");
		bedsoreLabel.setForeground(Color.BLACK);
		bedsoreLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bedsoreLabel.setBackground(Color.WHITE);
		bedsoreLabel.setBounds(20, 340, 200, 40);
		healthinfoPanel.add(bedsoreLabel);
		
		bedsoreText = new JTextField();
		bedsoreText.setToolTipText("");
		bedsoreText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bedsoreText.setEditable(false);
		bedsoreText.setColumns(10);
		bedsoreText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bedsoreText.setBackground(Color.WHITE);
		bedsoreText.setBounds(220, 340, 500, 40);
		healthinfoPanel.add(bedsoreText);
		
		suctionLabel = new JLabel("\uC11D\uC158 \uD544\uC694 \uC5EC\uBD80");
		suctionLabel.setForeground(Color.BLACK);
		suctionLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		suctionLabel.setBackground(Color.WHITE);
		suctionLabel.setBounds(20, 400, 200, 40);
		healthinfoPanel.add(suctionLabel);
		
		suctionText = new JTextField();
		suctionText.setToolTipText("");
		suctionText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		suctionText.setEditable(false);
		suctionText.setColumns(10);
		suctionText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		suctionText.setBackground(Color.WHITE);
		suctionText.setBounds(220, 400, 500, 40);
		healthinfoPanel.add(suctionText);
		
		Font Lb = new Font("¸¼Àº °íµñ", Font.PLAIN, 18);
		Font cb = new Font("¸¼Àº °íµñ", Font.PLAIN, 18);
		Font bft = new Font("¸¼Àº °íµñ", Font.PLAIN, 20);
		
		eventProc();
		
		try {
			NurseMypageInfoVO vo = dao.infoSelect(myId);
			imgPathText.setText(vo.getImgPath());
			imgAddLabel.setIcon(new ImageIcon(vo.getImgPath()));
			pwText.setText(vo.getPw());
			nameText.setText(vo.getName());
			juminText.setText(vo.getJumin());
			if(vo.getSex().equals("³²ÀÚ")) {
				manBtn.setSelected(true);
			} else if(vo.getSex().equals("¿©ÀÚ")) {
				womanBtn.setSelected(true);
			}
			fromBox.setSelectedItem(vo.getFrom());
			telText.setText(vo.getTel());
			addText.setText(vo.getAdd());
			bankBox.setSelectedItem(vo.getBank());
			bankNumText.setText(vo.getBankNum());
			if(vo.getCriminal().equals("Y")) {
				criminalYBtn.setSelected(true);
			} else if(vo.getCriminal().equals("N")) {
				criminalNBtn.setSelected(true);
			}
			if(vo.getWork().equals("301")) {
				work4Btn.setSelected(true);
			} else if(vo.getWork().equals("302")) {
				work8Btn.setSelected(true);
			} else if(vo.getWork().equals("303")) {
				workAllbtn.setSelected(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
		
		careertable();
		certitable();
		skilltable();
		meetingTable();
		
	}
	
	public void eventProc() {
		imgBtn.addActionListener(this);
		matchingPanelMemberBtn.addActionListener(this);
		memberPanelMatchingbtn.addActionListener(this);
		careerAddBtn.addActionListener(this);
		certiAddBtn.addActionListener(this);
		skillAddBtn.addActionListener(this);
		careerModiBtn.addActionListener(this); 
		certiModiBtn.addActionListener(this); 
		skillModiBtn.addActionListener(this);
		careerDelBtn.addActionListener(this); 
		certiDelBtn.addActionListener(this); 
		skillDelBtn.addActionListener(this);
		logoutbtn.addActionListener(this);
		MemModiBtn.addActionListener(this);
		salarybtn.addActionListener(this);
	    schedulebtn.addActionListener(this);
	    manBtn.addActionListener(this);
	    womanBtn.addActionListener(this);
	    criminalYBtn.addActionListener(this);
	    criminalNBtn.addActionListener(this);
	    work4Btn.addActionListener(this);
	    work8Btn.addActionListener(this);
	    workAllbtn.addActionListener(this);
		careertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = careertable.getSelectedRow();
			}
		});
		certitable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = certitable.getSelectedRow();
			}
		});
		skilltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = skilltable.getSelectedRow();
			}
		});
		meetingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = meetingTable.getSelectedRow();
				patientCode = String.valueOf(meetingTable.getValueAt(row, 1));
				meetingPatientDetail(patientCode);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = idText.getText();
		int row;
		Object o = e.getSource();
		if(o == matchingPanelMemberBtn) {
		    memberPanel.setVisible(true);
		    matchingPanel.setVisible(false);
		} else if(o == memberPanelMatchingbtn) {
		    memberPanel.setVisible(false);
		    matchingPanel.setVisible(true);
		} else if(o==careerAddBtn) {
			NurseinfoCareerAddView career = new NurseinfoCareerAddView(this);
			career.setVisible(true);
		} else if(o==careerModiBtn) {
			row = careertable.getSelectedRow();
			String careerFieldName = (String)careertable.getValueAt(row, 0);
			String startDate = (String)careertable.getValueAt(row, 1);
			String endDate = (String)careertable.getValueAt(row, 2);
			String detail = (String)careertable.getValueAt(row, 3);
			try {
				int code = dao.chooseCareer(myId, careerFieldName, startDate.substring(0, 10), endDate.substring(0, 10), detail);
				NurseinfoCareerModiView career = new NurseinfoCareerModiView(code, this);
				career.setVisible(true);
				career.careercodeText.setText(code+"");
				career.careerFieldText.setText(careerFieldName);
				career.startDateText.setText(startDate.substring(0, 10));
				career.endDateText.setText(endDate.substring(0, 10));
				career.detailText.setText(detail);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "°æ·Â Á¤º¸ ¼öÁ¤ÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e1.printStackTrace();
			}
		} else if(o==careerDelBtn) {
			row = careertable.getSelectedRow();
			String careerFieldName = (String)careertable.getValueAt(row, 0);
			try {
				dao.careerDelete(id, careerFieldName);
				JOptionPane.showMessageDialog(null, "°æ·Â Á¤º¸°¡ »èÁ¦µÇ¾ú½À´Ï´Ù.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "°æ·Â Á¤º¸ »èÁ¦°¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e1.printStackTrace();
			}
			careertable();
		} else if(o==certiAddBtn) {
			NurseinfoCertiAddView certi = new NurseinfoCertiAddView(this);
			certi.setVisible(true);
		} else if(o==certiModiBtn) {
			row = certitable.getSelectedRow();
			String field = (String)certitable.getValueAt(row, 0);
			String name = (String)certitable.getValueAt(row, 1);
			String date = (String)certitable.getValueAt(row, 2);
			try {
				int code = dao.chooseCerti(myId, name);
				NurseinfoCertiModiView certiModi = new NurseinfoCertiModiView(this, code, field, name);
				certiModi.setVisible(true);
				certiModi.certicodeText.setText(code+"");
				certiModi.certiFieldBox.setSelectedItem(field);
				certiModi.certinameBox.setSelectedItem(name);
				certiModi.certiDateText.setText(date.substring(0, 10));
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "ÀÚ°ÝÁõ Á¤º¸ ¼öÁ¤ÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
		} else if(o==certiDelBtn) {
			row = certitable.getSelectedRow();
			String certiName = (String)certitable.getValueAt(row, 1);
			try {
				dao.certiDelete(id, certiName);
				JOptionPane.showMessageDialog(null, "ÀÚ°ÝÁõ Á¤º¸°¡ »èÁ¦µÇ¾ú½À´Ï´Ù.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "ÀÚ°ÝÁõ Á¤º¸ »èÁ¦°¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e1.printStackTrace();
			}
			certitable();
		} else if(o==skillAddBtn) {
			NurseinfoSkillAddView skill = new NurseinfoSkillAddView(this);
			skill.setVisible(true);
		} else if(o==skillModiBtn) {
			row = skilltable.getSelectedRow();
			String field = (String)skilltable.getValueAt(row, 0);
			String name = (String)skilltable.getValueAt(row, 1);
			try {
				int code = dao.chooseSkill(myId, name);
				NurseinfoSkillModiView skillModi = new NurseinfoSkillModiView(this, code, field, name);
				skillModi.setVisible(true);
				skillModi.skillcodeText.setText(code+"");
				skillModi.skillFieldBox.setSelectedItem(field);
				skillModi.skillnameBox.setSelectedItem(name);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸ ¼öÁ¤ÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
		} else if(o==skillDelBtn) {
			row = skilltable.getSelectedRow();
			String skillName = (String)skilltable.getValueAt(row, 1);
			try {
				dao.skillDelete(id, skillName);
				JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸°¡ »èÁ¦µÇ¾ú½À´Ï´Ù.");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸ »èÁ¦°¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e1.printStackTrace();
			}
			skilltable();
		} else if(o==logoutbtn) {
			frame.setVisible(false);
		} else if(o==MemModiBtn) {
			String imgPath, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal, work;
			imgPath = imgPathText.getText();
			pw = pwText.getText();
			name = nameText.getText();
			jumin = juminText.getText();
			if(manBtn.isSelected()) {
				sex = manBtn.getText();
			} else if(womanBtn.isSelected()) {
				sex = womanBtn.getText();
			} else {
	            JOptionPane.showMessageDialog(null, "¼ºº°À» ¼±ÅÃÇØÁÖ¼¼¿ä.");
	            return;
	        }
			from = (String)fromBox.getSelectedItem();
			tel = telText.getText();
			add = addText.getText();
			bank = (String)bankBox.getSelectedItem();
			bankNum = bankNumText.getText();
			if(criminalYBtn.isSelected()) {
				JOptionPane.showMessageDialog(null, "¹üÁË °æ·ÂÀÌ Á¸ÀçÇÒ °æ¿ì Áö¿ø ºÒ°¡ÇÕ´Ï´Ù.");
				return;
			} else if(criminalNBtn.isSelected()) {
				criminal = "N";
			} else {
	            JOptionPane.showMessageDialog(null, "¹üÁË °æ·ÂÀÌ Á¸ÀçÇÒ °æ¿ì Áö¿ø ºÒ°¡ÇÕ´Ï´Ù.");
	            return;
	        }
			if(work4Btn.isSelected()) {
				work = "301";
			} else if(work8Btn.isSelected()) {
				work = "302";
			} else if(workAllbtn.isSelected()) {
				work = "303";
			} else {
	            JOptionPane.showMessageDialog(null, "Èñ¸Á ±Ù¹« À¯ÇüÀ» ¼±ÅÃÇØÁÖ¼¼¿ä.");
	            return;
	        }
			NurseMypageInfoVO vo = new NurseMypageInfoVO(imgPath, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal, work);
			try {
				dao.infoUpdate(id, vo);
				JOptionPane.showMessageDialog(null,name+" ´ÔÀÇ È¸¿ø ±âº» Á¤º¸°¡ ¼öÁ¤µÇ¾ú½À´Ï´Ù.");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "È¸¿ø ±âº» Á¤º¸ ¼öÁ¤¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
				return;
			}
		} else if (o == salarybtn) {
			NurseSalView sal = new NurseSalView(myId);
			JFrame nurseFrame = new JFrame("±Þ¿©°ü¸®");
			nurseFrame.getContentPane().add(sal);
			nurseFrame.setSize(1215, 935);
			nurseFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			nurseFrame.setLocation(680, 285);
			nurseFrame.setVisible(true);
	    } else if (o == schedulebtn) {
			NurseScheduleView sv = new NurseScheduleView(myId);
			JFrame nurseFrame = new JFrame("½ºÄÉÁÙ");
			nurseFrame.getContentPane().add(sv);
			nurseFrame.setSize(1215, 935);
			nurseFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			nurseFrame.setLocation(680, 285);
			nurseFrame.setVisible(true);
	    } else if(o==manBtn) {
			womanBtn.setSelected(false);
		} else if(o==womanBtn) {
			manBtn.setSelected(false);
		} else if(o==criminalYBtn) {
			criminalNBtn.setSelected(false);
		} else if(o==criminalNBtn) {
			criminalYBtn.setSelected(false);
		} else if(o==work4Btn) {
			work8Btn.setSelected(false);
			workAllbtn.setSelected(false);
		} else if(o==work8Btn) {
			work4Btn.setSelected(false);
			workAllbtn.setSelected(false);
		} else if(o==workAllbtn) {
			work4Btn.setSelected(false);
			work8Btn.setSelected(false);
		} else if(o==imgBtn) {
			File selectedImg=null;
			JFileChooser fc;
			fc = new JFileChooser();
			int imgValue = fc.showOpenDialog(null);
			if(imgValue==JFileChooser.APPROVE_OPTION) {
				selectedImg = fc.getSelectedFile();
				String imgPath = selectedImg.getAbsolutePath();
				imgAddLabel.setIcon(new ImageIcon(imgPath));
				imgPathText.setText(imgPath);
			} 
		}
	}
	
	void careertable() {
		try {
			ArrayList list = dao.careerselect(myId);
			careerList.data = list;
			careertable.setModel(careerList);
			careerList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void certitable() {
		try {
			ArrayList list = dao.certiselect(myId);
			certiList.data = list;
			certitable.setModel(certiList);
			certiList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void skilltable() {
		try {
			ArrayList list = dao.skillselect(myId);
			skillList.data = list;
			skilltable.setModel(skillList);
			skillList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void meetingTable() {
		try {
			ArrayList list = dao.meetingInfoSelect(myId);
			meetingList.data = list;
			meetingTable.setModel(meetingList);
			meetingList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void meetingPatientDetail(String patientCode) {
		try {
			NurseMypageInfoVO vo = dao.meetingPatientDetailSelect(patientCode);
			patientNameText.setText(vo.getPtname());
			patientSexText.setText(vo.getPtsex());
			patientDiagText.setText(vo.getPtdiagname());
			patientNoText.setText(vo.getPtcrno());
			conditionText.setText(vo.getPtcondition());
			mealText.setText(vo.getPtmeal());
			urineText.setText(vo.getPturine());
			paralText.setText(vo.getPtparal());
			exerciseText.setText(vo.getPtexercise());
			bedsoreText.setText(vo.getPtbedsore());
			suctionText.setText(vo.getPtsuction());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	class CareerListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"°æ·Â ºÐ¾ß","½ÃÀÛ ÀÏÀÚ","Á¾·á ÀÏÀÚ", "»ó¼¼ ³»¿ë"};
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
	
	class CertiListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"ÀÚ°ÝÁõ Á¾·ù","ÀÚ°ÝÁõ ¸í", "ÃëµæÀÏ"};
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
	
	class SkillListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"±â¼ú Á¾·ù","±â¼ú ¸í"};
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
	
	class meetingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"¸éÁ¢ ÄÚµå", "È¯ÀÚ ÄÚµå", "È¯ÀÚ ÀÌ¸§", "´ã´çÀÚ ÀÌ¸§", "´ã´çÀÚ ÀüÈ­¹øÈ£", "¸éÁ¢ ¿äÃ» ÀÏÀÚ"};
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
