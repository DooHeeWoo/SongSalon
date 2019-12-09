import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingConstants;
import java.awt.Color;

public class Bills {
	
	private JFrame frame;


	

	/**
	 * Launch the application.
	 */
	public void main(String text_name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bills window = new Bills();
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
	public Bills() {
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
		frame.setBounds(100, 100, 297, 369);
		frame.setTitle("영수증"); 
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("\uC601\uC218\uC99D");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("굴림", Font.BOLD, 15));
		Title.setBounds(82, 21, 104, 39);
		frame.getContentPane().add(Title);
		
		JLabel Today__ = new JLabel("\uACB0\uC81C\uB0A0\uC9DC");
		Today__.setBounds(23, 93, 57, 15);
		frame.getContentPane().add(Today__);
		
		JLabel Pay__Means = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		Pay__Means.setBounds(23, 147, 57, 15);
		frame.getContentPane().add(Pay__Means);
		
		JLabel Total__Cost = new JLabel();
		Total__Cost.setText("\uCD1D\uAE08\uC561");
		Total__Cost.setBounds(23, 215, 57, 15);
		frame.getContentPane().add(Total__Cost);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy년 MM월 dd일");
		String days = d_format.format(cal.getTime());
		
		JLabel Today = new JLabel(days);
		Today.setBounds(110, 93, 159, 15);
		frame.getContentPane().add(Today);
		
		JLabel Pay_means = new JLabel(paymentMethod.text_name);
		Pay_means.setBounds(110, 147, 159, 15);
		frame.getContentPane().add(Pay_means);
		
		JLabel Total_Cost = new JLabel(paymentMethod.cost_str);
		Total_Cost.setBounds(110, 215, 100, 15);
		frame.getContentPane().add(Total_Cost);
		
		Total_Cost.setText(paymentMethod.tot_money+"원");
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
