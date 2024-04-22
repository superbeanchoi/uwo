package view.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dao.loginDAO.LoginDAO;
import dao.loginDAO.NurseNewMemDAO;
import view.centeruser.CenterMypageView;
import view.guardianuser.GuardianMypageView;
import view.nurseuser.NurseMypageInfoView;
import vo.loginVO.LoginVO;

public class LoginView extends JFrame implements ActionListener {

	static LoginView frame;
	private JPanel contentPane;
	JLabel logoLabel, idLabel, pwLabel;
	JTextPane idText;
	JPasswordField pwText;
	JRadioButton guardianRB, nurseRB, centerRB;
	JButton loginBtn, newMemBtn;
	LoginDAO dao;
//	LoginVO vo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		//DB 연결
		try {
			dao = new LoginDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		setForeground(new Color(255, 255, 255));
		setTitle("\uC694\uC591 \uC778\uB825 \uD30C\uACAC \uD504\uB85C\uADF8\uB7A8");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("C:\\workspaces\\img\\NurselogoB.png"));
		logoLabel.setBounds(242, 50, 100, 90);
		contentPane.add(logoLabel);
		
		idLabel = new JLabel("ID");
		idLabel.setForeground(new Color(0, 0, 0));
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idLabel.setBounds(122, 170, 90, 30);
		contentPane.add(idLabel);
		
		pwLabel = new JLabel("PW");
		pwLabel.setForeground(new Color(0, 0, 0));
		pwLabel.setFont(new Font("굴림", Font.BOLD, 15));
		pwLabel.setBounds(122, 210, 90, 30);
		contentPane.add(pwLabel);
		
		idText = new JTextPane();
		idText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idText.setBounds(212, 170, 250, 30);
		contentPane.add(idText);
		
		pwText = new JPasswordField();
		pwText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwText.setForeground(new Color(0, 0, 0));
		pwText.setBounds(212, 210, 250, 30);
		contentPane.add(pwText);
		setLocation(975, 500);
		
		guardianRB = new JRadioButton("\uBCF4\uD638\uC790");
		guardianRB.setForeground(new Color(0, 0, 0));
		guardianRB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		guardianRB.setBackground(new Color(255, 228, 225));
		guardianRB.setBounds(123, 260, 70, 25);
		contentPane.add(guardianRB);
		
		nurseRB = new JRadioButton("\uC694\uC591\uBCF4\uD638\uC0AC");
		nurseRB.setForeground(new Color(0, 0, 0));
		nurseRB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nurseRB.setBackground(new Color(255, 228, 225));
		nurseRB.setBounds(242, 260, 100, 25);
		contentPane.add(nurseRB);
		
		centerRB = new JRadioButton("\uAD00\uB9AC\uC790");
		centerRB.setForeground(new Color(0, 0, 0));
		centerRB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		centerRB.setBackground(new Color(255, 228, 225));
		centerRB.setBounds(391, 260, 70, 25);
		contentPane.add(centerRB);
		
		loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		loginBtn.setBackground(new Color(0, 0, 0));
		loginBtn.setBounds(70, 310, 200, 50);
		contentPane.add(loginBtn);
		
		newMemBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		newMemBtn.setFont(new Font("굴림", Font.BOLD, 20));
		newMemBtn.setBackground(new Color(255, 255, 255));
		newMemBtn.setBounds(314, 310, 200, 50);
		contentPane.add(newMemBtn);
		
		eventProc();
		
	}
	
	public void eventProc() {
		loginBtn.addActionListener(this);
		newMemBtn.addActionListener(this);
		guardianRB.addActionListener(this);
		nurseRB.addActionListener(this);
		centerRB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id, pw;
		Object o = e.getSource();
		if(o==loginBtn) {
			id = idText.getText();
			pw = pwText.getText();
			boolean login;
			if(guardianRB.isSelected()) {
				try {
					login = dao.guardianSelect(id, pw);
					if(login) {
						GuardianMypageView guardianMain = new GuardianMypageView(id);
						guardianMain.frame.setVisible(true);
						guardianMain.textField_6.setText(id);
					} else {
						JOptionPane.showMessageDialog(null, "로그인 정보가 일치하지 않습니다. 다시 입력해주세요.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
					e2.printStackTrace();
				}
			} else if(nurseRB.isSelected()) {
				try {
					login = dao.nurseSelect(id, pw);
					if(login) {
						NurseMypageInfoView nurseMain = new NurseMypageInfoView(id);
						nurseMain.frame.setVisible(true);
						nurseMain.idText.setText(id);
					} else {
						JOptionPane.showMessageDialog(null, "로그인 정보가 일치하지 않습니다. 다시 입력해주세요.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
					e2.printStackTrace();
				}
			} else if(centerRB.isSelected()) {
				try {
					login = dao.centerSelect(id, pw);
					if(login) {
						CenterMypageView centerMain = new CenterMypageView(id);
						centerMain.frame.setVisible(true);
						centerMain.idText.setText(id);
					} else {
						JOptionPane.showMessageDialog(null, "로그인 정보가 일치하지 않습니다. 다시 입력해주세요.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
					e2.printStackTrace();
				}
			} else {
	            JOptionPane.showMessageDialog(null, "로그인 회원 유형을 선택해주세요.");
	            return;
			}
			clearScreen();
		} else if(o==newMemBtn) {
//			frame.setVisible(false);
//			newView.loginFrame = frame;
			NewMemberView newView = new NewMemberView();
			newView.setVisible(true);
			clearScreen();
		} else if(o==guardianRB) {
			nurseRB.setSelected(false);
			centerRB.setSelected(false);
		} else if(o==nurseRB) {
			guardianRB.setSelected(false);
			centerRB.setSelected(false);
		} else if(o==centerRB) {
			guardianRB.setSelected(false);
			nurseRB.setSelected(false);
		}
	}
	
	void clearScreen() {
		idText.setText("");
		pwText.setText("");
	}
	
}
