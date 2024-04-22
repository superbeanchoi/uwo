package view.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class NewMemberView extends JFrame implements ActionListener {

	static LoginView loginFrame;
	static NewMemberView frame;
	private JPanel contentPane;
	JLabel logoLabel;
	JButton guardianNewMemBtn, nurseloginNewMemBtn, backBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NewMemberView();
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
	public NewMemberView() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		setForeground(new Color(255, 255, 255));
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
		
		guardianNewMemBtn = new JButton("\uBCF4\uD638\uC790 \uD68C\uC6D0\uAC00\uC785");
		guardianNewMemBtn.setForeground(new Color(255, 255, 255));
		guardianNewMemBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		guardianNewMemBtn.setBackground(new Color(0, 0, 0));
		guardianNewMemBtn.setBounds(142, 190, 300, 50);
		contentPane.add(guardianNewMemBtn);
		
		nurseloginNewMemBtn = new JButton("\uC694\uC591\uBCF4\uD638\uC0AC \uD68C\uC6D0\uAC00\uC785");
		nurseloginNewMemBtn.setForeground(new Color(0, 0, 0));
		nurseloginNewMemBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		nurseloginNewMemBtn.setBackground(new Color(255, 255, 255));
		nurseloginNewMemBtn.setBounds(142, 270, 300, 50);
		contentPane.add(nurseloginNewMemBtn);
		
		backBtn = new JButton("");
		backBtn.setForeground(new Color(0, 0, 0));
		backBtn.setBackground(new Color(255, 228, 225));
		backBtn.setIcon(new ImageIcon("C:\\workspaces\\img\\backicon.png"));
		backBtn.setBounds(10, 10, 50, 50);
		contentPane.add(backBtn);
		setLocation(975, 500);
		
		eventProc();
		
	}
	
	public void eventProc() {
		guardianNewMemBtn.addActionListener(this);
		nurseloginNewMemBtn.addActionListener(this);
		backBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		static NewMemberView frame;
//		JLabel logoLabel;
//		JButton guardianNewMemBtn, nurseloginNewMemBtn, backBtn;
		Object o = e.getSource();
		if(o==guardianNewMemBtn) {
			GuardianNewMemView guardianNewMem = new GuardianNewMemView();
			guardianNewMem.setVisible(true);
		} else if(o==nurseloginNewMemBtn) {
			NurseNewMemView nurseNewMem = new NurseNewMemView();
			nurseNewMem.setVisible(true);
		} else if(o==backBtn) {
				setVisible(false);
		}
		
	}

}
