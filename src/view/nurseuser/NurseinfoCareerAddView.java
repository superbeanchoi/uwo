package view.nurseuser;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dao.loginDAO.NurseNewMemDAO;
import view.nurseuser.NurseMypageInfoView;
import vo.loginVO.NurseNewMemVO;

public class NurseinfoCareerAddView extends JFrame implements ActionListener {

	private NurseMypageInfoView parentView;
	private JPanel contentPane;
	private JTextField careerFieldText, startDateText, endDateText;
	JTextArea detailText;
	JButton newCareerBtn;
	NurseNewMemDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NurseinfoCareerAddView frame = new NurseinfoCareerAddView();
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
	public NurseinfoCareerAddView() {
		//DB ¿¬°á
		try {
			dao = new NurseNewMemDAO();
			System.out.println("DB¿¬°á ¼º°ø");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "DB¿¬°á ½ÇÆÐ\n"+e.getMessage());
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
		
		JLabel NewCareerLabel = new JLabel(" \uACBD\uB825 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NewCareerLabel.setForeground(new Color(0, 0, 0));
		NewCareerLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		NewCareerLabel.setBackground(new Color(255, 228, 225));
		NewCareerLabel.setBounds(0, 0, 584, 40);
		headPanel.add(NewCareerLabel);
		
		newCareerBtn = new JButton("\uC815\uBCF4 \uCD94\uAC00");
		newCareerBtn.setForeground(new Color(255, 255, 255));
		newCareerBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		newCareerBtn.setBackground(new Color(0, 0, 0));
		newCareerBtn.setBounds(192, 310, 200, 40);
		contentPane.add(newCareerBtn);
		
		JLabel careerFieldLabel = new JLabel("\uACBD\uB825 \uBD84\uC57C");
		careerFieldLabel.setForeground(Color.BLACK);
		careerFieldLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		careerFieldLabel.setBackground(Color.WHITE);
		careerFieldLabel.setBounds(77, 76, 90, 30);
		contentPane.add(careerFieldLabel);
		
		careerFieldText = new JTextField();
		careerFieldText.setToolTipText("");
		careerFieldText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		careerFieldText.setColumns(10);
		careerFieldText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		careerFieldText.setBackground(Color.WHITE);
		careerFieldText.setBounds(167, 76, 340, 30);
		contentPane.add(careerFieldText);
		
		JLabel startDateLabel = new JLabel("\uC2DC\uC791\uC77C\uC790");
		startDateLabel.setForeground(Color.BLACK);
		startDateLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		startDateLabel.setBackground(Color.WHITE);
		startDateLabel.setBounds(77, 126, 90, 30);
		contentPane.add(startDateLabel);
		
		startDateText = new JTextField();
		startDateText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startDateText.setText("");
			}
		});
		startDateText.setText("YYYY-MM-DD");
		startDateText.setToolTipText("");
		startDateText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		startDateText.setColumns(10);
		startDateText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		startDateText.setBackground(Color.WHITE);
		startDateText.setBounds(167, 126, 100, 30);
		contentPane.add(startDateText);
		
		JLabel endDateLabel = new JLabel("\uC885\uB8CC\uC77C\uC790");
		endDateLabel.setForeground(Color.BLACK);
		endDateLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		endDateLabel.setBackground(Color.WHITE);
		endDateLabel.setBounds(317, 126, 90, 30);
		contentPane.add(endDateLabel);
		
		endDateText = new JTextField();
		endDateText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				endDateText.setText("");
			}
		});
		endDateText.setText("YYYY-MM-DD");
		endDateText.setToolTipText("");
		endDateText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		endDateText.setColumns(10);
		endDateText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		endDateText.setBackground(Color.WHITE);
		endDateText.setBounds(407, 126, 100, 30);
		contentPane.add(endDateText);
		
		JLabel detailLabel = new JLabel("\uC0C1\uC138 \uB0B4\uC6A9");
		detailLabel.setForeground(Color.BLACK);
		detailLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		detailLabel.setBackground(Color.WHITE);
		detailLabel.setBounds(77, 176, 90, 30);
		contentPane.add(detailLabel);
		
		JPanel footPanel = new JPanel();
		footPanel.setLayout(null);
		footPanel.setBackground(new Color(255, 228, 225));
		footPanel.setBounds(0, 371, 584, 40);
		contentPane.add(footPanel);
		
		JScrollPane detailTextScroll = new JScrollPane();
		detailTextScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		detailTextScroll.setBounds(167, 176, 340, 100);
		contentPane.add(detailTextScroll);
		
		detailText = new JTextArea();
		detailText.setLineWrap(true);
		detailText.setForeground(Color.BLACK);
		detailText.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		detailText.setColumns(10);
		detailText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		detailText.setBackground(Color.WHITE);
		detailTextScroll.setViewportView(detailText);
		
		setLocation(975, 500);
		
		eventProc();
		
	}
	
	public NurseinfoCareerAddView(NurseMypageInfoView parentView) {
		this();
		this.parentView = parentView;
	}
	
	public void eventProc() {
		newCareerBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		private JPanel contentPane;
//		private JTextField careerFieldText, startDateText, endDateText;
//		JTextArea detailText;
//		JButton newCareerBtn;
		String id, field, start, end, detail;
		Object o = e.getSource();
		if(o==newCareerBtn) {
			id = parentView.idText.getText();
			field = careerFieldText.getText();
			start = startDateText.getText();
			end = endDateText.getText();
			detail = detailText.getText();
			NurseNewMemVO vo = new NurseNewMemVO();
			vo.setCareer(id, field, start, end, detail);
			JOptionPane.showMessageDialog(null, "°æ·Â Á¤º¸°¡ ±âÀÔµÇ¾ú½À´Ï´Ù.");
			try {
				dao.careerinsert(vo);
				parentView.careertable();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "°æ·Â Á¤º¸ ±âÀÔÀÌ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
				e2.printStackTrace();
			}
			setVisible(false);
		}
		
	}
}
