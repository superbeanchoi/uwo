package view.guardianuser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.guardianuserDAO.SubGuardianInfoDAO;
import vo.guardianuserVO.SubGuardianInfoVO;

public class Sub_GuardianAddView extends JPanel implements ActionListener {
	private JTextField textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
	JButton btnNewButton_1, btnNewButton;
	private GuardianMypageView mypage;
	patientTable patientlist;
	private JTable patienttable;
	String mg_id;
	SubGuardianInfoDAO dao;
	SubGuardianInfoVO vo;

	/**
	 * Create the panel.
	 */
	
	public Sub_GuardianAddView() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public Sub_GuardianAddView(GuardianMypageView mypage, String id) {
		// TODO Auto-generated constructor stub
		this.mypage=mypage;
		this.mg_id=id;
		initialize();
	}
	
	public void initialize() {

		try {
			dao = new SubGuardianInfoDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		vo = new SubGuardianInfoVO();
		
		setBackground(new Color(0, 0, 0));
		setLayout(null);

		JPanel patientPanel = new JPanel();
		patientPanel.setForeground(new Color(255, 255, 255));
		patientPanel.setLayout(null);
		patientPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uD658\uC790 \uC815\uBCF4 \uC870\uD68C", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 255, 255)));
		patientPanel.setBackground(new Color(0, 0, 0));
		patientPanel.setBounds(30, 180, 1140, 250);
		add(patientPanel);
		
		JScrollPane patientscrollPane = new JScrollPane();
		patientscrollPane.setBounds(15, 25, 1110, 200);
		patientPanel.add(patientscrollPane);

		patientscrollPane.setViewportView(patienttable);
		
		patientlist = new patientTable();
		patienttable = new JTable(patientlist);
		patienttable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		patientscrollPane.setViewportView(patienttable);

		patienttable.setRowHeight(20);
		patienttable.setBackground(Color.WHITE);
		patienttable.setSelectionBackground(new Color(255, 228, 225));
		patientscrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patienttable.getColumnCount(); i++) {
			patienttable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		btnNewButton_1 = new JButton("\uCD94\uAC00");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(375, 785, 200, 50);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel(
				"     \uBD80\uBCF4\uD638\uC790 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(0, 0, 1200, 70);
		add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 228, 225));

		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(50, 480, 150, 40);
		add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(680, 480, 150, 40);
		add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_3 = new JLabel("\uD658\uC790 \uCF54\uB4DC");
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(30, 110, 150, 40);
		add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_4 = new JLabel("\uD658\uC790\uC640\uC758 \uAD00\uACC4");
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(50, 630, 150, 40);
		add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(50, 550, 150, 40);
		add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		JLabel lblNewLabel_6 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(680, 550, 150, 40);
		add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(0, 0, 0));
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_1.setBounds(200, 480, 250, 40);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBackground(new Color(0, 0, 0));
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_2.setBounds(200, 630, 250, 40);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(0, 0, 0));
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_3.setBounds(200, 550, 250, 40);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBackground(new Color(0, 0, 0));
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_4.setBounds(830, 550, 250, 40);
		add(textField_4);
		textField_4.setColumns(10);

		btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Sub_GuardianAddView.this);
				frame.dispose();
			}
		});

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(625, 785, 200, 50);
		add(btnNewButton);

		textField_5 = new JTextField();
		textField_5.setBackground(new Color(0, 0, 0));
		textField_5.setForeground(new Color(255, 255, 255));
		textField_5.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_5.setBounds(830, 480, 250, 40);
		add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBackground(new Color(0, 0, 0));
		textField_6.setForeground(new Color(255, 255, 255));
		textField_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		textField_6.setBounds(180, 110, 250, 40);
		add(textField_6);
		textField_6.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 735, 1200, 165);
		add(panel);
		
		eventProc();
		selectPatientTable();

	}
	
	public void eventProc() {
		btnNewButton_1.addActionListener(this);
		patienttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = patienttable.getSelectedRow();
				String patientCode = (String)patienttable.getValueAt(row, 0);
				textField_6.setText(patientCode);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o==btnNewButton_1) {
			vo.setPt_no(textField_6.getText());
			vo.setSg_name(textField_1.getText());
			vo.setSg_birth(textField_5.getText());
			vo.setSg_tel(textField_3.getText());
			vo.setSg_add(textField_4.getText());
			vo.setSg_relation(textField_2.getText());

			try {
				dao.insertSubGuardianInfo(vo);
				mypage.subGuardiantableMGMatching(textField_6.getText());
				JOptionPane.showMessageDialog(null, "ºÎº¸È£ÀÚ Á¤º¸°¡ Ãß°¡µÇ¾ú½À´Ï´Ù.");
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Sub_GuardianAddView.this);
				frame.dispose();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "ºÎº¸È£ÀÚ Á¤º¸ Ãß°¡°¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				ex.printStackTrace();
			}
		}
	}
	
	void selectPatientTable() {
		try {
			ArrayList list = dao.patientInfoSelect(mg_id);
			patientlist.data = list;
			patienttable.setModel(patientlist);
			patientlist.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}
	
	class patientTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"È¯ÀÚ ÄÚµå","È¯ÀÚ ÀÌ¸§", "ÁÖ¹Î ¹øÈ£", "º¸È£ÀÚ¿ÍÀÇ °ü°è", "´ã´çÀÚ ¸í"};
		public int getColumnCount() { 
	        return columnNames.length; 
	    } 
	    public int getRowCount() { 
	        return data.size(); 
	    } 
	    public Object getValueAt(int row, int col) { 
	    	ArrayList temp = (ArrayList)data.get(row);
	    	return temp.get(col); 
	    }   
	    public String getColumnName(int col) {  
			return columnNames[col];
	    } 
	}

}
