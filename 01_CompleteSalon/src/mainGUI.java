import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class mainGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI window = new mainGUI();
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
	public mainGUI() {
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
		frame.setBounds(100, 100, 400, 630);
		frame.setTitle("SongSongSalon");// 위에 타이틀 선정
		frame.setLocationRelativeTo(null);// 킬떄 중앙에 위치하게
		frame.setResizable(true);// 창 사이즈변경 못하게
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn_Rsv = new JButton(new ImageIcon("images/rsvbtn.png"));
		btn_Rsv.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Rsv.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함
		btn_Rsv.setBackground(new Color(246,244,254));
		btn_Rsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer cst= new customer();
				cst.main(null);
				
			}
		});
		btn_Rsv.setBounds(81, 189, 243, 38);
		frame.getContentPane().add(btn_Rsv);
		
		JButton btn_RsvConfirm = new JButton(new ImageIcon("images/rsvconfirm.png"));
		btn_RsvConfirm.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_RsvConfirm.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함
		btn_RsvConfirm.setBackground(new Color(246,244,254));
		btn_RsvConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationConfirm rsvconfirm = new ReservationConfirm();
				rsvconfirm.main(null);
			}
		});
		btn_RsvConfirm.setBounds(81, 298, 243, 38);
		frame.getContentPane().add(btn_RsvConfirm);
		
		JButton btn_RsvCancel = new JButton(new ImageIcon("images/rsvCancel.png"));
		btn_RsvCancel.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_RsvCancel.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함
		btn_RsvCancel.setBackground(new Color(246,244,254));
		btn_RsvCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationCancel rsvCancel = new ReservationCancel();
				rsvCancel.main(null);
			}
		});
		btn_RsvCancel.setBounds(81, 410, 243, 38);
		frame.getContentPane().add(btn_RsvCancel);
		
		JLabel lblNewLabel = new JLabel("M E N U");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 84, 243, 46);
		frame.getContentPane().add(lblNewLabel);
		Image id = new ImageIcon(this.getClass().getResource("/songLogo.png")).getImage();
	}
}
