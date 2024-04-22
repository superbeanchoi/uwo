package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.centeruserDAO.CenterMemberSearchDAO;
import vo.centeruserVO.CenterMemberSearchVO;

public class CenterMemberSearchView extends JPanel implements ActionListener {

	CenterMemberSearchDAO dao = null;

	private JComboBox patientserchbox;
	private JTextField patientsearchtext;
	private JComboBox comNurseSearch;
	private JTextField tfNurseSearch;

	PatientListTable patientList;
	JTable patienttable;
	NurseListTable nurseList;
	JTable nursetable;
	subGuardianListTable subguardianList;
	JTable subguardiantable;
	
	private JTextField pcodetext, pnametext, pjumintext, psexcode, pcrnotext, pteltext, paddtext, cnnametext, cnteltext;
	private JTextField mgidtext, mgnametext, mgbirthtext, mgsextext, mgteltext, mgaddtext, relationtext;
	
	private JLabel nuimgLabel;
	private JTextField nuidText, nunameText, nujuminText, nusexText, nucountryText, nutelText, nuaddTetxt;
	private JTextField nucriminalText, nuserviceText, nubanknameText, nubanknumText;

	private JButton closebtn, phealthbtn, detailnuinfoBtn;
	String ptno, sgno, nuid;

	/**
	 * Create the panel.
	 */
	public CenterMemberSearchView() {

		try {
			dao = new CenterMemberSearchDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n" + e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
//// »ó´Ü Çì´õ
		JLabel headlabel = new JLabel("    \uC804\uCCB4 \uD68C\uC6D0 \uC815\uBCF4 \uC870\uD68C");
		headlabel.setBounds(0, 0, 1200, 70);
		headlabel.setOpaque(true);
		headlabel.setForeground(new Color(0, 0, 0));
		headlabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		headlabel.setBackground(new Color(255, 228, 225));
		add(headlabel);

//// È¯ÀÚ °Ë»ö ºÎºÐ
		JPanel patientpanel = new JPanel();
		patientpanel.setBackground(new Color(255, 255, 255));
		patientpanel.setBounds(10, 80, 580, 70);
		patientpanel.setBorder(new TitledBorder(" È¯ÀÚ °Ë»ö "));
		patientpanel.setLayout(null);
		add(patientpanel);

		patientserchbox = new JComboBox();
		patientserchbox.setBackground(new Color(255, 255, 255));
		patientserchbox.setModel(new DefaultComboBoxModel(new String[] {"\uD658\uC790 \uCF54\uB4DC", "\uD658\uC790 \uC774\uB984", "\uD658\uC790 \uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uD658\uC790 \uC804\uD654\uBC88\uD638"}));
		patientserchbox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		patientserchbox.setBounds(110, 25, 170, 30);
		patientpanel.add(patientserchbox);

		patientsearchtext = new JTextField();
		patientsearchtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		patientsearchtext.setBounds(290, 25, 180, 30);
		patientsearchtext.setColumns(10);
		patientpanel.add(patientsearchtext);

//// È¯ÀÚ °Ë»ö ¿µ¿ª
		JScrollPane patientscroll = new JScrollPane();
		patientscroll.setBounds(10, 160, 580, 100);
		add(patientscroll);

		patientList = new PatientListTable();
		patienttable = new JTable(patientList);
		patienttable.setBackground(new Color(255, 255, 255));
		patienttable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		patientscroll.setViewportView(patienttable);
		
		patienttable.setRowHeight(20);
		patienttable.setBackground(Color.WHITE);
		patienttable.setSelectionBackground(new Color(255, 228, 225));
		patientscroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patienttable.getColumnCount(); i++) {
			patienttable.getColumnModel().getColumn(i).setCellRenderer(center);
		}

//// È¯ÀÚ Á¤º¸ ¿µ¿ª
		JPanel patientdetailpanel = new JPanel();
		patientdetailpanel.setBorder(new TitledBorder(null, "\uD658\uC790 \uC0C1\uC138 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patientdetailpanel.setBackground(new Color(255, 255, 255));
		patientdetailpanel.setBounds(10, 270, 285, 490);
		patientdetailpanel.setLayout(null);
		add(patientdetailpanel);
		
		phealthbtn = new JButton("\uD658\uC790 \uAC74\uAC15\uC815\uBCF4 \uC870\uD68C");
		phealthbtn.setForeground(Color.WHITE);
		phealthbtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		phealthbtn.setBackground(Color.BLACK);
		phealthbtn.setBounds(17, 340, 250, 40);
		patientdetailpanel.add(phealthbtn);
		
		JLabel pcodelabel = new JLabel("\uD658\uC790 \uCF54\uB4DC");
		pcodelabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pcodelabel.setBounds(17, 25, 100, 30);
		patientdetailpanel.add(pcodelabel);
		
		pcodetext = new JTextField();
		pcodetext.setForeground(new Color(0, 0, 0));
		pcodetext.setBackground(new Color(255, 255, 255));
		pcodetext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pcodetext.setEditable(false);
		pcodetext.setColumns(10);
		pcodetext.setBounds(117, 25, 150, 30);
		patientdetailpanel.add(pcodetext);

		JLabel pnamelabel = new JLabel("\uD658\uC790 \uC774\uB984");
		pnamelabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pnamelabel.setBounds(17, 70, 100, 30);
		patientdetailpanel.add(pnamelabel);
		
		pnametext = new JTextField();
		pnametext.setBackground(new Color(255, 255, 255));
		pnametext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pnametext.setEditable(false);
		pnametext.setColumns(10);
		pnametext.setBounds(117, 70, 150, 30);
		patientdetailpanel.add(pnametext);
		
		JLabel pjuminlabel = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		pjuminlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pjuminlabel.setBounds(17, 115, 100, 30);
		patientdetailpanel.add(pjuminlabel);

		pjumintext = new JTextField();
		pjumintext.setBackground(new Color(255, 255, 255));
		pjumintext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pjumintext.setEditable(false);
		pjumintext.setColumns(10);
		pjumintext.setBounds(117, 115, 150, 30);
		patientdetailpanel.add(pjumintext);

		JLabel psexlabel = new JLabel("¼ºº°");
		psexlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		psexlabel.setBounds(17, 160, 100, 30);
		patientdetailpanel.add(psexlabel);

		psexcode = new JTextField();
		psexcode.setBackground(new Color(255, 255, 255));
		psexcode.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		psexcode.setEditable(false);
		psexcode.setColumns(10);
		psexcode.setBounds(117, 160, 150, 30);
		patientdetailpanel.add(psexcode);

		JLabel pcrnolabel = new JLabel("¿ä¾ç µî±Þ");
		pcrnolabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pcrnolabel.setBounds(17, 205, 100, 30);
		patientdetailpanel.add(pcrnolabel);
		
		pcrnotext = new JTextField();
		pcrnotext.setBackground(new Color(255, 255, 255));
		pcrnotext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pcrnotext.setEditable(false);
		pcrnotext.setColumns(10);
		pcrnotext.setBounds(117, 205, 150, 30);
		patientdetailpanel.add(pcrnotext);
		
		JLabel ptellabel = new JLabel("ÀüÈ­¹øÈ£");
		ptellabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		ptellabel.setBounds(17, 250, 100, 30);
		patientdetailpanel.add(ptellabel);
		
		pteltext = new JTextField();
		pteltext.setBackground(new Color(255, 255, 255));
		pteltext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pteltext.setEditable(false);
		pteltext.setColumns(10);
		pteltext.setBounds(117, 250, 150, 30);
		patientdetailpanel.add(pteltext);

		JLabel paddlabel = new JLabel("ÁÖ¼Ò");
		paddlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		paddlabel.setBounds(17, 295, 100, 30);
		patientdetailpanel.add(paddlabel);
		
		paddtext = new JTextField();
		paddtext.setBackground(new Color(255, 255, 255));
		paddtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		paddtext.setEditable(false);
		paddtext.setColumns(10);
		paddtext.setBounds(117, 295, 150, 30);
		patientdetailpanel.add(paddtext);
		
		JLabel cnnamelabel = new JLabel("\uB2F4\uB2F9\uC790 \uC774\uB984");
		cnnamelabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cnnamelabel.setBounds(17, 395, 100, 30);
		patientdetailpanel.add(cnnamelabel);

		cnnametext = new JTextField();
		cnnametext.setBackground(new Color(255, 255, 255));
		cnnametext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cnnametext.setEditable(false);
		cnnametext.setColumns(10);
		cnnametext.setBounds(117, 395, 150, 30);
		patientdetailpanel.add(cnnametext);
		
		JLabel cntellabel = new JLabel("\uB2F4\uB2F9\uC790 \uC804\uD654\uBC88\uD638");
		cntellabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cntellabel.setBounds(17, 440, 100, 30);
		patientdetailpanel.add(cntellabel);
		
		cnteltext = new JTextField();
		cnteltext.setBackground(new Color(255, 255, 255));
		cnteltext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cnteltext.setEditable(false);
		cnteltext.setColumns(10);
		cnteltext.setBounds(117, 440, 150, 30);
		patientdetailpanel.add(cnteltext);
		
		JPanel mainguardiandetailpanel = new JPanel();
		mainguardiandetailpanel.setLayout(null);
		mainguardiandetailpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC8FC\uBCF4\uD638\uC790 \uC0C1\uC138 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mainguardiandetailpanel.setBackground(Color.WHITE);
		mainguardiandetailpanel.setBounds(310, 270, 285, 340);
		add(mainguardiandetailpanel);
		
		JLabel mgidlabel = new JLabel("\uC8FC\uBCF4\uD638\uC790 \uC544\uC774\uB514");
		mgidlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgidlabel.setBounds(17, 25, 100, 30);
		mainguardiandetailpanel.add(mgidlabel);
		
		mgidtext = new JTextField();
		mgidtext.setBackground(new Color(255, 255, 255));
		mgidtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgidtext.setEditable(false);
		mgidtext.setColumns(10);
		mgidtext.setBounds(117, 25, 150, 30);
		mainguardiandetailpanel.add(mgidtext);
		
		JLabel mgnamelabel = new JLabel("\uC8FC\uBCF4\uD638\uC790 \uC774\uB984");
		mgnamelabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgnamelabel.setBounds(17, 70, 100, 30);
		mainguardiandetailpanel.add(mgnamelabel);
		
		mgnametext = new JTextField();
		mgnametext.setBackground(new Color(255, 255, 255));
		mgnametext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgnametext.setEditable(false);
		mgnametext.setColumns(10);
		mgnametext.setBounds(117, 70, 150, 30);
		mainguardiandetailpanel.add(mgnametext);
		
		JLabel mgbirthlabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		mgbirthlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgbirthlabel.setBounds(17, 115, 100, 30);
		mainguardiandetailpanel.add(mgbirthlabel);
		
		mgbirthtext = new JTextField();
		mgbirthtext.setBackground(new Color(255, 255, 255));
		mgbirthtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgbirthtext.setEditable(false);
		mgbirthtext.setColumns(10);
		mgbirthtext.setBounds(117, 115, 150, 30);
		mainguardiandetailpanel.add(mgbirthtext);
		
		JLabel mgsexlabel = new JLabel("\uC131\uBCC4");
		mgsexlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgsexlabel.setBounds(17, 160, 100, 30);
		mainguardiandetailpanel.add(mgsexlabel);
		
		mgsextext = new JTextField();
		mgsextext.setBackground(new Color(255, 255, 255));
		mgsextext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgsextext.setEditable(false);
		mgsextext.setColumns(10);
		mgsextext.setBounds(117, 160, 150, 30);
		mainguardiandetailpanel.add(mgsextext);
		
		JLabel mgtellabel = new JLabel("\uC804\uD654\uBC88\uD638");
		mgtellabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgtellabel.setBounds(17, 205, 100, 30);
		mainguardiandetailpanel.add(mgtellabel);
		
		mgteltext = new JTextField();
		mgteltext.setBackground(new Color(255, 255, 255));
		mgteltext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgteltext.setEditable(false);
		mgteltext.setColumns(10);
		mgteltext.setBounds(117, 205, 150, 30);
		mainguardiandetailpanel.add(mgteltext);
		
		JLabel mgaddlabel = new JLabel("\uC8FC\uC18C");
		mgaddlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgaddlabel.setBounds(17, 250, 100, 30);
		mainguardiandetailpanel.add(mgaddlabel);
		
		mgaddtext = new JTextField();
		mgaddtext.setBackground(new Color(255, 255, 255));
		mgaddtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		mgaddtext.setEditable(false);
		mgaddtext.setColumns(10);
		mgaddtext.setBounds(117, 250, 150, 30);
		mainguardiandetailpanel.add(mgaddtext);
		
		JLabel relationlabel = new JLabel("\uD658\uC790\uC640\uC758 \uAD00\uACC4");
		relationlabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		relationlabel.setBounds(17, 295, 100, 30);
		mainguardiandetailpanel.add(relationlabel);
		
		relationtext = new JTextField();
		relationtext.setBackground(new Color(255, 255, 255));
		relationtext.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		relationtext.setEditable(false);
		relationtext.setColumns(10);
		relationtext.setBounds(117, 295, 150, 30);
		mainguardiandetailpanel.add(relationtext);
		
		JPanel subguardianpanel = new JPanel();
		subguardianpanel.setBackground(new Color(255, 255, 255));
		subguardianpanel.setBorder(new TitledBorder(null, "\uBD80\uBCF4\uD638\uC790 \uC0C1\uC138 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subguardianpanel.setBounds(310, 620, 283, 140);
		add(subguardianpanel);
		subguardianpanel.setLayout(null);
		
		JScrollPane subguardianscroll = new JScrollPane();
		subguardianscroll.setBounds(10, 25, 260, 100);
		subguardianpanel.add(subguardianscroll);
		
		subguardianList = new subGuardianListTable();
		subguardiantable = new JTable(subguardianList);
		subguardiantable.setBackground(new Color(255, 255, 255));
		subguardiantable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		subguardianscroll.setViewportView(subguardiantable);
		
		subguardiantable.setRowHeight(20);
		subguardiantable.setBackground(Color.WHITE);
		subguardiantable.setSelectionBackground(new Color(255, 228, 225));
		subguardianscroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < subguardiantable.getColumnCount(); i++) {
			subguardiantable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
//// ¿ä¾çº¸È£»ç °Ë»ö ºÎºÐ
		JPanel nursepanel = new JPanel();
		nursepanel.setBackground(new Color(255, 255, 255));
		nursepanel.setBounds(610, 80, 580, 70);
		nursepanel.setLayout(null);
		nursepanel.setBorder(new TitledBorder(" ¿ä¾ç º¸È£»ç °Ë»ö "));
		add(nursepanel);

		comNurseSearch = new JComboBox();
		comNurseSearch.setBackground(new Color(255, 255, 255));
		comNurseSearch.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		comNurseSearch.setModel(new DefaultComboBoxModel(new String[] {"\uC694\uC591\uBCF4\uD638\uC0AC \uC544\uC774\uB514", "\uC694\uC591\uBCF4\uD638\uC0AC \uC774\uB984", "\uC694\uC591\uBCF4\uD638\uC0AC \uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC694\uC591\uBCF4\uD638\uC0AC \uC804\uD654\uBC88\uD638"}));
		comNurseSearch.setLocation(110, 25);
		comNurseSearch.setSize(170, 30);
		nursepanel.add(comNurseSearch);

		tfNurseSearch = new JTextField();
		tfNurseSearch.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		tfNurseSearch.setColumns(10);
		tfNurseSearch.setBounds(290, 25, 180, 30);
		nursepanel.add(tfNurseSearch);
		
//// ¿ä¾çº¸È£»ç °Ë»ö ¿µ¿ª		
		JScrollPane nurseScroll = new JScrollPane();
		nurseScroll.setBounds(610, 160, 580, 100);
		add(nurseScroll);

		nurseList = new NurseListTable();
		nursetable = new JTable(nurseList);
		nursetable.setBackground(new Color(255, 255, 255));
		nursetable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nurseScroll.setViewportView(nursetable);

		nursetable.setRowHeight(20);
		nursetable.setBackground(Color.WHITE);
		nursetable.setSelectionBackground(new Color(255, 228, 225));
		nurseScroll.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < nursetable.getColumnCount(); i++) {
			nursetable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
//// ¿ä¾çº¸È£»ç Á¤º¸ ¿µ¿ª
		JPanel nursedetailpanel = new JPanel();
		nursedetailpanel.setLayout(null);
		nursedetailpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC694\uC591\uBCF4\uD638\uC0AC \uC0C1\uC138 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nursedetailpanel.setBackground(Color.WHITE);
		nursedetailpanel.setBounds(607, 270, 583, 490);
		add(nursedetailpanel);
		
		nuimgLabel = new JLabel("        (\uC0AC\uC9C4)");
		nuimgLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuimgLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nuimgLabel.setBackground(Color.WHITE);
		nuimgLabel.setBounds(20, 30, 100, 120);
		nursedetailpanel.add(nuimgLabel);
		
		JLabel nuidLabel = new JLabel("\uC694\uC591\uBCF4\uD638\uC0AC \uC544\uC774\uB514");
		nuidLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuidLabel.setBounds(140, 45, 120, 30);
		nursedetailpanel.add(nuidLabel);
		
		nuidText = new JTextField();
		nuidText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuidText.setEditable(false);
		nuidText.setColumns(10);
		nuidText.setBackground(Color.WHITE);
		nuidText.setBounds(260, 45, 150, 30);
		nursedetailpanel.add(nuidText);
		
		JLabel nunameLbael = new JLabel("\uC694\uC591\uBCF4\uD638\uC0AC \uC774\uB984");
		nunameLbael.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nunameLbael.setBounds(140, 95, 120, 30);
		nursedetailpanel.add(nunameLbael);
		
		nunameText = new JTextField();
		nunameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nunameText.setEditable(false);
		nunameText.setColumns(10);
		nunameText.setBackground(Color.WHITE);
		nunameText.setBounds(260, 95, 150, 30);
		nursedetailpanel.add(nunameText);
		
		JLabel nujuminLabel = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		nujuminLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nujuminLabel.setBounds(20, 170, 120, 30);
		nursedetailpanel.add(nujuminLabel);
		
		nujuminText = new JTextField();
		nujuminText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nujuminText.setEditable(false);
		nujuminText.setColumns(10);
		nujuminText.setBackground(Color.WHITE);
		nujuminText.setBounds(140, 170, 140, 30);
		nursedetailpanel.add(nujuminText);
		
		JLabel nusexLabel = new JLabel("\uC131\uBCC4");
		nusexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nusexLabel.setBounds(300, 170, 120, 30);
		nursedetailpanel.add(nusexLabel);
		
		nusexText = new JTextField();
		nusexText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nusexText.setEditable(false);
		nusexText.setColumns(10);
		nusexText.setBackground(Color.WHITE);
		nusexText.setBounds(420, 170, 140, 30);
		nursedetailpanel.add(nusexText);
		
		JLabel nucountryLabel = new JLabel("\uAD6D\uC801");
		nucountryLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nucountryLabel.setBounds(20, 220, 120, 30);
		nursedetailpanel.add(nucountryLabel);
		
		nucountryText = new JTextField();
		nucountryText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nucountryText.setEditable(false);
		nucountryText.setColumns(10);
		nucountryText.setBackground(Color.WHITE);
		nucountryText.setBounds(140, 220, 140, 30);
		nursedetailpanel.add(nucountryText);
		
		JLabel nutelLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		nutelLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nutelLabel.setBounds(20, 270, 120, 30);
		nursedetailpanel.add(nutelLabel);
		
		nutelText = new JTextField();
		nutelText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nutelText.setEditable(false);
		nutelText.setColumns(10);
		nutelText.setBackground(Color.WHITE);
		nutelText.setBounds(140, 270, 140, 30);
		nursedetailpanel.add(nutelText);
		
		JLabel nuaddLabel = new JLabel("\uC8FC\uC18C");
		nuaddLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuaddLabel.setBounds(300, 270, 120, 30);
		nursedetailpanel.add(nuaddLabel);
		
		nuaddTetxt = new JTextField();
		nuaddTetxt.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuaddTetxt.setEditable(false);
		nuaddTetxt.setColumns(10);
		nuaddTetxt.setBackground(Color.WHITE);
		nuaddTetxt.setBounds(420, 270, 140, 30);
		nursedetailpanel.add(nuaddTetxt);
		
		JLabel nucriminalLabel = new JLabel("\uBC94\uC8C4 \uACBD\uB825 \uC5EC\uBD80");
		nucriminalLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nucriminalLabel.setBounds(20, 320, 120, 30);
		nursedetailpanel.add(nucriminalLabel);
		
		nucriminalText = new JTextField();
		nucriminalText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nucriminalText.setEditable(false);
		nucriminalText.setColumns(10);
		nucriminalText.setBackground(Color.WHITE);
		nucriminalText.setBounds(140, 320, 140, 30);
		nursedetailpanel.add(nucriminalText);
		
		JLabel nuserviceLabel = new JLabel("\uD76C\uB9DD \uADFC\uBB34 \uC720\uD615");
		nuserviceLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuserviceLabel.setBounds(300, 320, 120, 30);
		nursedetailpanel.add(nuserviceLabel);
		
		nuserviceText = new JTextField();
		nuserviceText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nuserviceText.setEditable(false);
		nuserviceText.setColumns(10);
		nuserviceText.setBackground(Color.WHITE);
		nuserviceText.setBounds(420, 320, 140, 30);
		nursedetailpanel.add(nuserviceText);
		
		JLabel nubanknameLabel = new JLabel("\uC740\uD589\uBA85");
		nubanknameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nubanknameLabel.setBounds(20, 370, 120, 30);
		nursedetailpanel.add(nubanknameLabel);
		
		nubanknameText = new JTextField();
		nubanknameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nubanknameText.setEditable(false);
		nubanknameText.setColumns(10);
		nubanknameText.setBackground(Color.WHITE);
		nubanknameText.setBounds(140, 370, 140, 30);
		nursedetailpanel.add(nubanknameText);
		
		JLabel nubanknumLabel = new JLabel("\uACC4\uC88C\uBC88\uD638");
		nubanknumLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nubanknumLabel.setBounds(301, 370, 120, 30);
		nursedetailpanel.add(nubanknumLabel);

		nubanknumText = new JTextField();
		nubanknumText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nubanknumText.setEditable(false);
		nubanknumText.setColumns(10);
		nubanknumText.setBackground(Color.WHITE);
		nubanknumText.setBounds(420, 370, 140, 30);
		nursedetailpanel.add(nubanknumText);
		
		detailnuinfoBtn = new JButton("\uC0C1\uC138 \uC778\uB825\uC815\uBCF4 \uC870\uD68C");
		detailnuinfoBtn.setForeground(Color.WHITE);
		detailnuinfoBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		detailnuinfoBtn.setBackground(Color.BLACK);
		detailnuinfoBtn.setBounds(20, 425, 540, 40);
		nursedetailpanel.add(detailnuinfoBtn);
		
	//// ÇÏ´Ü ÇªÅÍ
			JPanel footpanel = new JPanel();
			footpanel.setLayout(null);
			footpanel.setBackground(new Color(255, 228, 225));
			footpanel.setBounds(0, 780, 1200, 120);
			add(footpanel);

			closebtn = new JButton("\uB2EB\uAE30");
			closebtn.setForeground(Color.WHITE);
			closebtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			closebtn.setBackground(Color.BLACK);
			closebtn.setBounds(520, 35, 160, 50);
			footpanel.add(closebtn);
			
		eventProc();
		patienttable();
		nursetable();
	}

	void eventProc() {
		closebtn.addActionListener(this);
		patientsearchtext.addActionListener(this);
		tfNurseSearch.addActionListener(this);
		patienttable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = patienttable.getSelectedRow();
				ptno = String.valueOf(patienttable.getValueAt(row, 0));
				CenterMemberSearchVO vo = new CenterMemberSearchVO();
				try {
					vo = dao.allPatientInfoSelect(ptno);
					subGuardianselecttable();
					pcodetext.setText(vo.getPt_no());
					pnametext.setText(vo.getPt_name());
					pjumintext.setText(vo.getPt_jumin());
					psexcode.setText(vo.getPt_sex());
					pcrnotext.setText(vo.getCr_no());
					pteltext.setText(vo.getPt_tel());
					paddtext.setText(vo.getPt_add());
					cnnametext.setText(vo.getCn_name());
					cnteltext.setText(vo.getCn_tel());
					mgidtext.setText(vo.getMg_id());
					mgnametext.setText(vo.getMg_name());
					mgbirthtext.setText(vo.getMg_birth().substring(0, 10));
					mgsextext.setText(vo.getMg_sex());
					mgteltext.setText(vo.getMg_tel());
					mgaddtext.setText(vo.getMg_add());
					relationtext.setText(vo.getMg_relation());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					e2.printStackTrace();
				}
			}
		});
		phealthbtn.addActionListener(this);
		subguardiantable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = subguardiantable.getSelectedRow();
				sgno = String.valueOf(subguardiantable.getValueAt(row, 0));
				CenterMemberSubGuardianInfoView csm = new CenterMemberSubGuardianInfoView(sgno);
				JFrame CenterMemberSubGuardianInfoFrame = new JFrame("");
				CenterMemberSubGuardianInfoFrame.getContentPane().add(csm);
				CenterMemberSubGuardianInfoFrame.setSize(615, 635);
				CenterMemberSubGuardianInfoFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				CenterMemberSubGuardianInfoFrame.setLocation(970, 435);
				CenterMemberSubGuardianInfoFrame.setVisible(true);

			}
		});
		nursetable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = nursetable.getSelectedRow();
				nuid = String.valueOf(nursetable.getValueAt(row, 0));
				CenterMemberSearchVO vo = new CenterMemberSearchVO();
				try {
					vo = dao.allnurseInfoSelect(nuid);
					nuimgLabel.setText("");
					nuimgLabel.setIcon(new ImageIcon(vo.getNu_picture()));
					nuidText.setText(vo.getNu_id());
					nunameText.setText(vo.getNu_name());
					nujuminText.setText(vo.getNu_jumin());
					nusexText.setText(vo.getNu_sex());
					nucountryText.setText(vo.getNu_country());
					nutelText.setText(vo.getNu_tel());
					nuaddTetxt.setText(vo.getNu_add());
					nucriminalText.setText(vo.getNu_crimal());
					nuserviceText.setText(vo.getSv_typename());
					nubanknameText.setText(vo.getNu_bank());
					nubanknumText.setText(vo.getNu_accno());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					e2.printStackTrace();
				}
			}
		});
		detailnuinfoBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==closebtn) {
			SwingUtilities.getWindowAncestor(this).dispose();
		} else if (o == patientsearchtext) {
			patientselecttable();
		} else if (o == tfNurseSearch) {
			nurseselecttable();
		} else if (o == phealthbtn) {
			CenterMemberPatientHealthInfoView cpm = new CenterMemberPatientHealthInfoView(ptno);
			JFrame CenterPatientMemberHealthInfoFrame = new JFrame("");
			CenterPatientMemberHealthInfoFrame.getContentPane().add(cpm);
			CenterPatientMemberHealthInfoFrame.setSize(615, 935);
			CenterPatientMemberHealthInfoFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			CenterPatientMemberHealthInfoFrame.setLocation(970, 285);
			CenterPatientMemberHealthInfoFrame.setVisible(true);
		} else if (o==detailnuinfoBtn) {
			CenterMemberNurseInfoView cnm = new CenterMemberNurseInfoView(nuid);
			JFrame CenterMemberNurseInfoFrame = new JFrame("");
			CenterMemberNurseInfoFrame.getContentPane().add(cnm);
			CenterMemberNurseInfoFrame.setSize(615, 935);
			CenterMemberNurseInfoFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
			CenterMemberNurseInfoFrame.setLocation(970, 285);
			CenterMemberNurseInfoFrame.setVisible(true);
		}
	}

	public void clearScreen() {
		patientsearchtext.setText("");
		tfNurseSearch.setText("");
	}
	
	void patienttable() {
		try {
			ArrayList list = dao.allpatientSearch();
			patientList.data = list;
			patienttable.setModel(patientList);
			patientList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	void patientselecttable() {
		int sel = patientserchbox.getSelectedIndex();
		String text = patientsearchtext.getText();
		try {
			ArrayList list = dao.patientSearch(sel, text);
			patientList.data = list;
			patienttable.setModel(patientList);
			patientList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void subGuardianselecttable() {
		try {
			ArrayList list = dao.subGuardianSearch(ptno);
			subguardianList.data = list;
			subguardiantable.setModel(subguardianList);
			subguardianList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	void nursetable() {
		try {
			ArrayList list = dao.allnurseSearch();
			nurseList.data = list;
			nursetable.setModel(nurseList);
			nurseList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	void nurseselecttable() {
		int sel = comNurseSearch.getSelectedIndex();
		String text = tfNurseSearch.getText();
		try {
			ArrayList list = dao.nurseSearch(sel, text);
			nurseList.data = list;
			nursetable.setModel(nurseList);
			nurseList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	class PatientListTable extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "È¯ÀÚ ÄÚµå", "È¯ÀÚ ÀÌ¸§", "È¯ÀÚ ÁÖ¹Îµî·Ï¹øÈ£", "´ã´çÀÚÀÌ¸§", "´ã´çÀÚ ÀüÈ­¹øÈ£" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}

	class NurseListTable extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "¿ä¾çº¸È£»ç ¾ÆÀÌµð", "¿ä¾çº¸È£»ç ÀÌ¸§", "¿ä¾çº¸È£»ç ÁÖ¹Îµî·Ï¹øÈ£", "¿ä¾çº¸È£»ç ÀüÈ­¹øÈ£" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}
	
	class subGuardianListTable extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "ºÎº¸È£ÀÚ ÄÚµå", "ºÎº¸È£ÀÚ ÀÌ¸§" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}

}