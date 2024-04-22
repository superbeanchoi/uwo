package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.centeruserDAO.CenterPayDAO;

public class CenterPayView extends JPanel implements ActionListener {
	private JComboBox patientsearchbox, nursesearchbox;
	private JTextField patientsearchtext, nursesearchtext;
	private JPanel patientpaypanel, patientpaycompanel, nursepaypanel, footpanel;
	private JButton patientpayaddbtn, patientpaymodibtn, patientpaydelbtn, patientpaycombtn;
	private JButton nursepayaddbtn, nursepaymodibtn, nursepaydelbtn, closebtn;

	PatientListTable patientList;
	JTable patienttable;
	PatientPayListTable patientPayList;
	JTable patientpaytable;
	PatientPayCompleteTable patientPayCom;
	JTable patientpaycomtable;
	
	NurseListTable nurseList;
	JTable nursetable;
	NursePayListTable nursePayList;
	JTable nursepaytable;

	CenterPayDAO dao;

	String paypatienttableCode;
	String cnid, nuid, ssno, ptno, msno;
	
	/**
	 * Create the panel.
	 */
	public CenterPayView(String cnid) {
		this.cnid = cnid;
		initialize();
	}

	public void initialize() {
		try {
			dao = new CenterPayDAO();
			System.out.println("DB���� ����");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB���� ����\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);

//// ��� ���
		JLabel headlabel = new JLabel("    \uD68C\uACC4\uAD00\uB9AC");
		headlabel.setBounds(0, 0, 1200, 70);
		headlabel.setOpaque(true);
		headlabel.setForeground(new Color(0, 0, 0));
		headlabel.setFont(new Font("���� ���", Font.BOLD, 20));
		headlabel.setBackground(new Color(255, 228, 225));
		add(headlabel);

//// ȯ�� �˻�
		JPanel patientsearchpanel = new JPanel();
		patientsearchpanel.setBackground(new Color(255, 255, 255));
		patientsearchpanel.setBounds(10, 80, 580, 70);
		patientsearchpanel.setBorder(new TitledBorder(" ȯ�� �˻� "));
		add(patientsearchpanel);
		patientsearchpanel.setLayout(null);

		patientsearchbox = new JComboBox();
		patientsearchbox.setBackground(new Color(255, 255, 255));
		patientsearchbox.setFont(new Font("���� ���", Font.PLAIN, 12));
		patientsearchbox.setModel(new DefaultComboBoxModel(new String[] {"\uD658\uC790 \uCF54\uB4DC", "\uD658\uC790 \uC774\uB984", "\uD658\uC790 \uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uD658\uC790 \uC804\uD654\uBC88\uD638"}));
		patientsearchbox.setBounds(110, 25, 170, 30);
		patientsearchpanel.add(patientsearchbox);

		patientsearchtext = new JTextField();
		patientsearchtext.setFont(new Font("���� ���", Font.PLAIN, 12));
		patientsearchtext.setBounds(290, 25, 180, 30);
		patientsearchtext.setColumns(10);
		patientsearchpanel.add(patientsearchtext);

//// ȯ�� �˻� ���
		JScrollPane patientarea = new JScrollPane();
		patientarea.setBounds(10, 160, 580, 150);
		add(patientarea);

		patientPayList = new PatientPayListTable();
		patientList = new PatientListTable();
		patienttable = new JTable(patientList);
		patienttable.setBackground(new Color(255, 255, 255));
		patienttable.setFont(new Font("���� ���", Font.PLAIN, 12));
		patientarea.setViewportView(patienttable);

		patienttable.setRowHeight(20);
		patienttable.setBackground(Color.WHITE);
		patienttable.setSelectionBackground(new Color(255, 228, 225));
		patientarea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patienttable.getColumnCount(); i++) {
			patienttable.getColumnModel().getColumn(i).setCellRenderer(center);
		}

//// ���� ��ȸ
		patientpaypanel = new JPanel();
		patientpaypanel.setBorder(new TitledBorder(null, "\uD658\uC790 \uC6D4\uBCC4 \uBA85\uC138\uC11C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patientpaypanel.setBackground(new Color(255, 255, 255));
		patientpaypanel.setBounds(10, 325, 580, 275);
		add(patientpaypanel);
		patientpaypanel.setLayout(null);
				
		JScrollPane patientpayarea = new JScrollPane();
		patientpayarea.setBounds(15, 60, 550, 200);
		patientpaypanel.add(patientpayarea);
		patientpaytable = new JTable(patientPayList);
		patientpaytable.setBackground(new Color(255, 255, 255));
		patientpaytable.setFont(new Font("���� ���", Font.PLAIN, 12));
		patientpayarea.setViewportView(patientpaytable);
				
		patientpaytable.setRowHeight(20);
		patientpaytable.setBackground(Color.WHITE);
		patientpaytable.setSelectionBackground(new Color(255, 228, 225));
		patientpayarea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patientpaytable.getColumnCount(); i++) {
			patientpaytable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		patientpayaddbtn = new JButton("+");
		patientpayaddbtn.setBounds(15, 20, 60, 30);
		patientpaypanel.add(patientpayaddbtn);
		patientpayaddbtn.setForeground(Color.WHITE);
		patientpayaddbtn.setFont(new Font("���� ���", Font.BOLD, 17));
		patientpayaddbtn.setBackground(Color.BLACK);
					
		patientpaymodibtn = new JButton("����");
		patientpaymodibtn.setBounds(85, 20, 75, 30);
		patientpaypanel.add(patientpaymodibtn);
		patientpaymodibtn.setForeground(Color.WHITE);
		patientpaymodibtn.setFont(new Font("���� ���", Font.BOLD, 17));
		patientpaymodibtn.setBackground(Color.BLACK);
		
		patientpaydelbtn = new JButton("-");
		patientpaydelbtn.setBounds(170, 20, 60, 30);
		patientpaypanel.add(patientpaydelbtn);
		patientpaydelbtn.setForeground(Color.WHITE);
		patientpaydelbtn.setFont(new Font("���� ���", Font.BOLD, 17));
		patientpaydelbtn.setBackground(Color.BLACK);
		
		patientpaycombtn = new JButton("\uACB0\uC81C \uCC98\uB9AC");
		patientpaycombtn.setBounds(425, 20, 140, 30);
		patientpaypanel.add(patientpaycombtn);
		patientpaycombtn.setForeground(Color.WHITE);
		patientpaycombtn.setFont(new Font("���� ���", Font.BOLD, 17));
		patientpaycombtn.setBackground(Color.BLACK);
												
//// ���� ���� Ȯ��
		patientpaycompanel = new JPanel();
		patientpaycompanel.setBorder(new TitledBorder(null, "\uACB0\uC81C \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patientpaycompanel.setBackground(new Color(255, 255, 255));
		patientpaycompanel.setBounds(10, 615, 580, 165);
		add(patientpaycompanel);
		patientpaycompanel.setLayout(null);
		
		JScrollPane patientpaycomarea = new JScrollPane();
		patientpaycomarea.setBounds(15, 25, 550, 120);
		patientpaycompanel.add(patientpaycomarea);

		patientPayCom = new PatientPayCompleteTable();
		patientpaycomtable = new JTable(patientPayCom);
		patientpaycomtable.setBackground(new Color(255, 255, 255));
		patientpaycomtable.setFont(new Font("���� ���", Font.PLAIN, 12));
		patientpaycomarea.setViewportView(patientpaycomtable);
		
		patientpaycomtable.setRowHeight(20);
		patientpaycomtable.setBackground(Color.WHITE);
		patientpaycomtable.setSelectionBackground(new Color(255, 228, 225));
		patientpaycomarea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < patientpaycomtable.getColumnCount(); i++) {
			patientpaycomtable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
//// ��� ��ȣ�� �˻�
		JPanel nursesearchpanel = new JPanel();
		nursesearchpanel.setBackground(new Color(255, 255, 255));
		nursesearchpanel.setBounds(610, 80, 580, 70);
		nursesearchpanel.setLayout(null);
		nursesearchpanel.setBorder(new TitledBorder(null, "\uC694\uC591\uBCF4\uD638\uC0AC \uB9E4\uCE6D\uC815\uBCF4 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(nursesearchpanel);

		nursesearchbox = new JComboBox();
		nursesearchbox.setBackground(new Color(255, 255, 255));
		nursesearchbox.setFont(new Font("���� ���", Font.PLAIN, 12));
		nursesearchbox.setModel(new DefaultComboBoxModel(new String[] {"\uC694\uC591\uBCF4\uD638\uC0AC \uC544\uC774\uB514", "\uC694\uC591\uBCF4\uD638\uC0AC \uC774\uB984", "\uC694\uC591\uBCF4\uD638\uC0AC \uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC694\uC591\uBCF4\uD638\uC0AC \uC804\uD654\uBC88\uD638"}));
		nursesearchbox.setLocation(110, 25);
		nursesearchbox.setSize(170, 30);
		nursesearchpanel.add(nursesearchbox);

		nursesearchtext = new JTextField();
		nursesearchtext.setFont(new Font("���� ���", Font.PLAIN, 12));
		nursesearchtext.setColumns(10);
		nursesearchtext.setBounds(290, 25, 180, 30);
		nursesearchpanel.add(nursesearchtext);

//// ��� ��ȣ�� �˻� ���
		JScrollPane nursearea = new JScrollPane();
		nursearea.setBounds(610, 160, 580, 150);
		add(nursearea);

		nurseList = new NurseListTable();
		nursetable = new JTable(nurseList);
		nursetable.setBackground(new Color(255, 255, 255));
		nursetable.setFont(new Font("���� ���", Font.PLAIN, 12));
		nursearea.setViewportView(nursetable);
		nursePayList = new NursePayListTable();
		
		nursetable.setRowHeight(20);
		nursetable.setBackground(Color.WHITE);
		nursetable.setSelectionBackground(new Color(255, 228, 225));
		nursearea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < nursetable.getColumnCount(); i++) {
			nursetable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		nursepaypanel = new JPanel();
		nursepaypanel.setBorder(new TitledBorder(null, "\uC694\uC591 \uBCF4\uD638\uC0AC \uC815\uC0B0\uC11C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nursepaypanel.setBackground(new Color(255, 255, 255));
		nursepaypanel.setBounds(610, 325, 578, 455);
		add(nursepaypanel);
		nursepaypanel.setLayout(null);
		
		JScrollPane nursepayarea = new JScrollPane();
		nursepayarea.setBounds(15, 60, 550, 380);
		nursepaypanel.add(nursepayarea);
		nursepaytable = new JTable(nursePayList);
		nursepaytable.setBackground(new Color(255, 255, 255));
		nursepaytable.setFont(new Font("���� ���", Font.PLAIN, 12));
		nursepayarea.setViewportView(nursepaytable);
		
		nursepaytable.setRowHeight(20);
		nursepaytable.setBackground(Color.WHITE);
		nursepaytable.setSelectionBackground(new Color(255, 228, 225));
		nursepayarea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < nursepaytable.getColumnCount(); i++) {
			nursepaytable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
						
//// �޿� ���꼭 ��ȸ
		nursepayaddbtn = new JButton("+");
		nursepayaddbtn.setBounds(15, 20, 60, 30);
		nursepaypanel.add(nursepayaddbtn);
		nursepayaddbtn.setForeground(Color.WHITE);
		nursepayaddbtn.setFont(new Font("���� ���", Font.BOLD, 17));
		nursepayaddbtn.setBackground(Color.BLACK);
						
		nursepaymodibtn = new JButton("����");
		nursepaymodibtn.setBounds(85, 20, 75, 30);
		nursepaypanel.add(nursepaymodibtn);
		nursepaymodibtn.setForeground(Color.WHITE);
		nursepaymodibtn.setFont(new Font("���� ���", Font.BOLD, 17));
		nursepaymodibtn.setBackground(Color.BLACK);
	
		nursepaydelbtn = new JButton("-");
		nursepaydelbtn.setBounds(170, 20, 60, 30);
		nursepaypanel.add(nursepaydelbtn);
		nursepaydelbtn.setForeground(Color.WHITE);
		nursepaydelbtn.setFont(new Font("���� ���", Font.BOLD, 17));
		nursepaydelbtn.setBackground(Color.BLACK);
// Ǫ��
		footpanel = new JPanel();
		footpanel.setBackground(new Color(255, 228, 225));
		footpanel.setBounds(0, 800, 1200, 100);
		add(footpanel);
		footpanel.setLayout(null);
		
		closebtn = new JButton("\uB2EB\uAE30");
		closebtn.setBounds(520, 25, 160, 50);
		footpanel.add(closebtn);
		closebtn.setFont(new Font("���� ���", Font.BOLD, 20));
		closebtn.setForeground(new Color(255, 255, 255));
		closebtn.setBackground(new Color(0, 0, 0));
		
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// �ݱ� ��ư�� ������ �� â �ݱ�
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CenterPayView.this);
				frame.dispose();
			}
		});

		eventProc();
		allnursetable();
		allpatienttable();
	}

	void eventProc() {
		nursesearchtext.addActionListener(this);
		nursetable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = nursetable.getSelectedRow();
				nuid = String.valueOf(nursetable.getValueAt(row, 0));
				updatenursepaytable(nuid);
			}
		});
		nursepayaddbtn.addActionListener(this);
		nursepaytable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = nursepaytable.getSelectedRow();
				ssno = String.valueOf(nursepaytable.getValueAt(row, 0));
			}
		});
		nursepaymodibtn.addActionListener(this);
		nursepaydelbtn.addActionListener(this);
		patientsearchtext.addActionListener(this);
		patienttable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = patienttable.getSelectedRow();
				ptno = String.valueOf(patienttable.getValueAt(row, 0));
				updatepatientpaytable(ptno);
			}
		});
		patientpayaddbtn.addActionListener(this);
		patientpaymodibtn.addActionListener(this);
		patientpaytable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e2) {
				int row = patientpaytable.getSelectedRow();
				msno = String.valueOf(patientpaytable.getValueAt(row, 0));
				patientpaycompletetable(msno);
			}
		});		
		patientpaydelbtn.addActionListener(this);
		
		patientpaycombtn.addActionListener(this);
		
		//// ȯ�� ���� �������� ���콺 ���� �� ù ��° �÷��� Ư�� �����͸� ������� ���� ��.


	}

	public void actionPerformed(ActionEvent ev) {
		Object o = ev.getSource();
		if (o == nursesearchtext) {
			nursetable();
		} else if (o == nursepayaddbtn) {
			try {
				CenterNursePayAddView pnv = new CenterNursePayAddView(this, nuid);
				JFrame payNurseFrame = new JFrame("��� ��ȣ�� ����");
				payNurseFrame.getContentPane().add(pnv);
				payNurseFrame.setSize(615, 935);
				payNurseFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				payNurseFrame.setLocation(970, 285);
				payNurseFrame.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
				e.printStackTrace();
			}
		} else if (o == nursepaymodibtn) {
			try {
				CenterNursePayModiView npv = new CenterNursePayModiView(this, nuid, ssno);
				JFrame payNurseFrame = new JFrame("��� ��ȣ�� ����");
				payNurseFrame.getContentPane().add(npv);
				payNurseFrame.setSize(615, 935);
				payNurseFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				payNurseFrame.setLocation(970, 285);
				payNurseFrame.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
				e.printStackTrace();
			}
		} else if (o == nursepaydelbtn) {
			try {
				dao.nursePayDelete(ssno);
				updatenursepaytable(nuid);
				JOptionPane.showMessageDialog(null, "��� ��ȣ�� �޿� ������ �����Ǿ����ϴ�.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "��� ��ȣ�� �޿� ���� ������ �����Ͽ����ϴ�.");
				e.printStackTrace();
			}

		} else if (o == patientsearchtext) {
			patienttable();
		} else if (o == patientpayaddbtn) {
			try {
				CenterPatientPayAddView ppv = new CenterPatientPayAddView(this, ptno);
				JFrame payPatientFrame = new JFrame("ȯ�� ��� ��ȣ�� ����");
				payPatientFrame.getContentPane().add(ppv);
				payPatientFrame.setSize(615, 935);
				payPatientFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				payPatientFrame.setLocation(970, 285);
				payPatientFrame.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
				e.printStackTrace();
			}

		} else if (o == patientpaymodibtn) {
			try {
				CenterPatientPayModiView ppm = new CenterPatientPayModiView(this, ptno, msno);
				JFrame payPatientFrame = new JFrame("ȯ�� ��� ��ȣ�� ����");
				payPatientFrame.getContentPane().add(ppm);
				payPatientFrame.setSize(615, 935);
				payPatientFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
				payPatientFrame.setLocation(970, 285);
				payPatientFrame.setVisible(true);
			} catch (Exception e3) {
				JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
				e3.printStackTrace();
			}
		} else if (o == patientpaydelbtn) {
			try {
				dao.patientpaydelete(msno);
				updatepatientpaytable(ptno);
				JOptionPane.showMessageDialog(null, "ȯ�� ��� ��ȣ�� ������ �����Ǿ����ϴ�.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ȯ�� ��� ��ȣ�� ���� ������ �����Ͽ����ϴ�.");
				e.printStackTrace();
			}
		} else if (o == patientpaycombtn) {
			try {
				int option = JOptionPane.showConfirmDialog(null, "���� ó���� �����Ͻðڽ��ϱ�?", "���� ó��", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					dao.patientPayComplete(msno);
					patientpaycompletetable(msno);
					JOptionPane.showMessageDialog(null, "ȯ�� ��� ��ȣ�� ������ ���� �Ϸ� ó���Ǿ����ϴ�.");
				} else {
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ȯ�� ��� ��ȣ�� ���� ���� �Ϸ� ó���� �����Ͽ����ϴ�.");
				e.printStackTrace();
			}
		}
	}

	public void clearScreen() {
		patientsearchtext.setText("");
		nursesearchtext.setText("");
		nursepayaddbtn.setText("");
		patientpayaddbtn.setText("");
	}
	
	void allnursetable() {
		try {
			ArrayList list = dao.allnurseSearch(cnid);
			nurseList.ddata = list;
			nursetable.setModel(nurseList);
			nurseList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	void nursetable() {
		int sel = nursesearchbox.getSelectedIndex();
		String text = nursesearchtext.getText();
		try {
			ArrayList list = dao.nurseSearch(cnid, sel, text);
			nurseList.ddata = list;
			nursetable.setModel(nurseList);
			nurseList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	void updatenursepaytable(String nuid) {
		try {
			ArrayList list = dao.nurseSalSelect(nuid);
			nursePayList.data = list;
			nursepaytable.setModel(nursePayList);
			nursePayList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	void allpatienttable() {
		try {
			ArrayList list = dao.allpatientSearch(cnid);
			patientList.data = list;
			patienttable.setModel(patientList);
			patientList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	void patienttable() {
		int sel = patientsearchbox.getSelectedIndex();
		String text = patientsearchtext.getText();
		try {
			ArrayList list = dao.patientSearch(cnid, sel, text);
			patientList.data = list;
			patienttable.setModel(patientList);
			patientList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	void updatepatientpaytable(String ptno) {
		try {
			ArrayList list = dao.patientPaySelect(ptno);
			patientPayList.data = list;
			patientpaytable.setModel(patientPayList);
			patientPayList.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	void patientpaycompletetable(String msno) {
		try {
			ArrayList list = dao.patientPayCompleteSelect(msno);
			patientPayCom.data = list;
			patientpaycomtable.setModel(patientPayCom);
			patientPayCom.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���� ��ȸ�� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}
	}
	
	class NurseListTable extends AbstractTableModel {

		ArrayList ddata = new ArrayList();
		String[] columnNames = { "��纸ȣ�� ���̵�", "��纸ȣ�� �̸�", "��纸ȣ�� ��ȭ��ȣ", "��Ī �ڵ�" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return ddata.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList demp = (ArrayList) ddata.get(row);
			return demp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}
	
	class NursePayListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "���꼭 �ڵ�", "�ش���", "�ѱ޿�", "����", "�߰�������", "�Ǽ��ɾ�", "��������"};

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList demp = (ArrayList) data.get(row);
			return demp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}
	
	class PatientListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "ȯ�� �ڵ�", "ȯ�� �̸�", "�ֺ�ȣ�� ���̵�", "�ֺ�ȣ�� �̸�", "�ֺ�ȣ�� ��ȭ��ȣ", "��Ī �ڵ�" };

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
	
	class PatientPayListTable extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "���� �ڵ�", "ȯ�� �ڵ�", "�ش���", "�����ݾ�", "����", "�Աݱ���"};

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList demp = (ArrayList) data.get(row);
			return demp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	class PatientPayCompleteTable extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "���� �ڵ�", "���� �ڵ�", "��������", "��������" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList demp = (ArrayList) data.get(row);
			return demp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

}
