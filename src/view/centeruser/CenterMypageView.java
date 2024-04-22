package view.centeruser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.centeruserDAO.CenterMypageDAO;
import vo.centeruserVO.CenterMypageVO;

public class CenterMypageView implements ActionListener {

	public JFrame frame;
	private final JPanel menuPanel = new JPanel();
	public JTextField idText, pwText, nameText, telText, patientSearchText;
	private JPanel memberPanel, counselPanel;
	JComboBox patientSearchBox;
	JButton modiBtn;
	String id, patientCode;
	CenterMypageDAO dao;
	PatientSimpleListTable patientSimpleList;
	SubGuardianSimpleListTable subGuardianSimpleList;
	GuardianSimpleListTable guardianSimpleList;
	JTable patientSimpleTable, subGuardianSimpleTable, guardianSimpleTable;
	JButton visitaddBtn, visitmodiBtn, visitdelBtn;
	JTextArea visitmeetingDetailText, detailConsultingInfoText;
	JTable consultingTable;
	consultingListTable consultingList;
	String consultingCode;
	JTable visitMeetingTable;
	visitMeetingListTable visitMeetingList;
	String visitMeetingCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CenterMypageView window = new CenterMypageView();
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
	public CenterMypageView() {
		initialize();
	}

	public CenterMypageView(String id) {
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		frame = new JFrame();
		frame.setTitle("\uC694\uC591 \uC13C\uD130 \uBA54\uC778\uD398\uC774\uC9C0");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(570, 250);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\workspaces\\img\\NurseLogoMain.png"));
		lblNewLabel_3.setBounds(0, 0, 195, 165);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel_18.setBackground(new Color(255, 228, 225));
		lblNewLabel_18.setBounds(0, 890, 1384, 70);
		frame.getContentPane().add(lblNewLabel_18);
		menuPanel.setBackground(new Color(255, 228, 225));
		menuPanel.setBounds(0, 0, 195, 961);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);

		Font buttonFont = new Font("맑은 고딕", Font.PLAIN, 20);

		Font bf = new Font("맑은 고딕", Font.PLAIN, 14);

		JButton btnNewButton = new JButton("전체회원정보");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(0, 235, 195, 70);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		menuPanel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMatchView();
			}

			private void openMatchView() {
				CenterMemberSearchView cmv = new CenterMemberSearchView();
				JFrame memFrame = new JFrame("전체회원정보");
				memFrame.getContentPane().add(cmv);
				memFrame.setSize(1215, 935);
				memFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				memFrame.setLocation(680, 285);
				memFrame.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("스케줄");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1.setBounds(0, 375, 195, 70);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		menuPanel.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openScheduleView();
			}

			private void openScheduleView() {
				CenterScheduleView csv = new CenterScheduleView(id);

				JFrame scheduleFrame = new JFrame("스케줄");
				scheduleFrame.getContentPane().add(csv);
				scheduleFrame.setSize(1215, 935);
				scheduleFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				scheduleFrame.setLocation(680, 285);
				scheduleFrame.setVisible(true);
			}
		});

		JButton btnNewButton_2 = new JButton("마이페이지");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(0, 165, 195, 70);
		menuPanel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\uD68C\uACC4\uAD00\uB9AC");
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_3.setBounds(0, 445, 195, 70);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.BLACK);
		menuPanel.add(btnNewButton_3);

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPayView();
			}

			private void openPayView() {
				CenterPayView cpv = new CenterPayView(id);

				JFrame moneyFrame = new JFrame("회계관리");
				moneyFrame.getContentPane().add(cpv);
				moneyFrame.setSize(1215, 935);
				moneyFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				moneyFrame.setLocation(680, 285);
				moneyFrame.setVisible(true);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 283, 165);
		menuPanel.add(lblNewLabel_1);

		JButton btnNewButton_4 = new JButton("\uB9E4\uCE6D\uAD00\uB9AC");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.setBounds(0, 305, 195, 70);
		menuPanel.add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPayView();
			}

			private void openPayView() {
				MatchingView mpv = new MatchingView(id);

				JFrame matchFrame = new JFrame("매칭관리");
				matchFrame.getContentPane().add(mpv);
				matchFrame.setSize(1215, 935);
				matchFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				matchFrame.setLocation(680, 285);
				matchFrame.setVisible(true);
			}
		});
		
		JButton btnNewButton_11 = new JButton("로그아웃");
		btnNewButton_11.setBounds(0, 820, 195, 70);
		btnNewButton_11.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setBackground(Color.BLACK);
		menuPanel.add(btnNewButton_11);

		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}

			private void logout() {
				frame.setVisible(false);
			}
		});

		Font Lb = new Font("맑은 고딕", Font.PLAIN, 18);
		Font cb = new Font("맑은 고딕", Font.PLAIN, 18);
		Font bft = new Font("맑은 고딕", Font.PLAIN, 20);

