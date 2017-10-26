package ex6_2;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lb;
	private JLabel lblNewLabel_1;
	private JLabel lblWidth;
	private JLabel lblHeight;
	private JTextField tfLength;
	private JTextField tfWidth;
	private JTextField tfHeight;
	private JButton btStop;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	private JButton btAdd;
	ArrayList<Cube> cubes = new ArrayList<>();
	
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
		setTitle("Ex6-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 530);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lb = new JLabel("\u8ACB\u8F38\u5165\u7B2C1\u500B\u9577\u65B9\u9AD4\u8CC7\u8A0A");
		lb.setFont(new Font("新細明體", Font.PLAIN, 14));
		lb.setBounds(122, 44, 162, 22);
		contentPane.add(lb);
		
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
		
		btStop = new JButton("Stop");
		btStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				int counter = 1;
				for (Cube cube : cubes) {
					s += "第" + counter + "的立方體\n";
					s +=  cube.getInfo() + "\n";
					counter += 1;
				}
				s += "\n" + "共" + (counter - 1) + "個立方體";
				taResult.setText(s);
				cubes.clear();
				lb.setText("請輸入第" + (cubes.size() + 1) + "個長方體資訊");
			}
		});
		btStop.setFont(new Font("新細明體", Font.PLAIN, 14));
		btStop.setBounds(321, 181, 106, 29);
		contentPane.add(btStop);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 237, 402, 209);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(taResult);
		
		btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double length = Double.valueOf(tfLength.getText());
				double width = Double.valueOf(tfWidth.getText());
				double height = Double.valueOf(tfHeight.getText());
				Cube cube = new Cube(length, width, height);
				cubes.add(cube);
				tfLength.setText(null);
				tfWidth.setText(null);
				tfHeight.setText(null);
				taResult.setText("新增的長方體長、寬、高為:\n" + 
								cube.length + ", " + 
								cube.width + ", " + 
								cube.height);
				lb.setText("請輸入第" + (cubes.size() + 1) + "個長方體資訊");
			}
		});
		btAdd.setFont(new Font("新細明體", Font.PLAIN, 14));
		btAdd.setBounds(321, 133, 106, 29);
		contentPane.add(btAdd);
	}
}