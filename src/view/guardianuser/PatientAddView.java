package view.guardianuser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.guardianuserDAO.PatientInfoDAO;
import vo.guardianuserVO.PatientInfoVO;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatientAddView extends JPanel {
	private JRadioButton rdbtnNewRadioButton_2, rdbtnNewRadioButton_3, rdbtnNewRadioButton_4, rdbtnNewRadioButton_5,
			rdbtnNewRadioButton_6;
	private ButtonGroup sexGroup;
	private JTextField textField, textField_1, textField_3, textField_4, textField_6, textField_7, textField_8,
			textField_2, textField_5, textField_9, textField_10, textField_11, textField_12, textField_13, textField_14;
	JCheckBox chckbxNewCheckBox_23, chckbxNewCheckBox_22;
	JComboBox comboBox, comboBox_1, comboBox_1_1, comboBox_1_1_1, comboBox_1_1_1_1, comboBox_1_1_1_1_1, comboBox_1_1_1_1_1_1;
	JButton btnNewButton, btnNewButton_1;
	public GuardianMypageView mypage;
	String mg_id;
	PatientInfoDAO dao;
	PatientInfoVO vo;

	public PatientAddView() {
		initialize();
	}
	
	public PatientAddView(GuardianMypageView mypage, String id) {
		this.mypage=mypage;
		this.mg_id=id;
		initialize();
	}
	
	public void initialize() {

		setBackground(new Color(0, 0, 0));
		setLayout(null);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);
		buttonGroup.add(rdbtnNewRadioButton_4);
		buttonGroup.add(rdbtnNewRadioButton_5);
		buttonGroup.add(rdbtnNewRadioButton_6);

		chckbxNewCheckBox_23 = new JCheckBox("\uC5EC\uC790");
		chckbxNewCheckBox_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxNewCheckBox_22.setSelected(false);
			}
		});
		chckbxNewCheckBox_23.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox_23.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox_23.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		chckbxNewCheckBox_23.setBounds(300, 209, 100, 40);
		add(chckbxNewCheckBox_23);

		chckbxNewCheckBox_22 = new JCheckBox("\uB0A8\uC790");
		chckbxNewCheckBox_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxNewCheckBox_23.setSelected(false);
			}
		});
		chckbxNewCheckBox_22.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox_22.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox_22.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		chckbxNewCheckBox_22.setBounds(200, 209, 100, 40);
		add(chckbxNewCheckBox_22);

		JLabel lblNewLabel = new JLabel("     \uD658\uC790 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(0, 0, 1200, 70);
		add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 228, 225));

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(50, 89, 150, 40);
		add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_1_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setBounds(50, 149, 150, 40);
		add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_2 = new JLabel("\uC131\uBCC4");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(50, 209, 150, 40);
		add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_3 = new JLabel("\uC694\uC591\uB4F1\uAE09");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(50, 329, 150, 40);
		add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(680, 89, 150, 40);
		add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_6 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setBounds(680, 149, 150, 40);
		add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_6_1 = new JLabel("\uC8FC\uC694 \uC9C4\uB2E8\uBA85");
		lblNewLabel_6_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_6_1.setBounds(680, 209, 150, 40);
		add(lblNewLabel_6_1);
		lblNewLabel_6_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_6_1_1 = new JLabel("\uD0A4");
		lblNewLabel_6_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_6_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_6_1_1.setBounds(50, 269, 150, 40);
		add(lblNewLabel_6_1_1);

		JLabel lblNewLabel_6_1_2 = new JLabel("\uBAB8\uBB34\uAC8C");
		lblNewLabel_6_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_6_1_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_6_1_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_6_1_2.setBounds(680, 269, 150, 40);
		add(lblNewLabel_6_1_2);

		JLabel lblNewLabel_6_1_2_2 = new JLabel("\uBCF4\uD638\uC790\uC640\uC758 \uAD00\uACC4");
		lblNewLabel_6_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_6_1_2_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_6_1_2_2.setBackground(Color.BLACK);
		lblNewLabel_6_1_2_2.setBounds(680, 329, 150, 40);
		add(lblNewLabel_6_1_2_2);

		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 0));
		textField.setBounds(200, 89, 250, 40);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setBounds(200, 149, 250, 40);
		add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBackground(new Color(0, 0, 0));
		textField_3.setBounds(830, 89, 250, 40);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(0, 0, 0));
		textField_4.setBounds(830, 149, 250, 40);
		add(textField_4);
		textField_4.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_6.setForeground(new Color(255, 255, 255));
		textField_6.setBackground(new Color(0, 0, 0));
		textField_6.setBounds(830, 209, 250, 40);
		add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_7.setForeground(new Color(255, 255, 255));
		textField_7.setBackground(new Color(0, 0, 0));
		textField_7.setBounds(200, 269, 200, 40);
		add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_8.setForeground(new Color(255, 255, 255));
		textField_8.setBackground(new Color(0, 0, 0));
		textField_8.setBounds(830, 269, 200, 40);
		add(textField_8);
		textField_8.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setForeground(Color.WHITE);
		textField_14.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_14.setColumns(10);
		textField_14.setBackground(Color.BLACK);
		textField_14.setBounds(830, 330, 250, 40);
		add(textField_14);

		rdbtnNewRadioButton_2 = new JRadioButton("1\uB4F1\uAE09");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_3.setSelected(false);
				rdbtnNewRadioButton_4.setSelected(false);
				rdbtnNewRadioButton_5.setSelected(false);
				rdbtnNewRadioButton_6.setSelected(false);
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_2.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_2.setBounds(200, 329, 80, 40);
		add(rdbtnNewRadioButton_2);

		rdbtnNewRadioButton_3 = new JRadioButton("2\uB4F1\uAE09");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_4.setSelected(false);
				rdbtnNewRadioButton_5.setSelected(false);
				rdbtnNewRadioButton_6.setSelected(false);
			}
		});
		rdbtnNewRadioButton_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		rdbtnNewRadioButton_3.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_3.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_3.setBounds(280, 329, 80, 40);
		add(rdbtnNewRadioButton_3);

		rdbtnNewRadioButton_4 = new JRadioButton("3\uB4F1\uAE09");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				rdbtnNewRadioButton_5.setSelected(false);
				rdbtnNewRadioButton_6.setSelected(false);
			}
		});
		rdbtnNewRadioButton_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		rdbtnNewRadioButton_4.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_4.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_4.setBounds(370, 329, 80, 40);
		add(rdbtnNewRadioButton_4);

		rdbtnNewRadioButton_5 = new JRadioButton("4\uB4F1\uAE09");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				rdbtnNewRadioButton_4.setSelected(false);
				rdbtnNewRadioButton_6.setSelected(false);
			}
		});
		rdbtnNewRadioButton_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		rdbtnNewRadioButton_5.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_5.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_5.setBounds(460, 329, 80, 40);
		add(rdbtnNewRadioButton_5);

		rdbtnNewRadioButton_6 = new JRadioButton("5\uB4F1\uAE09");
		rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				rdbtnNewRadioButton_4.setSelected(false);
				rdbtnNewRadioButton_5.setSelected(false);
			}
		});
		rdbtnNewRadioButton_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		rdbtnNewRadioButton_6.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_6.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_6.setBounds(550, 329, 80, 40);
		add(rdbtnNewRadioButton_6);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 780, 1200, 120);
		add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setBounds(625, 40, 200, 50);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PatientAddView.this);
				frame.dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));

		btnNewButton_1 = new JButton("\uCD94\uAC00");
		btnNewButton_1.setBounds(375, 40, 200, 50);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.BLACK);

		btnNewButton_1.addActionListener(new ActionListener() {

			String crNo = null;
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String jumin = textField_1.getText();
				if (rdbtnNewRadioButton_2.isSelected()) {
					crNo = "1µî±Þ";
				} else if (rdbtnNewRadioButton_3.isSelected()) {
					crNo = "2µî±Þ";
				} else if (rdbtnNewRadioButton_4.isSelected()) {
					crNo = "3µî±Þ";
				} else if (rdbtnNewRadioButton_5.isSelected()) {
					crNo = "4µî±Þ";
				} else if (rdbtnNewRadioButton_6.isSelected()) {
					crNo = "5µî±Þ";
				}
				String sex = chckbxNewCheckBox_22.isSelected() ? "³²ÀÚ" : "¿©ÀÚ";
				String tel = textField_3.getText();
				String address = textField_4.getText();
				String diagName = textField_6.getText();
				String height = textField_7.getText();
				String weight = textField_8.getText();
				String relation = textField_14.getText();
				String condition = (String)comboBox.getSelectedItem();
				String meal = (String)comboBox_1.getSelectedItem();
				String urine = (String)comboBox_1_1.getSelectedItem();
				String paral = (String)comboBox_1_1_1.getSelectedItem();
				String exercise = (String)comboBox_1_1_1_1.getSelectedItem();
				String bedsore = (String)comboBox_1_1_1_1_1.getSelectedItem();
				String suction = (String)comboBox_1_1_1_1_1_1.getSelectedItem();
				
				PatientInfoVO vo = new PatientInfoVO(name, jumin, address, tel, sex, height, weight, diagName, crNo, condition, meal, urine, paral, exercise, bedsore, suction, relation);

				// DAO¸¦ ÅëÇØ µ¥ÀÌÅÍº£ÀÌ½º¿¡ È¯ÀÚ Á¤º¸ Ãß°¡
				try {
					dao = new PatientInfoDAO();
					dao.PatientInfo(vo, mg_id);
					mypage.patienttable();
					JOptionPane.showMessageDialog(null, "È¯ÀÚ Á¤º¸°¡ Ãß°¡µÇ¾ú½À´Ï´Ù.");
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PatientAddView.this);
					frame.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "È¯ÀÚ Á¤º¸ Ãß°¡°¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					ex.printStackTrace();
				}
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(0, 390, 1200, 380);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4_6 = new JLabel("Q1. \uC758\uC2DD \uC0C1\uD0DC\uB294 \uC5B4\uB5A4\uAC00\uC694?");
		lblNewLabel_4_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_6.setBounds(270, 20, 300, 30);
		panel_1.add(lblNewLabel_4_6);

		JLabel lblNewLabel_4_1 = new JLabel(
				"Q2. \uC2DD\uC0AC\uB97C \uC5B4\uB5BB\uAC8C \uD558\uACE0 \uACC4\uC2E0\uAC00\uC694?");
		lblNewLabel_4_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(270, 70, 300, 30);
		panel_1.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel(
				"Q3. \uB300\uC18C\uBCC0 \uD574\uACB0\uC740 \uC5B4\uB5BB\uAC8C \uD558\uC2DC\uB098\uC694?");
		lblNewLabel_4_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(270, 120, 300, 30);
		panel_1.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_4 = new JLabel("Q4. \uB9C8\uBE44\uAC00 \uC788\uB294 \uC0C1\uD0DC\uC2E0\uAC00\uC694?");
		lblNewLabel_4_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_4.setBounds(270, 170, 300, 30);
		panel_1.add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_5 = new JLabel(
				"Q5. \uAC70\uB3D9 \uBC0F \uC6B4\uB3D9 \uC0C1\uD0DC\uB294 \uC5B4\uB5A0\uC2E0\uAC00\uC694?");
		lblNewLabel_4_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_5.setBounds(270, 220, 300, 30);
		panel_1.add(lblNewLabel_4_5);

		JLabel lblNewLabel_4_3 = new JLabel("Q6. \uC695\uCC3D\uC774 \uC788\uC73C\uC2E0\uAC00\uC694?");
		lblNewLabel_4_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_3.setBounds(270, 270, 300, 26);
		panel_1.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_7 = new JLabel("Q7. \uC11D\uC158\uC774 \uD544\uC694\uD558\uC2E0\uAC00\uC694?");
		lblNewLabel_4_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4_7.setBounds(270, 320, 300, 30);
		panel_1.add(lblNewLabel_4_7);

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\uC758\uC2DD \uC788\uC74C",
				"\uC758\uC2DD \uC788\uC73C\uB098 \uC758\uC0AC\uC18C\uD1B5 \uC5B4\uB824\uC6C0",
				"\uC758\uC2DD \uC5C6\uC74C" }));
		comboBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox.setBounds(630, 20, 300, 30);
		panel_1.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "\uC2A4\uC2A4\uB85C \uC2DD\uC0AC \uAC00\uB2A5",
				"\uC2DD\uC0AC \uBCF4\uC870 \uD544\uC694\uD568", "\uACBD\uAD00 \uC601\uC591(\uD53C\uB529)",
				"\uC8FC\uC0AC\uB97C \uD1B5\uD55C \uC815\uB9E5 \uC601\uC591" }));
		comboBox_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(630, 70, 300, 30);
		panel_1.add(comboBox_1);

		comboBox_1_1 = new JComboBox();
		comboBox_1_1
				.setModel(new DefaultComboBoxModel(new String[] { "\uC2A4\uC2A4\uB85C \uD654\uC7A5\uC2E4 \uC774\uC6A9",
						"\uB3D9\uD589\uD558\uC5EC \uD654\uC7A5\uC2E4 \uC774\uC6A9", "\uAE30\uC800\uADC0",
						"\uC18C\uBCC0\uC904", "\uC7A5\uB8E8, \uC694\uB8E8" }));
		comboBox_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox_1_1.setBackground(Color.WHITE);
		comboBox_1_1.setBounds(632, 120, 300, 30);
		panel_1.add(comboBox_1_1);

		comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(
				new String[] { "\uC804\uC2E0\uB9C8\uBE44", "\uD3B8\uB9C8\uBE44", "\uC5C6\uC74C" }));
		comboBox_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox_1_1_1.setBackground(Color.WHITE);
		comboBox_1_1_1.setBounds(632, 170, 300, 30);
		panel_1.add(comboBox_1_1_1);

		comboBox_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1
				.setModel(new DefaultComboBoxModel(new String[] { "\uC2A4\uC2A4\uB85C \uAC78\uC744 \uC218 \uC788\uC74C",
						"\uC9C0\uD321\uC774 \uD639\uC740 \uD720\uCCB4\uC5B4 \uBCF4\uC870 \uD544\uC694",
						"\uCE68\uB300\uC5D0\uC11C\uB9CC \uC6C0\uC9C1\uC784\uC774 \uAC00\uB2A5",
						"\uC6C0\uC9C1\uC77C \uC218 \uC5C6\uC74C" }));
		comboBox_1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox_1_1_1_1.setBackground(Color.WHITE);
		comboBox_1_1_1_1.setBounds(630, 220, 300, 30);
		panel_1.add(comboBox_1_1_1_1);

		comboBox_1_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] { "\uC788\uC74C", "\uC5C6\uC74C" }));
		comboBox_1_1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox_1_1_1_1_1.setBackground(Color.WHITE);
		comboBox_1_1_1_1_1.setBounds(630, 275, 300, 30);
		panel_1.add(comboBox_1_1_1_1_1);

		comboBox_1_1_1_1_1_1 = new JComboBox();
		comboBox_1_1_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] { "\uC608", "\uC544\uB2C8\uC624" }));
		comboBox_1_1_1_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comboBox_1_1_1_1_1_1.setBackground(Color.WHITE);
		comboBox_1_1_1_1_1_1.setBounds(630, 327, 300, 30);
		panel_1.add(comboBox_1_1_1_1_1_1);

		JLabel lblNewLabel_6_1_1_1 = new JLabel("  CM");
		lblNewLabel_6_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_6_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_6_1_1_1.setBounds(400, 269, 50, 40);
		add(lblNewLabel_6_1_1_1);

		JLabel lblNewLabel_6_1_2_1 = new JLabel("  KG");
		lblNewLabel_6_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_6_1_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_6_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_6_1_2_1.setBounds(1030, 269, 50, 40);
		add(lblNewLabel_6_1_2_1);

	}
}
