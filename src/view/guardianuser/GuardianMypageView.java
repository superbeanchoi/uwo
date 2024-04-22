package view.guardianuser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.guardianuserDAO.GuardianMypageInfoDAO;
import vo.guardianuserVO.GuardianMypageInfoVO;

public class GuardianMypageView extends JPanel implements ActionListener {

	public static GuardianMypageView window;
	public JFrame frame;
	private final JPanel panel = new JPanel();
	public JTextField textField_6, textField_7, textField_8, textField_9, textField_10, textField_11;
	JCheckBox chckbxNewCheckBox_2, chckbxNewCheckBox_1_1;
	JButton btnNewButton_4;
	private JButton btnNewButton_1, btnNewButton_6_1, btnNewButton_5_1_2, btnNewButton_7_1, btnNewButton_8_1,
			btnNewButton_10_1_1_1, btnNewButton_9_1, btnNewButton_10_1, btnNewButton_10_1_1;
	private JPanel MatchingPanel, memberPanel; // 필드로 변경
	private boolean isMale, isFemale; // 여성 여부를 나타내는 변수
	GuardianMypageInfoDAO dao;
	GuardianMypageInfoVO vo;
	String mg_id;
	private JTable table, table_1;
	PatientListTable patientList;
	JTable patienttable;
	subGuardianListTable subGuardianList;
	JTable subGuardiantable;

	String subGuardianCode;
	String patientCode;

	JPanel meetingInfoPanel, NurseInfoPanel, consultingInfoPanel, detailConsultingInfoPanel;
	JLabel imgLabel;
	private JTextField nameText, sexText, surviceText;
	JTextArea detailMeetingInfoText, detailConsultingInfoText;
	JTable meetingTable;
	meetingListTable meetingList;
	String meetingCode;
	JTable consultingTable;
	consultingListTable consultingList;
	String consultingCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GuardianMypageView();
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
	public GuardianMypageView() {
		initialize();
		textField_6.setText(mg_id);
	}

	public GuardianMypageView(String id) {
		mg_id = id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		try {
			dao = new GuardianMypageInfoDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		vo = new GuardianMypageInfoVO();

		frame = new JFrame();
		frame.setTitle("\uBCF4\uD638\uC790 \uB9C8\uC774\uD398\uC774\uC9C0");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1400, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 0, 195, 961);
		frame.getContentPane().add(panel);
		frame.setLocation(570, 250);
		panel.setLayout(null);

		Font buttonFont = new Font("맑은 고딕", Font.PLAIN, 20);

		Font bf = new Font("맑은 고딕", Font.PLAIN, 14);

		JButton btnNewButton = new JButton("스케줄");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setBounds(0, 235, 195, 70);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "환자정보 추가" 버튼이 클릭되었을 때 실행되는 코드
				openPatientView(); // PatientView를 열기 위한 메서드 호출
			}

