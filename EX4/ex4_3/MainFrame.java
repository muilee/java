package ex4_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfStart;
	private JLabel lblStop;
	private JTextField tfStop;
	private JButton bfSubmit;
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
		setTitle("Ex4-3");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Start");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(138, 60, 70, 26);
		contentPane.add(lblNewLabel);
		
		tfStart = new JTextField();
		tfStart.setBounds(218, 61, 153, 26);
		contentPane.add(tfStart);
		tfStart.setColumns(10);
		
		lblStop = new JLabel("Stop");
		lblStop.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStop.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblStop.setBounds(138, 105, 70, 26);
		contentPane.add(lblStop);
		
		tfStop = new JTextField();
		tfStop.setColumns(10);
		tfStop.setBounds(218, 106, 153, 26);
		contentPane.add(tfStop);
		
		bfSubmit = new JButton("Submit");
		bfSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int start = Integer.valueOf(tfStart.getText());
				int stop = Integer.valueOf(tfStop.getText());
				int sum = 0;
				String t = "";
				for (int i = start; i <= stop; i++) {
					sum = sum + i;
					t = i + " ";
					if (i < 10) {
						t = "0" + t;
					}
					taResult.append(t);
					if ((i - start + 1)  % 10 == 0) {
						taResult.append("\n");
					}
				}
				taResult.append("\n總和 = " + sum + "\n");
			}
		});
		bfSubmit.setBounds(405, 105, 102, 26);
		contentPane.add(bfSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 169, 451, 193);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}
}
