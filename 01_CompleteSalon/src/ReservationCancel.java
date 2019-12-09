import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class ReservationCancel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationCancel frame = new ReservationCancel();
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
	public ReservationCancel() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame = new JFrame();
		setBounds(100, 100, 344, 435);
		contentPane = new JPanel();
		
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//	      Image img = toolkit.getImage("images/hair_salon.png");
//	      frame.setIconImage(img);
		contentPane.setBackground(new Color(246,244,254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(246,244,254));
		panel.setBounds(12, 42, 311, 291);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_cancelTime0 = new JLabel("\uC608\uC57D\uC2DC\uAC04:");
		lb_cancelTime0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_cancelTime0.setBounds(26, 80, 73, 20);
		panel.add(lb_cancelTime0);
		
		JLabel lb_cancelCstName0 = new JLabel("\uACE0\uAC1D\uC774\uB984:");
		lb_cancelCstName0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_cancelCstName0.setBounds(26, 120, 57, 20);
		panel.add(lb_cancelCstName0);
		
		JLabel lb_CancelSvName0 = new JLabel("\uC2DC\uC220\uC774\uB984:");
		lb_CancelSvName0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelSvName0.setBounds(26, 160, 57, 20);
		panel.add(lb_CancelSvName0);
		
		JLabel lb_CancelDsgName0 = new JLabel("\uB514\uC790\uC774\uB108 \uC774\uB984:");
		lb_CancelDsgName0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelDsgName0.setBounds(26, 200, 93, 20);
		panel.add(lb_CancelDsgName0);
		
		JLabel lb_cancelDate0 = new JLabel("\uC608\uC57D \uB0A0\uC9DC:");
		lb_cancelDate0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_cancelDate0.setBounds(26, 40, 73, 20);
		panel.add(lb_cancelDate0);
		
		JLabel lb_CancelPrice0 = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561:");
		lb_CancelPrice0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelPrice0.setBounds(26, 240, 79, 20);
		panel.add(lb_CancelPrice0);
		
		//String input_id = "idTest";
		//1. 예약 날짜 라벨
		JLabel lb_CancelDate = new JLabel("");
		lb_CancelDate.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelDate.setHorizontalAlignment(SwingConstants.CENTER);
		lb_CancelDate.setBounds(136, 40, 120, 20);
		RsvDAO rsvdao = new RsvDAO();
		String lbCancelDate = rsvdao.RsvDateselect(LoginUser.input_id);
		//String lbCancelDate = rsvdao.RsvDateselect(input_id);
		lb_CancelDate.setText(lbCancelDate);
		panel.add(lb_CancelDate);
		
		//2. 예약시간 라벨
		JLabel lb_CancelTime = new JLabel("");
		lb_CancelTime.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelTime.setHorizontalAlignment(SwingConstants.CENTER);
		lb_CancelTime.setBounds(136, 80, 120, 20);
		
		RsvSchDAO rsvschdao = new RsvSchDAO();
		String lbCanceltime = rsvschdao.RsvTimeSelect(LoginUser.input_id);
		//String lbCanceltime = rsvschdao.RsvTimeSelect(input_id);
		lb_CancelTime.setText(lbCanceltime);
		panel.add(lb_CancelTime);
		
		//3. 고객이름
		JLabel lb_CancelCstName = new JLabel("");
		lb_CancelCstName.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelCstName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_CancelCstName.setBounds(136, 120, 120, 20);
		CstDAO cstdao = new CstDAO();
		String lbCancelcstname = cstdao.RsvCstNameSelect(LoginUser.input_id);
		//String lbCancelcstname = cstdao.RsvCstNameSelect(input_id);
		lb_CancelCstName.setText(lbCancelcstname);
		panel.add(lb_CancelCstName);
		
		//4. 시술 이름
		JLabel lb_CancelSvName = new JLabel("");
		lb_CancelSvName.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelSvName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_CancelSvName.setBounds(136, 160, 120, 20);
		String lbCancelSvName = rsvdao.RsvSvselect(LoginUser.input_id);
		//String lbCancelSvName = rsvdao.RsvSvselect(input_id);
		lb_CancelSvName.setText(lbCancelSvName);
		
		panel.add(lb_CancelSvName);
		
		//5. 디자이너 이름
		JLabel lb_CancelDsgName = new JLabel("");
		lb_CancelDsgName.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelDsgName.setHorizontalAlignment(SwingConstants.CENTER);
		lb_CancelDsgName.setBounds(136, 200, 120, 20);
		DsgDAO dsgdao = new DsgDAO();
		String lbCancelDsgName = dsgdao.dsgNameselect(LoginUser.input_id);
		//String lbCancelDsgName = dsgdao.dsgNameselect(input_id);
		lb_CancelDsgName.setText(lbCancelDsgName);
		panel.add(lb_CancelDsgName);
		
		//6. 총결제금액
		JLabel lb_CancelPrice = new JLabel("");
		lb_CancelPrice.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_CancelPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_CancelPrice.setBounds(136, 240, 120, 20);
		int lbCancelPrice = rsvdao.rsvPriceSelect(LoginUser.input_id);
		//int lbCancelPrice = rsvdao.rsvPriceSelect(input_id);
		String a = ""+lbCancelPrice;
		lb_CancelPrice.setText(a);
		panel.add(lb_CancelPrice);
		
		//취소 버튼 누르면 창 닫아지게
		JButton btnNewButton = new JButton(new ImageIcon("images/Cancel2.png"));
		btnNewButton.setBorderPainted(false);// 버튼 외곽선 없애기
		btnNewButton.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함
		btnNewButton.setBackground(new Color(246,244,254));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//예약스케줄에서 select
				RsvSchDAO rsvschdao = new RsvSchDAO();
				
				//최종 DB 연결할 때는 input_id -> LoginUser.input_id로 변경할것
				DsgSchVO inputCancelList= rsvschdao.CancelListSelect(LoginUser.input_id);
				System.out.println(inputCancelList.getDsrsch_code()+inputCancelList.getDsrsch_date()+inputCancelList.getDsrsch_dcode()+inputCancelList.getDsrsch_time());
				
				String deleteSchCode = inputCancelList.getDsrsch_code(); //예약 테이블에서 delete할 때 필요한 스케줄 코드
				System.out.println(deleteSchCode);
				
				//디자이너 스케줄에 insert
				DsgSchDAO dsgschdao = new DsgSchDAO();
				dsgschdao.CancelListInsert(inputCancelList);
							
				//예약 테이블에서 먼저 delete시키기
				RsvDAO rsvdao = new RsvDAO();
				rsvdao.rsvDelete(deleteSchCode);
				
				//예약 스케줄에서 최종 delete 시키기
				rsvschdao.CancelListDelete(deleteSchCode);
				
				dispose();
			}
		});
		btnNewButton.setBounds(122, 350, 97, 25);
		contentPane.add(btnNewButton);
	}
}
