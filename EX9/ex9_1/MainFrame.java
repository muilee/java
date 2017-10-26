package ex9_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblDivisor;
	private JTextField tfDivident;
	private JTextField tfDivisor;
	private JButton btDivide;
	private JLabel lblDivident;
	private JScrollPane scrollPane;
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
		setTitle("Ex9-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDivisor = new JLabel("Divisor");
		lblDivisor.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblDivisor.setBounds(81, 132, 67, 32);
		contentPane.add(lblDivisor);
		
		tfDivident = new JTextField();
		tfDivident.setBounds(176, 90, 132, 32);
		contentPane.add(tfDivident);
		tfDivident.setColumns(10);
		
		tfDivisor = new JTextField();
		tfDivisor.setColumns(10);
		tfDivisor.setBounds(176, 132, 132, 32);
		contentPane.add(tfDivisor);
		
		btDivide = new JButton("Divide");
		btDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int divident = Integer.valueOf(tfDivident.getText());
					int divisor = Integer.valueOf(tfDivisor.getText());
					double ans = divident / divisor;
					
					taResult.setText(String.format("%s / %s = %s", divident, divisor, ans));
				}catch(ArithmeticException exception1){
					taResult.setText("除數不可為 0,請再重新輸入");
				}catch(Exception exception2) {
					taResult.setText("被除數或除數格式錯誤");
				}
			}
		});
		btDivide.setFont(new Font("新細明體", Font.PLAIN, 14));
		btDivide.setBounds(334, 130, 121, 34);
		contentPane.add(btDivide);
		
		lblDivident = new JLabel("Divident");
		lblDivident.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblDivident.setBounds(81, 90, 67, 32);
		contentPane.add(lblDivident);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 202, 412, 193);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
	}
}
