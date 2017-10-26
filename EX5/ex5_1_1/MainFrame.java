package ex5_1_1;

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
import java.util.ArrayList;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumber;
	private JButton btAdd;
	private JButton btStop;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	ArrayList<Double> numbers = new ArrayList<>();
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
		setTitle("Ex5-1-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNumber = new JTextField();
		tfNumber.setBounds(45, 60, 133, 32);
		contentPane.add(tfNumber);
		tfNumber.setColumns(10);
		
		btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double num = Double.valueOf(tfNumber.getText());
				numbers.add(num);
				taResult.setText(num+"");
				tfNumber.setText(null);
			}
		});
		btAdd.setFont(new Font("新細明體", Font.PLAIN, 14));
		btAdd.setBounds(205, 60, 121, 32);
		contentPane.add(btAdd);
		
		btStop = new JButton("Stop");
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = "";
				double sum = 0;
				for(double number : numbers) {
					sum += number;
					text += number + " ";
				}
				text += "\n總和  = " + sum + "\n平均  = " + (sum / numbers.size());
				taResult.setText(text);
			}
		});
		btStop.setFont(new Font("新細明體", Font.PLAIN, 14));
		btStop.setBounds(344, 60, 121, 32);
		contentPane.add(btStop);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 136, 420, 201);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}

}
