package ex4_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox cbbSeason;
	private JButton btSubmit;
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
		setTitle("Ex-2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbbSeason = new JComboBox();
		cbbSeason.setFont(new Font("新細明體", Font.PLAIN, 16));
		cbbSeason.setModel(new DefaultComboBoxModel(new String[] {"\u6625", "\u590F", "\u79CB", "\u51AC"}));
		cbbSeason.setBounds(106, 59, 145, 34);
		contentPane.add(cbbSeason);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cbbSeason.getSelectedIndex();
				String text = "";
				switch (index) {
				case 0:
					text = "春暖花開";
					break;
				case 1:
					text = "夏日炎炎";
					break;
				case 2:
					text = "秋高氣爽";
					break;
				case 3:
					text = "東風凜冽";
					break;
				default:
					break;
				}
				taResult.setText(text);
			}
		});
		btSubmit.setFont(new Font("新細明體", Font.PLAIN, 14));
		btSubmit.setBounds(288, 59, 128, 34);
		contentPane.add(btSubmit);
		
		taResult = new JTextArea();
		taResult.setBounds(92, 142, 368, 152);
		contentPane.add(taResult);
	}
}
