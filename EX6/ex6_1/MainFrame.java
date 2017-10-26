package ex6_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblWidth;
	private JLabel lblHeight;
	private JTextField tfLength;
	private JTextField tfWidth;
	private JTextField tfHeight;
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
		setTitle("Ex6-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Infomation");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(156, 44, 89, 22);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Length");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 90, 55, 22);
		contentPane.add(lblNewLabel_1);
		
		lblWidth = new JLabel("Width");
		lblWidth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWidth.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblWidth.setBounds(60, 136, 55, 22);
		contentPane.add(lblWidth);
		
		lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeight.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblHeight.setBounds(60, 184, 55, 22);
		contentPane.add(lblHeight);
		
		tfLength = new JTextField();
		tfLength.setBounds(133, 87, 130, 29);
		contentPane.add(tfLength);
		tfLength.setColumns(10);
		
		tfWidth = new JTextField();
		tfWidth.setColumns(10);
		tfWidth.setBounds(133, 133, 130, 29);
		contentPane.add(tfWidth);
		
		tfHeight = new JTextField();
		tfHeight.setColumns(10);
		tfHeight.setBounds(133, 181, 130, 29);
		contentPane.add(tfHeight);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double length = Double.valueOf(tfLength.getText());
				double width = Double.valueOf(tfWidth.getText());
				double height = Double.valueOf(tfHeight.getText());
				Cube cube = new Cube(length, width, height);
				taResult.setText(cube.getInfo());
			}
		});
		btSubmit.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSubmit.setBounds(321, 181, 106, 29);
		contentPane.add(btSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 237, 402, 209);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}
}
