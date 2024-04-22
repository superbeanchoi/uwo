package view.centeruser;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dao.centeruserDAO.MatchingDAO;
import dao.guardianuserDAO.NurseInfoDAO;
import vo.centeruserVO.MatchingVO;
import vo.guardianuserVO.NurseInfoVO;
import vo.nurseuserVO.NurseMypageInfoVO;

public class MatchingPatientInfoView extends JFrame {

	JPanel contentPane;
	JButton newMemBtn;
	MatchingDAO dao;
	private String nuId;
	String mg_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchingPatientInfoView frame = new MatchingPatientInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public MatchingPatientInfoView() {
		initialize(); // »ý¼ºÀÚ ³»¿ëÀ» ¸Þ¼Òµå·Î µû·Î ºÐ¸®
	}

	private JLabel patientDiagLabel;
	private JTextField patientDiagText;
	private JLabel patientNoLabel;
	private JTextField patientNoText;
	private JPanel healthinfoPanel;
	private JLabel conditionLabel;
	private JTextField conditionText;
	private JLabel mealLabel;
	private JTextField mealText;
	private JLabel urineLabel;
	private JTextField urineText;
	private JLabel paralLabel;
	private JTextField paralText;
	private JLabel exerciseLabel;
	private JTextField exerciseText;
	private JLabel bedsoreLabel;
	private JTextField bedsoreText;
	private JLabel suctionLabel;
	private JTextField suctionText;
	private JLabel heightLabel;
	private JTextField heightText;
	private JTextField weightText;
	private JLabel weightLabel;
	private JLabel cmLabel;
	private JLabel kgLabel;
	private JPanel mginfoPanel;
	private JLabel mgidLabel;
	private JTextField mgidText;
	private JLabel mgnameLabel;
	private JTextField mgnameText;
	private JLabel mgbirthLabel;
	private JTextField mgbirthText;
	private JLabel mgsexLabel;
	private JTextField mgsexText;
	private JTextField mgtelText;
	private JLabel mgtelLabel;
	private JPanel patientinfoPanel;
	private JLabel patientcodeLabel;
	private JTextField patientcodeText;
	private JLabel patientnameLabel;
	private JTextField patientnameText;
	private JLabel patientJuminLabel;
	private JTextField patientJuminText;
	private JLabel patientSexLabel;
	private JTextField patientSexText;
	private JTextField patientTelText;
	private JLabel patientTelLabel;
	private JLabel mgaddLabel;
	private JTextField mgaddText;
	private JLabel patientAddLabel;
	private JTextField patientAddText;
	
	String ptcode;

	public MatchingPatientInfoView(String ptcode) {
		this.ptcode=ptcode;
		initialize(); // »ý¼ºÀÚ ³»¿ëÀ» ¸Þ¼Òµå·Î µû·Î ºÐ¸®
	}

