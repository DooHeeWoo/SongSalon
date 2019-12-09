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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class LoginUser {
	public static String input_id;
	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser window = new LoginUser();
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
	public LoginUser() {
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 400, 630);
		frame.setTitle("SongSongSalon"); // 제목 설정
	    frame.setLocationRelativeTo(null);// 켤 때 중앙에 위치하도록
	    frame.setResizable(false);// 사이즈변경 못하게
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtId.setFont(new Font("굴림", Font.PLAIN, 15));
		txtId.setToolTipText("Password\uB97C \uC785\uB825\uD558\uC138\uC694");
		txtId.setBounds(94, 260, 250, 44);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btn_Login = new JButton(new ImageIcon("images/signIn2.png"));
		btn_Login.setForeground(Color.LIGHT_GRAY);
		btn_Login.setBackground(Color.WHITE);
		btn_Login.setBorderPainted(false);
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_id = txtId.getText();
				txtPw.setEchoChar('*'); // 비밀번호 가리기 위해
				String input_password = new String(txtPw.getPassword());
				
				// getPassword()는 char[] 형태로 반환하므로 new String 으로 문자열 객체형으로 변환
				CstDAO dao_user = new CstDAO();
				String name = dao_user.CstIdPwselect(input_id, input_password);
				System.out.println(name);
				if(name != null) {
					JOptionPane.showMessageDialog(null, name+"님 환영합니다.");
					mainGUI cstmain= new mainGUI();
					cstmain.main(null);
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패", "경고", JOptionPane.ERROR_MESSAGE);
					txtPw.setText("");
				}
				
			}
		});
		
		txtPw = new JPasswordField();
		txtPw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtPw.setBounds(94, 314, 250, 44);
		frame.getContentPane().add(txtPw);
		btn_Login.setFont(new Font("굴림", Font.BOLD, 17));
		btn_Login.setBounds(50, 377, 294, 32);
		frame.getContentPane().add(btn_Login);
		
		JButton btn_Join = new JButton(new ImageIcon("images/creatAccount.png"));
		btn_Join.setBackground(Color.WHITE);
		btn_Join.setBorderPainted(false);
		btn_Join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JoinUser ju = new JoinUser();
				ju.main(null);
			}
		});
		btn_Join.setFont(new Font("굴림", Font.BOLD, 17));
		btn_Join.setBounds(50, 431, 294, 32);
		frame.getContentPane().add(btn_Join);
		
		JLabel lblUser = new JLabel("(\uC0AC\uC6A9\uC790\uC6A9)");
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("굴림", Font.PLAIN, 13));
		lblUser.setBounds(12, 10, 79, 23);
		frame.getContentPane().add(lblUser);
		
		JLabel lblId = new JLabel("");
		Image id = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblId.setIcon(new ImageIcon(id));
		lblId.setBounds(51, 260, 32, 44);
		frame.getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("");
		Image pw = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		lblPw.setIcon(new ImageIcon(pw));
		lblPw.setBounds(51, 314, 32, 44);
		frame.getContentPane().add(lblPw);
		
		JLabel lb_logo = new JLabel("");
		Image signIn = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lb_logo.setIcon(new ImageIcon(signIn));
		lb_logo.setBounds(140, 67, 136, 144);
		frame.getContentPane().add(lb_logo);
		
		JLabel lb_title = new JLabel("");
		Image songSalon = new ImageIcon(this.getClass().getResource("/songSalon2.png")).getImage();
		lb_title.setIcon(new ImageIcon(songSalon));
		lb_title.setBounds(114, 206, 180, 44);
		frame.getContentPane().add(lb_title);
		
		
	}
}
