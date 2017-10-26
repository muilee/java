package ex12_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblLatitude;
	private JLabel lblLongitude;
	private JTextField tfStation;
	private JTextField tfLatitude;
	private JTextField tfLongitude;
	private JButton btAdd;
	private JScrollPane scrollPane;
	private JTextArea taAdd;
	private JLabel lblBegin;
	private JLabel lblEnd;
	private JButton btSearch;
	private JScrollPane scrollPane_1;
	private JTextArea taSearch;
	private JSeparator separator;
	private TreeSet<Station> stations = new TreeSet<Station>();
	private JComboBox cbbBegin;
	private JComboBox cbbEnd;
	private TreeSet<Station> subSet;
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
		setTitle("Ex12-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Station");
		lblNewLabel.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 61, 68, 27);
		contentPane.add(lblNewLabel);
		
		lblLatitude = new JLabel("Latitude");
		lblLatitude.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblLatitude.setBounds(49, 103, 68, 27);
		contentPane.add(lblLatitude);
		
		lblLongitude = new JLabel("Longitude");
		lblLongitude.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblLongitude.setBounds(49, 147, 68, 27);
		contentPane.add(lblLongitude);
		
		tfStation = new JTextField();
		tfStation.setBounds(127, 61, 127, 30);
		contentPane.add(tfStation);
		tfStation.setColumns(10);
		
		tfLatitude = new JTextField();
		tfLatitude.setColumns(10);
		tfLatitude.setBounds(127, 106, 127, 30);
		contentPane.add(tfLatitude);
		
		tfLongitude = new JTextField();
		tfLongitude.setColumns(10);
		tfLongitude.setBounds(127, 150, 127, 30);
		contentPane.add(tfLongitude);
		
		btAdd = new JButton("Add");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfStation.getText();
				double lalitude = Double.valueOf(tfLatitude.getText());
				double longitude = Double.valueOf(tfLongitude.getText());
				stations.add(new Station(name, lalitude, longitude));
				String text = "";
				cbbBegin.removeAllItems();
				cbbEnd.removeAllItems();
				for(Station station : stations) {
					text += station.name + "\blalitude" + station.latitude + "\n";
					cbbBegin.addItem(station);
					cbbEnd.addItem(station);
				}
				taAdd.setText(text);
				tfStation.setText(null);
				tfLatitude.setText(null);
				tfLongitude.setText(null);
			}
		});
		btAdd.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		btAdd.setBounds(273, 149, 108, 31);
		contentPane.add(btAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 202, 344, 210);
		contentPane.add(scrollPane);
		
		taAdd = new JTextArea();
		taAdd.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(taAdd);
		
		lblBegin = new JLabel("Begin");
		lblBegin.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblBegin.setBounds(430, 61, 68, 27);
		contentPane.add(lblBegin);
		
		lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		lblEnd.setBounds(430, 103, 68, 27);
		contentPane.add(lblEnd);
		
		btSearch = new JButton("Search");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Station begin = (Station) cbbBegin.getSelectedItem();
				Station end = (Station) cbbEnd.getSelectedItem();
				String text = "";
				double number = begin.latitude - end.latitude;
				if(number >= 0) {
					subSet = (TreeSet<Station>) stations.subSet(begin, true,  end, true);
					for(Station station : subSet) {
						text += station.name + "\blalitude" + station.latitude + "\n";
					}
				}else {
					subSet = (TreeSet<Station>) stations.subSet(end, true,  begin, true);
					for(Station station : subSet) {
						text = station.name + "\blalitude" + station.latitude + "\n" + text;
					}
				}
				taSearch.setText(text);
			}
		});
		btSearch.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		btSearch.setBounds(664, 103, 108, 31);
		contentPane.add(btSearch);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(430, 202, 344, 210);
		contentPane.add(scrollPane_1);
		
		taSearch = new JTextArea();
		taSearch.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane_1.setViewportView(taSearch);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBounds(406, 27, 2, 387);
		contentPane.add(separator);
		
		cbbBegin = new JComboBox();
		cbbBegin.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		cbbBegin.setBounds(508, 61, 127, 30);
		contentPane.add(cbbBegin);
		
		cbbEnd = new JComboBox();
		cbbEnd.setFont(new Font("�s�ө���", Font.PLAIN, 14));
		cbbEnd.setBounds(508, 106, 127, 30);
		contentPane.add(cbbEnd);
	}
}
