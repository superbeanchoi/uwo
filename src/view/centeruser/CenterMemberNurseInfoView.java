package view.centeruser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

public class CenterMemberNurseInfoView extends JPanel implements ActionListener {
	String nuid;
	CenterMemberSearchDAO dao;
	private JTextField nuidText;
	JButton closeBtn;
	CareerListTable careerList;
	CertiListTable certiList;
	SkillListTable skillList;
	JTable careertable, certitable, skilltable;

	/**
	 * Create the panel.
	 */
	
	public CenterMemberNurseInfoView() {
		// TODO Auto-generated constructor stub
		initialize();
	}
	
	public CenterMemberNurseInfoView(String nuid) {
		// TODO Auto-generated constructor stub
		this.nuid=nuid;
		initialize();
	}
	
	public void initialize() {
		//DB 연결
		try {
			dao = new CenterMemberSearchDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel headLabel = new JLabel("     \uC0C1\uC138 \uC778\uB825 \uC815\uBCF4");
		headLabel.setBounds(0, 0, 600, 70);
		add(headLabel);
		headLabel.setOpaque(true);
		headLabel.setForeground(new Color(0, 0, 0));
		headLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		headLabel.setBackground(new Color(255, 228, 225));

		JLabel nuidLabel = new JLabel("\uC694\uC591\uBCF4\uD638\uC0AC \uC544\uC774\uB514");
		nuidLabel.setForeground(Color.BLACK);
		nuidLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nuidLabel.setBackground(Color.WHITE);
		nuidLabel.setBounds(20, 90, 200, 30);
		add(nuidLabel);
		
		nuidText = new JTextField();
		nuidText.setToolTipText("");
		nuidText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nuidText.setEditable(false);
		nuidText.setColumns(10);
		nuidText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nuidText.setBackground(Color.WHITE);
		nuidText.setBounds(220, 90, 150, 30);
		add(nuidText);
		
		JPanel careerpanel = new JPanel();
		careerpanel.setBorder(new TitledBorder(null, "\uACBD\uB825 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		careerpanel.setBackground(new Color(255, 255, 255));
		careerpanel.setBounds(20, 140, 560, 180);
		add(careerpanel);
		careerpanel.setLayout(null);
		
		JScrollPane careerArea = new JScrollPane();
		careerArea.setBounds(17, 25, 525, 135);
		careerpanel.add(careerArea);
		
		careerList = new CareerListTable();
		careertable = new JTable(careerList);
		careertable.setBackground(new Color(255, 255, 255));
		careertable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		careerArea.setViewportView(careertable);
		
		careertable.setRowHeight(20);
		careertable.setBackground(Color.WHITE);
		careertable.setSelectionBackground(new Color(255, 228, 225));
		careerArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < careertable.getColumnCount(); i++) {
			careertable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel certipanel = new JPanel();
		certipanel.setLayout(null);
		certipanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC790\uACA9\uC99D \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		certipanel.setBackground(Color.WHITE);
		certipanel.setBounds(20, 340, 560, 180);
		add(certipanel);
		
		JScrollPane certiArea = new JScrollPane();
		certiArea.setBounds(17, 25, 525, 135);
		certipanel.add(certiArea);
		
		certiList = new CertiListTable();
		certitable = new JTable(certiList);
		certitable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		certiArea.setViewportView(certitable);
		
		certitable.setRowHeight(20);
		certitable.setBackground(Color.WHITE);
		certitable.setSelectionBackground(new Color(255, 228, 225));
		certiArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < certitable.getColumnCount(); i++) {
			certitable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		JPanel skillpanel = new JPanel();
		skillpanel.setLayout(null);
		skillpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uAE30\uC220 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		skillpanel.setBackground(Color.WHITE);
		skillpanel.setBounds(20, 550, 560, 180);
		add(skillpanel);
		
		JScrollPane skillArea = new JScrollPane();
		skillArea.setBounds(17, 25, 525, 135);
		skillpanel.add(skillArea);
		
		skillList = new SkillListTable();
		skilltable = new JTable(skillList);
		skilltable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		skillArea.setViewportView(skilltable);
		
		skilltable.setRowHeight(20);
		skilltable.setBackground(Color.WHITE);
		skilltable.setSelectionBackground(new Color(255, 228, 225));
		skillArea.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < skilltable.getColumnCount(); i++) {
			skilltable.getColumnModel().getColumn(i).setCellRenderer(center);
		}
		
		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBackground(new Color(0, 0, 0));
		closeBtn.setBounds(220, 800, 160, 50);
		add(closeBtn);

		JLabel footLabel = new JLabel("");
		footLabel.setOpaque(true);
		footLabel.setForeground(Color.BLACK);
		footLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		footLabel.setBackground(new Color(255, 228, 225));
		footLabel.setBounds(0, 760, 600, 140);
		add(footLabel);
		
		eventProc();
		
		try {
			CenterMemberSearchVO vo = new CenterMemberSearchVO();
			nuidText.setText(nuid);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
		
		careertable();
		certitable();
		skilltable();
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
	
	void careertable() {
		try {
			ArrayList list = dao.careerselect(nuid);
			careerList.data = list;
			careertable.setModel(careerList);
			careerList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void certitable() {
		try {
			ArrayList list = dao.certiselect(nuid);
			certiList.data = list;
			certitable.setModel(certiList);
			certiList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	void skilltable() {
		try {
			ArrayList list = dao.skillselect(nuid);
			skillList.data = list;
			skilltable.setModel(skillList);
			skillList.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "정보 조회에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	class CareerListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String[] columnNames = { "경력 분야", "시작 일자", "종료 일자", "상세 내용" };

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
		String[] columnNames = { "자격증 종류", "자격증 명", "취득일" };

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
		String[] columnNames = { "기술 종류", "기술 명" };

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
