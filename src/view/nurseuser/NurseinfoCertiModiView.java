package view.nurseuser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.nurseuserDAO.NurseMypageInfoDAO;
import view.login.NurseNewMemDetailView;
import vo.nurseuserVO.NurseMypageInfoVO;

public class NurseinfoCertiModiView extends JFrame implements ActionListener {

	private NurseMypageInfoView parentView;
	private int code;
	private String field, name;
	private JPanel contentPane;
	public JTextField certicodeText, certiDateText;
	public JComboBox certiFieldBox, certinameBox;
	JButton newCertiBtn;
	NurseMypageInfoDAO dao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseinfoCertiModiView frame = new NurseinfoCertiModiView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public NurseinfoCertiModiView(NurseMypageInfoView parentView, int code, String field, String name) {
		this();
		this.parentView = parentView;
		this.code=code;
		this.field = field;
		this.name = name;
	}

	/**
	 * Create the frame.
	 */
	public NurseinfoCertiModiView() {
		//DB ����
		try {
			dao = new NurseMypageInfoDAO();
			System.out.println("DB���� ����");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB���� ����\n"+e.getMessage());
			e.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\workspaces\\img\\Mainicon.png"));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headPanel = new JPanel();
		headPanel.setLayout(null);
		headPanel.setBackground(new Color(255, 228, 225));
		headPanel.setBounds(0, 0, 584, 40);
		contentPane.add(headPanel);
		
		JLabel NewCertiLabel = new JLabel(" \uC790\uACA9\uC99D \uC815\uBCF4\uB97C \uC218\uC815\uD558\uC138\uC694");
		NewCertiLabel.setForeground(new Color(0, 0, 0));
		NewCertiLabel.setFont(new Font("���� ����", Font.BOLD, 15));
		NewCertiLabel.setBackground(Color.BLACK);
		NewCertiLabel.setBounds(0, 0, 584, 40);
		headPanel.add(NewCertiLabel);
		
		certicodeText = new JTextField();
		certicodeText.setEditable(false);
		certicodeText.setFont(new Font("���� ����", Font.PLAIN, 12));
		certicodeText.setBounds(464, 10, 100, 20);
		headPanel.add(certicodeText);
		certicodeText.setColumns(10);
		
		newCertiBtn = new JButton("\uC815\uBCF4 \uC218\uC815");
		newCertiBtn.setForeground(new Color(255, 255, 255));
		newCertiBtn.setFont(new Font("���� ����", Font.BOLD, 15));
		newCertiBtn.setBackground(new Color(0, 0, 0));
		newCertiBtn.setBounds(192, 310, 200, 40);
		contentPane.add(newCertiBtn);
		
		JLabel certiFieldLabel = new JLabel("\uC790\uACA9\uC99D \uC885\uB958");
		certiFieldLabel.setForeground(Color.BLACK);
		certiFieldLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
		certiFieldLabel.setBackground(Color.WHITE);
		certiFieldLabel.setBounds(142, 100, 100, 30);
		contentPane.add(certiFieldLabel);
		
		JLabel certinameLabel = new JLabel("\uC790\uACA9\uC99D \uBA85");
		certinameLabel.setForeground(Color.BLACK);
		certinameLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
		certinameLabel.setBackground(Color.WHITE);
		certinameLabel.setBounds(142, 150, 100, 30);
		contentPane.add(certinameLabel);
		
		JLabel certiDateLabel = new JLabel("\uCDE8\uB4DD\uC77C");
		certiDateLabel.setForeground(Color.BLACK);
		certiDateLabel.setFont(new Font("���� ����", Font.PLAIN, 15));
		certiDateLabel.setBackground(Color.WHITE);
		certiDateLabel.setBounds(142, 200, 100, 30);
		contentPane.add(certiDateLabel);
		
		certiDateText = new JTextField();
		certiDateText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				certiDateText.setText("");
			}
		});
		certiDateText.setToolTipText("");
		certiDateText.setFont(new Font("���� ����", Font.PLAIN, 15));
		certiDateText.setColumns(10);
		certiDateText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		certiDateText.setBackground(Color.WHITE);
		certiDateText.setBounds(242, 201, 100, 30);
		contentPane.add(certiDateText);
		
		JPanel footPanel = new JPanel();
		footPanel.setLayout(null);
		footPanel.setBackground(new Color(255, 228, 225));
		footPanel.setBounds(0, 371, 584, 40);
		contentPane.add(footPanel);
		
		certiFieldBox = new JComboBox();
		certiFieldBox.setModel(new DefaultComboBoxModel(new String[] {"\uC694\uC591", "\uBCF5\uC9C0", "\uAC04\uBCD1", "\uC758\uB8CC"}));
		certiFieldBox.setFont(new Font("���� ����", Font.PLAIN, 15));
		certiFieldBox.setBackground(new Color(255, 255, 255));
		certiFieldBox.setBounds(242, 100, 200, 30);
		contentPane.add(certiFieldBox);
		
		certinameBox = new JComboBox();
		certinameBox.setFont(new Font("���� ����", Font.PLAIN, 15));
		certinameBox.setBackground(Color.WHITE);
		certinameBox.setBounds(242, 150, 200, 30);
		contentPane.add(certinameBox);
		setLocation(975, 500);
		
		if(field=="���") {
			String certiName[] = {"��纸ȣ�� �ڰ���"};
			certinameBox.setModel(new DefaultComboBoxModel(certiName));
		} else if(field=="����") {
			String certiName[] = {"��ȸ������ 1��", "��ȸ������ 2��", "�ǰ������� �ڰ���"};
			certinameBox.setModel(new DefaultComboBoxModel(certiName));
		} else if(field=="����") {
			String certiName[] = {"������ �ڰ���"};
			certinameBox.setModel(new DefaultComboBoxModel(certiName));
		} else if(field=="�Ƿ�") {
			String certiName[] = {"��ȣ�� �ڰ���", "��ȣ������ �ڰ���", "����ġ��� �ڰ���", "�۾�ġ��� �ڰ���"};
			certinameBox.setModel(new DefaultComboBoxModel(certiName));
		}
		
		eventProc();
		
	}
	
	public void eventProc() {
		newCertiBtn.addActionListener(this);
		certiFieldBox.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		private JPanel contentPane;
//		private JTextField certiDateText;
//		JButton newCertiBtn;
//		JComboBox certiFieldBox, certinameBox;
		int certiNum;
		String date;
		Object o = e.getSource();
		if(o==newCertiBtn) {
			int[][] ciCol = {{501}, {502, 503, 504}, {505}, {506, 507, 508, 509}};
			certiNum = ciCol[certiFieldBox.getSelectedIndex()][certinameBox.getSelectedIndex()];
			date = certiDateText.getText();
			NurseMypageInfoVO vo = new NurseMypageInfoVO();
			vo.setCerti(certiNum, date);
			JOptionPane.showMessageDialog(null, "�ڰ��� ������ �����Ǿ����ϴ�.");
			try {
				dao.certiModi(code, vo);
				parentView.certitable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "�ڰ��� ���� ������ �����Ͽ����ϴ�.");
				e2.printStackTrace();
			}
			setVisible(false);
		} else if(o==certiFieldBox) {
			if((String)certiFieldBox.getSelectedItem()=="���") {
				String certiName[] = {"��纸ȣ�� �ڰ���"};
				certinameBox.setModel(new DefaultComboBoxModel(certiName));
			} else if((String)certiFieldBox.getSelectedItem()=="����") {
				String certiName[] = {"��ȸ������ 1��", "��ȸ������ 2��", "�ǰ������� �ڰ���"};
				certinameBox.setModel(new DefaultComboBoxModel(certiName));
			} else if((String)certiFieldBox.getSelectedItem()=="����") {
				String certiName[] = {"������ �ڰ���"};
				certinameBox.setModel(new DefaultComboBoxModel(certiName));
			} else if((String)certiFieldBox.getSelectedItem()=="�Ƿ�") {
				String certiName[] = {"��ȣ�� �ڰ���", "��ȣ������ �ڰ���", "����ġ��� �ڰ���", "�۾�ġ��� �ڰ���"};
				certinameBox.setModel(new DefaultComboBoxModel(certiName));
			}
		}
		
	}
}