package ex10_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btNew;
	private JButton btSave;
	private JButton btOpen;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	File file = new File("./note.txt");

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
		setTitle("Ex10-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 498);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btNew = new JButton("New");
		btNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taResult.setText("");
			}
		});
		btNew.setFont(new Font("新細明體", Font.PLAIN, 14));
		btNew.setBounds(66, 73, 107, 34);
		contentPane.add(btNew);
		
		btSave = new JButton("Save");
		btSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = taResult.getText();
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(text);
					fw.close();
				}catch(IOException exception) {
					exception.printStackTrace();
				}
				
			}
		});
		btSave.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSave.setBounds(209, 73, 107, 34);
		contentPane.add(btSave);
		
		btOpen = new JButton("Open");
		btOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader fr = new FileReader(file);
					int i = 0;
					String s = "";
					while((i = fr.read()) != -1) {
						s += String.valueOf((char) i);
					}
					taResult.setText(s);
					fr.close();
				}catch(IOException exception) {
					exception.printStackTrace();
				}
				
				
			}
		});
		btOpen.setFont(new Font("新細明體", Font.PLAIN, 14));
		btOpen.setBounds(350, 73, 107, 34);
		contentPane.add(btOpen);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 157, 431, 239);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
	}
}
