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

		JLabel lb_rsvDate0 = new JLabel("예약날짜:");
		lb_rsvDate0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_rsvDate0.setBounds(34, 80, 76, 21);
		contentPane.add(lb_rsvDate0);

		JLabel lb_cstName0 = new JLabel("고객이름:");
		lb_cstName0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_cstName0.setBounds(34, 160, 76, 21);
		contentPane.add(lb_cstName0);

		JLabel lb_rsvTime0 = new JLabel("예약시간:");
		lb_rsvTime0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_rsvTime0.setBounds(34, 120, 76, 21);
		contentPane.add(lb_rsvTime0);

		JLabel lb_svName0 = new JLabel("시술이름:");
		lb_svName0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_svName0.setBounds(34, 200, 76, 21);
		contentPane.add(lb_svName0);

		JLabel lb_dsgName0 = new JLabel("디자이너 이름:");
		lb_dsgName0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_dsgName0.setBounds(34, 240, 90, 21);
		contentPane.add(lb_dsgName0);

		JLabel lb_totalPrice0 = new JLabel("총 결제금액:");
		lb_totalPrice0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_totalPrice0.setBounds(34, 280, 76, 21);
		contentPane.add(lb_totalPrice0);

		//String input_id = "idTest";
		//모두 예약테이블 거쳐서 데이터가 select되게끔 하기
		// 1. 예약날짜 라벨에 넣기(예약 테이블)
		JLabel lb_rsvDate = new JLabel("");
		lb_rsvDate.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_rsvDate.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rsvDate.setBounds(122, 80, 166, 21);

		RsvDAO rsvdao = new RsvDAO();
		String lbRsvDate = rsvdao.RsvDateselect(LoginUser.input_id);
		lb_rsvDate.setText(lbRsvDate);
		contentPane.add(lb_rsvDate);

		// 2. 예약시간 라벨에 넣기(예약 테이블 -> 예약 스케줄 테이블)
		JLabel lb_rsvTime = new JLabel("");
		lb_rsvTime.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_rsvTime.setHorizontalAlignment(SwingConstants.CENTER);
		lb_rsvTime.setBounds(122, 120, 166, 21);

		RsvSchDAO rsvschdao = new RsvSchDAO();
		String lbRsvtime = rsvschdao.RsvTimeSelect(LoginUser.input_id);
		lb_rsvTime.setText(lbRsvtime);
		contentPane.add(lb_rsvTime);

		// 3. 고객 이름 라벨에 넣기(예약테이블 -> 고객테이블)
		JLabel lb_cstName = new JLabel("");
		lb_cstName.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_cstName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_cstName.setBounds(122, 160, 166, 21);
		CstDAO cstdao = new CstDAO();
		String lbcstname = cstdao.RsvCstNameSelect(LoginUser.input_id);
		lb_cstName.setText(lbcstname);

		contentPane.add(lb_cstName);

		//4. 시술 이름 라벨에 넣기(예약 테이블)
		JLabel lb_svName = new JLabel("");
		lb_svName.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_svName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_svName.setBounds(122, 200, 166, 21);
		String lbRsvSvName = rsvdao.RsvSvselect(LoginUser.input_id);
		lb_svName.setText(lbRsvSvName);
		contentPane.add(lb_svName);

		//5. 디자이너 이름 라벨에 넣기(예약테이블->예약스케줄 테이블->디자이너 테이블)
		JLabel lb_dsgName = new JLabel("");
		lb_dsgName.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_dsgName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_dsgName.setBounds(122, 240, 166, 21);
		DsgDAO dsgdao = new DsgDAO();
		String lbRsvDsgName = dsgdao.dsgNameselect(LoginUser.input_id);
		lb_dsgName.setText(lbRsvDsgName);
		
		contentPane.add(lb_dsgName);

		//6. 총결제금액(예약테이블)
		JLabel lb_totalPrice = new JLabel("");
		lb_totalPrice.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_totalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_totalPrice.setBounds(122, 280, 166, 21);
		int lbrsvPrice = rsvdao.rsvPriceSelect(LoginUser.input_id);
		String a = ""+lbrsvPrice;
		lb_totalPrice.setText(a);
		contentPane.add(lb_totalPrice);

		//확인 버튼 누르면 창 닫아지게
		JButton btnNewButton = new JButton(new ImageIcon("images/OK.png"));
		btnNewButton.setBorderPainted(false);// 버튼 외곽선 없애기
		btnNewButton.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함
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