			private void openPatientView() {
				// TODO Auto-generated method stub
				GuardianScheduleView sv = new GuardianScheduleView(mg_id);

				// 팝업 창 또는 새로운 창으로 PatientView를 표시
				// 여기서는 새로운 JFrame으로 표시하는 예시를 들었습니다.
				JFrame patientFrame = new JFrame("스케줄");
				patientFrame.getContentPane().add(sv);
				patientFrame.setSize(1215, 935);
				patientFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				patientFrame.setLocation(680, 285);
				patientFrame.setVisible(true);
			}
		});

		btnNewButton_1 = new JButton("요양보호사 검색");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_1.setBounds(0, 305, 195, 70);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("마이페이지");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(0, 165, 195, 70);
		panel.add(btnNewButton_2);

		btnNewButton_4 = new JButton("\uC0C1\uB2F4\uC694\uCCAD");
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_4.setBounds(0, 375, 195, 70);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.BLACK);
		panel.add(btnNewButton_4);

		JButton btnNewButton_11 = new JButton("로그아웃");
		btnNewButton_11.setBounds(0, 820, 195, 70);
		btnNewButton_11.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setBackground(Color.BLACK);
		panel.add(btnNewButton_11);

		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "로그아웃" 버튼이 클릭되었을 때 실행되는 코드
				logout(); // 로그아웃 메서드 호출
			}

			private void logout() {
				frame.setVisible(false);
			}
		});

		JButton btnNewButton_13 = new JButton("\uACB0\uC81C\uAD00\uB9AC");
		btnNewButton_13.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.setBackground(new Color(0, 0, 0));
		btnNewButton_13.setBounds(0, 445, 195, 70);
		panel.add(btnNewButton_13);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\workspaces\\img\\NurseLogoMain.png"));
		lblNewLabel.setBounds(0, 0, 195, 165);
		panel.add(lblNewLabel);

		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "환자정보 추가" 버튼이 클릭되었을 때 실행되는 코드
				openPayMentView(); // PatientView를 열기 위한 메서드 호출
			}

			private void openPayMentView() {
				// TODO Auto-generated method stub
				GuradianPaymentView pm = new GuradianPaymentView(mg_id);

				// 여기서는 새로운 JFrame으로 표시하는 예시를 들었습니다.
				JFrame patientFrame = new JFrame("결제관리");
				patientFrame.getContentPane().add(pm);
				patientFrame.setSize(1215, 935);
				patientFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				patientFrame.setLocation(680, 285);
				patientFrame.setVisible(true);
			}
		});

		Font Lb = new Font("맑은 고딕", Font.PLAIN, 18);
		Font cb = new Font("맑은 고딕", Font.PLAIN, 18);
		Font bft = new Font("맑은 고딕", Font.PLAIN, 20);

		memberPanel = new JPanel();
		memberPanel.setBackground(new Color(255, 255, 255));
		memberPanel.setBounds(194, 0, 1190, 961);
		frame.getContentPane().add(memberPanel);
		memberPanel.setLayout(null);

		JButton btnNewButton_5_1 = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		btnNewButton_5_1.setBounds(0, 0, 180, 70);
		btnNewButton_5_1.setForeground(new Color(0, 0, 0));
		btnNewButton_5_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_5_1.setBackground(new Color(255, 255, 255));
		memberPanel.add(btnNewButton_5_1);

		JButton btnNewButton_6_1 = new JButton("\uD65C\uB3D9\uB0B4\uC5ED");
		btnNewButton_6_1.setBounds(180, 0, 180, 70);
		btnNewButton_6_1.setForeground(Color.WHITE);
		btnNewButton_6_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_6_1.setBackground(Color.BLACK);
		memberPanel.add(btnNewButton_6_1);

		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMatchingView(); // MatchingPanel을 열기 위한 메서드 호출
			}

			private void openMatchingView() {
				MatchingPanel.setVisible(true); // MatchingPanel을 화면에 표시
				memberPanel.setVisible(false);
			}
		});

		JLabel lblNewLabel_7 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_7.setBounds(70, 230, 80, 40);
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_7);

		JLabel lblNewLabel_1_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1_1.setBounds(70, 290, 80, 40);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("\uC774\uB984");
		lblNewLabel_2_1.setBounds(70, 350, 80, 40);
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_3_1.setBounds(70, 410, 80, 40);
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_4_1.setBounds(70, 470, 80, 40);
		lblNewLabel_4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_5_1.setBounds(70, 530, 80, 40);
		lblNewLabel_5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_5_1);

		JLabel lblNewLabel_6_1 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_6_1.setBounds(70, 590, 80, 40);
		lblNewLabel_6_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		memberPanel.add(lblNewLabel_6_1);

		chckbxNewCheckBox_2 = new JCheckBox("\uB0A8\uC790");
		chckbxNewCheckBox_2.setBounds(200, 470, 120, 40);
		chckbxNewCheckBox_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		memberPanel.add(chckbxNewCheckBox_2);

		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isMale = chckbxNewCheckBox_2.isSelected();
				isFemale = !isMale;
				chckbxNewCheckBox_1_1.setSelected(false);
			}
		});

		chckbxNewCheckBox_1_1 = new JCheckBox("\uC5EC\uC790");
		chckbxNewCheckBox_1_1.setBounds(340, 470, 120, 40);
		chckbxNewCheckBox_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		chckbxNewCheckBox_1_1.setBackground(Color.WHITE);
		memberPanel.add(chckbxNewCheckBox_1_1);

		chckbxNewCheckBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isFemale = chckbxNewCheckBox_1_1.isSelected();
				isMale = !isFemale;
				chckbxNewCheckBox_2.setSelected(false);
			}
		});

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_6.setBounds(200, 230, 300, 40);
		textField_6.setColumns(10);
		memberPanel.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_7.setBounds(200, 290, 300, 40);
		textField_7.setColumns(10);
		memberPanel.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_8.setBounds(200, 350, 300, 40);
		textField_8.setColumns(10);
		memberPanel.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_9.setBounds(200, 410, 300, 40);
		textField_9.setColumns(10);
		memberPanel.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_10.setBounds(200, 530, 300, 40);
		textField_10.setColumns(10);
		memberPanel.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_11.setBounds(200, 590, 300, 40);
		textField_11.setColumns(10);
		memberPanel.add(textField_11);

		btnNewButton_7_1 = new JButton("+");
		btnNewButton_7_1.setBounds(925, 175, 50, 30);
		btnNewButton_7_1.setForeground(Color.WHITE);
		btnNewButton_7_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_7_1.setBackground(Color.BLACK);
		memberPanel.add(btnNewButton_7_1);

		btnNewButton_8_1 = new JButton("\uC218\uC815");
		btnNewButton_8_1.setBounds(985, 175, 75, 30);
		btnNewButton_8_1.setForeground(Color.WHITE);
		btnNewButton_8_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_8_1.setBackground(Color.BLACK);
		memberPanel.add(btnNewButton_8_1);

		btnNewButton_10_1_1_1 = new JButton("-");
		btnNewButton_10_1_1_1.setForeground(Color.WHITE);
		btnNewButton_10_1_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_10_1_1_1.setBackground(Color.BLACK);
		btnNewButton_10_1_1_1.setBounds(1070, 175, 50, 30);
		memberPanel.add(btnNewButton_10_1_1_1);

		JLabel careerLabel = new JLabel("\uD658\uC790 \uC815\uBCF4");
		careerLabel.setForeground(Color.BLACK);
		careerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		careerLabel.setBackground(Color.WHITE);
		careerLabel.setBounds(570, 160, 150, 40);
		memberPanel.add(careerLabel);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(570, 215, 550, 150);
		memberPanel.add(panel_1_1);
		panel_1_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 550, 150);
		panel_1_1.add(scrollPane);

		patientList = new PatientListTable();
		patienttable = new JTable(patientList);
		patienttable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(patienttable);
		
		patienttable.setRowHeight(20);
		patienttable.setBackground(Color.WHITE);
		patienttable.setSelectionBackground(new Color(255, 228, 225));
		scrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patienttable.getColumnCount(); i++) {
			patienttable.getColumnModel().getColumn(i).setCellRenderer(center);
		}

		btnNewButton_9_1 = new JButton("+");
		btnNewButton_9_1.setBounds(925, 440, 50, 30);
		btnNewButton_9_1.setForeground(Color.WHITE);
		btnNewButton_9_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_9_1.setBackground(Color.BLACK);
		memberPanel.add(btnNewButton_9_1);

		btnNewButton_10_1 = new JButton("\uC218\uC815");
		btnNewButton_10_1.setBounds(985, 440, 75, 30);
		btnNewButton_10_1.setForeground(Color.WHITE);
		btnNewButton_10_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_10_1.setBackground(Color.BLACK);
		memberPanel.add(btnNewButton_10_1);

		btnNewButton_10_1_1 = new JButton("-");
		btnNewButton_10_1_1.setForeground(Color.WHITE);
		btnNewButton_10_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton_10_1_1.setBackground(Color.BLACK);
		btnNewButton_10_1_1.setBounds(1070, 440, 50, 30);
		memberPanel.add(btnNewButton_10_1_1);

		JLabel careerLabel_1 = new JLabel("\uBD80\uBCF4\uD638\uC790 \uC815\uBCF4");
		careerLabel_1.setForeground(Color.BLACK);
		careerLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		careerLabel_1.setBackground(Color.WHITE);
		careerLabel_1.setBounds(570, 430, 150, 40);
		memberPanel.add(careerLabel_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(255, 255, 255));
		panel_2_1.setBounds(570, 480, 550, 150);
		memberPanel.add(panel_2_1);
		panel_2_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 550, 150);
		panel_2_1.add(scrollPane_1);

		subGuardianList = new subGuardianListTable();
		subGuardiantable = new JTable(subGuardianList);
		subGuardiantable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrollPane_1.setViewportView(subGuardiantable);

		subGuardiantable.setRowHeight(20);
		subGuardiantable.setBackground(Color.WHITE);
		subGuardiantable.setSelectionBackground(new Color(255, 228, 225));
		scrollPane_1.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < subGuardiantable.getColumnCount(); i++) {
			subGuardiantable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JButton btnNewButton_12_1 = new JButton("\uC218\uC815");
		btnNewButton_12_1.setBounds(495, 750, 200, 70);
		btnNewButton_12_1.setForeground(Color.WHITE);
		btnNewButton_12_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_12_1.setBackground(Color.BLACK);
		memberPanel.add(btnNewButton_12_1);

		btnNewButton_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "수정완료" 버튼이 클릭되었을 때 실행되는 코드
				updateMypageInfo(); // 회원 정보 수정 메서드 호출
			}

			private void updateMypageInfo() {
				// 입력된 회원 정보를 MypageInfoVO 객체에 설정
				vo.setMg_id(textField_6.getText());
				vo.setMg_pw(textField_7.getText());
				vo.setMg_name(textField_8.getText());
				vo.setMg_birth(textField_9.getText());
				vo.setMg_sex(isMale ? "남자" : "여자");
				vo.setMg_tel(textField_10.getText());
				vo.setMg_add(textField_11.getText());
				// 나머지 필드들도 동일하게 설정

				try {
					// DAO를 통해 회원 정보를 업데이트
					dao.updateMypageInfo(vo);
					JOptionPane.showMessageDialog(null, textField_8.getText()+" 님의 회원 기본 정보가 수정되었습니다.");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "회원 기본 정보 수정에 실패하였습니다.");
					ex.printStackTrace();
					return;
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(0, 0, 1190, 70);
		memberPanel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(-195, 890, 1384, 70);
		memberPanel.add(panel_2);

		MatchingPanel = new JPanel();
		MatchingPanel.setForeground(new Color(255, 255, 255));
		MatchingPanel.setBackground(new Color(255, 255, 255));
		MatchingPanel.setLayout(null);
		MatchingPanel.setBounds(195, 0, 1189, 961);
		frame.getContentPane().add(MatchingPanel);

		JButton btnNewButton_6_1_1 = new JButton("\uD65C\uB3D9\uB0B4\uC5ED");
		btnNewButton_6_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_6_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_6_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_6_1_1.setBounds(180, 0, 180, 70);
		MatchingPanel.add(btnNewButton_6_1_1);

		JButton btnNewButton_5_1_2 = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		btnNewButton_5_1_2.setForeground(Color.WHITE);
		btnNewButton_5_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton_5_1_2.setBackground(Color.BLACK);
		btnNewButton_5_1_2.setBounds(0, 0, 180, 70);
		MatchingPanel.add(btnNewButton_5_1_2);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 228, 225));
		panel_1_2.setBounds(0, 0, 1190, 70);
		MatchingPanel.add(panel_1_2);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(255, 228, 225));
		panel_2_2.setBounds(0, 890, 1384, 70);
		MatchingPanel.add(panel_2_2);

		meetingInfoPanel = new JPanel();
		meetingInfoPanel.setLayout(null);
		meetingInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uBA74\uC811 \uC694\uCCAD \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		meetingInfoPanel.setBackground(Color.WHITE);
		meetingInfoPanel.setBounds(24, 110, 730, 350);
		MatchingPanel.add(meetingInfoPanel);

		JScrollPane meetingInfoScroll = new JScrollPane();
		meetingInfoScroll.setBounds(15, 25, 700, 300);
		meetingInfoPanel.add(meetingInfoScroll);

		meetingList = new meetingListTable();
		meetingTable = new JTable(meetingList);
		meetingTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		meetingInfoScroll.setViewportView(meetingTable);

		meetingTable.setRowHeight(20);
		meetingTable.setBackground(Color.WHITE);
		meetingTable.setSelectionBackground(new Color(255, 228, 225));
		meetingInfoScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < meetingTable.getColumnCount(); i++) {
			meetingTable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		detailMeetingInfoText = new JTextArea();
		detailMeetingInfoText.setLineWrap(true);
		detailMeetingInfoText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		detailMeetingInfoText.setEditable(false);
		detailMeetingInfoText.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uBA74\uC811 \uC694\uCCAD \uC0C1\uC138 \uB0B4\uC6A9", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		detailMeetingInfoText.setBounds(774, 310, 390, 150);
		MatchingPanel.add(detailMeetingInfoText);

		NurseInfoPanel = new JPanel();
		NurseInfoPanel.setLayout(null);
		NurseInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC694\uCCAD \uC694\uC591\uBCF4\uD638\uC0AC \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		NurseInfoPanel.setBackground(Color.WHITE);
		NurseInfoPanel.setBounds(774, 110, 390, 175);
		MatchingPanel.add(NurseInfoPanel);

		imgLabel = new JLabel("");
		imgLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBounds(15, 35, 100, 120);
		NurseInfoPanel.add(imgLabel);

		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(130, 35, 110, 30);
		NurseInfoPanel.add(nameLabel);

		nameText = new JTextField();
		nameText.setBackground(new Color(255, 255, 255));
		nameText.setEditable(false);
		nameText.setBounds(240, 35, 130, 30);
		nameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		NurseInfoPanel.add(nameText);
		nameText.setColumns(10);

		JLabel sexLabel = new JLabel("\uC131\uBCC4");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		sexLabel.setBackground(Color.WHITE);
		sexLabel.setBounds(130, 80, 110, 30);
		NurseInfoPanel.add(sexLabel);

		sexText = new JTextField();
		sexText.setBackground(new Color(255, 255, 255));
		sexText.setEditable(false);
		sexText.setColumns(10);
		sexText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sexText.setBounds(240, 80, 130, 30);
		NurseInfoPanel.add(sexText);

		JLabel surviceLabel = new JLabel("\uD76C\uB9DD\uADFC\uBB34\uC720\uD615");
		surviceLabel.setForeground(Color.BLACK);
		surviceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		surviceLabel.setBackground(Color.WHITE);
		surviceLabel.setBounds(130, 125, 110, 30);
		NurseInfoPanel.add(surviceLabel);

		surviceText = new JTextField();
		surviceText.setColumns(10);
		surviceText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		surviceText.setBounds(240, 125, 130, 30);
		NurseInfoPanel.add(surviceText);

		consultingInfoPanel = new JPanel();
		consultingInfoPanel.setLayout(null);
		consultingInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uC77C\uBC18 \uC0C1\uB2F4 \uC694\uCCAD \uB0B4\uC5ED", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		consultingInfoPanel.setBackground(Color.WHITE);
		consultingInfoPanel.setBounds(24, 500, 730, 350);
		MatchingPanel.add(consultingInfoPanel);

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
		
		detailConsultingInfoPanel = new JPanel();
		detailConsultingInfoPanel.setLayout(null);
		detailConsultingInfoPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"상세 상담 요청 내역", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		detailConsultingInfoPanel.setBackground(Color.WHITE);
		detailConsultingInfoPanel.setBounds(774, 500, 390, 350);
		MatchingPanel.add(detailConsultingInfoPanel);

		detailConsultingInfoText = new JTextArea();
		detailConsultingInfoText.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		detailConsultingInfoText.setEditable(false);
		detailConsultingInfoText.setLineWrap(true);
		detailConsultingInfoText.setBounds(15, 25, 360, 300);
		detailConsultingInfoPanel.add(detailConsultingInfoText);

		btnNewButton_5_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMemberPanel(); // MemberPanel을 열기 위한 메서드 호출
			}

			private void openMemberPanel() {
				MatchingPanel.setVisible(false); // MatchingPanel을 숨김
				memberPanel.setVisible(true); // MemberPanel을 화면에 표시
			}

		});

		try {
			// DAO를 통해 해당 ID의 회원 정보를 가져옴
			GuardianMypageInfoVO memberInfo = dao.getMypageInfo(mg_id);
//        	System.out.println(mg_id);

			// 가져온 회원 정보를 화면에 표시

			textField_7.setText(memberInfo.getMg_pw());
			textField_8.setText(memberInfo.getMg_name());
			textField_9.setText(memberInfo.getMg_birth().substring(0, 10));
			// 남녀 여부에 따라 체크박스 설정
			if ("남자".equals(memberInfo.getMg_sex())) {
				chckbxNewCheckBox_2.setSelected(true);
				chckbxNewCheckBox_1_1.setSelected(false);
			} else if ("여자".equals(memberInfo.getMg_sex())) {
				chckbxNewCheckBox_2.setSelected(false);
				chckbxNewCheckBox_1_1.setSelected(true);
			} else {
				// 성별 정보가 "남자" 또는 "여자"가 아닌 경우에 대한 처리
				chckbxNewCheckBox_2.setSelected(false);
				chckbxNewCheckBox_1_1.setSelected(false);
				// 또는 예외를 던져서 처리할 수도 있음
				// throw new IllegalArgumentException("올바르지 않은 성별 정보입니다.");
			}
			textField_10.setText(memberInfo.getMg_tel());
			textField_11.setText(memberInfo.getMg_add());

			// 나머지 필드들도 동일하게 설정
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			ex.printStackTrace();
		}

		eventproc();
		patienttable();
		meetingTable();
		consultingTable();

	}

	public void eventproc() {
		btnNewButton_7_1.addActionListener(this);
		btnNewButton_8_1.addActionListener(this);
		btnNewButton_10_1_1_1.addActionListener(this);
		btnNewButton_9_1.addActionListener(this);
		btnNewButton_10_1.addActionListener(this);
		btnNewButton_10_1_1.addActionListener(this);
		patienttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = patienttable.getSelectedRow();
				patientCode = String.valueOf(patienttable.getValueAt(row, 0));
				subGuardiantableMGMatching(patientCode);
			}
		});
		subGuardiantable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = subGuardiantable.getSelectedRow();
				subGuardianCode = String.valueOf(subGuardiantable.getValueAt(row, 0));
			}
		});
		meetingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = meetingTable.getSelectedRow();
				meetingCode = String.valueOf(meetingTable.getValueAt(row, 0));
				meetingDetail(meetingCode);
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
		btnNewButton_4.addActionListener(this);
		btnNewButton_1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btnNewButton_7_1) { // 환자정보 +
			PatientAddView pv = new PatientAddView(this, mg_id);
			JFrame PatientViewFrame = new JFrame("환자 정보 추가");
			PatientViewFrame.getContentPane().add(pv);
			PatientViewFrame.setSize(1215, 935);
			PatientViewFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			PatientViewFrame.setLocation(680, 285);
			PatientViewFrame.setVisible(true);
		} else if (o == btnNewButton_8_1) { // 환자정보 수정
			int code = Integer.parseInt(patientCode);
			PatientModifyView pv = new PatientModifyView(this, code);
			JFrame PatientModifyViewFrame = new JFrame("환자 정보 수정");
			PatientModifyViewFrame.getContentPane().add(pv);
			PatientModifyViewFrame.setSize(1215, 935);
			PatientModifyViewFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			PatientModifyViewFrame.setLocation(680, 285);
			PatientModifyViewFrame.setVisible(true);
		} else if (o == btnNewButton_10_1_1_1) { // 환자정보 -
			int code = Integer.parseInt(patientCode);
			try {
				dao.patientInfoDelete(code);
				JOptionPane.showMessageDialog(null, "환자 정보가 삭제되었습니다.");
				patienttable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "환자 정보 삭제가 실패하였습니다.");
				e2.printStackTrace();
			}
		} else if (o == btnNewButton_9_1) { // 부보호자 +
			Sub_GuardianAddView sgv = new Sub_GuardianAddView(this, mg_id);
			JFrame Sub_GuardianViewFrame = new JFrame("부보호자 정보 추가");
			Sub_GuardianViewFrame.getContentPane().add(sgv);
			Sub_GuardianViewFrame.setSize(1215, 935);
			Sub_GuardianViewFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			Sub_GuardianViewFrame.setLocation(680, 285);
			Sub_GuardianViewFrame.setVisible(true);
		} else if (o == btnNewButton_10_1) { // 부보호자 수정
			int prow = patienttable.getSelectedRow();
			int sgcode = Integer.parseInt(subGuardianCode);
			int ptcode = Integer.parseInt(patientCode);
			Sub_GuardianModifyView sgmv = new Sub_GuardianModifyView(this, mg_id, sgcode, ptcode, prow);
			JFrame Sub_GuardianModifyViewFrame = new JFrame("부보호자 정보 수정");
			Sub_GuardianModifyViewFrame.getContentPane().add(sgmv);
			Sub_GuardianModifyViewFrame.setSize(1215, 935);
			Sub_GuardianModifyViewFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			Sub_GuardianModifyViewFrame.setLocation(680, 285);
			Sub_GuardianModifyViewFrame.setVisible(true);
		} else if (o == btnNewButton_10_1_1) { // 부보호자 -
			int code = Integer.parseInt(subGuardianCode);
			try {
				dao.subGuardianInfoDelete(code);
				JOptionPane.showMessageDialog(null, "부보호자 정보가 삭제되었습니다.");
				subGuardiantable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "부보호자 정보 삭제가 실패하였습니다.");
				e2.printStackTrace();
			}
		} else if (o == btnNewButton_4) { // 일반상담요청
			GuardianConsulltationView ct = new GuardianConsulltationView(this, mg_id);
			JFrame ConsulltationFrame = new JFrame("상담요청");
			ConsulltationFrame.getContentPane().add(ct);
			ConsulltationFrame.setSize(1215, 935);
			ConsulltationFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			ConsulltationFrame.setLocation(680, 285);
			ConsulltationFrame.setVisible(true);
		} else if (o == btnNewButton_1) { // 요양보호사 검색
			NurseSearchView nu = new NurseSearchView(this, mg_id);
			// 팝업 창 또는 새로운 창으로 PatientView를 표시
			// 여기서는 새로운 JFrame으로 표시하는 예시를 들었습니다.
			JFrame nurseFrame = new JFrame("요양보호사 검색");
			nurseFrame.getContentPane().add(nu);
			nurseFrame.setSize(1215, 935);
			nurseFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			nurseFrame.setLocation(680, 285);
			nurseFrame.setVisible(true);
		}
	}

	void patienttable() {
		try {
			ArrayList list = dao.patientInfoSelect(mg_id);
			patientList.data = list;
			patienttable.setModel(patientList);
			patientList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void subGuardiantable() {
		try {
			ArrayList list = dao.subGuardianInfoSelect(mg_id);
			subGuardianList.data = list;
			subGuardiantable.setModel(subGuardianList);
			subGuardianList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void subGuardiantableMGMatching(String patientCode) {
		try {
			ArrayList list = dao.subGuardianInfoSelectMGMatching(mg_id, patientCode);
			subGuardianList.data = list;
			subGuardiantable.setModel(subGuardianList);
			subGuardianList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void meetingTable() {
		try {
			ArrayList list = dao.meetingInfoSelect(mg_id);
			meetingList.data = list;
			meetingTable.setModel(meetingList);
			meetingList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void meetingDetail(String meetingCode) {
		try {
			vo = dao.meetingDetailSelect(meetingCode);
			imgLabel.setIcon(new ImageIcon(vo.getNu_picture()));
			nameText.setText(vo.getNu_name());
			sexText.setText(vo.getNu_sex());
			surviceText.setText(vo.getSv_type());
			detailMeetingInfoText.setText(vo.getMt_content());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void consultingTable() {
		try {
			ArrayList list = dao.consultingSelect(mg_id);
			consultingList.data = list;
			consultingTable.setModel(consultingList);
			consultingList.fireTableDataChanged();
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

	class PatientListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "환자 코드", "환자 이름", "요양 등급", "담당자 이름", "담당자 전화번호" };

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

	class subGuardianListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "부보호자 코드", "부보호자 이름", "전화번호", "주소", "환자 이름", "환자와의 관계" };

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

	class meetingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "면접 코드", "환자 코드", "환자 이름", "요양보호사 이름", "면접 요청 일자" };

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

	class consultingListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "상담 코드", "환자 코드", "환자 이름", "담당자 이름", "상담 일자" };

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