package ex11_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfCount;
	private JButton btSubmit;
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
		setTitle("Ex11-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 481);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("\u8981\u7522\u751F\u5E7E\u500B\u6578");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(51, 63, 96, 34);
		contentPane.add(lblNewLabel);
		
		tfCount = new JTextField();
		tfCount.setFont(new Font("新細明體", Font.PLAIN, 14));
		tfCount.setBounds(169, 63, 162, 34);
		contentPane.add(tfCount);
		tfCount.setColumns(10);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = Integer.valueOf(tfCount.getText());
				int temp = 0;
				String text = "";
				for(int i = 0; i < count; i++) {
					temp = (int) Math.floor(Math.random()*100 + 1);
					text += temp;
					if (temp % 2 == 0 || temp % 3 == 0 || temp % 5 == 0 || temp % 7 == 0 || temp == 1) {
						text += "不";
					}
					text += "是質數\n";
				}
				taResult.setText(text);
			}
		});
		btSubmit.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSubmit.setBounds(354, 63, 118, 34);
		contentPane.add(btSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 155, 423, 223);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
	}
}
