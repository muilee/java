package ex8_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cbbCountries;
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
		setTitle("Ex8-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Country you want to go");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 74, 139, 29);
		contentPane.add(lblNewLabel);
		
		cbbCountries = new JComboBox();
		cbbCountries.setFont(new Font("新細明體", Font.PLAIN, 14));
		cbbCountries.setModel(new DefaultComboBoxModel(Country.values()));
		cbbCountries.setBounds(182, 72, 141, 32);
		contentPane.add(cbbCountries);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Country country = (Country) cbbCountries.getSelectedItem();
				String text = "你選的地方是: " + country + "\n";
				text += country.getInfo();
				taResult.setText(text);
			}
		});
		btSubmit.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSubmit.setBounds(343, 71, 127, 32);
		contentPane.add(btSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 181, 417, 215);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
	}
}