//// 계정 정보 멤버 패널		
		memberPanel = new JPanel();
		memberPanel.setBounds(193, 0, 1191, 891);
		frame.getContentPane().add(memberPanel);
		memberPanel.setBackground(new Color(255, 255, 255));
		memberPanel.setLayout(null);

		JButton btnNewButton_5_1 = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		btnNewButton_5_1.setForeground(Color.BLACK);
		btnNewButton_5_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_5_1.setBackground(Color.WHITE);
		btnNewButton_5_1.setBounds(0, 0, 180, 70);
		memberPanel.add(btnNewButton_5_1);

		JButton btnNewButton_6_1 = new JButton("\uC0C1\uB2F4\uB0B4\uC5ED");
		btnNewButton_6_1.setForeground(Color.WHITE);
		btnNewButton_6_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_6_1.setBackground(Color.BLACK);
		btnNewButton_6_1.setBounds(179, 0, 180, 70);
		memberPanel.add(btnNewButton_6_1);

		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCounselView(); // counselPanel을 열기 위한 메서드 호출
			}

			private void openCounselView() {
				counselPanel.setVisible(true); // counselPanel을 화면에 표시
				memberPanel.setVisible(false);
			}
		});

		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		idLabel.setBounds(30, 300, 150, 40);
		memberPanel.add(idLabel);

		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		pwLabel.setBounds(30, 370, 150, 40);
		memberPanel.add(pwLabel);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		nameLabel.setBounds(30, 440, 150, 40);
		memberPanel.add(nameLabel);

		JLabel telLabel = new JLabel("전화번호");
		telLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		telLabel.setBounds(30, 510, 150, 40);
		memberPanel.add(telLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idText.setColumns(10);
		idText.setBounds(180, 300, 250, 40);
		memberPanel.add(idText);

		pwText = new JTextField();
		pwText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwText.setColumns(10);
		pwText.setBounds(180, 370, 250, 40);
		memberPanel.add(pwText);

		nameText = new JTextField();
		nameText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameText.setColumns(10);
		nameText.setBounds(180, 440, 250, 40);
		memberPanel.add(nameText);

		telText = new JTextField();
		telText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		telText.setColumns(10);
		telText.setBounds(180, 510, 250, 40);
		memberPanel.add(telText);

		modiBtn = new JButton("\uC218\uC815");
		modiBtn.setForeground(Color.WHITE);
		modiBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		modiBtn.setBackground(Color.BLACK);
		modiBtn.setBounds(132, 700, 200, 70);
		memberPanel.add(modiBtn);

		JLabel headLabel = new JLabel("");
		headLabel.setBounds(-193, 0, 1384, 70);
		memberPanel.add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(Color.BLACK);
		headLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));

		JPanel patientInfoPanel = new JPanel();
		patientInfoPanel.setLayout(null);
		patientInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uB2F4\uB2F9 \uD658\uC790 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		patientInfoPanel.setBackground(Color.WHITE);
		patientInfoPanel.setBounds(461, 100, 700, 740);
		memberPanel.add(patientInfoPanel);

		patientSearchBox = new JComboBox();
		patientSearchBox.setBackground(new Color(255, 255, 255));
		patientSearchBox.setModel(new DefaultComboBoxModel(new String[] {"\uD658\uC790 \uCF54\uB4DC", "\uD658\uC790 \uC774\uB984"}));
		patientSearchBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		patientSearchBox.setBounds(160, 35, 150, 30);
		patientInfoPanel.add(patientSearchBox);

		patientSearchText = new JTextField();
		patientSearchText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		patientSearchText.setColumns(10);
		patientSearchText.setBounds(320, 35, 220, 30);
		patientInfoPanel.add(patientSearchText);

		JPanel patientsimpleInfoPanel = new JPanel();
		patientsimpleInfoPanel.setLayout(null);
		patientsimpleInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uD658\uC790 \uAE30\uBCF8 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		patientsimpleInfoPanel.setBackground(Color.WHITE);
		patientsimpleInfoPanel.setBounds(21, 80, 658, 200);
		patientInfoPanel.add(patientsimpleInfoPanel);

		JScrollPane patientsimpleInfoScroll = new JScrollPane();
		patientsimpleInfoScroll.setBounds(19, 25, 620, 160);
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
		
		JPanel GuardianInfoPanel = new JPanel();
		GuardianInfoPanel.setLayout(null);
		GuardianInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790\uBCC4 \uC8FC\uBCF4\uD638\uC790 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GuardianInfoPanel.setBackground(Color.WHITE);
		GuardianInfoPanel.setBounds(21, 300, 658, 200);
		patientInfoPanel.add(GuardianInfoPanel);
		
		JScrollPane GuardianInfoScroll = new JScrollPane();
		GuardianInfoScroll.setBounds(19, 25, 620, 160);
		GuardianInfoPanel.add(GuardianInfoScroll);
		
		guardianSimpleList = new GuardianSimpleListTable();
		guardianSimpleTable = new JTable(guardianSimpleList);
		guardianSimpleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		GuardianInfoScroll.setViewportView(guardianSimpleTable);
		
		guardianSimpleTable.setRowHeight(20);
		guardianSimpleTable.setBackground(Color.WHITE);
		guardianSimpleTable.setSelectionBackground(new Color(255, 228, 225));
		GuardianInfoScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < guardianSimpleTable.getColumnCount(); i++) {
			guardianSimpleTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel subGuardianInfoPanel = new JPanel();
		subGuardianInfoPanel.setLayout(null);
		subGuardianInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uD658\uC790\uBCC4 \uBD80\uBCF4\uD638\uC790 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		subGuardianInfoPanel.setBackground(Color.WHITE);
		subGuardianInfoPanel.setBounds(21, 520, 658, 200);
		patientInfoPanel.add(subGuardianInfoPanel);

		JScrollPane subGuardianInfoScroll = new JScrollPane();
		subGuardianInfoScroll.setBounds(19, 25, 620, 160);
		subGuardianInfoPanel.add(subGuardianInfoScroll);
		
		subGuardianSimpleList = new SubGuardianSimpleListTable();
		subGuardianSimpleTable = new JTable(subGuardianSimpleList);
		subGuardianSimpleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		subGuardianInfoScroll.setViewportView(subGuardianSimpleTable);
		
		subGuardianSimpleTable.setRowHeight(20);
		subGuardianSimpleTable.setBackground(Color.WHITE);
		subGuardianSimpleTable.setSelectionBackground(new Color(255, 228, 225));
		subGuardianInfoScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < subGuardianSimpleTable.getColumnCount(); i++) {
			subGuardianSimpleTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}

