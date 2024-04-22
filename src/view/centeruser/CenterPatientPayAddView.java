package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dao.centeruserDAO.CenterPayDAO;
import vo.centeruserVO.CenterPayVO;

public class CenterPatientPayAddView extends JPanel {
	public JTextField msnotext;
	public JTextField ptnotext;
	public JTextField msdatetext;
	public JTextField mspaytext;
	public JTextField msdeposittext;
	public JTextField mstaxtext;
	public JTextField dpbanktext;
	public JTextField dpvirtualtext;

	CenterPayDAO dao;
	private CenterPayView parentView;
	String ptno;

	public CenterPatientPayAddView(CenterPayView parentView, String ptno) {
		setBackground(new Color(255, 255, 255));
		this.parentView = parentView;
		this.ptno = ptno;
		initialize();
	}

	/**
	 * Create the panel.
	 */
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

		JLabel lblNewLabel_1 = new JLabel("\uBA85\uC138\uC11C \uCF54\uB4DC");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(100, 150, 150, 30);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uD658\uC790 \uCF54\uB4DC");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(100, 210, 150, 30);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ÇØ´ç ³â¿ù");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(100, 270, 150, 30);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(100, 330, 150, 30);
		add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\uC138\uAE08");
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(100, 390, 150, 30);
		add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("\uC785\uAE08 \uAE30\uD55C");
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(100, 450, 150, 30);
		add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("ÀºÇà¸í");
		lblNewLabel_7.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(100, 570, 150, 30);
		add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("°¡»ó °èÁÂ");
		lblNewLabel_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(100, 630, 150, 30);
		add(lblNewLabel_8);

		msnotext = new JTextField();
		msnotext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		msnotext.setEditable(false);
		msnotext.setColumns(10);
		msnotext.setBounds(250, 150, 250, 30);
		add(msnotext);

		ptnotext = new JTextField();
		ptnotext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		ptnotext.setEditable(false);
		ptnotext.setColumns(10);
		ptnotext.setBounds(250, 210, 250, 30);
		add(ptnotext);

		msdatetext = new JTextField();
		msdatetext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		msdatetext.setColumns(10);
		msdatetext.setBounds(250, 270, 250, 30);
		add(msdatetext);

		mspaytext = new JTextField();
		mspaytext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mspaytext.setColumns(10);
		mspaytext.setBounds(250, 330, 250, 30);
		add(mspaytext);

		mstaxtext = new JTextField();
		mstaxtext.setEditable(false);
		mstaxtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		mstaxtext.setColumns(10);
		mstaxtext.setBounds(250, 390, 250, 30);
		add(mstaxtext);

		msdeposittext = new JTextField();
		msdeposittext.setEditable(false);
		msdeposittext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		msdeposittext.setColumns(10);
		msdeposittext.setBounds(250, 450, 250, 30);
		add(msdeposittext);

		dpbanktext = new JTextField();
		dpbanktext.setEditable(false);
		dpbanktext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		dpbanktext.setColumns(10);
		dpbanktext.setBounds(250, 570, 250, 30);
		add(dpbanktext);

		dpvirtualtext = new JTextField();
		dpvirtualtext.setEditable(false);
		dpvirtualtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		dpvirtualtext.setColumns(10);
		dpvirtualtext.setBounds(250, 630, 250, 30);
		add(dpvirtualtext);

		JLabel headLabel = new JLabel("     \uD658\uC790 \uC694\uC591 \uBCF4\uD638\uBE44 \uBA85\uC138\uC11C");
		headLabel.setOpaque(true);
		headLabel.setForeground(Color.BLACK);
		headLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));
		headLabel.setBounds(0, 0, 600, 70);
		add(headLabel);

		JButton patientPaySave = new JButton("\uC800\uC7A5");
		patientPaySave.setForeground(Color.WHITE);
		patientPaySave.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		patientPaySave.setBackground(Color.BLACK);
		patientPaySave.setBounds(220, 800, 160, 50);
		add(patientPaySave);

		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 760, 600, 140);
		add(footLabel);

		patientPaySave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msdate = msdatetext.getText();
				int mspay = Integer.parseInt(mspaytext.getText());
				int mstax = (int) (mspay * 0.045);
				LocalDate inputDate = LocalDate.parse(msdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				LocalDate resultDate = inputDate.plusDays(7);
				String msdeposit = resultDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

				mstaxtext.setText(String.valueOf(mstax));
				msdeposittext.setText(msdeposit);
				
				CenterPayVO vo = new CenterPayVO();
				vo.setPt_no(ptno);
				vo.setMs_date(msdate);
				vo.setMs_pay_amount(String.valueOf(mspay));
				vo.setMs_deposit(msdeposit);
				vo.setMs_tax(String.valueOf(mstax));
				
				try {
					dao.patientPayInsert(vo);
					JOptionPane.showMessageDialog(null, "È¯ÀÚ ¿ä¾ç º¸È£ºñ ¸í¼¼¼­°¡ Ãß°¡µÇ¾ú½À´Ï´Ù.");
					parentView.updatepatientpaytable(ptno);
					JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CenterPatientPayAddView.this);
					frame.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "È¯ÀÚ ¿ä¾ç º¸È£ºñ ¸í¼¼¼­ Ãß°¡¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					ex.printStackTrace();
				}

			}
		});

		try {
			ptnotext.setText(ptno);
			CenterPayVO vo = dao.getPatientBankInfo(ptno);
			dpbanktext.setText(vo.getDp_bank());
			dpvirtualtext.setText(vo.getDp_virtual());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

}
