package ex5_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfNum3;
	private JTextField tfNum4;
	private JTextField tfNum5;
	private JButton btSubmit;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	double[] numbers = new double[5];

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
		setTitle("Ex5-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(71, 46, 120, 30);
		contentPane.add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setColumns(10);
		tfNum2.setBounds(71, 86, 120, 30);
		contentPane.add(tfNum2);
		
		tfNum3 = new JTextField();
		tfNum3.setColumns(10);
		tfNum3.setBounds(71, 126, 120, 30);
		contentPane.add(tfNum3);
		
		tfNum4 = new JTextField();
		tfNum4.setColumns(10);
		tfNum4.setBounds(71, 166, 120, 30);
		contentPane.add(tfNum4);
		
		tfNum5 = new JTextField();
		tfNum5.setColumns(10);
		tfNum5.setBounds(71, 206, 120, 30);
		contentPane.add(tfNum5);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = "";
				double sum = 0;
				numbers[0] = Integer.valueOf(tfNum1.getText());
				numbers[1] = Integer.valueOf(tfNum2.getText());
				numbers[2] = Integer.valueOf(tfNum3.getText());
				numbers[3] = Integer.valueOf(tfNum4.getText());
				numbers[4] = Integer.valueOf(tfNum5.getText());
				for (int i = 0; i < 5; i++) {
					sum = sum + numbers[i];
					s += numbers[i] + " ";
				}
				s += "\n總和  = " + sum;
				s += "\n平均  = " + (sum / 5);
				taResult.setText(s);
			}
		});
		btSubmit.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSubmit.setBounds(226, 205, 109, 30);
		contentPane.add(btSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 261, 363, 186);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}
}
