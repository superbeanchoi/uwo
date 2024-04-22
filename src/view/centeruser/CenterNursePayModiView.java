package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.centeruserDAO.CenterPayDAO;
import vo.centeruserVO.CenterPayVO;

public class CenterNursePayModiView extends JPanel {

	public JTextField paynotext;
	public JTextField nuidtext;
	public JTextField yearmonthtext;
	public JTextField sumpaytext;
	public JTextField taxtext;
	public JTextField feetext;
	public JTextField reciepttext;
	public JTextField paydatetext;
	public JTextField paystatustext;
	JButton nursePaySave;

	CenterPayDAO dao;
	CenterPayVO vo;
	private CenterPayView parentView;
	String nuid, ssno;

	public CenterNursePayModiView(CenterPayView parentView, String nuid, String ssno) {
		setBackground(new Color(255, 255, 255));
		this.parentView = parentView;
		this.nuid=nuid;
		this.ssno = ssno;
		initialize();
	}

	public void initialize() {

		try {
			dao = new CenterPayDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n" + e.getMessage());
			e.printStackTrace();
		}
		setLayout(null);

		JLabel paynolabel = new JLabel("\uAE09\uC5EC\uC815\uC0B0\uC11C \uCF54\uB4DC");
		paynolabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paynolabel.setBounds(100, 150, 150, 30);
		add(paynolabel);

		JLabel nuidlabel = new JLabel("\uC694\uC591\uBCF4\uD638\uC0AC \uC544\uC774\uB514");
		nuidlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nuidlabel.setBounds(100, 210, 150, 30);
		add(nuidlabel);

		JLabel yearmonthlabel = new JLabel("ÇØ´ç ³â¿ù");
		yearmonthlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		yearmonthlabel.setBounds(100, 270, 150, 30);
		add(yearmonthlabel);

		JLabel sumpaylabel = new JLabel("ÃÑ±Þ¿©");
		sumpaylabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sumpaylabel.setBounds(100, 330, 150, 30);
		add(sumpaylabel);

		JLabel taxlabel = new JLabel("¼¼±Ý");
		taxlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		taxlabel.setBounds(100, 390, 150, 30);
		add(taxlabel);

		JLabel feelabel = new JLabel("Áß°³ ¼ö¼ö·á");
		feelabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		feelabel.setBounds(100, 450, 150, 30);
		add(feelabel);

		JLabel recieptlabel = new JLabel("½Ç¼ö·É¾×");
		recieptlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		recieptlabel.setBounds(100, 510, 150, 30);
		add(recieptlabel);

		JLabel paydatelabel = new JLabel("Áö±ÞÀÏÀÚ");
		paydatelabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paydatelabel.setBounds(100, 570, 150, 30);
		add(paydatelabel);

		JLabel paystatuslabel = new JLabel("Áö±Þ¿©ºÎ");
		paystatuslabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paystatuslabel.setBounds(100, 630, 150, 30);
		add(paystatuslabel);

		paynotext = new JTextField();
		paynotext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paynotext.setEditable(false);
		paynotext.setColumns(10);
		paynotext.setBounds(250, 150, 250, 30);
		add(paynotext);

		nuidtext = new JTextField();
		nuidtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nuidtext.setEditable(false);
		nuidtext.setColumns(10);
		nuidtext.setBounds(250, 210, 250, 30);
		add(nuidtext);

		yearmonthtext = new JTextField();
		yearmonthtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		yearmonthtext.setColumns(10);
		yearmonthtext.setBounds(250, 270, 250, 30);
		add(yearmonthtext);

		sumpaytext = new JTextField();
		sumpaytext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sumpaytext.setColumns(10);
		sumpaytext.setBounds(250, 330, 250, 30);
		add(sumpaytext);

		taxtext = new JTextField();
		taxtext.setEditable(false);
		taxtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		taxtext.setColumns(10);
		taxtext.setBounds(250, 390, 250, 30);
		add(taxtext);

		feetext = new JTextField();
		feetext.setEditable(false);
		feetext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		feetext.setColumns(10);
		feetext.setBounds(250, 450, 250, 30);
		add(feetext);

		reciepttext = new JTextField();
		reciepttext.setEditable(false);
		reciepttext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		reciepttext.setColumns(10);
		reciepttext.setBounds(250, 510, 250, 30);
		add(reciepttext);

		paydatetext = new JTextField();
		paydatetext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paydatetext.setColumns(10);
		paydatetext.setBounds(250, 570, 250, 30);
		add(paydatetext);

		paystatustext = new JTextField();
		paystatustext.setText("Y");
		paystatustext.setEditable(false);
		paystatustext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		paystatustext.setColumns(10);
		paystatustext.setBounds(250, 630, 250, 30);
		add(paystatustext);

		nursePaySave = new JButton("\uC218\uC815");
		nursePaySave.setForeground(Color.WHITE);
		nursePaySave.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		nursePaySave.setBackground(Color.BLACK);
		nursePaySave.setBounds(220, 800, 160, 50);
		add(nursePaySave);

		nursePaySave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyNursetPay();
			}

