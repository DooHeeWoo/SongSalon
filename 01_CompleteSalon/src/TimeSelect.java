
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class TimeSelect {

	public static String gender;
	public static String selectedDate = customer.calDate; // customer클래스의 날짜 데이터를 가져온것
	public static String selectedDsg;
	public static String selectedHour;
	public static String selectedDsgName;
	public static String sv_name;
	public static int basic_price; // payment 페이지 기본가격 변수
	private JLabel label_Info;
	public static int extraMoney;
	ArrayList<Sv_VO> styleList = new ArrayList<>();
	// 시간 버튼 + HashMap
	HashMap<String, JButton> map = new HashMap<String, JButton>();
	ArrayList<String> IntimeList = new ArrayList<String>();
	ArrayList<String> selectMList = new ArrayList<String>();
	ArrayList<String> selectWList = new ArrayList<String>();
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeSelect window = new TimeSelect();
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
	public TimeSelect() {
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
		frame.getContentPane().setFont(new Font("굴림", Font.PLAIN, 9));
		final Color BACKGROUND = new Color(246, 244, 254);
		frame.getContentPane().setBackground(BACKGROUND);
		frame.setBounds(100, 100, 400, 630);// 띄는 위치, 가로, 세로
		frame.setTitle("SongSongSalon");// 위에 타이틀 선정
		frame.setLocationRelativeTo(null);// 킬떄 중앙에 위치하게
		frame.setResizable(true);// 창 사이즈변경 못하게
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel time_page = new JPanel();
		time_page.setBackground(BACKGROUND);
		time_page.setBounds(12, 285, 360, 92);
		frame.getContentPane().add(time_page);
		time_page.setLayout(null);

		// 10시 버튼
		JButton btn_10time = new JButton(new ImageIcon("images/timebtn_10.png"));
		btn_10time.setBackground(BACKGROUND);

		btn_10time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "10:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);
			}
		});

		btn_10time.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_10time.setFocusPainted(false); // 버튼이 선택되었을 때 생기는 테두리 사용안함

		btn_10time.setBounds(31, 13, 50, 27);
		time_page.add(btn_10time);
		map.put("10:00", btn_10time);

		// 11시 버튼
		JButton btn_11time = new JButton(new ImageIcon("images/timebtn_11.png"));
		btn_11time.setBackground(BACKGROUND);

		btn_11time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "11:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_11time.setBorderPainted(false);
		btn_11time.setBounds(93, 13, 50, 27);
		time_page.add(btn_11time);
		map.put("11:00", btn_11time);

		// 12시 버튼
		JButton btn_12time = new JButton(new ImageIcon("images/timebtn_12.png"));

		btn_12time.setBorderPainted(false);
		btn_12time.setBackground(BACKGROUND);
		btn_12time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHour = "12:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_12time.setBounds(155, 13, 50, 27);
		time_page.add(btn_12time);
		map.put("12:00", btn_12time);

		// 13시 버튼
		JButton btn_13time = new JButton(new ImageIcon("images/timebtn_13.png"));

		btn_13time.setBorderPainted(false);
		btn_13time.setBackground(BACKGROUND);
		btn_13time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "13:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);
			}
		});
		btn_13time.setBounds(217, 13, 50, 27);
		time_page.add(btn_13time);
		map.put("13:00", btn_13time);

		// 14시 버튼
		JButton btn_14time = new JButton(new ImageIcon("images/timebtn_14.png"));
		btn_14time.setFont(new Font("굴림", Font.PLAIN, 7));
		btn_14time.setBorderPainted(false);
		btn_14time.setBackground(BACKGROUND);
		btn_14time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHour = "14:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_14time.setBounds(279, 13, 50, 27);
		time_page.add(btn_14time);
		map.put("14:00", btn_14time);

		// 15시 버튼
		JButton btn_15time = new JButton(new ImageIcon("images/timebtn_15.png"));
		btn_15time.setBorderPainted(false);
		btn_15time.setBackground(BACKGROUND);
		btn_15time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "15:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_15time.setBounds(31, 48, 50, 27);
		time_page.add(btn_15time);
		map.put("15:00", btn_15time);

		// 16시 버튼
		JButton btn_16time = new JButton(new ImageIcon("images/timebtn_16.png"));
		btn_16time.setBorderPainted(false);
		btn_16time.setBackground(BACKGROUND);
		btn_16time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "16:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_16time.setBounds(93, 48, 50, 27);
		time_page.add(btn_16time);
		map.put("16:00", btn_16time);

		// 17시버튼
		JButton btn_17time = new JButton(new ImageIcon("images/timebtn_17.png"));

		btn_17time.setBorderPainted(false);
		btn_17time.setBackground(BACKGROUND);
		btn_17time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "17:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_17time.setBounds(155, 48, 50, 27);
		time_page.add(btn_17time);
		map.put("17:00", btn_17time);

		// 18시 버튼
		JButton btn_18time = new JButton(new ImageIcon("images/timebtn_18.png"));
		btn_18time.setBorderPainted(false);
		btn_18time.setBackground(BACKGROUND);
		btn_18time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				selectedHour = "18:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName + "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_18time.setBounds(217, 48, 50, 27);
		time_page.add(btn_18time);
		map.put("18:00", btn_18time);

		// 19시 버튼
		JButton btn_19time = new JButton(new ImageIcon("images/timebtn_19.png"));

		btn_19time.setBorderPainted(false);
		btn_19time.setBackground(BACKGROUND);
		btn_19time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedHour = "19:00";
				System.out.println(selectedHour);

				label_Info.setText("예약날짜 : " + selectedDate + "    디자이너 : " + selectedDsgName+ "   시간 : " + selectedHour);
				System.out.println(label_Info.getText());
				label_Info.setVisible(true);

			}
		});
		btn_19time.setBounds(279, 48, 50, 27);
		time_page.add(btn_19time);
		map.put("19:00", btn_19time);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(279, 10, 50, 27);
		time_page.add(lblNewLabel);

		// 버튼 setEnabled false로 초기화
		btn_10time.setEnabled(false);
		btn_11time.setEnabled(false);
		btn_12time.setEnabled(false);
		btn_13time.setEnabled(false);
		btn_14time.setEnabled(false);
		btn_15time.setEnabled(false);
		btn_16time.setEnabled(false);
		btn_17time.setEnabled(false);
		btn_18time.setEnabled(false);
		btn_19time.setEnabled(false);

		JPanel Select_page = new JPanel();
		Select_page.setBackground(BACKGROUND);
		Select_page.setBounds(12, 383, 360, 65);
		frame.getContentPane().add(Select_page);
		Select_page.setLayout(null);
		Image img0 = new ImageIcon(this.getClass().getResource("/re_director.png")).getImage();
		Image img1 = new ImageIcon(this.getClass().getResource("/re_designer1.png")).getImage();
		Image img2 = new ImageIcon(this.getClass().getResource("/re_designer2.png")).getImage();
		Image img3 = new ImageIcon(this.getClass().getResource("/re_designer3.png")).getImage();
		Image img4 = new ImageIcon(this.getClass().getResource("/re_designer4.png")).getImage();

		JComboBox combo_style = new JComboBox();
		combo_style.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		combo_style.setBackground(BACKGROUND);
		combo_style.setBounds(0, 35, 360, 21);
		Select_page.add(combo_style);
		combo_style.setToolTipText("");

		SvDAO svdao = new SvDAO();
