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

public class JoinUser {

	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtPw;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinUser window = new JoinUser();
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
	public JoinUser() {
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
		frame.setTitle("SongSongSalon"); // ���� ����
	    frame.setLocationRelativeTo(null);// �� �� �߾ӿ� ��ġ�ϵ���
	    frame.setResizable(false);// ������� ���ϰ�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtId = new JTextField();
		txtId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtId.setFont(new Font("����", Font.PLAIN, 15));
		txtId.setBounds(96, 168, 250, 25);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

		txtPw = new JPasswordField();
		txtPw.setFont(new Font("����", Font.PLAIN, 15));
		txtPw.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPw.setBounds(96, 234, 250, 25);
		frame.getContentPane().add(txtPw);
		txtPw.setColumns(10);

		txtName = new JTextField();
		txtName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtName.setBounds(96, 288, 250, 25);
		txtName.setFont(new Font("����", Font.PLAIN, 15));
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

//		txtGender = new JTextField();
//		txtGender.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
//		txtGender.setBounds(101, 348, 250, 25);
//		txtGender.setFont(new Font("����", Font.PLAIN, 15));
//		frame.getContentPane().add(txtGender);
//		txtGender.setColumns(10);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPhoneNumber.setBounds(96, 352, 250, 25);
		txtPhoneNumber.setFont(new Font("����", Font.PLAIN, 15));
		frame.getContentPane().add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);

//		JButton btnJoin = new JButton(new ImageIcon("img/resister.png"));
//		btnJoin.setBounds(124, 421, 294, 32);
//		btnJoin.setBorderPainted(false);
//		btnJoin.setBackground(Color.WHITE);
//		btnJoin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String id = txtId.getText();
//				txtPw.setEchoChar('*'); // ��й�ȣ ������ ����
//				String password = new String(txtPw.getPassword());
//				// getPassword()�� char[] ���·� ��ȯ�ϹǷ� new String ���� ���ڿ� ��ü������ ��ȯ
//				String name = txtName.getText();
//				String gender = txtGender.getText();
//				String phoneNumber = txtPhoneNumber.getText();
//
//				MemberVO_User vo_user = new MemberVO_User(id, password, name, gender, phoneNumber);
//				DAO_User dao_user = new DAO_User();
//				int result = dao_user.insert(vo_user);
//
//				if (result != 0) {
//					JOptionPane.showMessageDialog(null, "ȸ������ ����", "�˸�", result);
//				} else {
//					JOptionPane.showMessageDialog(null, "ȸ������ ����", "���", JOptionPane.ERROR_MESSAGE);;
//				}
//			}
//		});
//		btnJoin.setFont(new Font("����", Font.BOLD, 17));
//		btnJoin.setBounds(109, 484, 120, 44);
//		frame.getContentPane().add(btnJoin);
		

		
		
		//���� ��ư �߰�
		JButton btnJoin = new JButton(new ImageIcon("images/resister.png"));
		btnJoin.setBorderPainted(false);
		btnJoin.setBackground(Color.WHITE);
		      btnJoin.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            String id = txtId.getText();
		            txtPw.setEchoChar('*'); // ��й�ȣ ������ ����
		            String password = new String(txtPw.getPassword());
		            // getPassword()�� char[] ���·� ��ȯ�ϹǷ� new String ���� ���ڿ� ��ü������ ��ȯ
		            String name = txtName.getText();
		            String phoneNumber = txtPhoneNumber.getText();

		            MemberVO_User vo_user = new MemberVO_User(id, password, name, phoneNumber);
		            CstDAO dao_user = new CstDAO();
		            int result = dao_user.Cstinsert(vo_user);

		            if (result != 0) {
		               JOptionPane.showMessageDialog(null, "ȸ������ ����", "�˸�", result);
		            } else {
		               JOptionPane.showMessageDialog(null, "ȸ������ ����", "���", JOptionPane.ERROR_MESSAGE);;
		            }
		         }
		      });
		      btnJoin.setFont(new Font("����", Font.BOLD, 17));
		      btnJoin.setBounds(59, 404, 294, 32);
		      frame.getContentPane().add(btnJoin);

		    //�ݱ��ư
		JButton btnClose = new JButton(new ImageIcon("images/close.png"));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBorderPainted(false);
		btnClose.addActionListener(new ActionListener() {
		               public void actionPerformed(ActionEvent e) {
		                  frame.dispose();
		               }
		            });
		            btnClose.setFont(new Font("����", Font.BOLD, 17));
		            btnClose.setBounds(59, 456, 294, 32);
		            frame.getContentPane().add(btnClose);
		
		
		

