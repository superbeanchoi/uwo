package view.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.loginDAO.NurseNewMemDAO;
import vo.loginVO.NurseNewMemVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NurseNewMemView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField imgPathText, idText, pwText, nameText, juminText, fromText, telText, addText, bankText, bankNumText;
	private JLabel imgbox;
	JButton newMemBtn, imgBtn, idsameBtn;
	JRadioButton manBtn, womanBtn, criminalYBtn, criminalNBtn, work4Btn, work8Btn, workAllbtn;
	NurseNewMemDAO dao;
	NurseNewMemVO vo;
	private JTextField imgPath;
	JComboBox fromBox, bankBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseNewMemView frame = new NurseNewMemView();
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
	public NurseNewMemView() {
		//DB ¿¬°á
		try {
			dao = new NurseNewMemDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setTitle("\uC694\uC591\uBCF4\uD638\uC0AC \uD68C\uC6D0\uAC00\uC785");
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
		headPanel.setBounds(0, 0, 1184, 50);
		headPanel.setBackground(new Color(255, 228, 225));
		contentPane.add(headPanel);
		headPanel.setLayout(null);
		
		JLabel NewMemLabel = new JLabel("  \uD68C\uC6D0\uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NewMemLabel.setBounds(0, 0, 1184, 50);
		NewMemLabel.setForeground(new Color(0, 0, 0));
		NewMemLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		NewMemLabel.setBackground(new Color(255, 228, 225));
		headPanel.add(NewMemLabel);
		
		newMemBtn = new JButton("\uC0C1\uC138 \uC778\uB825\uC815\uBCF4 \uC785\uB825\uD558\uAE30");
		newMemBtn.setBounds(467, 700, 250, 50);
		newMemBtn.setForeground(new Color(255, 255, 255));
		newMemBtn.setBackground(new Color(0, 0, 0));
		newMemBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		contentPane.add(newMemBtn);
		
		JPanel footPanel = new JPanel();
		footPanel.setBounds(0, 811, 1184, 50);
		footPanel.setBackground(new Color(255, 228, 225));
		contentPane.add(footPanel);
		
		JLabel imgLabel = new JLabel("\uC0AC\uC9C4");
		imgLabel.setForeground(Color.BLACK);
		imgLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBounds(122, 165, 120, 30);
		contentPane.add(imgLabel);
		
		imgBtn = new JButton("\uBD88\uB7EC\uC624\uAE30");
		imgBtn.setForeground(Color.WHITE);
		imgBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		imgBtn.setBackground(Color.BLACK);
		imgBtn.setBounds(354, 165, 100, 30);
		contentPane.add(imgBtn);
		
		imgPathText = new JTextField();
		imgPathText.setForeground(new Color(0, 0, 0));
		imgPathText.setEditable(false);
		imgPathText.setToolTipText("");
		imgPathText.setFont(new Font("¸¼Àº °íµñ", Font.ITALIC, 12));
		imgPathText.setColumns(10);
		imgPathText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgPathText.setBackground(Color.WHITE);
		imgPathText.setBounds(464, 166, 78, 30);
		contentPane.add(imgPathText);
		
		imgbox = new JLabel("   (120*100)");
		imgbox.setForeground(new Color(0, 0, 0));
		imgbox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		imgbox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgbox.setBackground(new Color(255, 255, 255));
		imgbox.setBounds(242, 120, 100, 120);
		contentPane.add(imgbox);
		
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		idLabel.setBackground(Color.WHITE);
		idLabel.setBounds(642, 135, 120, 30);
		contentPane.add(idLabel);
		
		idText = new JTextField();
		idText.setToolTipText("");
		idText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		idText.setColumns(10);
		idText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		idText.setBackground(Color.WHITE);
		idText.setBounds(762, 135, 190, 30);
		contentPane.add(idText);
		
		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setForeground(Color.BLACK);
		pwLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pwLabel.setBackground(Color.WHITE);
		pwLabel.setBounds(642, 185, 120, 30);
		contentPane.add(pwLabel);
		
		pwText = new JTextField();
		pwText.setToolTipText("");
		pwText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		pwText.setColumns(10);
		pwText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pwText.setBackground(Color.WHITE);
		pwText.setBounds(762, 185, 300, 30);
		contentPane.add(pwText);
		
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(122, 290, 120, 30);
		contentPane.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setToolTipText("");
		nameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nameText.setBackground(Color.WHITE);
		nameText.setBounds(242, 290, 300, 30);
		contentPane.add(nameText);
		
		JLabel juminLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		juminLabel.setForeground(Color.BLACK);
		juminLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		juminLabel.setBackground(Color.WHITE);
		juminLabel.setBounds(122, 340, 120, 30);
		contentPane.add(juminLabel);
		
		juminText = new JTextField();
		juminText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				juminText.setText("");
			}
		});
		juminText.setText(" 900101-1010101");
		juminText.setToolTipText("");
		juminText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		juminText.setColumns(10);
		juminText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		juminText.setBackground(Color.WHITE);
		juminText.setBounds(242, 340, 300, 30);
		contentPane.add(juminText);
		
		JLabel sexLabel = new JLabel("\uC131\uBCC4");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sexLabel.setBackground(Color.WHITE);
		sexLabel.setBounds(642, 290, 120, 30);
		contentPane.add(sexLabel);
		
		manBtn = new JRadioButton("\uB0A8\uC790");
		manBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		manBtn.setForeground(new Color(0, 0, 0));
		manBtn.setBackground(new Color(255, 255, 255));
		manBtn.setBounds(762, 290, 120, 30);
		contentPane.add(manBtn);
		
		womanBtn = new JRadioButton("\uC5EC\uC790");
		womanBtn.setForeground(Color.BLACK);
		womanBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		womanBtn.setBackground(Color.WHITE);
		womanBtn.setBounds(882, 290, 120, 30);
		contentPane.add(womanBtn);
		
		JLabel fromLabel = new JLabel("\uAD6D\uC801");
		fromLabel.setForeground(Color.BLACK);
		fromLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		fromLabel.setBackground(Color.WHITE);
		fromLabel.setBounds(642, 340, 120, 30);
		contentPane.add(fromLabel);
		
		fromBox = new JComboBox();
		fromBox.setModel(new DefaultComboBoxModel(new String[] {"\uB300\uD55C\uBBFC\uAD6D", "\uC77C\uBCF8", "\uC911\uAD6D", "\uB300\uB9CC", "\uD64D\uCF69", "\uBCA0\uD2B8\uB0A8", "\uB9D0\uB808\uC774\uC2DC\uC544", "\uC778\uB3C4\uB124\uC2DC\uC544", "\uD0DC\uAD6D", "\uD544\uB9AC\uD540", "\uC778\uB3C4", "\uAE30\uD0C0 \uAD6D\uAC00"}));
		fromBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		fromBox.setBackground(Color.WHITE);
		fromBox.setBounds(762, 340, 300, 30);
		contentPane.add(fromBox);
		
		JLabel telLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telLabel.setForeground(Color.BLACK);
		telLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telLabel.setBackground(Color.WHITE);
		telLabel.setBounds(122, 420, 120, 30);
		contentPane.add(telLabel);
		
		telText = new JTextField();
		telText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				telText.setText("");
			}
		});
		telText.setText(" 010-0000-0000");
		telText.setToolTipText("");
		telText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telText.setColumns(10);
		telText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		telText.setBackground(Color.WHITE);
		telText.setBounds(242, 420, 300, 30);
		contentPane.add(telText);
		
		JLabel addLabel = new JLabel("\uC8FC\uC18C");
		addLabel.setForeground(Color.BLACK);
		addLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		addLabel.setBackground(Color.WHITE);
		addLabel.setBounds(642, 420, 120, 30);
		contentPane.add(addLabel);
		
		addText = new JTextField();
		addText.setToolTipText("");
		addText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		addText.setColumns(10);
		addText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		addText.setBackground(Color.WHITE);
		addText.setBounds(762, 420, 300, 30);
		contentPane.add(addText);
		
		JLabel bankLabel = new JLabel("\uC740\uD589\uBA85");
		bankLabel.setForeground(Color.BLACK);
		bankLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankLabel.setBackground(Color.WHITE);
		bankLabel.setBounds(122, 500, 120, 30);
		contentPane.add(bankLabel);
		
		bankBox = new JComboBox();
		bankBox.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC\uC740\uD589", "\uAE30\uC5C5\uC740\uD589", "\uB18D\uD611\uC740\uD589", "\uC2E0\uD55C\uC740\uD589", "\uC6B0\uB9AC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uCE74\uCE74\uC624\uBC45\uD06C", "\uD1A0\uC2A4\uBC45\uD06C"}));
		bankBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankBox.setBackground(Color.WHITE);
		bankBox.setBounds(242, 500, 300, 30);
		contentPane.add(bankBox);
		
		JLabel bankNumLabel = new JLabel("\uACC4\uC88C\uBC88\uD638");
		bankNumLabel.setForeground(Color.BLACK);
		bankNumLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankNumLabel.setBackground(Color.WHITE);
		bankNumLabel.setBounds(122, 550, 120, 30);
		contentPane.add(bankNumLabel);
		
		bankNumText = new JTextField();
		bankNumText.setToolTipText("");
		bankNumText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bankNumText.setColumns(10);
		bankNumText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bankNumText.setBackground(Color.WHITE);
		bankNumText.setBounds(242, 550, 300, 30);
		contentPane.add(bankNumText);
		
		JLabel criminalLabel = new JLabel("\uBC94\uC8C4\uACBD\uB825\uC5EC\uBD80");
		criminalLabel.setForeground(Color.BLACK);
		criminalLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		criminalLabel.setBackground(Color.WHITE);
		criminalLabel.setBounds(642, 500, 120, 30);
		contentPane.add(criminalLabel);
		
		criminalYBtn = new JRadioButton("\uC788\uC74C");
		criminalYBtn.setForeground(Color.BLACK);
		criminalYBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		criminalYBtn.setBackground(Color.WHITE);
		criminalYBtn.setBounds(762, 500, 120, 30);
		contentPane.add(criminalYBtn);
		
		criminalNBtn = new JRadioButton("\uC5C6\uC74C");
		criminalNBtn.setSelected(true);
		criminalNBtn.setForeground(Color.BLACK);
		criminalNBtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		criminalNBtn.setBackground(Color.WHITE);
		criminalNBtn.setBounds(882, 500, 120, 30);
		contentPane.add(criminalNBtn);
		
		JLabel workLabel = new JLabel("\uD76C\uB9DD\uADFC\uBB34\uC720\uD615");
		workLabel.setForeground(Color.BLACK);
		workLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		workLabel.setBackground(Color.WHITE);
		workLabel.setBounds(642, 550, 120, 30);
		contentPane.add(workLabel);
		
		work4Btn = new JRadioButton("4\uC2DC\uAC04");
		work4Btn.setForeground(Color.BLACK);
		work4Btn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		work4Btn.setBackground(Color.WHITE);
		work4Btn.setBounds(762, 550, 120, 30);
		contentPane.add(work4Btn);
		
		work8Btn = new JRadioButton("8\uC2DC\uAC04");
		work8Btn.setForeground(Color.BLACK);
		work8Btn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		work8Btn.setBackground(Color.WHITE);
		work8Btn.setBounds(882, 550, 120, 30);
		contentPane.add(work8Btn);
		
		workAllbtn = new JRadioButton("\uC785\uC8FC");
		workAllbtn.setForeground(Color.BLACK);
		workAllbtn.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		workAllbtn.setBackground(Color.WHITE);
		workAllbtn.setBounds(1002, 550, 120, 30);
		contentPane.add(workAllbtn);
		
		idsameBtn = new JButton("\uC911\uBCF5 \uD655\uC778");
		idsameBtn.setForeground(Color.WHITE);
		idsameBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		idsameBtn.setBackground(Color.BLACK);
		idsameBtn.setBounds(962, 135, 100, 30);
		contentPane.add(idsameBtn);
		
		setLocation(680, 250);
		
		eventProc();
		
	}
	
	public void eventProc() {
		newMemBtn.addActionListener(this);
		imgBtn.addActionListener(this);
		idsameBtn.addActionListener(this);
		manBtn.addActionListener(this);
		womanBtn.addActionListener(this);
		criminalYBtn.addActionListener(this);
		criminalNBtn.addActionListener(this);
		work4Btn.addActionListener(this);
		work8Btn.addActionListener(this);
		workAllbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String imgPath, imgText, id, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal;
		int survice;
		File selectedImg=null;
		JFileChooser fc;
		Object o = e.getSource();
		if(o==imgBtn) {
			imgbox.setIcon(null);
			fc = new JFileChooser();
			int imgValue = fc.showOpenDialog(this);
			if(imgValue==JFileChooser.APPROVE_OPTION) {
				selectedImg = fc.getSelectedFile();
				imgPath = selectedImg.getAbsolutePath();
				imgbox.setText("");
				imgbox.setIcon(new ImageIcon(imgPath));
				imgPathText.setText(imgPath);
			} 
		} else if(o==newMemBtn) {
			imgText = imgPathText.getText();
			id = idText.getText();
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
				survice = 301;
			} else if(work8Btn.isSelected()) {
				survice = 302;
			} else if(workAllbtn.isSelected()) {
				survice = 303;
			} else {
	            JOptionPane.showMessageDialog(null, "Èñ¸Á ±Ù¹« À¯ÇüÀ» ¼±ÅÃÇØÁÖ¼¼¿ä.");
	            return;
	        }
			NurseNewMemVO vo = new NurseNewMemVO(imgText, id, pw, name, jumin, sex, from, tel, add, bank, bankNum, criminal, survice);
			try {
				dao.insert(vo);
				JOptionPane.showMessageDialog(null, name+" ´ÔÀÇ È¸¿ø ±âº» Á¤º¸°¡ ÀÔ·ÂµÇ¾ú½À´Ï´Ù.");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "È¸¿ø ±âº» Á¤º¸ ÀÔ·ÂÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
				return;
			}
			NurseNewMemDetailView newView = new NurseNewMemDetailView();
			newView.setVisible(true);
			newView.imgbox.setIcon(new ImageIcon(imgText));
			newView.nameText.setText(name);
			newView.idText.setText(id);
			newView.pwText.setText(pw);
			setVisible(false);
			
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
}
