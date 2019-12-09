import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class paymentMethod {
	public static String tot_money;
	public static String text_name;
	// �ٸ��������� ������ public static���� �ؼ� ���������� ������ ��
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public int cost;
	public static String cost_str;
	
	public static DAO dao = new DAO();
	SvDAO svdao = new SvDAO();
	DAO_RESERVATION daorsv = new DAO_RESERVATION();
	private static VO vo;
	ArrayList<Integer> list = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymentMethod window = new paymentMethod();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public paymentMethod() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	      Image img = toolkit.getImage("images/hair_salon.png");
	      frame.setIconImage(img);
		frame.getContentPane().setBackground(new Color(246,244,254));
		frame.setBounds(100, 100, 400, 364);
		frame.setTitle("���� �ϱ�");// ���� Ÿ��Ʋ ����
		frame.setLocationRelativeTo(null);// ų�� �߾ӿ�\ ��ġ�ϰ�
		frame.setResizable(false);// ������� ���ϰ�
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246,244,254));
		panel.setBounds(19, 49, 363, 209);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uACB0\uC81C\uC218\uB2E8 \uC120\uD0DD");
		lblNewLabel.setFont(new Font("�޸ո���T", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 25, 125, 15);
		panel.add(lblNewLabel);
		
		JRadioButton radioButton_1 = new JRadioButton("\uD604\uAE08");
		radioButton_1.setFont(new Font("�޸ո���T", Font.PLAIN, 12));
		radioButton_1.setBackground(new Color(246,244,254));
		radioButton_1.setBounds(8, 55, 72, 23);
		panel.add(radioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("\uCE74\uB4DC");
		radioButton_2.setFont(new Font("�޸ո���T", Font.PLAIN, 12));
		radioButton_2.setBackground(new Color(246,244,254));
		
		radioButton_2.setBounds(84, 55, 72, 23);
		panel.add(radioButton_2);
		buttonGroup.add(radioButton_2);
		group.add(radioButton_2);
		
		JLabel label = new JLabel("\uCD1D \uAE08\uC561 :");
		label.setFont(new Font("�޸ո���T", Font.PLAIN, 12));
		label.setBounds(12, 167, 76, 15);
		panel.add(label);
		
		
		JLabel label_1 = new JLabel("\uB514\uC790\uC774\uB108\uC5D0 \uB530\uB978 \uCD94\uAC00\uAE08\uC561 :");
		label_1.setFont(new Font("�޸ո���T", Font.PLAIN, 12));
		label_1.setBounds(12, 96, 158, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\uAE30\uBCF8 \uAC00\uACA9 :");
		label_2.setFont(new Font("�޸ո���T", Font.PLAIN, 12));
		label_2.setBounds(12, 130, 66, 15);
		panel.add(label_2);
		
		JLabel lb_Extra_money = new JLabel("");
		lb_Extra_money.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Extra_money.setFont(new Font("�޸ո���T", Font.BOLD, 13));
		lb_Extra_money.setBounds(167, 96, 158, 15);
		panel.add(lb_Extra_money);
		String ExtraPrice = ""+TimeSelect.extraMoney;
		lb_Extra_money.setText(ExtraPrice+"��");
		
		
		JLabel lb_basic_money = new JLabel("");
		lb_basic_money.setHorizontalAlignment(SwingConstants.CENTER);
		lb_basic_money.setFont(new Font("�޸ո���T", Font.BOLD, 13));
		lb_basic_money.setBounds(167, 130, 158, 15);
		panel.add(lb_basic_money);
		String BasicPrice = ""+TimeSelect.basic_price;
		lb_basic_money.setText(BasicPrice+"��");
		
		JLabel total_money = new JLabel("\uC5BC\uB9C8?");
		total_money.setFont(new Font("�޸ո���T", Font.BOLD, 13));
		total_money.setHorizontalAlignment(SwingConstants.CENTER);
		total_money.setBounds(167, 167, 158, 15);
		panel.add(total_money);
		
		int BasicM = Integer.parseInt(BasicPrice);
		int ExtraM = Integer.parseInt(ExtraPrice);
		int totMoney = BasicM+ExtraM;
		tot_money = ""+totMoney;
		total_money.setText(tot_money+"��");
		
		
		
		
		JButton btn_pay = new JButton(new ImageIcon("images/pay.png")); 
		btn_pay.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		btn_pay.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		btn_pay.setBackground(new Color(246,244,254));
		btn_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bills bills = new Bills();
				
				if(radioButton_2.isSelected()) { // ī�� ���� ��
					text_name = radioButton_2.getText();
					//cost = Integer.parseInt(dao.select(vo));
					//cost_str = Integer.toString(cost);
				}
				else if(radioButton_1.isSelected()) { // ���� ���� ��
					text_name = radioButton_1.getText();
					//cost = Integer.parseInt(dao.select(vo));
					//cost *= 0.9; // 10% ���εǾ��� ����
					// ����� ���� �߰��� ��� ���� cost �̸� ���ڿ��� ��ȯ
					//cost_str = Integer.toString(cost);
				}
				bills.main(text_name);
				
				// ���� ������ �ð�, ��¥, �����̳� �ڵ带 �̿��Ͽ� �����̳� ������ ���̺��� ������ �̾ƿ���
				String date = TimeSelect.selectedDate;
				System.out.println(date);
				String time = TimeSelect.selectedHour;
				System.out.println(time);
				String DCode = TimeSelect.selectedDsg;
				System.out.println(DCode);
				
				
				VO_SCHEDULE sch = svdao.selectSchcode(date,time,DCode);
				String deleteschcode = sch.getSch_code();
				String gender = TimeSelect.gender;
				String svname = TimeSelect.sv_name;
				//�̾ƿ� �������� ���� �����ٿ� insert
				svdao.insertrsvsch(sch);
				
				//�����̳� ������ ���̺��� �̾ƿ� ������ delete
				svdao.deletedsgsch(deleteschcode);
				
//				���� ���̺� ���� ���� insert
				int a = daorsv.insert(new VO_RESERVATION(date, gender,totMoney,LoginUser.input_id,svname,deleteschcode));
			
				
								
			}
		});
		
		btn_pay.setBounds(49, 285, 100, 25);
		frame.getContentPane().add(btn_pay);
		JButton btn_cancle = new JButton(new ImageIcon("images/cancel.png"));
		btn_cancle.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		btn_cancle.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		btn_cancle.setBackground(new Color(246,244,254));
		btn_cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btn_cancle.setBounds(236, 285, 100, 25);
		frame.getContentPane().add(btn_cancle);
		
	}
}
	