	private void initialize() {
		// TODO Auto-generated method stub

		// DB ¿¬°á
		try {
			dao = new MatchingDAO();
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
		setBounds(100, 100, 1215, 935);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocation(680, 285);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel headPanel = new JPanel();
		headPanel.setBounds(0, 0, 1199, 50);
		headPanel.setBackground(new Color(255, 228, 225));
		contentPane.add(headPanel);
		headPanel.setLayout(null);

		JLabel NewMemLabel = new JLabel("  \uC0C1\uC138 \uC815\uBCF4");
		NewMemLabel.setBounds(0, 0, 1200, 50);
		NewMemLabel.setForeground(new Color(0, 0, 0));
		NewMemLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		NewMemLabel.setBackground(new Color(255, 228, 225));
		headPanel.add(NewMemLabel);

		newMemBtn = new JButton("\uB2EB\uAE30");
		newMemBtn.setBounds(524, 715, 150, 50);
		newMemBtn.setForeground(new Color(255, 255, 255));
		newMemBtn.setBackground(new Color(0, 0, 0));
		newMemBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		contentPane.add(newMemBtn);
		newMemBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Ã¢À» ´Ý´Â ÄÚµå
				dispose(); // ÀÌ ¸Þ¼Òµå´Â ÇöÀç Ã¢À» ´Ý½À´Ï´Ù.
			}
		});

		JPanel footPanel = new JPanel();
		footPanel.setBounds(0, 811, 1200, 85);
		footPanel.setBackground(new Color(255, 228, 225));
		contentPane.add(footPanel);
		
		healthinfoPanel = new JPanel();
		healthinfoPanel.setLayout(null);
		healthinfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790 \uAC74\uAC15 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		healthinfoPanel.setBackground(Color.WHITE);
		healthinfoPanel.setBounds(425, 80, 748, 605);
		contentPane.add(healthinfoPanel);
		
		conditionLabel = new JLabel("\uC758\uC2DD \uC0C1\uD0DC");
		conditionLabel.setForeground(Color.BLACK);
		conditionLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		conditionLabel.setBackground(Color.WHITE);
		conditionLabel.setBounds(22, 165, 200, 40);
		healthinfoPanel.add(conditionLabel);
		
		conditionText = new JTextField();
		conditionText.setToolTipText("");
		conditionText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		conditionText.setEditable(false);
		conditionText.setColumns(10);
		conditionText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		conditionText.setBackground(Color.WHITE);
		conditionText.setBounds(222, 165, 500, 40);
		healthinfoPanel.add(conditionText);
		
		mealLabel = new JLabel("\uC2DD\uC0AC \uAC00\uB2A5 \uC5EC\uBD80");
		mealLabel.setForeground(Color.BLACK);
		mealLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mealLabel.setBackground(Color.WHITE);
		mealLabel.setBounds(22, 225, 200, 40);
		healthinfoPanel.add(mealLabel);
		
		mealText = new JTextField();
		mealText.setToolTipText("");
		mealText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mealText.setEditable(false);
		mealText.setColumns(10);
		mealText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mealText.setBackground(Color.WHITE);
		mealText.setBounds(222, 225, 500, 40);
		healthinfoPanel.add(mealText);
		
		urineLabel = new JLabel("\uB300\uC18C\uBCC0 \uD574\uACB0 \uAC00\uB2A5 \uC5EC\uBD80");
		urineLabel.setForeground(Color.BLACK);
		urineLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		urineLabel.setBackground(Color.WHITE);
		urineLabel.setBounds(22, 285, 200, 40);
		healthinfoPanel.add(urineLabel);
		
		urineText = new JTextField();
		urineText.setToolTipText("");
		urineText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		urineText.setEditable(false);
		urineText.setColumns(10);
		urineText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		urineText.setBackground(Color.WHITE);
		urineText.setBounds(222, 285, 500, 40);
		healthinfoPanel.add(urineText);
		
		paralLabel = new JLabel("\uB9C8\uBE44 \uC5EC\uBD80");
		paralLabel.setForeground(Color.BLACK);
		paralLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paralLabel.setBackground(Color.WHITE);
		paralLabel.setBounds(22, 345, 200, 40);
		healthinfoPanel.add(paralLabel);
		
		paralText = new JTextField();
		paralText.setToolTipText("");
		paralText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paralText.setEditable(false);
		paralText.setColumns(10);
		paralText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paralText.setBackground(Color.WHITE);
		paralText.setBounds(222, 345, 500, 40);
		healthinfoPanel.add(paralText);
		
		exerciseLabel = new JLabel("\uAC70\uB3D9 \uBC0F \uC6B4\uB3D9 \uC0C1\uD0DC");
		exerciseLabel.setForeground(Color.BLACK);
		exerciseLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		exerciseLabel.setBackground(Color.WHITE);
		exerciseLabel.setBounds(22, 405, 200, 40);
		healthinfoPanel.add(exerciseLabel);
		
		exerciseText = new JTextField();
		exerciseText.setToolTipText("");
		exerciseText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		exerciseText.setEditable(false);
		exerciseText.setColumns(10);
		exerciseText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		exerciseText.setBackground(Color.WHITE);
		exerciseText.setBounds(222, 405, 500, 40);
		healthinfoPanel.add(exerciseText);
		
		bedsoreLabel = new JLabel("\uC695\uCC3D \uC5EC\uBD80");
		bedsoreLabel.setForeground(Color.BLACK);
		bedsoreLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bedsoreLabel.setBackground(Color.WHITE);
		bedsoreLabel.setBounds(22, 465, 200, 40);
		healthinfoPanel.add(bedsoreLabel);
		
		bedsoreText = new JTextField();
		bedsoreText.setToolTipText("");
		bedsoreText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bedsoreText.setEditable(false);
		bedsoreText.setColumns(10);
		bedsoreText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bedsoreText.setBackground(Color.WHITE);
		bedsoreText.setBounds(222, 465, 500, 40);
		healthinfoPanel.add(bedsoreText);
		
		suctionLabel = new JLabel("\uC11D\uC158 \uD544\uC694 \uC5EC\uBD80");
		suctionLabel.setForeground(Color.BLACK);
		suctionLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		suctionLabel.setBackground(Color.WHITE);
		suctionLabel.setBounds(22, 525, 200, 40);
		healthinfoPanel.add(suctionLabel);
		
		suctionText = new JTextField();
		suctionText.setToolTipText("");
		suctionText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		suctionText.setEditable(false);
		suctionText.setColumns(10);
		suctionText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		suctionText.setBackground(Color.WHITE);
		suctionText.setBounds(222, 525, 500, 40);
		healthinfoPanel.add(suctionText);
		
		patientDiagLabel = new JLabel("\uC8FC\uC694 \uC9C4\uB2E8\uBA85");
		patientDiagLabel.setBounds(22, 105, 120, 40);
		healthinfoPanel.add(patientDiagLabel);
		patientDiagLabel.setForeground(Color.BLACK);
		patientDiagLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientDiagLabel.setBackground(Color.WHITE);
		
		patientDiagText = new JTextField();
		patientDiagText.setBounds(142, 105, 200, 40);
		healthinfoPanel.add(patientDiagText);
		patientDiagText.setToolTipText("");
		patientDiagText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientDiagText.setEditable(false);
		patientDiagText.setColumns(10);
		patientDiagText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientDiagText.setBackground(Color.WHITE);
		
		patientNoLabel = new JLabel("\uC694\uC591\uB4F1\uAE09");
		patientNoLabel.setBounds(402, 105, 120, 40);
		healthinfoPanel.add(patientNoLabel);
		patientNoLabel.setForeground(Color.BLACK);
		patientNoLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientNoLabel.setBackground(Color.WHITE);
		
		patientNoText = new JTextField();
		patientNoText.setBounds(522, 105, 200, 40);
		healthinfoPanel.add(patientNoText);
		patientNoText.setToolTipText("");
		patientNoText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientNoText.setEditable(false);
		patientNoText.setColumns(10);
		patientNoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientNoText.setBackground(Color.WHITE);
		
		heightLabel = new JLabel("\uD0A4");
		heightLabel.setForeground(Color.BLACK);
		heightLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		heightLabel.setBackground(Color.WHITE);
		heightLabel.setBounds(22, 45, 120, 40);
		healthinfoPanel.add(heightLabel);
		
		heightText = new JTextField();
		heightText.setToolTipText("");
		heightText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		heightText.setEditable(false);
		heightText.setColumns(10);
		heightText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		heightText.setBackground(Color.WHITE);
		heightText.setBounds(142, 45, 150, 40);
		healthinfoPanel.add(heightText);
		
		weightText = new JTextField();
		weightText.setToolTipText("");
		weightText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		weightText.setEditable(false);
		weightText.setColumns(10);
		weightText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		weightText.setBackground(Color.WHITE);
		weightText.setBounds(522, 45, 150, 40);
		healthinfoPanel.add(weightText);
		
		weightLabel = new JLabel("\uBAB8\uBB34\uAC8C");
		weightLabel.setForeground(Color.BLACK);
		weightLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		weightLabel.setBackground(Color.WHITE);
		weightLabel.setBounds(402, 45, 120, 40);
		healthinfoPanel.add(weightLabel);
		
		cmLabel = new JLabel(" CM");
		cmLabel.setForeground(Color.BLACK);
		cmLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		cmLabel.setBackground(Color.WHITE);
		cmLabel.setBounds(292, 45, 50, 40);
		healthinfoPanel.add(cmLabel);
		
		kgLabel = new JLabel(" KG");
		kgLabel.setForeground(Color.BLACK);
		kgLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		kgLabel.setBackground(Color.WHITE);
		kgLabel.setBounds(672, 45, 50, 40);
		healthinfoPanel.add(kgLabel);
		
		mginfoPanel = new JPanel();
		mginfoPanel.setLayout(null);
		mginfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC8FC\uBCF4\uD638\uC790 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mginfoPanel.setBackground(Color.WHITE);
		mginfoPanel.setBounds(22, 80, 380, 294);
		contentPane.add(mginfoPanel);
		
		mgidLabel = new JLabel("\uC544\uC774\uB514");
		mgidLabel.setForeground(Color.BLACK);
		mgidLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgidLabel.setBackground(Color.WHITE);
		mgidLabel.setBounds(20, 25, 120, 30);
		mginfoPanel.add(mgidLabel);
		
		mgidText = new JTextField();
		mgidText.setToolTipText("");
		mgidText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgidText.setEditable(false);
		mgidText.setColumns(10);
		mgidText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mgidText.setBackground(Color.WHITE);
		mgidText.setBounds(140, 25, 200, 30);
		mginfoPanel.add(mgidText);
		
		mgnameLabel = new JLabel("\uC774\uB984");
		mgnameLabel.setForeground(Color.BLACK);
		mgnameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgnameLabel.setBackground(Color.WHITE);
		mgnameLabel.setBounds(20, 70, 120, 30);
		mginfoPanel.add(mgnameLabel);
		
		mgnameText = new JTextField();
		mgnameText.setToolTipText("");
		mgnameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgnameText.setEditable(false);
		mgnameText.setColumns(10);
		mgnameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mgnameText.setBackground(Color.WHITE);
		mgnameText.setBounds(140, 70, 200, 30);
		mginfoPanel.add(mgnameText);
		
		mgbirthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		mgbirthLabel.setForeground(Color.BLACK);
		mgbirthLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgbirthLabel.setBackground(Color.WHITE);
		mgbirthLabel.setBounds(20, 115, 120, 30);
		mginfoPanel.add(mgbirthLabel);
		
		mgbirthText = new JTextField();
		mgbirthText.setToolTipText("");
		mgbirthText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgbirthText.setEditable(false);
		mgbirthText.setColumns(10);
		mgbirthText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mgbirthText.setBackground(Color.WHITE);
		mgbirthText.setBounds(140, 115, 200, 30);
		mginfoPanel.add(mgbirthText);
		
		mgsexLabel = new JLabel("\uC131\uBCC4");
		mgsexLabel.setForeground(Color.BLACK);
		mgsexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgsexLabel.setBackground(Color.WHITE);
		mgsexLabel.setBounds(20, 160, 120, 30);
		mginfoPanel.add(mgsexLabel);
		
		mgsexText = new JTextField();
		mgsexText.setToolTipText("");
		mgsexText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgsexText.setEditable(false);
		mgsexText.setColumns(10);
		mgsexText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mgsexText.setBackground(Color.WHITE);
		mgsexText.setBounds(140, 160, 200, 30);
		mginfoPanel.add(mgsexText);
		
		mgtelText = new JTextField();
		mgtelText.setToolTipText("");
		mgtelText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgtelText.setEditable(false);
		mgtelText.setColumns(10);
		mgtelText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mgtelText.setBackground(Color.WHITE);
		mgtelText.setBounds(140, 205, 200, 30);
		mginfoPanel.add(mgtelText);
		
		mgtelLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		mgtelLabel.setForeground(Color.BLACK);
		mgtelLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgtelLabel.setBackground(Color.WHITE);
		mgtelLabel.setBounds(20, 205, 120, 30);
		mginfoPanel.add(mgtelLabel);
		
		mgaddLabel = new JLabel("\uC8FC\uC18C");
		mgaddLabel.setBounds(20, 250, 120, 30);
		mginfoPanel.add(mgaddLabel);
		mgaddLabel.setForeground(Color.BLACK);
		mgaddLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgaddLabel.setBackground(Color.WHITE);
		
		mgaddText = new JTextField();
		mgaddText.setBounds(140, 250, 200, 30);
		mginfoPanel.add(mgaddText);
		mgaddText.setToolTipText("");
		mgaddText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mgaddText.setEditable(false);
		mgaddText.setColumns(10);
		mgaddText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mgaddText.setBackground(Color.WHITE);
		
		patientinfoPanel = new JPanel();
		patientinfoPanel.setLayout(null);
		patientinfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790 \uAE30\uBCF8 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		patientinfoPanel.setBackground(Color.WHITE);
		patientinfoPanel.setBounds(22, 385, 380, 300);
		contentPane.add(patientinfoPanel);
		
		patientcodeLabel = new JLabel("\uD658\uC790 \uCF54\uB4DC");
		patientcodeLabel.setForeground(Color.BLACK);
		patientcodeLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientcodeLabel.setBackground(Color.WHITE);
		patientcodeLabel.setBounds(20, 25, 120, 30);
		patientinfoPanel.add(patientcodeLabel);
		
		patientcodeText = new JTextField();
		patientcodeText.setToolTipText("");
		patientcodeText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientcodeText.setEditable(false);
		patientcodeText.setColumns(10);
		patientcodeText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientcodeText.setBackground(Color.WHITE);
		patientcodeText.setBounds(140, 25, 200, 30);
		patientinfoPanel.add(patientcodeText);
		
		patientnameLabel = new JLabel("\uC774\uB984");
		patientnameLabel.setForeground(Color.BLACK);
		patientnameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientnameLabel.setBackground(Color.WHITE);
		patientnameLabel.setBounds(20, 70, 120, 30);
		patientinfoPanel.add(patientnameLabel);
		
		patientnameText = new JTextField();
		patientnameText.setToolTipText("");
		patientnameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientnameText.setEditable(false);
		patientnameText.setColumns(10);
		patientnameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientnameText.setBackground(Color.WHITE);
		patientnameText.setBounds(140, 70, 200, 30);
		patientinfoPanel.add(patientnameText);
		
		patientJuminLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		patientJuminLabel.setForeground(Color.BLACK);
		patientJuminLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientJuminLabel.setBackground(Color.WHITE);
		patientJuminLabel.setBounds(20, 115, 120, 30);
		patientinfoPanel.add(patientJuminLabel);
		
		patientJuminText = new JTextField();
		patientJuminText.setToolTipText("");
		patientJuminText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientJuminText.setEditable(false);
		patientJuminText.setColumns(10);
		patientJuminText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientJuminText.setBackground(Color.WHITE);
		patientJuminText.setBounds(140, 115, 200, 30);
		patientinfoPanel.add(patientJuminText);
		
		patientSexLabel = new JLabel("\uC131\uBCC4");
		patientSexLabel.setForeground(Color.BLACK);
		patientSexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientSexLabel.setBackground(Color.WHITE);
		patientSexLabel.setBounds(20, 160, 120, 30);
		patientinfoPanel.add(patientSexLabel);
		
		patientSexText = new JTextField();
		patientSexText.setToolTipText("");
		patientSexText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientSexText.setEditable(false);
		patientSexText.setColumns(10);
		patientSexText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientSexText.setBackground(Color.WHITE);
		patientSexText.setBounds(140, 160, 200, 30);
		patientinfoPanel.add(patientSexText);
		
		patientTelText = new JTextField();
		patientTelText.setToolTipText("");
		patientTelText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientTelText.setEditable(false);
		patientTelText.setColumns(10);
		patientTelText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientTelText.setBackground(Color.WHITE);
		patientTelText.setBounds(140, 205, 200, 30);
		patientinfoPanel.add(patientTelText);
		
		patientTelLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		patientTelLabel.setForeground(Color.BLACK);
		patientTelLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientTelLabel.setBackground(Color.WHITE);
		patientTelLabel.setBounds(20, 205, 120, 30);
		patientinfoPanel.add(patientTelLabel);
		
		patientAddLabel = new JLabel("\uC8FC\uC18C");
		patientAddLabel.setForeground(Color.BLACK);
		patientAddLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientAddLabel.setBackground(Color.WHITE);
		patientAddLabel.setBounds(20, 250, 120, 30);
		patientinfoPanel.add(patientAddLabel);
		
		patientAddText = new JTextField();
		patientAddText.setToolTipText("");
		patientAddText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		patientAddText.setEditable(false);
		patientAddText.setColumns(10);
		patientAddText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		patientAddText.setBackground(Color.WHITE);
		patientAddText.setBounds(140, 250, 200, 30);
		patientinfoPanel.add(patientAddText);

		try {
			MatchingVO vo = dao.patientinfoSelect(ptcode);
			mgidText.setText(vo.getMg_id());
			mgnameText.setText(vo.getMg_name());
			mgbirthText.setText(vo.getMg_birth().substring(0, 10));
			mgsexText.setText(vo.getMg_sex());
			mgtelText.setText(vo.getMg_tel());
			mgaddText.setText(vo.getMg_add());
			
			patientcodeText.setText(vo.getPt_no());
			patientnameText.setText(vo.getPt_name());
			patientJuminText.setText(vo.getPt_jumin());
			patientSexText.setText(vo.getPt_sex());
			patientTelText.setText(vo.getPt_tel());
			patientAddText.setText(vo.getPt_add());
			
			heightText.setText(vo.getPt_height());
			weightText.setText(vo.getPt_weight());
			patientDiagText.setText(vo.getPt_diagname());
			patientNoText.setText(vo.getCr_no());
			conditionText.setText(vo.getPt_condition());
			mealText.setText(vo.getPt_meal());
			urineText.setText(vo.getPt_urine());
			paralText.setText(vo.getPt_paral());
			exerciseText.setText(vo.getPt_exercise());
			bedsoreText.setText(vo.getPt_bedsore());
			suctionText.setText(vo.getPt_suction());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}

	}

}
