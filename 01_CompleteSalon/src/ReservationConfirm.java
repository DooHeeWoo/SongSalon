import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ReservationConfirm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationConfirm frame = new ReservationConfirm();
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
	public ReservationConfirm() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(246,244,254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lb_rsvDate0 = new JLabel("���೯¥:");
		lb_rsvDate0.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_rsvDate0.setBounds(34, 80, 76, 21);
		contentPane.add(lb_rsvDate0);

		JLabel lb_cstName0 = new JLabel("���̸�:");
		lb_cstName0.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_cstName0.setBounds(34, 160, 76, 21);
		contentPane.add(lb_cstName0);

		JLabel lb_rsvTime0 = new JLabel("����ð�:");
		lb_rsvTime0.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_rsvTime0.setBounds(34, 120, 76, 21);
		contentPane.add(lb_rsvTime0);

		JLabel lb_svName0 = new JLabel("�ü��̸�:");
		lb_svName0.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_svName0.setBounds(34, 200, 76, 21);
		contentPane.add(lb_svName0);

		JLabel lb_dsgName0 = new JLabel("�����̳� �̸�:");
		lb_dsgName0.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_dsgName0.setBounds(34, 240, 90, 21);
		contentPane.add(lb_dsgName0);

		JLabel lb_totalPrice0 = new JLabel("�� �����ݾ�:");
		lb_totalPrice0.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_totalPrice0.setBounds(34, 280, 76, 21);
		contentPane.add(lb_totalPrice0);

		//String input_id = "idTest";
		//��� �������̺� ���ļ� �����Ͱ� select�ǰԲ� �ϱ�
		// 1. ���೯¥ �󺧿� �ֱ�(���� ���̺�)
		JLabel lb_rsvDate = new JLabel("");
		lb_rsvDate.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_rsvDate.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rsvDate.setBounds(122, 80, 166, 21);

		RsvDAO rsvdao = new RsvDAO();
		String lbRsvDate = rsvdao.RsvDateselect(LoginUser.input_id);
		lb_rsvDate.setText(lbRsvDate);
		contentPane.add(lb_rsvDate);

		// 2. ����ð� �󺧿� �ֱ�(���� ���̺� -> ���� ������ ���̺�)
		JLabel lb_rsvTime = new JLabel("");
		lb_rsvTime.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_rsvTime.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rsvTime.setBounds(122, 120, 166, 21);

		RsvSchDAO rsvschdao = new RsvSchDAO();
		String lbRsvtime = rsvschdao.RsvTimeSelect(LoginUser.input_id);
		lb_rsvTime.setText(lbRsvtime);
		contentPane.add(lb_rsvTime);

		// 3. �� �̸� �󺧿� �ֱ�(�������̺� -> �����̺�)
		JLabel lb_cstName = new JLabel("");
		lb_cstName.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_cstName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cstName.setBounds(122, 160, 166, 21);
		CstDAO cstdao = new CstDAO();
		String lbcstname = cstdao.RsvCstNameSelect(LoginUser.input_id);
		lb_cstName.setText(lbcstname);

		contentPane.add(lb_cstName);

		//4. �ü� �̸� �󺧿� �ֱ�(���� ���̺�)
		JLabel lb_svName = new JLabel("");
		lb_svName.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_svName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_svName.setBounds(122, 200, 166, 21);
		String lbRsvSvName = rsvdao.RsvSvselect(LoginUser.input_id);
		lb_svName.setText(lbRsvSvName);
		contentPane.add(lb_svName);

		//5. �����̳� �̸� �󺧿� �ֱ�(�������̺�->���ེ���� ���̺�->�����̳� ���̺�)
		JLabel lb_dsgName = new JLabel("");
		lb_dsgName.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_dsgName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_dsgName.setBounds(122, 240, 166, 21);
		DsgDAO dsgdao = new DsgDAO();
		String lbRsvDsgName = dsgdao.dsgNameselect(LoginUser.input_id);
		lb_dsgName.setText(lbRsvDsgName);
		
		contentPane.add(lb_dsgName);

		//6. �Ѱ����ݾ�(�������̺�)
		JLabel lb_totalPrice = new JLabel("");
		lb_totalPrice.setFont(new Font("�޸ո���T", Font.PLAIN, 13));
		lb_totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_totalPrice.setBounds(122, 280, 166, 21);
		int lbrsvPrice = rsvdao.rsvPriceSelect(LoginUser.input_id);
		String a = ""+lbrsvPrice;
		lb_totalPrice.setText(a);
		contentPane.add(lb_totalPrice);

		//Ȯ�� ��ư ������ â �ݾ�����
		JButton btnNewButton = new JButton(new ImageIcon("images/OK.png"));
		btnNewButton.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		btnNewButton.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		btnNewButton.setBackground(new Color(246,244,254));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(122, 350, 97, 25);
		contentPane.add(btnNewButton);
	}
}