//		// 남성 라디오 버튼
		selectMList = svdao.select_male2();
		JRadioButton radiobtn_male = new JRadioButton("남성");
		radiobtn_male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				combo_style.removeAllItems();
//				for (int i = 0; i < selectMList.size(); i++) {
//					combo_style.addItem(selectMList.get(i));
//				}
				styleList.clear();
				System.out.println(styleList.size());
				combo_style.removeAllItems();
				styleList = svdao.select_male2();
				for (int i = 0; i < styleList.size(); i++) {
					String a ="시술 이름: "+ styleList.get(i).getSv_name() +"    시술가격: "+ styleList.get(i).getSv_price() +"    소요시간: "+styleList.get(i).getSv_time();
					combo_style.addItem(a);
					//combo_style.addItem(selectMList.get(i));
			}
		}});
		
		radiobtn_male.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		radiobtn_male.setBounds(204, 1, 65, 23);
		radiobtn_male.setBackground(BACKGROUND);
		Select_page.add(radiobtn_male);
		buttonGroup.add(radiobtn_male);

		// 여성 라디오 버튼
		selectWList = svdao.select_female2();
		JRadioButton radiobtn_female = new JRadioButton("여성");
		radiobtn_female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				combo_style.removeAllItems();
//				for (int i = 0; i < selectWList.size(); i++) {
//					combo_style.addItem(selectWList.get(i));
//				}
				styleList.clear();
				combo_style.removeAllItems();
				styleList = svdao.select_female2();
				for (int i = 0; i < styleList.size(); i++) {
					String a ="시술 이름: "+ styleList.get(i).getSv_name() +"    시술가격: "+ styleList.get(i).getSv_price() +"    소요시간: "+styleList.get(i).getSv_time();
					combo_style.addItem(a);
					
					
					//combo_style.addItem(selectWList.get(i));
				}
				
			}
		});

		radiobtn_female.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		radiobtn_female.setBounds(87, 1, 65, 23);
		radiobtn_female.setBackground(BACKGROUND);
		Select_page.add(radiobtn_female);
		buttonGroup.add(radiobtn_female);
		
		

		// 디자이너 페이지2
		JPanel designer_page2 = new JPanel();
		designer_page2.setBackground(BACKGROUND);
		designer_page2.setBounds(12, 74, 360, 189);
		frame.getContentPane().add(designer_page2);
		designer_page2.setLayout(null);

		JLabel imgLabel2 = new JLabel("");
		imgLabel2.setBounds(31, 18, 298, 138);
		designer_page2.add(imgLabel2);
		imgLabel2.setIcon(new ImageIcon(img2));
		imgLabel2.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btn_Pre2 = new JButton(new ImageIcon("images/prebtn.png"));
		btn_Pre2.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Pre2.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Pre2.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		btn_Pre2.setBounds(118, 171, 20, 16);
		designer_page2.add(btn_Pre2);

		JButton btn_Next2 = new JButton(new ImageIcon("images/nextbtn.png"));
		btn_Next2.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Next2.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Next2.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Next2.setBounds(220, 171, 20, 16);
		designer_page2.add(btn_Next2);

		JLabel lb_desinername2 = new JLabel("이시면");
		lb_desinername2.setFont(new Font("휴먼모음T", Font.PLAIN, 13));

		lb_desinername2.setHorizontalAlignment(SwingConstants.CENTER);
		lb_desinername2.setBounds(145, 171, 66, 15);
		designer_page2.add(lb_desinername2);

		JButton btn_designerSelect2 = new JButton(new ImageIcon("images/re_select.png"));
		btn_designerSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(selectedDate);
				// initializationBtn();
				btn_10time.setEnabled(false);
				btn_11time.setEnabled(false);
				btn_12time.setEnabled(false);
				btn_13time.setEnabled(false);
				btn_14time.setEnabled(false);
				btn_15time.setEnabled(false);
				btn_16time.setEnabled(false);
				btn_17time.setEnabled(false);
				btn_18time.setEnabled(false);
				btn_19time.setEnabled(false);
				selectedDsgName = "이시면";
				selectedDsg = "DSR2";
				DsgSchDAO testdao = new DsgSchDAO();
				IntimeList = testdao.timeselect(selectedDsg);//IntimeList에 시술 가능한 시간대를 담고

				btnActive(IntimeList);//이에 해당하는 버튼만 map을 이용해 활성화 시키기
			}

		});

		btn_designerSelect2.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_designerSelect2.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_designerSelect2.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		btn_designerSelect2.setFont(new Font("굴림", Font.PLAIN, 9));
		btn_designerSelect2.setHorizontalAlignment(SwingConstants.LEFT);
		btn_designerSelect2.setVerticalAlignment(SwingConstants.TOP);
		btn_designerSelect2.setBounds(252, 166, 78, 23);
		designer_page2.add(btn_designerSelect2);

		designer_page2.setVisible(false);

		JButton btn_Pay = new JButton(new ImageIcon("images/re_payment.png"));
		btn_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				basic_price = styleList.get(combo_style.getSelectedIndex()).getSv_price();
				extraMoney = svdao.selectextraprice(selectedDsg);
				sv_name = styleList.get(combo_style.getSelectedIndex()).getSv_name();
				
				if(radiobtn_female.isSelected()) {
					gender = "여성";
				}
				if (radiobtn_male.isSelected()) gender = "남성";
				
				
				paymentMethod pM = new paymentMethod();
				pM.main(null);
			}
		});
		btn_Pay.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Pay.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Pay.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Pay.setBounds(255, 550, 89, 23);
		frame.getContentPane().add(btn_Pay);

		// 디자이너 페이지1
		JPanel designer_page1 = new JPanel();
		designer_page1.setBackground(BACKGROUND);
		designer_page1.setBounds(12, 74, 360, 189);
		frame.getContentPane().add(designer_page1);
		designer_page1.setLayout(null);

		JLabel imgLabel = new JLabel("");

		imgLabel.setBounds(31, 18, 298, 138);
		designer_page1.add(imgLabel);
		imgLabel.setIcon(new ImageIcon(img1));
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btn_Next1 = new JButton(new ImageIcon("images/nextbtn.png"));
		btn_Next1.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Next1.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Next1.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Next1.setBounds(220, 171, 20, 16);
		designer_page1.add(btn_Next1);

		JButton btn_Pre1 = new JButton(new ImageIcon("images/prebtn.png"));
		btn_Pre1.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Pre1.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Pre1.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Pre1.setBounds(118, 171, 20, 16);
		designer_page1.add(btn_Pre1);

		JLabel lb_designername1 = new JLabel("김승현");
		lb_designername1.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_designername1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_designername1.setBounds(145, 171, 66, 15);
		designer_page1.add(lb_designername1);

		JButton btn_designerSelect1 = new JButton(new ImageIcon("images/re_select.png"));
		btn_designerSelect1.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_designerSelect1.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_designerSelect1.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		btn_designerSelect1.setFont(new Font("굴림", Font.PLAIN, 9));
		btn_designerSelect1.setHorizontalAlignment(SwingConstants.LEFT);
		btn_designerSelect1.setVerticalAlignment(SwingConstants.TOP);
		btn_designerSelect1.setBounds(252, 166, 78, 23);
		designer_page1.add(btn_designerSelect1);

		designer_page1.setVisible(false);

		btn_designerSelect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// initializationBtn();
				btn_10time.setEnabled(false);
				btn_11time.setEnabled(false);
				btn_12time.setEnabled(false);
				btn_13time.setEnabled(false);
				btn_14time.setEnabled(false);
				btn_15time.setEnabled(false);
				btn_16time.setEnabled(false);
				btn_17time.setEnabled(false);
				btn_18time.setEnabled(false);
				btn_19time.setEnabled(false);
				selectedDsgName = "김승현";
				selectedDsg = "DSR1";
				DsgSchDAO testdao = new DsgSchDAO();
				IntimeList = testdao.timeselect(selectedDsg);;

				btnActive(IntimeList);
			}

		});

		// 디자이너 페이지3
		JPanel designer_page3 = new JPanel();
		designer_page3.setBackground(BACKGROUND);
		designer_page3.setBounds(12, 74, 360, 189);
		frame.getContentPane().add(designer_page3);
		designer_page3.setLayout(null);

		JLabel imgLabel3 = new JLabel("");
		imgLabel3.setBounds(31, 18, 298, 138);
		designer_page3.add(imgLabel3);
		imgLabel3.setIcon(new ImageIcon(img3));
		imgLabel3.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btn_Pre3 = new JButton(new ImageIcon("images/prebtn.png"));
		btn_Pre3.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Pre3.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Pre3.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Pre3.setBounds(118, 171, 20, 16);
		designer_page3.add(btn_Pre3);

		JButton btn_Next3 = new JButton(new ImageIcon("images/nextbtn.png"));
		btn_Next3.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Next3.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Next3.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Next3.setBounds(220, 171, 20, 16);
		designer_page3.add(btn_Next3);

		JLabel lb_designername3 = new JLabel("김준철");
		lb_designername3.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_designername3.setHorizontalAlignment(SwingConstants.CENTER);
		lb_designername3.setBounds(145, 171, 66, 15);
		designer_page3.add(lb_designername3);

		JButton btn_designerSelect3 = new JButton(new ImageIcon("images/re_select.png"));
		btn_designerSelect3.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_designerSelect3.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_designerSelect3.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		btn_designerSelect3.setFont(new Font("굴림", Font.PLAIN, 9));
		btn_designerSelect3.setHorizontalAlignment(SwingConstants.LEFT);
		btn_designerSelect3.setVerticalAlignment(SwingConstants.TOP);
		btn_designerSelect3.setBounds(252, 166, 78, 23);
		designer_page3.add(btn_designerSelect3);
		btn_designerSelect3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// initializationBtn();
				btn_10time.setEnabled(false);
				btn_11time.setEnabled(false);
				btn_12time.setEnabled(false);
				btn_13time.setEnabled(false);
				btn_14time.setEnabled(false);
				btn_15time.setEnabled(false);
				btn_16time.setEnabled(false);
				btn_17time.setEnabled(false);
				btn_18time.setEnabled(false);
				btn_19time.setEnabled(false);
				selectedDsgName = "김준철";
				selectedDsg = "DSR3";
				DsgSchDAO testdao = new DsgSchDAO();
				IntimeList = testdao.timeselect(selectedDsg);

				btnActive(IntimeList);
			}

		});

		JButton btnBack = new JButton(new ImageIcon("images/re_before.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer cst2 = new customer();
				cst2.main(null);
			}
		});
		btnBack.setBorderPainted(false);// 버튼 외곽선 없애기
		btnBack.setContentAreaFilled(false);// 내용영역 채우지 않기
		btnBack.setFocusPainted(false);
		btnBack.setBounds(44, 550, 97, 23);
		frame.getContentPane().add(btnBack);

		// 디자이너 페이지0
		JPanel designer_page0 = new JPanel();
		designer_page0.setBackground(BACKGROUND);
		designer_page0.setBounds(12, 74, 360, 189);
		frame.getContentPane().add(designer_page0);
		designer_page0.setLayout(null);

		JLabel imgLabel0 = new JLabel("");

		imgLabel0.setBounds(31, 18, 298, 138);
		designer_page0.add(imgLabel0);
		imgLabel0.setIcon(new ImageIcon(img0));
		imgLabel0.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btn_Next0 = new JButton(new ImageIcon("images/nextbtn.png"));
		btn_Next0.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Next0.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Next0.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Next0.setBounds(220, 171, 20, 16);
		designer_page0.add(btn_Next0);

		JButton btn_Pre0 = new JButton(new ImageIcon("images/prebtn.png"));
		btn_Pre0.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Pre0.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Pre0.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Pre0.setBounds(118, 171, 20, 16);
		designer_page0.add(btn_Pre0);

		JLabel lb_designername0 = new JLabel("노송이");
		lb_designername0.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_designername0.setHorizontalAlignment(SwingConstants.CENTER);
		lb_designername0.setBounds(145, 171, 66, 15);
		designer_page0.add(lb_designername0);

		JButton btn_designerSelect0 = new JButton(new ImageIcon("images/re_select.png"));
		btn_designerSelect0.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_designerSelect0.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_designerSelect0.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		btn_designerSelect0.setFont(new Font("굴림", Font.PLAIN, 9));
		btn_designerSelect0.setHorizontalAlignment(SwingConstants.LEFT);
		btn_designerSelect0.setVerticalAlignment(SwingConstants.TOP);
		btn_designerSelect0.setBounds(252, 166, 78, 23);
		designer_page0.add(btn_designerSelect0);
		designer_page3.setVisible(false);
		
		btn_designerSelect0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// initializationBtn();
				btn_10time.setEnabled(false);
				btn_11time.setEnabled(false);
				btn_12time.setEnabled(false);
				btn_13time.setEnabled(false);
				btn_14time.setEnabled(false);
				btn_15time.setEnabled(false);
				btn_16time.setEnabled(false);
				btn_17time.setEnabled(false);
				btn_18time.setEnabled(false);
				btn_19time.setEnabled(false);
				selectedDsgName = "노송이";
				selectedDsg = "DSR0";
				DsgSchDAO testdao = new DsgSchDAO();
				IntimeList = testdao.timeselect(selectedDsg);

				btnActive(IntimeList);
			}

		});

		// 디자이너 페이지4
		JPanel designer_page4 = new JPanel();
		designer_page4.setBackground(BACKGROUND);
		designer_page4.setBounds(12, 74, 360, 189);
		frame.getContentPane().add(designer_page4);
		designer_page4.setLayout(null);

		JLabel imgLabel4 = new JLabel("");

		imgLabel4.setBounds(31, 18, 298, 138);
		designer_page4.add(imgLabel4);
		imgLabel4.setIcon(new ImageIcon(img4));
		imgLabel4.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btn_Next4 = new JButton(new ImageIcon("images/nextbtn.png"));
		btn_Next4.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Next4.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Next4.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Next4.setBounds(220, 171, 20, 16);
		designer_page4.add(btn_Next4);

		JButton btn_Pre4 = new JButton(new ImageIcon("images/prebtn.png"));
		btn_Pre4.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_Pre4.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_Pre4.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함

		btn_Pre4.setBounds(118, 171, 20, 16);
		designer_page4.add(btn_Pre4);

		JLabel lb_designername4 = new JLabel("우도희");
		lb_designername4.setFont(new Font("휴먼모음T", Font.PLAIN, 13));
		lb_designername4.setHorizontalAlignment(SwingConstants.CENTER);
		lb_designername4.setBounds(145, 171, 66, 15);
		designer_page4.add(lb_designername4);

		JButton btn_designerSelect4 = new JButton(new ImageIcon("images/re_select.png"));
		btn_designerSelect4.setBorderPainted(false);// 버튼 외곽선 없애기
		btn_designerSelect4.setContentAreaFilled(false);// 내용영역 채우지 않기
		btn_designerSelect4.setFocusPainted(false);// 선택되었을 때 생기는 테두리 사용안함
		btn_designerSelect4.setFont(new Font("굴림", Font.PLAIN, 9));
		btn_designerSelect4.setHorizontalAlignment(SwingConstants.LEFT);
		btn_designerSelect4.setVerticalAlignment(SwingConstants.TOP);
		btn_designerSelect4.setBounds(252, 166, 78, 23);
		designer_page4.add(btn_designerSelect4);