//		JButton btnClose = new JButton(new ImageIcon("img/close.png"));
//		btnClose.setBounds(139, 476, 294, 32);
//		btnClose.setBackground(Color.WHITE);
//		btnClose.setBorderPainted(false);
//		btnClose.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//			}
//		});
//		btnClose.setFont(new Font("����", Font.BOLD, 17));
//		btnClose.setBounds(239, 484, 120, 44);
//		frame.getContentPane().add(btnClose);

		JLabel lblUserJoin = new JLabel("(\uC0AC\uC6A9\uC790\uC6A9)");
		lblUserJoin.setForeground(Color.LIGHT_GRAY);
		lblUserJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserJoin.setFont(new Font("����", Font.PLAIN, 13));
		lblUserJoin.setBounds(0, 10, 73, 23);
		frame.getContentPane().add(lblUserJoin);

		JLabel lblId = new JLabel("");
		Image id = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblId.setIcon(new ImageIcon(id));
		lblId.setBounds(52, 149, 32, 44);
		lblId.setFont(new Font("����", Font.BOLD, 15));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("");
		lblPw.setBounds(52, 209,  32, 44);
		Image pw = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		lblPw.setIcon(new ImageIcon(pw));
		frame.getContentPane().add(lblPw);
		
		JLabel lblNewLabel = new JLabel("Admin ID");
		lblNewLabel.setForeground(new Color(158,139,243));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(96, 154, 250, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAdminPassword = new JLabel("Admin password");
		lblAdminPassword.setForeground(new Color(158,139,243));
		lblAdminPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPassword.setBounds(96, 214, 250, 15);
		frame.getContentPane().add(lblAdminPassword);

		JLabel lblName = new JLabel("");
		lblName.setBounds(52, 269, 32, 44);
		Image business = new ImageIcon(this.getClass().getResource("/name.png")).getImage();
		lblName.setIcon(new ImageIcon(business));
		frame.getContentPane().add(lblName);

//		JLabel lbGender = new JLabel("");
//		lbGender.setBounds(57, 329, 32, 44);
//		Image storeBoard = new ImageIcon(this.getClass().getResource("/gender.png")).getImage();
//		lbGender.setIcon(new ImageIcon(storeBoard));
//		frame.getContentPane().add(lbGender);

		JLabel lblPhoneNumber = new JLabel("");
		lblPhoneNumber.setBounds(52, 333, 32, 44);
		Image boss = new ImageIcon(this.getClass().getResource("/phoneNumber.png")).getImage();
		lblPhoneNumber.setIcon(new ImageIcon(boss));
		frame.getContentPane().add(lblPhoneNumber);

		JLabel label = new JLabel("Sign up");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("���ʷҵ���", Font.BOLD, 20));
		label.setBounds(59, 56, 90, 44);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image idCard = new ImageIcon(this.getClass().getResource("/idCard.png")).getImage();
		label_1.setIcon(new ImageIcon(idCard));
		label_1.setBounds(23, 56, 39, 44);
		frame.getContentPane().add(label_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setForeground(new Color(158, 139, 243));
		lblName_1.setBounds(96, 274, 250, 15);
		frame.getContentPane().add(lblName_1);
		
//		JLabel lblGender = new JLabel("Gender");
//		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
//		lblGender.setForeground(new Color(158, 139, 243));
//		lblGender.setBounds(101, 334, 250, 15);
//		frame.getContentPane().add(lblGender);
		
		JLabel lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber_1.setForeground(new Color(158, 139, 243));
		lblPhoneNumber_1.setBounds(96, 334, 250, 15);
		frame.getContentPane().add(lblPhoneNumber_1);
	}

}
