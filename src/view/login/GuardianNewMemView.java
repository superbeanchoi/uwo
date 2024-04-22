package view.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.loginDAO.GuardianNewMemDAO;
import vo.loginVO.GuardianNewMemVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuardianNewMemView extends JFrame implements ActionListener {

	static GuardianNewMemView frame;
	private JPanel contentPane;
	private JTextField idText, pwText, nameText, birthText, telText, addText;
	JRadioButton manbtn, womanbtn;
	JButton newMemBtn, idsameBtn;
	GuardianNewMemDAO dao;
	GuardianNewMemVO vo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GuardianNewMemView();
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
	public GuardianNewMemView() {
		//DB ¿¬°á
		try {
			dao = new GuardianNewMemDAO();
			System.out.println("DB¿¬°á ¼º°ø");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setTitle("\uBCF4\uD638\uC790 \uD68C\uC6D0\uAC00\uC785");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 228, 225));
		headPanel.setBounds(0, 0, 1184, 50);
		contentPane.add(headPanel);
		headPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  \uD68C\uC6D0\uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(0, 0, 1184, 50);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 228, 225));
		headPanel.add(lblNewLabel);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setBackground(new Color(255, 255, 255));
		idLabel.setForeground(new Color(0, 0, 0));
		idLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		idLabel.setBounds(382, 170, 120, 40);
		contentPane.add(idLabel);
		
		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setForeground(Color.BLACK);
		pwLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		pwLabel.setBackground(Color.WHITE);
		pwLabel.setBounds(382, 230, 120, 40);
		contentPane.add(pwLabel);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(382, 290, 120, 40);
		contentPane.add(nameLabel);
		
		JLabel birthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		birthLabel.setForeground(Color.BLACK);
		birthLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		birthLabel.setBackground(Color.WHITE);
		birthLabel.setBounds(382, 350, 120, 40);
		contentPane.add(birthLabel);
		
		JLabel sexLabel = new JLabel("\uC131\uBCC4");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		sexLabel.setBackground(Color.WHITE);
		sexLabel.setBounds(382, 410, 120, 40);
		contentPane.add(sexLabel);
		
		manbtn = new JRadioButton("\uB0A8\uC790");
		manbtn.setBackground(new Color(255, 255, 255));
		manbtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		manbtn.setBounds(502, 410, 120, 40);
		contentPane.add(manbtn);
		
		womanbtn = new JRadioButton("\uC5EC\uC790");
		womanbtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		womanbtn.setBackground(Color.WHITE);
		womanbtn.setBounds(622, 410, 120, 40);
		contentPane.add(womanbtn);
		
		JLabel tellLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		tellLabel.setForeground(Color.BLACK);
		tellLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		tellLabel.setBackground(Color.WHITE);
		tellLabel.setBounds(382, 470, 120, 40);
		contentPane.add(tellLabel);
		
		JLabel addLabel = new JLabel("\uC8FC\uC18C");
		addLabel.setForeground(Color.BLACK);
		addLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		addLabel.setBackground(Color.WHITE);
		addLabel.setBounds(382, 530, 120, 40);
		contentPane.add(addLabel);
		
		idText = new JTextField();
		idText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		idText.setToolTipText("");
		idText.setBackground(new Color(255, 255, 255));
		idText.setBounds(502, 170, 180, 40);
		contentPane.add(idText);
		idText.setColumns(10);
		idText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		pwText = new JTextField();
		pwText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pwText.setToolTipText("");
		pwText.setColumns(10);
		pwText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pwText.setBackground(Color.WHITE);
		pwText.setBounds(502, 230, 300, 40);
		contentPane.add(pwText);
		
		nameText = new JTextField();
		nameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameText.setToolTipText("");
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nameText.setBackground(Color.WHITE);
		nameText.setBounds(502, 290, 300, 40);
		contentPane.add(nameText);
		
		birthText = new JTextField();
		birthText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				birthText.setText("");
			}
		});
		birthText.setText(" YYYY-MM-DD");
		birthText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		birthText.setToolTipText("");
		birthText.setColumns(10);
		birthText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		birthText.setBackground(Color.WHITE);
		birthText.setBounds(502, 350, 300, 40);
		contentPane.add(birthText);
		
		telText = new JTextField();
		telText.setText(" 010-0000-0000");
		telText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				telText.setText("");
			}
		});
		telText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telText.setToolTipText("");
		telText.setColumns(10);
		telText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		telText.setBackground(Color.WHITE);
		telText.setBounds(502, 470, 300, 40);
		contentPane.add(telText);
		
		addText = new JTextField();
		addText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		addText.setToolTipText("");
		addText.setColumns(10);
		addText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		addText.setBackground(Color.WHITE);
		addText.setBounds(502, 530, 300, 40);
		contentPane.add(addText);
		
		newMemBtn = new JButton("\uD68C\uC6D0\uAC00\uC785 \uC644\uB8CC");
		newMemBtn.setForeground(new Color(255, 255, 255));
		newMemBtn.setBackground(new Color(0, 0, 0));
		newMemBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		newMemBtn.setBounds(467, 650, 250, 50);
		contentPane.add(newMemBtn);
		
		JPanel footPanel = new JPanel();
		footPanel.setBackground(new Color(255, 228, 225));
		footPanel.setBounds(0, 811, 1184, 50);
		contentPane.add(footPanel);
		
		idsameBtn = new JButton("\uC911\uBCF5 \uD655\uC778");
		idsameBtn.setForeground(Color.WHITE);
		idsameBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		idsameBtn.setBackground(Color.BLACK);
		idsameBtn.setBounds(692, 170, 110, 40);
		contentPane.add(idsameBtn);
		setLocation(680, 250);
		
		eventProc();
		
	}
	
	public void eventProc() {
		newMemBtn.addActionListener(this);
		idsameBtn.addActionListener(this);
		manbtn.addActionListener(this);
		womanbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		private JTextField idText, pwText, nameText, birthText, tellText, addText;
//		JRadioButton manbtn, womanbtn;
//		JButton newMemBtn;
		String id, pw, name, birth, sex, tel, add;
		Object o = e.getSource();
		if(o==newMemBtn) {
			id = idText.getText();
			pw = pwText.getText();
			name = nameText.getText();
			birth = birthText.getText();
			tel = telText.getText();
			add = addText.getText();
			if(manbtn.isSelected()) {
				sex = manbtn.getText();
			} else if(womanbtn.isSelected()) {
				sex = womanbtn.getText();
			} else {
	            JOptionPane.showMessageDialog(null, "¼ºº°À» ¼±ÅÃÇØÁÖ¼¼¿ä.");
	            return;
	        }
			GuardianNewMemVO vo = new GuardianNewMemVO(id, pw, name, birth, sex, tel, add);
			try {
				dao.insert(vo);
				JOptionPane.showMessageDialog(null, name+" ´ÔÀÇ È¸¿ø °¡ÀÔÀÌ ¼º°øÀûÀ¸·Î ¿Ï·áµÇ¾ú½À´Ï´Ù.");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "È¸¿ø °¡ÀÔ¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
				return;
			}
			LoginView newView = new LoginView();
			newView.setVisible(true);
			setVisible(false);
		} else if(o==manbtn) {
			womanbtn.setSelected(false);
		} else if(o==womanbtn) {
			manbtn.setSelected(false);
		} else if(o==idsameBtn) {
			id = idText.getText();
			try {
				boolean loginid = dao.select(id);
				if(loginid) {
					JOptionPane.showMessageDialog(null, "Á¸ÀçÇÏ´Â ¾ÆÀÌµð ÀÔ´Ï´Ù. ´Ù¸¥ ¾ÆÀÌµð¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				} else {
					JOptionPane.showMessageDialog(null, "»ç¿ë °¡´ÉÇÑ ¾ÆÀÌµð ÀÔ´Ï´Ù.");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Á¤º¸ ÀÔ·Â¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
		}
		
	}
	
	void clearScreen() {
		idText.setText("");
		pwText.setText("");
		nameText.setText("");
		birthText.setText("");
		telText.setText("");
		addText.setText("");
		manbtn.setVisible(false);
		womanbtn.setVisible(false);
	}
}