//// 상담 내역 카운슬 패널
		counselPanel = new JPanel();
		counselPanel.setBackground(new Color(255, 255, 255));
		counselPanel.setBounds(193, 0, 1191, 891);
		frame.getContentPane().add(counselPanel);
		counselPanel.setLayout(null);

		JButton btnNewButton_5_1_1 = new JButton("회원정보");
		btnNewButton_5_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_5_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_5_1_1.setBackground(new Color(0, 0, 0));
		btnNewButton_5_1_1.setBounds(0, 0, 180, 70);
		counselPanel.add(btnNewButton_5_1_1);

		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMemberView(); // memberPanel을 열기 위한 메서드 호출
			}

			private void openMemberView() {
				memberPanel.setVisible(true); // memberPanel을 화면에 표시
				counselPanel.setVisible(false);
			}
		});

		JButton btnNewButton_6_1_1 = new JButton("상담내역");
		btnNewButton_6_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_6_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_6_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_6_1_1.setBounds(179, 0, 180, 70);
		counselPanel.add(btnNewButton_6_1_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setOpaque(true);
		lblNewLabel_4_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_4_1_1.setBackground(new Color(255, 228, 225));
		lblNewLabel_4_1_1.setBounds(-193, 0, 1384, 70);
		counselPanel.add(lblNewLabel_4_1_1);
		
		JPanel visitmeetingInfoPanel = new JPanel();
		visitmeetingInfoPanel.setLayout(null);
		visitmeetingInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uBC29\uBB38 \uC0C1\uB2F4 \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		visitmeetingInfoPanel.setBackground(Color.WHITE);
		visitmeetingInfoPanel.setBounds(25, 110, 730, 350);
		counselPanel.add(visitmeetingInfoPanel);
		
		JScrollPane visitmeetingInfoScroll = new JScrollPane();
		visitmeetingInfoScroll.setBounds(15, 65, 700, 260);
		visitmeetingInfoPanel.add(visitmeetingInfoScroll);
		
		visitMeetingList = new visitMeetingListTable();
		visitMeetingTable = new JTable(visitMeetingList);
		visitMeetingTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		visitmeetingInfoScroll.setViewportView(visitMeetingTable);
		
		visitMeetingTable.setRowHeight(20);
		visitMeetingTable.setBackground(Color.WHITE);
		visitMeetingTable.setSelectionBackground(new Color(255, 228, 225));
		visitmeetingInfoScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < visitMeetingTable.getColumnCount(); i++) {
			visitMeetingTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		visitaddBtn = new JButton("+");
		visitaddBtn.setForeground(Color.WHITE);
		visitaddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		visitaddBtn.setBackground(Color.BLACK);
		visitaddBtn.setBounds(520, 25, 50, 30);
		visitmeetingInfoPanel.add(visitaddBtn);
		
		visitmodiBtn = new JButton("\uC218\uC815");
		visitmodiBtn.setForeground(Color.WHITE);
		visitmodiBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		visitmodiBtn.setBackground(Color.BLACK);
		visitmodiBtn.setBounds(580, 25, 75, 30);
		visitmeetingInfoPanel.add(visitmodiBtn);
		
		visitdelBtn = new JButton("-");
		visitdelBtn.setForeground(Color.WHITE);
		visitdelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		visitdelBtn.setBackground(Color.BLACK);
		visitdelBtn.setBounds(665, 25, 50, 30);
		visitmeetingInfoPanel.add(visitdelBtn);
		
		JPanel visitmeetingDetailPanel = new JPanel();
		visitmeetingDetailPanel.setLayout(null);
		visitmeetingDetailPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC0C1\uC138 \uC0C1\uB2F4 \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		visitmeetingDetailPanel.setBackground(Color.WHITE);
		visitmeetingDetailPanel.setBounds(776, 110, 390, 350);
		counselPanel.add(visitmeetingDetailPanel);
		
		visitmeetingDetailText = new JTextArea();
		visitmeetingDetailText.setLineWrap(true);
		visitmeetingDetailText.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		visitmeetingDetailText.setEditable(false);
		visitmeetingDetailText.setBounds(15, 25, 360, 300);
		visitmeetingDetailPanel.add(visitmeetingDetailText);
		
		JPanel consultingInfoPanel = new JPanel();
		consultingInfoPanel.setLayout(null);
		consultingInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC77C\uBC18 \uC0C1\uB2F4 \uC694\uCCAD \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		consultingInfoPanel.setBackground(Color.WHITE);
		consultingInfoPanel.setBounds(25, 500, 730, 350);
		counselPanel.add(consultingInfoPanel);
		
		JScrollPane consultingInfoScroll = new JScrollPane();
		consultingInfoScroll.setBounds(15, 25, 700, 300);
		consultingInfoPanel.add(consultingInfoScroll);
		
		consultingList = new consultingListTable();
		consultingTable = new JTable(consultingList);
		consultingTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		consultingInfoScroll.setViewportView(consultingTable);
		
		consultingTable.setRowHeight(20);
		consultingTable.setBackground(Color.WHITE);
		consultingTable.setSelectionBackground(new Color(255, 228, 225));
		consultingInfoScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < consultingTable.getColumnCount(); i++) {
			consultingTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel detailConsultingInfoPanel = new JPanel();
		detailConsultingInfoPanel.setLayout(null);
		detailConsultingInfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "상세 상담 요청 내역", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		detailConsultingInfoPanel.setBackground(Color.WHITE);
		detailConsultingInfoPanel.setBounds(776, 500, 390, 350);
		counselPanel.add(detailConsultingInfoPanel);
		
		detailConsultingInfoText = new JTextArea();
		detailConsultingInfoText.setLineWrap(true);
		detailConsultingInfoText.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		detailConsultingInfoText.setEditable(false);
		detailConsultingInfoText.setBounds(15, 25, 360, 300);
		detailConsultingInfoPanel.add(detailConsultingInfoText);
		

		try {
			CenterMypageVO vo = dao.getCenterInfo(id);
			pwText.setText(vo.getCnpw());
			nameText.setText(vo.getCnname());
			telText.setText(vo.getCntel());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
		
		eventproc();
		
		patientSimpleTable();
		guardianSimpleTable();
		subGuardianSimpleTable();
		
		visitMeetingTable();
		consultingTable();
		
	}
	
	public void eventproc() {
		modiBtn.addActionListener(this);
		patientSearchText.addActionListener(this);
		patientSimpleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = patientSimpleTable.getSelectedRow();
				patientCode = String.valueOf(patientSimpleTable.getValueAt(row, 0));
				patientDetail(patientCode);
			}
		});
		consultingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = consultingTable.getSelectedRow();
				consultingCode = String.valueOf(consultingTable.getValueAt(row, 0));
				consultingDetail(consultingCode);
			}
		});
		visitMeetingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = visitMeetingTable.getSelectedRow();
				visitMeetingCode = String.valueOf(visitMeetingTable.getValueAt(row, 0));
				visitMeetingDetail(visitMeetingCode);
			}
		});
		visitaddBtn.addActionListener(this);
		visitmodiBtn.addActionListener(this);
		visitdelBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==modiBtn) {
			CenterMypageVO vo = new CenterMypageVO();
			vo.setCnid(id);
			vo.setCnpw(pwText.getText());
			vo.setCnname(nameText.getText());
			vo.setCntel(telText.getText());
			try {
				dao.infoUpdate(vo);
				JOptionPane.showMessageDialog(null, nameText.getText()+" 님의 회원 기본 정보가 수정되었습니다.");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "회원 기본 정보 수정에 실패하였습니다.");
				e2.printStackTrace();
			}
		} else if(o==patientSearchText) {
			patientSearch();
		} else if(o==visitaddBtn) {
			VisitMeetingAddView vm = new VisitMeetingAddView(this, id);
			JFrame VisitMeetingAddViewFrame = new JFrame("방문 상담");
			VisitMeetingAddViewFrame.getContentPane().add(vm);
			VisitMeetingAddViewFrame.setSize(1215, 935);
			VisitMeetingAddViewFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			VisitMeetingAddViewFrame.setLocation(680, 285);
			VisitMeetingAddViewFrame.setVisible(true);
		} else if(o==visitmodiBtn) {
			VisitMeetingModiView vm = new VisitMeetingModiView(this, id, visitMeetingCode);
			JFrame VisitMeetingModiViewFrame = new JFrame("방문 상담 수정");
			VisitMeetingModiViewFrame.getContentPane().add(vm);
			VisitMeetingModiViewFrame.setSize(1215, 935);
			VisitMeetingModiViewFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			VisitMeetingModiViewFrame.setLocation(680, 285);
			VisitMeetingModiViewFrame.setVisible(true);
		} else if(o==visitdelBtn) {
			try {
				dao.visitmeetingDelete(visitMeetingCode);
				JOptionPane.showMessageDialog(null, "방문 상담 내역이 삭제되었습니다.");
				visitMeetingTable();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "방문 상담 내역 삭제가 실패하였습니다.");
				e2.printStackTrace();
			}
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
	
	void patientDetail(String patientCode) {
		try {
			ArrayList list1 = dao.guardianSearch(patientCode);
			guardianSimpleList.data = list1;
			guardianSimpleTable.setModel(guardianSimpleList);
			guardianSimpleList.fireTableDataChanged();
			
			ArrayList list2 = dao.subGuardianSearch(patientCode);
			subGuardianSimpleList.data = list2;
			subGuardianSimpleTable.setModel(subGuardianSimpleList);
			subGuardianSimpleList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
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
	
	void guardianSimpleTable() {
		try {
			ArrayList list = dao.guardianSimpleSelect(id);
			guardianSimpleList.data = list;
			guardianSimpleTable.setModel(guardianSimpleList);
			guardianSimpleList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void subGuardianSimpleTable() {
		try {
			ArrayList list = dao.subGuardianSimpleSelect(id);
			subGuardianSimpleList.data = list;
			subGuardianSimpleTable.setModel(subGuardianSimpleList);
			subGuardianSimpleList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void consultingTable() {
		try {
			ArrayList list = dao.consultingSelect(id);
			consultingList.data = list;
			consultingTable.setModel(consultingList);
			consultingList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void visitMeetingTable() {
		try {
			ArrayList list = dao.visitMeetingSelect(id);
			visitMeetingList.data = list;
			visitMeetingTable.setModel(visitMeetingList);
			visitMeetingList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void consultingDetail(String consultingCode) {
		try {
			String content = dao.consultingDetailSelect(consultingCode);
			detailConsultingInfoText.setText(content);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	void visitMeetingDetail(String visitMeetingCode) {
		try {
			String content = dao.visitMeetingDetailSelect(visitMeetingCode);
			visitmeetingDetailText.setText(content);
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
	
	class GuardianSimpleListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"환자 코드", "주보호자 이름", "주보호자 주소", "주보호자 전화번호", "환자와의 관계"};
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
	
	class SubGuardianSimpleListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"환자 코드", "부보호자 이름", "부보호자 주소", "부보호자 전화번호", "환자와의 관계"};
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
	
	class consultingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"상담 코드", "환자 코드", "환자 이름", "주보호자 이름", "주보호자 전화번호", "상담 요청 일자"};
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
	
	class visitMeetingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"상담 코드", "환자 코드", "환자 이름", "환자 주소", "주보호자 이름", "방문 일자"};
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