			private void modifyNursetPay() {
				String nuDate = yearmonthtext.getText();
				int nuTotal = Integer.parseInt(sumpaytext.getText()); 
				int nuTax = (int) (nuTotal*0.045);
				int nuCommision = (int) (nuTotal*0.1);
				int nuReal = nuTotal-nuTax-nuCommision;
				String nuGetDate = paydatetext.getText();
				String nuPayStatus = paystatustext.getText();

				taxtext.setText(String.valueOf(nuTax));
				feetext.setText(String.valueOf(nuCommision));
				reciepttext.setText(String.valueOf(nuReal));
				
				CenterPayVO vo = new CenterPayVO();
				vo.setNu_id(ssno);
				vo.setSs_date(nuDate);
				vo.setSs_sumsal(String.valueOf(nuTotal));
				vo.setSs_tax(String.valueOf(nuTax));
				vo.setSs_fee(String.valueOf(nuCommision));
				vo.setSs_receipt(String.valueOf(nuReal));
				vo.setSs_paydate(nuGetDate);
				vo.setSs_paystatus(nuPayStatus);
				try {
					dao.nursePayModify(vo, ssno);
					JOptionPane.showMessageDialog(null, "¿ä¾ç º¸È£»ç ±Þ¿© ¸í¼¼¼­°¡ ¼öÁ¤µÇ¾ú½À´Ï´Ù.");
					parentView.updatenursepaytable(nuid);
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CenterNursePayModiView.this);
					frame.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "¿ä¾ç º¸È£»ç ±Þ¿© ¸í¼¼¼­ ¼öÁ¤ÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					e.printStackTrace();
				}
			}
		});

		JLabel headLabel = new JLabel("     \uC694\uC591\uBCF4\uD638\uC0AC \uAE09\uC5EC \uC815\uC0B0\uC11C");
		headLabel.setOpaque(true);
		headLabel.setForeground(Color.BLACK);
		headLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));
		headLabel.setBounds(0, 0, 600, 70);
		add(headLabel);

		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 760, 600, 140);
		add(footLabel);
		
		try {
			CenterPayVO vo = dao.nursePayget(ssno);
			paynotext.setText(ssno);
			nuidtext.setText(vo.getNu_id());
			yearmonthtext.setText(vo.getSs_date().substring(0, 10));
			sumpaytext.setText(vo.getSs_sumsal());
			taxtext.setText(vo.getSs_tax());
			feetext.setText(vo.getSs_fee());
			reciepttext.setText(vo.getSs_receipt());
			paydatetext.setText(vo.getSs_paydate().substring(0, 10));
			paystatustext.setText(vo.getSs_paystatus());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}

	}
}
