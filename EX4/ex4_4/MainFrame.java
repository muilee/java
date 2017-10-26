package ex4_4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfDislike;
	private JButton bfSubmit;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Dislike");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 14));
		lblNewLabel.setBounds(98, 69, 53, 23);
		contentPane.add(lblNewLabel);
		
		tfDislike = new JTextField();
		tfDislike.setBounds(164, 66, 149, 28);
		contentPane.add(tfDislike);
		tfDislike.setColumns(10);
		
		bfSubmit = new JButton("Submit");
		bfSubmit.setFont(new Font("新細明體", Font.PLAIN, 14));
		bfSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dislike = Integer.valueOf(tfDislike.getText());
				String s = "";
				int counter = 0;
				for (int i = 1; i <= 49; i++) {
					int quotient = i / 10;
					int remainder = i % 10;
					if (quotient == dislike || remainder == dislike) {
						continue;
					}
					counter++;
					if (i < 10) {
						s += "0";
					}
					s += i + " ";
					if (counter % 9 == 0) {
						s += "\n";
					}
				}
				s += "\n總個數 = " + counter;
				taResult.setText(s);
			}
		});
		bfSubmit.setBounds(335, 66, 87, 28);
		contentPane.add(bfSubmit);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 132, 394, 213);
		contentPane.add(scrollPane);
		
		taResult = new JTextArea();
		scrollPane.setViewportView(taResult);
	}

}
