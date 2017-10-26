package ex4_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfMoney;
	private JLabel lblVacation;
	private JTextField tfVacation;
	private JButton bfConfirm;
	private JTextArea taResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Ex-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Money");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(120, 61, 66, 15);
		contentPane.add(lblNewLabel);
		
		tfMoney = new JTextField();
		tfMoney.setBounds(196, 58, 151, 21);
		contentPane.add(tfMoney);
		tfMoney.setColumns(10);
		
		lblVacation = new JLabel("Vacation");
		lblVacation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVacation.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblVacation.setBounds(120, 102, 66, 15);
		contentPane.add(lblVacation);
		
		tfVacation = new JTextField();
		tfVacation.setColumns(10);
		tfVacation.setBounds(196, 99, 151, 21);
		contentPane.add(tfVacation);
		
		bfConfirm = new JButton("Confirm");
		bfConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int money = Integer.valueOf(tfMoney.getText());
				int vacation = Integer.valueOf(tfVacation.getText());
				if (money >= 20000) {
					if (vacation >= 5) {
						taResult.setText("可以去泰國玩");
					}
					else {
						taResult.setText("有錢沒閒");
					}
				}
				else {
					if (vacation >= 5) {
						taResult.setText("有閒沒錢");
					}
					else {
						taResult.setText("既沒錢又沒閒,真可憐");
					}
				}
			}
		});
		bfConfirm.setBounds(390, 98, 87, 23);
		contentPane.add(bfConfirm);
		
		taResult = new JTextArea();
		taResult.setBounds(120, 164, 367, 156);
		contentPane.add(taResult);
	}
}
