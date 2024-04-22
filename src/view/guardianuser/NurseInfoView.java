package view.guardianuser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import dao.guardianuserDAO.NurseInfoDAO;
import vo.guardianuserVO.NurseInfoVO;

public class NurseInfoView extends JFrame {

	GuardianMypageView mainView;
	JPanel contentPane;
	JButton newMemBtn;
	NurseInfoDAO dao;
	NurseInfoVO vo;
	CareerListTable careerList;
	CertiListTable certiList;
	SkillListTable skillList;
	JTable careertable, certitable, skilltable;
	JLabel imgLabel, imgbox, nameLabel, sexLabel, countryLabel;
	JTextField nameText, sexText, countryText;
	private JButton newMemBtn_1;
	private JLabel telLabel;
	private JTextField telText;
	private JTextField surviceText;
	private String nuId;
	String mg_id;
	NurseSearchView nurse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseInfoView frame = new NurseInfoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public NurseInfoView() {
		initialize(); // »ý¼ºÀÚ ³»¿ëÀ» ¸Þ¼Òµå·Î µû·Î ºÐ¸®
	}

	String nu_name;
	String nu_sex;
	String nu_country;
	String sv_typename;

	public NurseInfoView(GuardianMypageView mainView, String mg_id, String nu_name, String nu_sex, String nu_country, String sv_typename) {
		this.mainView=mainView;
		this.mg_id = mg_id;
		this.nu_name = nu_name;
		this.nu_sex = nu_sex;
		this.nu_country = nu_country;
		this.sv_typename = sv_typename;
		initialize(); // »ý¼ºÀÚ ³»¿ëÀ» ¸Þ¼Òµå·Î µû·Î ºÐ¸®
	}

