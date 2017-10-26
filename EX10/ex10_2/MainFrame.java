package ex10_2;

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
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lb;
	private JLabel lblJeight;
	private JTextField tfLength;
	private JTextField tfWidth;
	private JTextField tfHeight;
	private JLabel lblWidth;
	private JLabel lblLength;
	private JButton btAdd;
	private JButton btSave;
	private JButton btOpen;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	ArrayList<Cube> cubes = new ArrayList<Cube>();
	File file = new File("./note1.txt");

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
		setTitle("Ex10-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 526);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lb = new JLabel("\u8ACB\u8F38\u5165\u7B2C1\u500B\u7ACB\u65B9\u9AD4\u8CC7\u8A0A");
		lb.setFont(new Font("新細明體", Font.PLAIN, 14));
		lb.setBounds(96, 35, 162, 26);
		contentPane.add(lb);

		lblJeight = new JLabel("Height");
		lblJeight.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblJeight.setBounds(62, 164, 62, 31);
		contentPane.add(lblJeight);

		tfLength = new JTextField();
		tfLength.setBounds(150, 76, 156, 31);
		contentPane.add(tfLength);
		tfLength.setColumns(10);

		tfWidth = new JTextField();
		tfWidth.setColumns(10);
		tfWidth.setBounds(150, 120, 156, 31);
		contentPane.add(tfWidth);

		tfHeight = new JTextField();
		tfHeight.setColumns(10);
		tfHeight.setBounds(150, 164, 156, 31);
		contentPane.add(tfHeight);

		lblWidth = new JLabel("Width");
		lblWidth.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblWidth.setBounds(62, 120, 62, 31);
		contentPane.add(lblWidth);

		lblLength = new JLabel("Length");
		lblLength.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblLength.setBounds(62, 77, 62, 31);
		contentPane.add(lblLength);

		btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double length = Double.valueOf(tfLength.getText());
				double width = Double.valueOf(tfWidth.getText());
				double height = Double.valueOf(tfHeight.getText());
				Cube cube = new Cube(length, width, height);
				cubes.add(cube);
				taResult.setText(cube.toString());
				lb.setText("請輸入第" + (cubes.size() + 1) + "個立方體資訊");
				tfLength.setText(null);
				tfWidth.setText(null);
				tfHeight.setText(null);
			}
		});
		btAdd.setFont(new Font("新細明體", Font.PLAIN, 14));
		btAdd.setBounds(333, 76, 107, 31);
		contentPane.add(btAdd);

		btSave = new JButton("Save");
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String text = "";
					int counter = 0;
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					for (Cube cube : cubes) {
						counter += 1;
						oos.writeObject(cube);
						text += String.format("第%d個立方體\n%s", counter, cube.toString());
					}
					oos.close();
					text += "\n共" + cubes.size() + "個立方體";
					taResult.setText(text);
				} catch (IOException exception) {
					exception.printStackTrace();
				}

			}
		});
		btSave.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSave.setBounds(333, 120, 107, 31);
		contentPane.add(btSave);

		btOpen = new JButton("Open");
		btOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = "";
				int counter = 0;
				ObjectInputStream ois;
				
				try {
					FileInputStream fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					try {
						while (true) {
							counter += 1;
							text += String.format("第%d個立方體\n%s", counter, ((Cube) ois.readObject()).toString());
						}
					
					}catch(EOFException e1) {
						ois.close();
					}
					
				} catch (IOException exception) {
					exception.printStackTrace();
				} catch (ClassNotFoundException exception1) {
					exception1.printStackTrace();
				} 
				text += "\n共" + (counter - 1) + "個立方體";
				taResult.setText(text);

			}
		});
		btOpen.setFont(new Font("新細明體", Font.PLAIN, 14));
		btOpen.setBounds(333, 164, 107, 31);
		contentPane.add(btOpen);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 223, 434, 235);
		contentPane.add(scrollPane);

		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
	}

}
