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

import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import dao.nurseuserDAO.NurseMypageInfoDAO;
import vo.nurseuserVO.NurseMypageInfoVO;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NurseinfoSkillModiView extends JFrame implements ActionListener {

	private NurseMypageInfoView parentView;
	private int code;
	private String field, name;
	private JPanel contentPane;
	public JTextField skillcodeText;
	public JComboBox skillFieldBox, skillnameBox;
	JButton newSkillBtn;
	NurseMypageInfoDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseinfoSkillModiView frame = new NurseinfoSkillModiView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public NurseinfoSkillModiView(NurseMypageInfoView parentView, int code, String field, String name) {
		this();
		this.parentView = parentView;
		this.code = code;
		this.field = field;
		this.name = name;
	}

	/**
	 * Create the frame.
	 */
	public NurseinfoSkillModiView() {
		//DB ¿¬°á
		try {
			dao = new NurseMypageInfoDAO();
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
		
		JLabel NewSkillLabel = new JLabel(" \uBCF4\uC720 \uAE30\uC220 \uC815\uBCF4\uB97C \uC218\uC815\uD558\uC138\uC694");
		NewSkillLabel.setForeground(new Color(0, 0, 0));
		NewSkillLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		NewSkillLabel.setBackground(Color.BLACK);
		NewSkillLabel.setBounds(0, 0, 584, 40);
		headPanel.add(NewSkillLabel);
		
		skillcodeText = new JTextField();
		skillcodeText.setEditable(false);
		skillcodeText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		skillcodeText.setBounds(464, 10, 100, 20);
		headPanel.add(skillcodeText);
		skillcodeText.setColumns(10);
		
		newSkillBtn = new JButton("\uC815\uBCF4 \uC218\uC815");
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
		
		skillFieldBox = new JComboBox();
		skillFieldBox.setModel(new DefaultComboBoxModel(new String[] {"\uAC04\uD638"}));
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
		
		if(field=="°£È£") {
			String skillName[] = {"Åõ¾à", "¼®¼Ç", "³ú°ü", "¼Òµ¶", "³Ú¶óÅæ"};
			skillnameBox.setModel(new DefaultComboBoxModel(skillName));
		} 
		
		eventProc();
		
	}
	
	public void eventProc() {
		newSkillBtn.addActionListener(this);
		skillFieldBox.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int skillNum;
		Object o = e.getSource();
		if(o==newSkillBtn) {
			int[][] skCol = {{201, 202, 203, 204, 205}};
			skillNum = skCol[skillFieldBox.getSelectedIndex()][skillnameBox.getSelectedIndex()];
			NurseMypageInfoVO vo = new NurseMypageInfoVO();
			vo.setSkill(skillNum);
			JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸°¡ ¼öÁ¤µÇ¾ú½À´Ï´Ù.");
			try {
				dao.skillModi(code, vo);
				parentView.skilltable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "±â¼ú Á¤º¸ ¼öÁ¤ÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
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
