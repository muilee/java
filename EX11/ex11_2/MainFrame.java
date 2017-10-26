package ex11_2;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField tfBirth;
	private JTextField tfOld;
	private JLabel lbBirth;
	private JLabel lbOld;

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
		setTitle("ex11_2");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 294);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("\u751F\u65E5");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 75, 90, 33);
		contentPane.add(lblNewLabel);
		
		label = new JLabel("\u5E74\u7D00");
		label.setFont(new Font("新細明體", Font.PLAIN, 14));
		label.setBounds(49, 145, 90, 36);
		contentPane.add(label);
		
		tfBirth = new JTextField();
		tfBirth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String birth = tfBirth.getText();
				String regex = "(19\\d{2}|20(0\\d|1[0-4]))-(1[0-2]|[1-9])-(([1-2][0-9]|3[01])|[1-9])";
				if(birth.matches(regex)) {
					lbBirth.setText("格式正確");
				}else {
					lbBirth.setText("格式錯誤");
				}
			}
		});
		tfBirth.setBounds(160, 74, 214, 36);
		contentPane.add(tfBirth);
		tfBirth.setColumns(10);
		
		tfOld = new JTextField();
		tfOld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String birth = tfOld.getText();
				String regex = "120|((1[01]\\d|[1-9]\\d|\\d)(\\.\\d+)?)";
				if(birth.matches(regex)) {
					lbOld.setText("格式正確");
				}else {
					lbOld.setText("格式錯誤");
				}
				

			}
		});
		tfOld.setColumns(10);
		tfOld.setBounds(160, 146, 214, 36);
		contentPane.add(tfOld);
		
		lbBirth = new JLabel("");
		lbBirth.setFont(new Font("新細明體", Font.PLAIN, 14));
		lbBirth.setBounds(425, 75, 107, 33);
		contentPane.add(lbBirth);
		
		lbOld = new JLabel("");
		lbOld.setFont(new Font("新細明體", Font.PLAIN, 14));
		lbOld.setBounds(425, 147, 107, 33);
		contentPane.add(lbOld);
	}
}
