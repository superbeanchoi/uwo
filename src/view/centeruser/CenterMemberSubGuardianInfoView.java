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

public class CenterMemberSubGuardianInfoView extends JPanel implements ActionListener {
	String sgno;
	CenterMemberSearchDAO dao;
	JButton closeBtn;
	private JTextField sgnoText, sgnameText, sgbirthText, sgtelText, sgaddText, sgrelationText;

	/**
	 * Create the panel.
	 */
	
	public CenterMemberSubGuardianInfoView() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public CenterMemberSubGuardianInfoView(String sgno) {
		// TODO Auto-generated constructor stub
		this.sgno=sgno;
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
		
		JLabel headLabel = new JLabel("     \uBD80\uBCF4\uD638\uC790 \uC0C1\uC138 \uC815\uBCF4");
		headLabel.setBounds(0, 0, 600, 70);
		add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));

		JLabel sgnoLabel = new JLabel("\uBD80\uBCF4\uD638\uC790 \uCF54\uB4DC");
		sgnoLabel.setForeground(Color.BLACK);
		sgnoLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgnoLabel.setBackground(Color.WHITE);
		sgnoLabel.setBounds(30, 110, 200, 30);
		add(sgnoLabel);

		sgnoText = new JTextField();
		sgnoText.setToolTipText("");
		sgnoText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgnoText.setEditable(false);
		sgnoText.setColumns(10);
		sgnoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sgnoText.setBackground(Color.WHITE);
		sgnoText.setBounds(230, 110, 150, 30);
		add(sgnoText);
		
		JLabel sgnameLabel = new JLabel("\uBD80\uBCF4\uD638\uC790 \uC774\uB984");
		sgnameLabel.setForeground(Color.BLACK);
		sgnameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgnameLabel.setBackground(Color.WHITE);
		sgnameLabel.setBounds(30, 170, 200, 30);
		add(sgnameLabel);
		
		sgnameText = new JTextField();
		sgnameText.setToolTipText("");
		sgnameText.setText((String) null);
		sgnameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgnameText.setEditable(false);
		sgnameText.setColumns(10);
		sgnameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sgnameText.setBackground(Color.WHITE);
		sgnameText.setBounds(230, 170, 340, 30);
		add(sgnameText);
		
		JLabel sgbirthLabel = new JLabel("\uBD80\uBCF4\uD638\uC790 \uC0DD\uB144\uC6D4\uC77C");
		sgbirthLabel.setForeground(Color.BLACK);
		sgbirthLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgbirthLabel.setBackground(Color.WHITE);
		sgbirthLabel.setBounds(30, 230, 200, 30);
		add(sgbirthLabel);
		
		sgbirthText = new JTextField();
		sgbirthText.setToolTipText("");
		sgbirthText.setText((String) null);
		sgbirthText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgbirthText.setEditable(false);
		sgbirthText.setColumns(10);
		sgbirthText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sgbirthText.setBackground(Color.WHITE);
		sgbirthText.setBounds(230, 230, 340, 30);
		add(sgbirthText);
		
		JLabel sgtelLabel = new JLabel("\uBD80\uBCF4\uD638\uC790 \uC804\uD654\uBC88\uD638");
		sgtelLabel.setForeground(Color.BLACK);
		sgtelLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgtelLabel.setBackground(Color.WHITE);
		sgtelLabel.setBounds(30, 290, 200, 30);
		add(sgtelLabel);
		
		sgtelText = new JTextField();
		sgtelText.setToolTipText("");
		sgtelText.setText((String) null);
		sgtelText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgtelText.setEditable(false);
		sgtelText.setColumns(10);
		sgtelText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sgtelText.setBackground(Color.WHITE);
		sgtelText.setBounds(230, 290, 340, 30);
		add(sgtelText);
		
		JLabel sgaddLabel = new JLabel("\uBD80\uBCF4\uD638\uC790 \uC8FC\uC18C");
		sgaddLabel.setForeground(Color.BLACK);
		sgaddLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgaddLabel.setBackground(Color.WHITE);
		sgaddLabel.setBounds(30, 350, 200, 30);
		add(sgaddLabel);
		
		sgaddText = new JTextField();
		sgaddText.setToolTipText("");
		sgaddText.setText((String) null);
		sgaddText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgaddText.setEditable(false);
		sgaddText.setColumns(10);
		sgaddText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sgaddText.setBackground(Color.WHITE);
		sgaddText.setBounds(230, 350, 340, 30);
		add(sgaddText);
		
		JLabel sgrelationLabel = new JLabel("\uD658\uC790\uC640\uC758 \uAD00\uACC4");
		sgrelationLabel.setForeground(Color.BLACK);
		sgrelationLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgrelationLabel.setBackground(Color.WHITE);
		sgrelationLabel.setBounds(30, 410, 200, 30);
		add(sgrelationLabel);
		
		sgrelationText = new JTextField();
		sgrelationText.setToolTipText("");
		sgrelationText.setText((String) null);
		sgrelationText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sgrelationText.setEditable(false);
		sgrelationText.setColumns(10);
		sgrelationText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sgrelationText.setBackground(Color.WHITE);
		sgrelationText.setBounds(230, 410, 340, 30);
		add(sgrelationText);
		
		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBackground(new Color(0, 0, 0));
		closeBtn.setBounds(220, 525, 160, 50);
		add(closeBtn);
		
		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 500, 600, 100);
		add(footLabel);
		
		eventProc();
		
		try {
			CenterMemberSearchVO vo = new CenterMemberSearchVO();
			vo = dao.detailsubGuradianInfoSelect(sgno);
			sgnoText.setText(sgno);
			sgnameText.setText(vo.getSg_name());
			sgbirthText.setText(vo.getSg_birth().substring(0, 10));
			sgtelText.setText(vo.getSg_tel());
			sgaddText.setText(vo.getSg_add());
			sgrelationText.setText(vo.getSg_relation());
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
