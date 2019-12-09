
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//public String calDate;

public class customer extends CalendarDataManager {

	public static String calDate; // �޷� ��¥���� �޾ƿ��� ����

	private JFrame frame;
	JPanel calPane1;
	private JButton todayBut_1;
	JButton yearbut;
	JButton monbut;
	JButton weekDayName1[];
	JButton dateButs[][] = new JButton[6][7];
	final String WEEK_DAY_NAME[] = { "��", "��", "ȭ", "��", "��", "��", "��" };
	final String WEEK_DAY_NAME1[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	JLabel botonInfo = new JLabel("Welcom to Calendar!");
	listenForDateButs lForDateButs = new listenForDateButs();
	JPanel infoPanel;
	JLabel infoClock;
	JLabel SelectData2;
	JLabel todayLab;
	JButton lYearBut;
	JButton lMonBut;
	JLabel curMMYYYYLab;
	JButton nMonBut;
	JButton nYearBut;
	ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
	private JButton btn_designer_select;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer window = new customer();
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
	public customer() {
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
		frame.setTitle("SongSongSalon");// ���� Ÿ��Ʋ ����
		frame.setLocationRelativeTo(null);// ų�� �߾ӿ�\ ��ġ�ϰ�
		frame.setResizable(false);// ������� ���ϰ�
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel calendar_Full = new JPanel();
		calendar_Full.setBackground(new Color(246,244,254));
		calendar_Full.setBounds(12, 78, 367, 302);
		frame.getContentPane().add(calendar_Full);
		calendar_Full.setLayout(null);

		// Ķ����
		JPanel calendar = new JPanel();
		calendar.setBackground(Color.WHITE);
		calendar.setBounds(27, 65, 312, 190);
		calendar_Full.add(calendar);
		calendar.setLayout(null);
		weekDayName1 = new JButton[7];
		for (int i = 0; i < CAL_WIDTH; i++) {
			weekDayName1[i] = new JButton(WEEK_DAY_NAME[i]);
			weekDayName1[i].setContentAreaFilled(false);
			weekDayName1[i].setForeground(Color.WHITE);

			if (i == 0)
				weekDayName1[i].setBackground(new Color(200, 50, 50));
			else if (i == 6)
				weekDayName1[i].setBackground(new Color(50, 100, 200));
			else
				weekDayName1[i].setBackground(new Color(150, 150, 150));
			weekDayName1[i].setOpaque(true);
			weekDayName1[i].setFocusPainted(false);
			weekDayName1[i].setFont(new Font("���", Font.PLAIN, 8));
			calendar.add(weekDayName1[i]);
		}
		for (int i = 0; i < CAL_HEIGHT; i++) {
			for (int j = 0; j < CAL_WIDTH; j++) {
				dateButs[i][j] = new JButton();
				dateButs[i][j].setBorderPainted(false);
				dateButs[i][j].setContentAreaFilled(true);
				dateButs[i][j].setBackground(Color.WHITE);
				dateButs[i][j].setOpaque(true);
				dateButs[i][j].setFocusPainted(false);
				dateButs[i][j].addActionListener(lForDateButs);
				calendar.add(dateButs[i][j]);
			}
		}
		calendar.setLayout(new GridLayout(0, 7, 2, 2));
		calendar.setBorder(new EmptyBorder(0, 3, 0, 3));

		// now �г�
		JPanel now = new JPanel();
		now.setBackground(new Color(246,244,254));
		now.setBounds(0, 30, 367, 25);
		calendar_Full.add(now);
		now.setLayout(null);
		showCal();
//	      todayLab = new JLabel(today.get(Calendar.MONTH)+1+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR));
//	      todayLab.setFont(new Font("���",Font.ITALIC,10));
		lYearBut = new JButton(new ImageIcon("images/doublePre.png"));
		lYearBut.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		lYearBut.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		lYearBut.setBackground(new Color(246,244,254));
		lYearBut.setToolTipText("Previous Year");
		lYearBut.addActionListener(lForCalOpButtons);
		lYearBut.setFont(new Font("���", Font.ITALIC, 8));

		lMonBut = new JButton(new ImageIcon("images/pre.png"));
	    lMonBut.setBackground(new Color(246,244,254));
	    lMonBut.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
	    lMonBut.setFocusPainted(false); //
		
		lMonBut.setToolTipText("Previous Month");
		lMonBut.addActionListener(lForCalOpButtons);
		lMonBut.setFont(new Font("���", Font.ITALIC, 8));
		curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=3>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
				+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
		
		
		
		nMonBut = new JButton(new ImageIcon("images/next2.png"));
		nMonBut.setSize(28, 8);
	    nMonBut.setBackground(new Color(246,244,254));
	    nMonBut.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
	    nMonBut.setFocusPainted(false); //
		
		
		
		nMonBut.setToolTipText("Next Month");
		nMonBut.addActionListener(lForCalOpButtons);
		nMonBut.setFont(new Font("���", Font.ITALIC, 8));
		nYearBut = new JButton(new ImageIcon("images/doubleNext.png"));
		nYearBut.setSize(25, 8);
		nYearBut.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		nYearBut.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		nYearBut.setBackground(new Color(246,244,254));
		nYearBut.setToolTipText("Next Year");
		nYearBut.addActionListener(lForCalOpButtons);
		nYearBut.setFont(new Font("���", Font.ITALIC, 8));
		now.setLayout(new GridBagLayout());
//	      now.add(todayLab);
		now.add(lYearBut);
		now.add(lMonBut);
		now.add(curMMYYYYLab);
		now.add(nMonBut);
		now.add(nYearBut);

		// btn_to �г�
		JPanel btn_to = new JPanel();
		btn_to.setBackground(new Color(246,244,254));
		btn_to.setBounds(257, 0, 78, 35);
		calendar_Full.add(btn_to);
		btn_to.setLayout(null);
		todayBut_1 = new JButton(new ImageIcon("images/today.png"));
		todayBut_1.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		todayBut_1.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		todayBut_1.setBackground(new Color(246,244,254));
		todayBut_1.setBounds(0, 0, 78, 30);
		btn_to.add(todayBut_1);
		todayBut_1.setToolTipText("Today");
		todayBut_1.addActionListener(lForCalOpButtons);
		todayBut_1.setFont(new Font("���", Font.ITALIC, 8));

		btn_designer_select = new JButton(new ImageIcon("images/next4.png"));
		btn_designer_select.setBorderPainted(false);// ��ư �ܰ��� ���ֱ�
		btn_designer_select.setFocusPainted(false); // ��ư�� ���õǾ��� �� ����� �׵θ� ������
		btn_designer_select.setBackground(new Color(246,244,254));
		btn_designer_select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeSelect ts = new TimeSelect();
				ts.main(null);

			}
		});
		btn_designer_select.setBounds(265, 520, 85, 35);
		frame.getContentPane().add(btn_designer_select);

		infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout());
		infoClock = new JLabel("", SwingConstants.RIGHT);
		infoClock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoPanel.add(infoClock, BorderLayout.NORTH);

		SelectData2 = new JLabel("<Html><font size=5>" + (today.get(Calendar.MONTH) + 1) + "/"
				+ today.get(Calendar.DAY_OF_MONTH) + "/" + today.get(Calendar.YEAR) + "&nbsp;(Today)</html>",
				SwingConstants.CENTER);
		SelectData2.setBounds(37, 263, 302, 29);
		calendar_Full.add(SelectData2);

	}

	private class listenForDateButs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int k = 0, l = 0;
			for (int i = 0; i < CAL_HEIGHT; i++) {
				for (int j = 0; j < CAL_WIDTH; j++) {
					if (e.getSource() == dateButs[i][j]) {
						k = i;
						l = j;
					}
				}
			}
			if (e.getSource() == dateButs[3][3])
				System.out.println("Ŭ��");

			if (!(k == 0 && l == 0))
				calday = calDATE[k][l]; // today��ư�� ���������� �� actionPerformed�Լ��� ����Ǳ� ������ ���� �κ�

			cal = new GregorianCalendar(calYear, calMonth, calday);

			String dDayString = new String();
			int dDay = ((int) ((cal.getTimeInMillis() - today.getTimeInMillis()) / 1000 / 60 / 60 / 24));
			if (dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR))
					&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH)))
				dDayString = "Today";
			else if (dDay >= 0)
				dDayString = "D-" + (dDay + 1);
			else if (dDay < 0)
				dDayString = "D+" + (dDay) * (-1);
			String s = " ���õǾ����ϴ�.";
			SelectData2.setText(
					"<Html><font size=5>" + (calMonth + 1) + "/" + calday + "/" + calYear + s + "&nbsp;</html>");
			calDate = (calMonth + 1) + "/" + calday;
			System.out.println(calDate);

		}
	}

	private void showCal() {
		for (int i = 0; i < CAL_HEIGHT; i++) {
			for (int j = 0; j < CAL_WIDTH; j++) {
				String fontColor = "black";
				if (j == 0)
					fontColor = "red";
				else if (j == 6)
					fontColor = "blue";

				File f = new File("MemoData/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
						+ (calDATE[i][j] < 10 ? "0" : "") + calDATE[i][j] + ".txt");
				if (f.exists()) {
					dateButs[i][j]
							.setText("<html><b><font color=" + fontColor + ">" + calDATE[i][j] + "</font></b></html>");
				} else
					dateButs[i][j].setText("<html><font color=" + fontColor + ">" + calDATE[i][j] + "</font></html>");

				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
				dateButs[i][j].removeAll();
				if (calMonth == today.get(Calendar.MONTH) && calYear == today.get(Calendar.YEAR)
						&& calDATE[i][j] == today.get(Calendar.DAY_OF_MONTH)) {
					dateButs[i][j].add(todayMark);
					dateButs[i][j].setToolTipText("Today");
				}

				if (calDATE[i][j] == 0)
					dateButs[i][j].setVisible(false);
				else
					dateButs[i][j].setVisible(true);
			}
		}
	}

	private class ListenForCalOpButtons implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == todayBut_1) {
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
			} else if (e.getSource() == lYearBut)
				moveMonth(-12);
			else if (e.getSource() == lMonBut)
				moveMonth(-1);
			else if (e.getSource() == nMonBut)
				moveMonth(1);
			else if (e.getSource() == nYearBut)
				moveMonth(12);

			curMMYYYYLab.setText("<html><table width=100><tr><th><font size=3>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
					+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
			showCal();
			String printToday = "<Html><font size=5>"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR)+"&nbsp;(Today)</html>"; 
			SelectData2.setText(printToday);
		}
	}

	private void focusToday() {
		if (today.get(Calendar.DAY_OF_WEEK) == 1)
			dateButs[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH) - 1][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
	}
}
