package view.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import dao.loginDAO.NurseNewMemDAO;
import vo.loginVO.NurseNewMemVO;

public class NurseNewMemDetailView extends JFrame implements ActionListener {

	JPanel contentPane;
	JButton newMemBtn;
	JButton careerAddBtn, careerDelBtn, certiAddBtn, certiDelBtn, skillAddBtn, skillDelBtn;
	NurseNewMemDAO dao;
	NurseNewMemVO vo;
	CareerListTable careerList;
	CertiListTable certiList;
	SkillListTable skillList;
	JTable careertable, certitable, skilltable;
	JLabel imgLabel, imgbox, nameLabel, idLabel, pwLabel;
	JTextField nameText, idText, pwText;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseNewMemDetailView frame = new NurseNewMemDetailView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NurseNewMemDetailView() {
		//DB 연결
		try {
			dao = new NurseNewMemDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		setTitle("\uC694\uC591\uBCF4\uD638\uC0AC \uD68C\uC6D0\uAC00\uC785");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headPanel = new JPanel();
		headPanel.setBounds(0, 0, 1184, 50);
		headPanel.setBackground(new Color(255, 228, 225));
		contentPane.add(headPanel);
		headPanel.setLayout(null);
		
		JLabel NewMemLabel = new JLabel("  \uC0C1\uC138 \uC778\uB825 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NewMemLabel.setBounds(0, 0, 1184, 50);
		NewMemLabel.setForeground(new Color(0, 0, 0));
		NewMemLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		NewMemLabel.setBackground(new Color(255, 228, 225));
		headPanel.add(NewMemLabel);
		
		newMemBtn = new JButton("\uD68C\uC6D0\uAC00\uC785 \uC644\uB8CC");
		newMemBtn.setBounds(467, 725, 250, 50);
		newMemBtn.setForeground(new Color(255, 255, 255));
		newMemBtn.setBackground(new Color(0, 0, 0));
		newMemBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		contentPane.add(newMemBtn);
		
		JPanel footPanel = new JPanel();
		footPanel.setBounds(0, 811, 1184, 50);
		footPanel.setBackground(new Color(255, 228, 225));
		contentPane.add(footPanel);
		
		JLabel careerLabel = new JLabel("\uACBD\uB825 \uC815\uBCF4");
		careerLabel.setForeground(Color.BLACK);
		careerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		careerLabel.setBackground(Color.WHITE);
		careerLabel.setBounds(510, 100, 120, 30);
		contentPane.add(careerLabel);
		
		JScrollPane careerArea = new JScrollPane();
		careerArea.setBounds(510, 140, 600, 120);
		contentPane.add(careerArea);
		
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
		
		careerAddBtn = new JButton("+");
		careerAddBtn.setForeground(Color.WHITE);
		careerAddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		careerAddBtn.setBackground(Color.BLACK);
		careerAddBtn.setBounds(1000, 100, 50, 30);
		contentPane.add(careerAddBtn);
		
		careerDelBtn = new JButton("-");
		careerDelBtn.setForeground(Color.WHITE);
		careerDelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		careerDelBtn.setBackground(Color.BLACK);
		careerDelBtn.setBounds(1060, 100, 50, 30);
		contentPane.add(careerDelBtn);
		
		JLabel certiLabel = new JLabel("\uC790\uACA9\uC99D \uC815\uBCF4");
		certiLabel.setForeground(Color.BLACK);
		certiLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		certiLabel.setBackground(Color.WHITE);
		certiLabel.setBounds(510, 315, 120, 30);
		contentPane.add(certiLabel);
		
		JScrollPane certiArea = new JScrollPane();
		certiArea.setBounds(510, 355, 600, 120);
		contentPane.add(certiArea);
		
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
		
		certiAddBtn = new JButton("+");
		certiAddBtn.setForeground(Color.WHITE);
		certiAddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		certiAddBtn.setBackground(Color.BLACK);
		certiAddBtn.setBounds(1000, 315, 50, 30);
		contentPane.add(certiAddBtn);
		
		certiDelBtn = new JButton("-");
		certiDelBtn.setForeground(Color.WHITE);
		certiDelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		certiDelBtn.setBackground(Color.BLACK);
		certiDelBtn.setBounds(1060, 315, 50, 30);
		contentPane.add(certiDelBtn);
		
		JLabel skillLabel = new JLabel("\uAE30\uC220 \uC815\uBCF4");
		skillLabel.setForeground(Color.BLACK);
		skillLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		skillLabel.setBackground(Color.WHITE);
		skillLabel.setBounds(510, 520, 120, 30);
		contentPane.add(skillLabel);
		
		JScrollPane skillArea = new JScrollPane();
		skillArea.setBounds(510, 560, 600, 120);
		contentPane.add(skillArea);
		
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
		
		skillAddBtn = new JButton("+");
		skillAddBtn.setForeground(Color.WHITE);
		skillAddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		skillAddBtn.setBackground(Color.BLACK);
		skillAddBtn.setBounds(1000, 520, 50, 30);
		contentPane.add(skillAddBtn);
		
		skillDelBtn = new JButton("-");
		skillDelBtn.setForeground(Color.WHITE);
		skillDelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		skillDelBtn.setBackground(Color.BLACK);
		skillDelBtn.setBounds(1060, 520, 50, 30);
		contentPane.add(skillDelBtn);
		
		imgbox = new JLabel("");
		imgbox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		imgbox.setBackground(Color.WHITE);
		imgbox.setBounds(170, 220, 100, 120);
		contentPane.add(imgbox);
		
		nameText = new JTextField();
		nameText.setEditable(false);
		nameText.setToolTipText("");
		nameText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameText.setColumns(10);
		nameText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		nameText.setBackground(Color.WHITE);
		nameText.setBounds(170, 383, 250, 30);
		contentPane.add(nameText);
		
		nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(50, 383, 120, 30);
		contentPane.add(nameLabel);
		
		idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idLabel.setBackground(Color.WHITE);
		idLabel.setBounds(50, 463, 120, 30);
		contentPane.add(idLabel);
		
		pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setForeground(Color.BLACK);
		pwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwLabel.setBackground(Color.WHITE);
		pwLabel.setBounds(50, 543, 120, 30);
		contentPane.add(pwLabel);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setToolTipText("");
		idText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		idText.setColumns(10);
		idText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		idText.setBackground(Color.WHITE);
		idText.setBounds(170, 463, 250, 30);
		contentPane.add(idText);
		
		pwText = new JTextField();
		pwText.setEditable(false);
		pwText.setToolTipText("");
		pwText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		pwText.setColumns(10);
		pwText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pwText.setBackground(Color.WHITE);
		pwText.setBounds(170, 543, 250, 30);
		contentPane.add(pwText);
		
		imgLabel = new JLabel("\uC0AC\uC9C4");
		imgLabel.setForeground(Color.BLACK);
		imgLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		imgLabel.setBackground(Color.WHITE);
		imgLabel.setBounds(50, 265, 120, 30);
		contentPane.add(imgLabel);
		
		setLocation(680, 250);
		eventProc();
	}
	
	public void eventProc() {
		careerAddBtn.addActionListener(this);
		certiAddBtn.addActionListener(this);
		skillAddBtn.addActionListener(this);
		newMemBtn.addActionListener(this);
		careertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int col = 0;
				int row = careertable.getSelectedRow();
				String careerFiledName = (String)careertable.getValueAt(row, col);
				careerDelBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String id = idText.getText();
						try {
							dao.careerDelete(id, careerFiledName);
							JOptionPane.showMessageDialog(null, "경력 정보가 삭제되었습니다.");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "경력 정보 삭제가 실패하였습니다.");
							e1.printStackTrace();
						}
						careertable();
					}
				});
			}
		});
		certitable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int col = 1;
				int row = certitable.getSelectedRow();
				String certiName = (String)certitable.getValueAt(row, col);
				certiDelBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String id = idText.getText();
						try {
							dao.certiDelete(id, certiName);
							JOptionPane.showMessageDialog(null, "자격증 정보가 삭제되었습니다.");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "자격증 정보 삭제가 실패하였습니다.");
							e1.printStackTrace();
						}
						certitable();
					}
				});
			}
		});
		skilltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int col = 1;
				int row = skilltable.getSelectedRow();
				String skillName = (String)skilltable.getValueAt(row, col);
				skillDelBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String id = idText.getText();
						try {
							dao.skillDelete(id, skillName);
							JOptionPane.showMessageDialog(null, "기술 정보가 삭제되었습니다.");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "기술 정보 삭제가 실패하였습니다.");
							e1.printStackTrace();
						}
						skilltable();
					}
				});
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o==newMemBtn) {
			String name = nameText.getText();
			JOptionPane.showMessageDialog(null, name+" 님의 회원 가입이 성공적으로 완료되었습니다.");
			LoginView newView = new LoginView();
			newView.setVisible(true);
			setVisible(false);
		} else if(o==careerAddBtn) {
			NurseCareerAddView career = new NurseCareerAddView(this);
			career.setVisible(true);
		} else if(o==certiAddBtn) {
			NurseCertiAddView certi = new NurseCertiAddView(this);
			certi.setVisible(true);
		} else if(o==skillAddBtn) {
			NurseSkillAddView skill = new NurseSkillAddView(this);
			skill.setVisible(true);
		}
		
	}
	
	void careertable() {
		try {
			String id = idText.getText();
			ArrayList list = dao.careerselect(id);
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
			String id = idText.getText();
			ArrayList list = dao.certiselect(id);
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
			String id = idText.getText();
			ArrayList list = dao.skillselect(id);
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
		String [] columnNames = {"경력 분야","시작 일자","종료 일자", "상세 내용"};
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
	
	class CertiListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"자격증 종류","자격증 명", "취득일"};
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
	
	class SkillListTable extends AbstractTableModel {
		ArrayList data = new ArrayList();
		String [] columnNames = {"기술 종류","기술 명"};
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