//		//최종 결제 정보 화면
//		String str = "예약날짜: " + selectedDate + "디자이너: " + selectedDsg + "시간: " + selectedHour;
//		JPanel Info_page = new JPanel();
//		Info_page.setBackground(new Color(246, 244, 254));
//		Info_page.setBounds(12, 450, 360, 92);
//		frame.getContentPane().add(Info_page);
//		Info_page.setLayout(null);
//		JLabel label_Info = new JLabel(str);
//		label_Info.setHorizontalAlignment(SwingConstants.CENTER);
//		label_Info.setBounds(12, 10, 336, 28);
//		Info_page.add(label_Info);

		btn_designerSelect4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// initializationBtn();
				btn_10time.setEnabled(false);
				btn_11time.setEnabled(false);
				btn_12time.setEnabled(false);
				btn_13time.setEnabled(false);
				btn_14time.setEnabled(false);
				btn_15time.setEnabled(false);
				btn_16time.setEnabled(false);
				btn_17time.setEnabled(false);
				btn_18time.setEnabled(false);
				btn_19time.setEnabled(false);
				selectedDsgName = "우도희";
				selectedDsg = "DSR4";
				DsgSchDAO testdao = new DsgSchDAO();
				IntimeList = testdao.timeselect(selectedDsg);

				btnActive(IntimeList);
			}

		});

		designer_page4.setVisible(false);

		JPanel Info_page = new JPanel();
		Info_page.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(220,213,251)));
		Info_page.setBackground(new Color(246, 244, 254));
		Info_page.setBounds(12, 457, 360, 85);
		frame.getContentPane().add(Info_page);
		Info_page.setLayout(null);
		label_Info = new JLabel();
		label_Info.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		label_Info.setHorizontalAlignment(SwingConstants.CENTER);
		label_Info.setBounds(12, 25, 336, 34);
		Info_page.add(label_Info);

		// 디자이너 페이지0에서 1로, 다음버튼
		btn_Next0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page0.setVisible(false);
				designer_page1.setVisible(true);
				// selectedName = "김승현";

			}
		});

		// 디자이너 페이지1에서 2로, 다음버튼
		btn_Next1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page1.setVisible(false);
				designer_page2.setVisible(true);
				// selectedDsg = "이시면";
			}
		});

		// 디자이너 페이지2에서 3으로, 다음버튼
		btn_Next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page2.setVisible(false);
				designer_page3.setVisible(true);
				// selectedDsg = "김준철";
			}
		});

		// 디자이너 페이지3에서 4로, 다음버튼
		btn_Next3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page3.setVisible(false);
				designer_page4.setVisible(true);
				// selectedDsg = "우도희";
			}
		});

		// 디자이너 페이지4에서 0로, 다음버튼
		btn_Next4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page4.setVisible(false);
				designer_page0.setVisible(true);
				// selectedDsg = "노송이";
			}
		});

		// 디자이너 페이지 0에서 4으로,이전버튼
		btn_Pre0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page4.setVisible(true);
				designer_page0.setVisible(false);
				// selectedDsg = "우도희";
			}
		});
		// 디자이너 페이지 1에서 0로,이전버튼
		btn_Pre1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page0.setVisible(true);
				designer_page1.setVisible(false);
				// selectedDsg = "노송이";
			}
		});

		// 디자이너 페이지 2에서 1로,이전버튼
		btn_Pre2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page1.setVisible(true);
				designer_page2.setVisible(false);
				// selectedDsg = "김승현";
			}
		});

		// 디자이너 페이지 3에서 2로,이전버튼
		btn_Pre3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page2.setVisible(true);
				designer_page3.setVisible(false);
				// selectedDsg = "이시면";
			}
		});

		// 디자이너 페이지 4에서 3로,이전버튼
		btn_Pre4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				designer_page3.setVisible(true);
				designer_page4.setVisible(false);
				// selectedDsg = "김준철";
			}
		});

