package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dao.centeruserDAO.CenterMemberSearchDAO;
import vo.centeruserVO.CenterMemberSearchVO;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CenterMemberPatientHealthInfoView extends JPanel implements ActionListener {
	String ptno;
	CenterMemberSearchDAO dao;
	private JTextField ptnoText, diagnameText, heightText, weightText;
	private JTextField conditionText, mealText, urineText, paralText, exerciseText, bedsoreText, suctionText;
	JButton closeBtn;

	/**
	 * Create the panel.
	 */
	
	public CenterMemberPatientHealthInfoView() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public CenterMemberPatientHealthInfoView(String ptno) {
		// TODO Auto-generated constructor stub
		this.ptno=ptno;
		initialize();
	}
	
	public void initialize() {
		//DB ¿¬°á
		try {
			dao = new CenterMemberSearchDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel headLabel = new JLabel("     \uD658\uC790 \uAC74\uAC15 \uC815\uBCF4");
		headLabel.setBounds(0, 0, 600, 70);
		add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));

		JLabel ptnoLabel = new JLabel("\uD658\uC790 \uCF54\uB4DC");
		ptnoLabel.setForeground(Color.BLACK);
		ptnoLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ptnoLabel.setBackground(Color.WHITE);
		ptnoLabel.setBounds(30, 90, 200, 30);
		add(ptnoLabel);
		
		ptnoText = new JTextField();
		ptnoText.setToolTipText("");
		ptnoText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ptnoText.setEditable(false);
		ptnoText.setColumns(10);
		ptnoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ptnoText.setBackground(Color.WHITE);
		ptnoText.setBounds(230, 90, 150, 30);
		add(ptnoText);
		
		JPanel simplehealthinfoPanel = new JPanel();
		simplehealthinfoPanel.setLayout(null);
		simplehealthinfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790 \uAE30\uBCF8 \uAC74\uAC15 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		simplehealthinfoPanel.setBackground(Color.WHITE);
		simplehealthinfoPanel.setBounds(10, 140, 580, 180);
		add(simplehealthinfoPanel);
		
		JLabel diagnameLabel = new JLabel("\uC8FC\uC694 \uC9C4\uB2E8\uBA85");
		diagnameLabel.setForeground(Color.BLACK);
		diagnameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		diagnameLabel.setBackground(Color.WHITE);
		diagnameLabel.setBounds(20, 30, 200, 30);
		simplehealthinfoPanel.add(diagnameLabel);
		
		diagnameText = new JTextField();
		diagnameText.setToolTipText("");
		diagnameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		diagnameText.setEditable(false);
		diagnameText.setColumns(10);
		diagnameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		diagnameText.setBackground(Color.WHITE);
		diagnameText.setBounds(220, 30, 340, 30);
		simplehealthinfoPanel.add(diagnameText);
		
		JLabel heightLabel = new JLabel("\uD0A4");
		heightLabel.setForeground(Color.BLACK);
		heightLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		heightLabel.setBackground(Color.WHITE);
		heightLabel.setBounds(20, 80, 200, 30);
		simplehealthinfoPanel.add(heightLabel);
		
		heightText = new JTextField();
		heightText.setToolTipText("");
		heightText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		heightText.setEditable(false);
		heightText.setColumns(10);
		heightText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		heightText.setBackground(Color.WHITE);
		heightText.setBounds(220, 80, 270, 30);
		simplehealthinfoPanel.add(heightText);
		
		JLabel weightLabel = new JLabel("\uBAB8\uBB34\uAC8C");
		weightLabel.setForeground(Color.BLACK);
		weightLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		weightLabel.setBackground(Color.WHITE);
		weightLabel.setBounds(20, 130, 200, 30);
		simplehealthinfoPanel.add(weightLabel);
		
		weightText = new JTextField();
		weightText.setToolTipText("");
		weightText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		weightText.setEditable(false);
		weightText.setColumns(10);
		weightText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		weightText.setBackground(Color.WHITE);
		weightText.setBounds(220, 130, 270, 30);
		simplehealthinfoPanel.add(weightText);
		
		JLabel cmLabel = new JLabel(" CM");
		cmLabel.setForeground(Color.BLACK);
		cmLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		cmLabel.setBackground(Color.WHITE);
		cmLabel.setBounds(490, 80, 70, 30);
		simplehealthinfoPanel.add(cmLabel);
		
		JLabel kgLabel = new JLabel(" KG");
		kgLabel.setForeground(Color.BLACK);
		kgLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		kgLabel.setBackground(Color.WHITE);
		kgLabel.setBounds(490, 130, 70, 30);
		simplehealthinfoPanel.add(kgLabel);
		
		JPanel detailhealthinfoPanel = new JPanel();
		detailhealthinfoPanel.setLayout(null);
		detailhealthinfoPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uD658\uC790 \uC0C1\uC138 \uAC74\uAC15 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		detailhealthinfoPanel.setBackground(Color.WHITE);
		detailhealthinfoPanel.setBounds(10, 350, 580, 380);
		add(detailhealthinfoPanel);
		
		JLabel conditionLabel = new JLabel("\uC758\uC2DD \uC0C1\uD0DC");
		conditionLabel.setForeground(Color.BLACK);
		conditionLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		conditionLabel.setBackground(Color.WHITE);
		conditionLabel.setBounds(20, 30, 200, 30);
		detailhealthinfoPanel.add(conditionLabel);
		
		conditionText = new JTextField();
		conditionText.setToolTipText("");
		conditionText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		conditionText.setEditable(false);
		conditionText.setColumns(10);
		conditionText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		conditionText.setBackground(Color.WHITE);
		conditionText.setBounds(220, 30, 340, 30);
		detailhealthinfoPanel.add(conditionText);
		
		JLabel mealLabel = new JLabel("\uC2DD\uC0AC \uAC00\uB2A5 \uC5EC\uBD80");
		mealLabel.setForeground(Color.BLACK);
		mealLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mealLabel.setBackground(Color.WHITE);
		mealLabel.setBounds(20, 80, 200, 30);
		detailhealthinfoPanel.add(mealLabel);
		
		mealText = new JTextField();
		mealText.setToolTipText("");
		mealText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mealText.setEditable(false);
		mealText.setColumns(10);
		mealText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mealText.setBackground(Color.WHITE);
		mealText.setBounds(220, 80, 340, 30);
		detailhealthinfoPanel.add(mealText);
		
		JLabel urineLabel = new JLabel("\uB300\uC18C\uBCC0 \uD574\uACB0 \uAC00\uB2A5 \uC5EC\uBD80");
		urineLabel.setForeground(Color.BLACK);
		urineLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		urineLabel.setBackground(Color.WHITE);
		urineLabel.setBounds(20, 130, 200, 30);
		detailhealthinfoPanel.add(urineLabel);
		
		urineText = new JTextField();
		urineText.setToolTipText("");
		urineText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		urineText.setEditable(false);
		urineText.setColumns(10);
		urineText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		urineText.setBackground(Color.WHITE);
		urineText.setBounds(220, 130, 340, 30);
		detailhealthinfoPanel.add(urineText);
		
		JLabel paralLabel = new JLabel("\uB9C8\uBE44 \uC5EC\uBD80");
		paralLabel.setForeground(Color.BLACK);
		paralLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paralLabel.setBackground(Color.WHITE);
		paralLabel.setBounds(20, 180, 200, 30);
		detailhealthinfoPanel.add(paralLabel);
		
		paralText = new JTextField();
		paralText.setToolTipText("");
		paralText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paralText.setEditable(false);
		paralText.setColumns(10);
		paralText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paralText.setBackground(Color.WHITE);
		paralText.setBounds(220, 180, 340, 30);
		detailhealthinfoPanel.add(paralText);
		
		JLabel exerciseLabel = new JLabel("\uAC70\uB3D9 \uBC0F \uC6B4\uB3D9 \uC0C1\uD0DC");
		exerciseLabel.setForeground(Color.BLACK);
		exerciseLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		exerciseLabel.setBackground(Color.WHITE);
		exerciseLabel.setBounds(20, 230, 200, 30);
		detailhealthinfoPanel.add(exerciseLabel);
		
		exerciseText = new JTextField();
		exerciseText.setToolTipText("");
		exerciseText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		exerciseText.setEditable(false);
		exerciseText.setColumns(10);
		exerciseText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		exerciseText.setBackground(Color.WHITE);
		exerciseText.setBounds(220, 230, 340, 30);
		detailhealthinfoPanel.add(exerciseText);
		
		JLabel bedsoreLabel = new JLabel("\uC695\uCC3D \uC5EC\uBD80");
		bedsoreLabel.setForeground(Color.BLACK);
		bedsoreLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bedsoreLabel.setBackground(Color.WHITE);
		bedsoreLabel.setBounds(20, 280, 200, 30);
		detailhealthinfoPanel.add(bedsoreLabel);
		
		bedsoreText = new JTextField();
		bedsoreText.setToolTipText("");
		bedsoreText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		bedsoreText.setEditable(false);
		bedsoreText.setColumns(10);
		bedsoreText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		bedsoreText.setBackground(Color.WHITE);
		bedsoreText.setBounds(220, 280, 340, 30);
		detailhealthinfoPanel.add(bedsoreText);
		
		JLabel suctionLabel = new JLabel("\uC11D\uC158 \uD544\uC694 \uC5EC\uBD80");
		suctionLabel.setForeground(Color.BLACK);
		suctionLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		suctionLabel.setBackground(Color.WHITE);
		suctionLabel.setBounds(20, 330, 200, 30);
		detailhealthinfoPanel.add(suctionLabel);
		
		suctionText = new JTextField();
		suctionText.setToolTipText("");
		suctionText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		suctionText.setEditable(false);
		suctionText.setColumns(10);
		suctionText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		suctionText.setBackground(Color.WHITE);
		suctionText.setBounds(220, 330, 340, 30);
		detailhealthinfoPanel.add(suctionText);
		
		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBackground(new Color(0, 0, 0));
		closeBtn.setBounds(220, 800, 160, 50);
		add(closeBtn);

		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 760, 600, 140);
		add(footLabel);
		
		eventProc();
		
		try {
			CenterMemberSearchVO vo = new CenterMemberSearchVO();
			vo = dao.detailPatientInfoSelect(ptno);
			ptnoText.setText(ptno);
			diagnameText.setText(vo.getPt_diagname());
			heightText.setText(vo.getPt_height());
			weightText.setText(vo.getPt_weight());
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
	
	public void eventProc() {
		closeBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==closeBtn) {
			SwingUtilities.getWindowAncestor(this).dispose();
		}
	}
	
	
	
}
