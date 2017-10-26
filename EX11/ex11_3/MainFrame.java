package ex11_3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
	private JButton btOpen;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	ArrayList<Book> books = new ArrayList<Book>();
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
		setTitle("Ex11-3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btOpen = new JButton("Open");
		btOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File("./note.csv");
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String text = "";
					while((text=br.readLine()) != null) {
						String[] s = text.split("\\s*,\\s*");
						double price = Double.valueOf(s[1]);
						books.add(new Book(s[0], price, s[2]));
					}
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
				String text = "name\tprice\tauthor\n";
				for (Book book : books) {
					text += book.name + "\t" + book.price + "\t" + book.author + "\n";
				}
				taResult.setText(text);
			}
		});
		btOpen.setFont(new Font("新細明體", Font.PLAIN, 14));
		btOpen.setBounds(190, 32, 112, 34);
		contentPane.add(btOpen);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 96, 426, 268);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}
}