//		btn_designerSelect0.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// initializationBtn();
//				btn_10time.setEnabled(false);
//				btn_11time.setEnabled(false);
//				btn_12time.setEnabled(false);
//				btn_13time.setEnabled(false);
//				btn_14time.setEnabled(false);
//				btn_15time.setEnabled(false);
//				btn_16time.setEnabled(false);
//				btn_17time.setEnabled(false);
//				btn_18time.setEnabled(false);
//				btn_19time.setEnabled(false);
//				selectedDsg = "DSR0";
//				DsgSchDAO testdao = new DsgSchDAO();
//				IntimeList = testdao.timeselect(selectedDsg);
//
//				btnActive(IntimeList);
//			}
//
//		});

		// 콤보박스 인덱스 번호 이미지 출력
//		cmb_designer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JComboBox cb = (JComboBox) e.getSource();
//				int index = cb.getSelectedIndex();
//				imgLabel.setIcon(images[index - 1]);
//			}
//		});

		// 시술종류 프린트
		JLabel combo_content = new JLabel();
		combo_content.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		combo_content.setHorizontalAlignment(SwingConstants.CENTER);

		combo_content.setBounds(12, 47, 338, 34);
		Info_page.add(combo_content);
		
		JLabel lb_payInfo = new JLabel("<<\uACB0\uC81C \uC815\uBCF4>>");
		lb_payInfo.setFont(new Font("휴먼모음T", Font.PLAIN, 14));
		lb_payInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lb_payInfo.setBounds(8, 10, 103, 15);
		Info_page.add(lb_payInfo);
		combo_style.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comboContent = (String) combo_style.getSelectedItem();
				combo_content.setText(comboContent);

			}
		});

	}

	protected void btnActive(ArrayList<String> List) {
		for (int i = 0; i < List.size(); i++) {
			map.get(List.get(i)).setEnabled(true);

		}

	}
}
