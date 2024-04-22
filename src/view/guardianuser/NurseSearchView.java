package view.guardianuser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.guardianuserDAO.NurseSearchDAO;
import vo.guardianuserVO.NurseSearchVO;

public class NurseSearchView extends JPanel {
	NurseSearchVO vo;
	NurseSearchDAO dao;
	private JTable table;
	private DefaultTableModel tableModel;
	private NurseSearchVO selectedNurse;
	private String mg_id;
	GuardianMypageView mainView;

	/**
	 * Create the panel.
	 */

	public NurseSearchView() {
		// TODO Auto-generated constructor stub
		initilize();
	}

	public NurseSearchView(GuardianMypageView mainView, String mg_id) {
		// TODO Auto-generated constructor stub
		this.mainView=mainView;
		this.mg_id = mg_id;
		initilize();
	}

	public void initilize() {
		try {
			dao = new NurseSearchDAO();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB연결 실패\n"+e.getMessage());
			e.printStackTrace();
		}
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		setBackground(new Color(0, 0, 0));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("     \uC694\uC591\uBCF4\uD638\uC0AC \uAC80\uC0C9");
		lblNewLabel.setBounds(0, 0, 1209, 70);
		add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(255, 228, 225));

		JPanel panel = new JPanel();
		panel.setBounds(0, 80, 1209, 70);
		panel.setBackground(new Color(255, 228, 225));
		add(panel);

		JComboBox<String> filterComboBox = new JComboBox<>();
		filterComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		filterComboBox.setForeground(new Color(255, 255, 255));
		filterComboBox.setBackground(new Color(0, 0, 0));
		filterComboBox.setBounds(20, 20, 150, 30);
		filterComboBox.addItem("성별");
		filterComboBox.addItem("남자");
		filterComboBox.addItem("여자");
		panel.setLayout(null);
		panel.add(filterComboBox);

		JComboBox<String> filterComboBox_2 = new JComboBox<String>();
		filterComboBox_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		filterComboBox_2.setForeground(new Color(255, 255, 255));
		filterComboBox_2.setBackground(new Color(0, 0, 0));
		filterComboBox_2.setBounds(180, 20, 150, 30);
		filterComboBox_2.addItem("국적");
		filterComboBox_2.addItem("대한민국");
		filterComboBox_2.addItem("일본");
		filterComboBox_2.addItem("중국");
		filterComboBox_2.addItem("대만");
		filterComboBox_2.addItem("홍콩");
		filterComboBox_2.addItem("베트남");
		filterComboBox_2.addItem("말레이시아");
		filterComboBox_2.addItem("인도네시아");
		filterComboBox_2.addItem("태국");
		filterComboBox_2.addItem("필리핀");
		filterComboBox_2.addItem("인도");
		filterComboBox_2.addItem("기타");
		panel.add(filterComboBox_2);

		JComboBox<String> filterComboBox_3 = new JComboBox<String>();
		filterComboBox_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		filterComboBox_3.setForeground(new Color(255, 255, 255));
		filterComboBox_3.setBackground(new Color(0, 0, 0));
		filterComboBox_3.setBounds(340, 20, 150, 30);
		filterComboBox_3.addItem("서비스 유형");
		filterComboBox_3.addItem("4시간");
		filterComboBox_3.addItem("8시간");
		filterComboBox_3.addItem("입주");

		panel.add(filterComboBox_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 160, 1200, 630);
		add(scrollPane);

		table = new JTable();
		tableModel = new DefaultTableModel();

		tableModel.addColumn("이름");
		tableModel.addColumn("성별");
		tableModel.addColumn("국적");
		tableModel.addColumn("서비스 유형");
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) { // Single click
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						// 선택된 간호사 정보를 저장
						selectedNurse = new NurseSearchVO((String) table.getValueAt(selectedRow, 0),
								(String) table.getValueAt(selectedRow, 1), (String) table.getValueAt(selectedRow, 2),
								(String) table.getValueAt(selectedRow, 3)
						);
						// 마우스 클릭 이벤트에서 NurseInfo 창을 열고 선택된 간호사 정보를 전달
						openNurseInfoWindow(selectedNurse);
					}
				}
			}
		});
		
		table.setRowHeight(25);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(255, 228, 225));
		scrollPane.getViewport().setBackground(Color.WHITE);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(center);
		}

		JButton searchButton = new JButton("검색");
		searchButton.setBounds(1017, 15, 150, 40);
		panel.add(searchButton);
		searchButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setBackground(new Color(0, 0, 0));

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 선택된 필터 값 가져오기

				String nu_sex = (String) filterComboBox_2.getSelectedItem();
				String nu_country = (String) filterComboBox_3.getSelectedItem();
				String sv_typename = (String) filterComboBox.getSelectedItem();
				List<NurseSearchVO> searchResult = dao.nurseSearch(sv_typename, nu_sex, nu_country);
				updateTable(searchResult);

			}
		});

		JButton btnNewButton = new JButton("\uB2EB\uAE30");
		btnNewButton.setBounds(520, 825, 160, 50);
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 800, 1200, 100);
		panel_1.setBackground(new Color(255, 228, 225));
		add(panel_1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 닫기 버튼이 눌렸을 때 창 닫기
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(NurseSearchView.this);
				frame.dispose();
			}
		});
		
		String nu_sex = (String) filterComboBox_2.getSelectedItem();
		String nu_country = (String) filterComboBox_3.getSelectedItem();
		String sv_typename = (String) filterComboBox.getSelectedItem();
		List<NurseSearchVO> searchResult = dao.nurseSearch(sv_typename, nu_sex, nu_country);
		updateTable(searchResult);
		
	}

	private void updateTable(List<NurseSearchVO> dataList) {
		tableModel.setRowCount(0); // Clear existing rows

		for (NurseSearchVO nurse : dataList) {
			Object[] rowData = { nurse.getNu_name(), nurse.getNu_sex(), nurse.getNu_country(), nurse.getSv_typename() };
			tableModel.addRow(rowData);
		}
	}

	private void openNurseInfoWindow(NurseSearchVO nurse) {
		String nu_name, nu_sex, nu_country, sv_typename;
		nu_name = nurse.getNu_name(); // Assuming you have a method like getNuName() in NurseVO
		nu_sex = nurse.getNu_sex(); // Assuming you have a method like getNuSex() in NurseVO
		nu_country = nurse.getNu_country(); // Assuming you have a method like getNuCountry() in NurseVO
		sv_typename = nurse.getSv_typename();

		NurseInfoView nurseInfoWindow = new NurseInfoView(mainView, mg_id, nu_name, nu_sex, nu_country, sv_typename);
		nurseInfoWindow.setVisible(true);

	}
}
