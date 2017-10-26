package ex8_2;

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
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cbbCountries;
	private JButton btSubmit;
	private JScrollPane scrollPane;
	private JTextArea taResult;
	private JComboBox cbbSpots;
	private JLabel lblNewLabel_1;
	private JLabel lbSpots;

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
		setTitle("Ex8-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Country you want to go");
		lblNewLabel.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblNewLabel.setBounds(184, 31, 155, 29);
		contentPane.add(lblNewLabel);
		
		cbbCountries = new JComboBox();
		cbbCountries.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Country country = (Country) cbbCountries.getSelectedItem();
				switch(country){
					case US:
						cbbSpots.setModel(new DefaultComboBoxModel(US.values()));
						break;
					case UK:
						cbbSpots.setModel(new DefaultComboBoxModel(UK.values()));
						break;
					case TAIWAN:
						cbbSpots.setModel(new DefaultComboBoxModel(Taiwan.values()));
						break;
				}
			}
		});
		cbbCountries.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		cbbCountries.setModel(new DefaultComboBoxModel(Country.values()));
		cbbCountries.setBounds(182, 72, 141, 32);
		contentPane.add(cbbCountries);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Country country = (Country) cbbCountries.getSelectedItem();
				Object spot = cbbSpots.getSelectedItem();
				if (spot instanceof US) {
					spot = (US) spot;
				}else if(spot instanceof UK) {
					spot = (UK) spot;
				}else {
					spot = (Taiwan) spot;
				}
				String text = country + " " + spot;
				taResult.setText(text);
			}
		});
		btSubmit.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		btSubmit.setBounds(343, 127, 127, 32);
		contentPane.add(btSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 198, 417, 198);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		taResult.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taResult);
		
		cbbSpots = new JComboBox();
		cbbSpots.setModel(new DefaultComboBoxModel(US.values()));
		cbbSpots.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		cbbSpots.setBounds(182, 129, 141, 29);
		contentPane.add(cbbSpots);
		
		lblNewLabel_1 = new JLabel("Country");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(86, 72, 66, 32);
		contentPane.add(lblNewLabel_1);
		
		lbSpots = new JLabel("Spots");
		lbSpots.setHorizontalAlignment(SwingConstants.CENTER);
		lbSpots.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lbSpots.setBounds(86, 127, 66, 32);
		contentPane.add(lbSpots);
	}
}
