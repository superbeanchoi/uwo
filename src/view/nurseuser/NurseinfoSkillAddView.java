package view.nurseuser;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.loginDAO.NurseNewMemDAO;
import vo.loginVO.NurseNewMemVO;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class NurseinfoSkillAddView extends JFrame implements ActionListener {

	private NurseMypageInfoView parentView;
	private JPanel contentPane;
	JButton newSkillBtn;
	JComboBox skillFieldBox, skillnameBox;
	NurseNewMemDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseinfoSkillAddView frame = new NurseinfoSkillAddView();
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
	public NurseinfoSkillAddView() {
		//DB ¿¬°á
		try {
			dao = new NurseNewMemDAO();
			System.out.println("DB¿¬°á ¼º°ø");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headPanel = new JPanel();
		headPanel.setLayout(null);
		headPanel.setBackground(new Color(255, 228, 225));
		headPanel.setBounds(0, 0, 584, 40);
		contentPane.add(headPanel);
		
		JLabel NewCertiLabel = new JLabel(" \uBCF4\uC720 \uAE30\uC220 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NewCertiLabel.setForeground(new Color(0, 0, 0));
		NewCertiLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		NewCertiLabel.setBackground(new Color(255, 228, 225));
		NewCertiLabel.setBounds(0, 0, 584, 40);
		headPanel.add(NewCertiLabel);
		
		newSkillBtn = new JButton("\uC815\uBCF4 \uCD94\uAC00");
		newSkillBtn.setForeground(new Color(255, 255, 255));
		newSkillBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		newSkillBtn.setBackground(new Color(0, 0, 0));
		newSkillBtn.setBounds(192, 310, 200, 40);
		contentPane.add(newSkillBtn);
		
		JLabel skillFieldLabel = new JLabel("\uAE30\uC220 \uC885\uB958");
		skillFieldLabel.setForeground(Color.BLACK);
		skillFieldLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		skillFieldLabel.setBackground(Color.WHITE);
		skillFieldLabel.setBounds(142, 125, 100, 30);
		contentPane.add(skillFieldLabel);
		
		JLabel skillnameLabel = new JLabel("\uAE30\uC220 \uBA85");
		skillnameLabel.setForeground(Color.BLACK);
		skillnameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		skillnameLabel.setBackground(Color.WHITE);
		skillnameLabel.setBounds(142, 185, 100, 30);
		contentPane.add(skillnameLabel);
		
		JPanel footPanel = new JPanel();
		footPanel.setLayout(null);
		footPanel.setBackground(new Color(255, 228, 225));
		footPanel.setBounds(0, 371, 584, 40);
		contentPane.add(footPanel);
		
		
		String skillField[] = {"°£È£"};
		skillFieldBox = new JComboBox(skillField);
		skillFieldBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		skillFieldBox.setBackground(new Color(255, 255, 255));
		skillFieldBox.setBounds(242, 125, 200, 30);
		contentPane.add(skillFieldBox);
		
		skillnameBox = new JComboBox();
		skillnameBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		skillnameBox.setBackground(Color.WHITE);
		skillnameBox.setBounds(242, 185, 200, 30);
		contentPane.add(skillnameBox);
		setLocation(975, 500);
		
		eventProc();
		
	}
	
	public NurseinfoSkillAddView(NurseMypageInfoView parentView) {
		this();
		this.parentView = parentView;
	}
	
	public void eventProc() {
		newSkillBtn.addActionListener(this);
		skillFieldBox.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id;
		int skillNum;
		Object o = e.getSource();
		if(o==newSkillBtn) {
			int[][] skCol = {{201, 202, 203, 204, 205}};
			id = parentView.idText.getText();
			skillNum = skCol[skillFieldBox.getSelectedIndex()][skillnameBox.getSelectedIndex()];
			NurseNewMemVO vo = new NurseNewMemVO();
			vo.setSkill(id, skillNum);
			JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸°¡ ±âÀÔµÇ¾ú½À´Ï´Ù.");
			try {
				dao.skillinsert(vo);
				parentView.skilltable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸ ±âÀÔÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
			setVisible(false);
		} else if(o==skillFieldBox) {
			if((String)skillFieldBox.getSelectedItem()=="°£È£") {
				String skillName[] = {"Åõ¾à", "¼®¼Ç", "³ú°ü", "¼Òµ¶", "³Ú¶óÅæ"};
				skillnameBox.setModel(new DefaultComboBoxModel(skillName));
			}
		}
	}
}