	private void initialize() {
		// TODO Auto-generated method stub

		// DB ¿¬°á
		try {
			dao = new NurseInfoDAO();
			System.out.println("DB¿¬°á ¼º°ø");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		setTitle("\uC0C1\uC138 \uC815\uBCF4");
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

		JLabel NewMemLabel = new JLabel("  \uC0C1\uC138 \uC778\uB825 \uC815\uBCF4");
		NewMemLabel.setBounds(0, 0, 1200, 50);
		NewMemLabel.setForeground(new Color(0, 0, 0));
		NewMemLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		NewMemLabel.setBackground(new Color(255, 228, 225));
		headPanel.add(NewMemLabel);

		newMemBtn = new JButton("\uB2EB\uAE30");
		newMemBtn.setBounds(625, 715, 150, 50);
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

		JLabel careerLabel = new JLabel("\uACBD\uB825 \uC815\uBCF4");
		careerLabel.setForeground(Color.BLACK);
		careerLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		careerLabel.setBackground(Color.WHITE);
		careerLabel.setBounds(530, 100, 120, 30);
		contentPane.add(careerLabel);

		JScrollPane careerArea = new JScrollPane();
		careerArea.setBounds(530, 140, 600, 120);
		contentPane.add(careerArea);

		careerList = new CareerListTable();
		careertable = new JTable(careerList);
		careertable.setBackground(new Color(255, 255, 255));
		careertable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		careerArea.setViewportView(careertable);

		careertable.setRowHeight(20);
		careertable.setBackground(Color.WHITE);
		careertable.setSelectionBackground(new Color(255, 228, 225));
		careerArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < careertable.getColumnCount(); i++) {
			careertable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JLabel certiLabel = new JLabel("\uC790\uACA9\uC99D \uC815\uBCF4");
		certiLabel.setForeground(Color.BLACK);
		certiLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		certiLabel.setBackground(Color.WHITE);
		certiLabel.setBounds(530, 300, 120, 30);
		contentPane.add(certiLabel);

		JScrollPane certiArea = new JScrollPane();
		certiArea.setBounds(530, 340, 600, 120);
		contentPane.add(certiArea);

		certiList = new CertiListTable();
		certitable = new JTable(certiList);
		certitable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		certiArea.setViewportView(certitable);

		certitable.setRowHeight(20);
		certitable.setBackground(Color.WHITE);
		certitable.setSelectionBackground(new Color(255, 228, 225));
		certiArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < certitable.getColumnCount(); i++) {
			certitable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JLabel skillLabel = new JLabel("\uAE30\uC220 \uC815\uBCF4");
		skillLabel.setForeground(Color.BLACK);
		skillLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		skillLabel.setBackground(Color.WHITE);
		skillLabel.setBounds(530, 500, 120, 30);
		contentPane.add(skillLabel);

		JScrollPane skillArea = new JScrollPane();
		skillArea.setBounds(530, 540, 600, 120);
		contentPane.add(skillArea);

		skillList = new SkillListTable();
		skilltable = new JTable(skillList);
		skilltable.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		skillArea.setViewportView(skilltable);

		skilltable.setRowHeight(20);
		skilltable.setBackground(Color.WHITE);
		skilltable.setSelectionBackground(new Color(255, 228, 225));
		skillArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < skilltable.getColumnCount(); i++) {
			skilltable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		imgbox = new JLabel("");
		imgbox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgbox.setBackground(Color.WHITE);
		imgbox.setBounds(191, 140, 100, 120);
		contentPane.add(imgbox);

		nameText = new JTextField();
		nameText.setEditable(false);
		nameText.setToolTipText("");
		nameText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nameText.setBackground(Color.WHITE);
		nameText.setBounds(190, 300, 250, 30);
		contentPane.add(nameText);

		nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(70, 300, 120, 30);
		contentPane.add(nameLabel);

		sexLabel = new JLabel("\uC131\uBCC4");
		sexLabel.setForeground(Color.BLACK);
		sexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sexLabel.setBackground(Color.WHITE);
		sexLabel.setBounds(70, 380, 120, 30);
		contentPane.add(sexLabel);

		countryLabel = new JLabel("\uAD6D\uC801");
		countryLabel.setForeground(Color.BLACK);
		countryLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		countryLabel.setBackground(Color.WHITE);
		countryLabel.setBounds(70, 460, 120, 30);
		contentPane.add(countryLabel);

		sexText = new JTextField();
		sexText.setEditable(false);
		sexText.setToolTipText("");
		sexText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		sexText.setColumns(10);
		sexText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		sexText.setBackground(Color.WHITE);
		sexText.setBounds(190, 380, 250, 30);
		contentPane.add(sexText);

		countryText = new JTextField();
		countryText.setEditable(false);
		countryText.setToolTipText("");
		countryText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		countryText.setColumns(10);
		countryText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		countryText.setBackground(Color.WHITE);
		countryText.setBounds(190, 460, 250, 30);
		contentPane.add(countryText);

		imgLabel = new JLabel("\uC0AC\uC9C4");
		imgLabel.setForeground(Color.BLACK);
		imgLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBounds(70, 185, 120, 30);
		contentPane.add(imgLabel);

		newMemBtn_1 = new JButton("\uBA74\uC811\uC694\uCCAD");
		newMemBtn_1.setForeground(Color.WHITE);
		newMemBtn_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		newMemBtn_1.setBackground(Color.BLACK);
		newMemBtn_1.setBounds(425, 715, 150, 50);
		contentPane.add(newMemBtn_1);

		newMemBtn_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openInterviewWindow(); // Call a method to open the interview window
			}
		});

		telLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telLabel.setForeground(Color.BLACK);
		telLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telLabel.setBackground(Color.WHITE);
		telLabel.setBounds(70, 540, 120, 30);
		contentPane.add(telLabel);

		telText = new JTextField();
		telText.setToolTipText("");
		telText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		telText.setEditable(false);
		telText.setColumns(10);
		telText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		telText.setBackground(Color.WHITE);
		telText.setBounds(190, 540, 250, 30);
		contentPane.add(telText);

		JLabel surviceLabel = new JLabel("\uC11C\uBE44\uC2A4 \uC720\uD615");
		surviceLabel.setForeground(Color.BLACK);
		surviceLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		surviceLabel.setBackground(Color.WHITE);
		surviceLabel.setBounds(70, 620, 120, 30);
		contentPane.add(surviceLabel);

		surviceText = new JTextField();
		surviceText.setToolTipText("");
		surviceText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		surviceText.setEditable(false);
		surviceText.setColumns(10);
		surviceText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		surviceText.setBackground(Color.WHITE);
		surviceText.setBounds(190, 620, 250, 30);
		contentPane.add(surviceText);

		try {
			NurseInfoVO vo = dao.infoSelect(nu_name, nu_sex, nu_country, sv_typename);
			imgbox.setIcon(new ImageIcon(vo.getNu_picture()));
			nameText.setText(vo.getNu_name());
			sexText.setText(vo.getNu_sex());
			telText.setText(vo.getNu_tel());
			countryText.setText(vo.getNu_country());
			surviceText.setText(vo.getSv_typename());
			nuId = vo.getId();
			careertable();
			certitable();
			skilltable();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}

	}

	void careertable() {
		try {
			String id = nuId;
			ArrayList list = dao.careerselect(id);
			careerList.data = list;
			careertable.setModel(careerList);
			careerList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	void certitable() {
		try {
			String id = nuId;
			ArrayList list = dao.certiselect(id);
			certiList.data = list;
			certitable.setModel(certiList);
			certiList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	void skilltable() {
		try {
			String id = nuId;
			ArrayList list = dao.skillselect(id);
			skillList.data = list;
			skilltable.setModel(skillList);
			skillList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Á¤º¸ Á¶È¸¿¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
			e.printStackTrace();
		}
	}

	class CareerListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "°æ·Â ºÐ¾ß", "½ÃÀÛ ÀÏÀÚ", "Á¾·á ÀÏÀÚ", "»ó¼¼ ³»¿ë" };

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

	class CertiListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "ÀÚ°ÝÁõ Á¾·ù", "ÀÚ°ÝÁõ ¸í", "ÃëµæÀÏ" };

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

	class SkillListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "±â¼ú Á¾·ù", "±â¼ú ¸í" };

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

	private void openInterviewWindow() {
		// Create an instance of the meeting window
		MeetingView meetingWindow = new MeetingView(mainView, mg_id, nuId);
//		 meetingWindow.setVisible(true);
		meetingWindow.selectPatientTable();
		JFrame meetingFrame = new JFrame("¸éÁ¢ ¿äÃ»");
		meetingFrame.getContentPane().add(meetingWindow);
		meetingFrame.setSize(1215, 935);
		meetingFrame.setLocation(680, 285);
		meetingFrame.setVisible(true);
		meetingWindow.selectPatientTable();
	}

}
