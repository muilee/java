package ex9_2;

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
	private JTextField tfLength;
	private JButton btSubmit;
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
		setTitle("Ex9-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfLength = new JTextField();
		tfLength.setBounds(176, 90, 132, 32);
		contentPane.add(tfLength);
		tfLength.setColumns(10);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int length = Integer.valueOf(tfLength.getText());
					Cube cube = new Cube();
					cube.setLength(length);
					taResult.setText("volume = " + Math.pow(length, 3));
				}catch(CubeException exception1){
					taResult.setText("length can't equal or be less than 0");
				}catch(Exception exception2) {
					taResult.setText("The format is wrong");
				}
				
			}
		});
		btSubmit.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		btSubmit.setBounds(333, 88, 121, 34);
		contentPane.add(btSubmit);
		
		lblDivident = new JLabel("Length");
		lblDivident.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblDivident.setBounds(81, 90, 67, 32);
		contentPane.add(lblDivident);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 176, 412, 219);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
	}
}