import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField queuesize;
	private JTextField element;
	private JTextField displaybox;
	private int size;
	private int q[];
	private int f = 0;
	private int r = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
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
	public Queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(171, 224, 174));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUEUE DATA STRUCTURE");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(297, 23, 236, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER QUEUE SIZE  :");
		lblNewLabel_1.setForeground(new Color(0, 0, 64));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1.setBounds(54, 97, 172, 21);
		contentPane.add(lblNewLabel_1);

		queuesize = new JTextField();
		queuesize.setBounds(260, 96, 144, 19);
		contentPane.add(queuesize);
		queuesize.setColumns(10);

		JButton create = new JButton("CREATE QUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create queue code
				size = Integer.valueOf(queuesize.getText());
				q = new int[size];
				String msg = "queue of size " + size + " Created";
				JOptionPane.showMessageDialog(contentPane, msg);

			}
		});
		create.setForeground(new Color(255, 128, 64));
		create.setFont(new Font("Constantia", Font.BOLD, 17));
		create.setBounds(337, 154, 163, 29);
		contentPane.add(create);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT  :");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(54, 239, 181, 21);
		contentPane.add(lblNewLabel_1_1);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(260, 238, 144, 19);
		contentPane.add(element);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert code
				int elem;
				if (r == size - 1) {
					JOptionPane.showMessageDialog(contentPane, "Insertion not Possible");
				} else {

					elem = Integer.valueOf(element.getText());
					++r;
					q[r] = elem;
					JOptionPane.showMessageDialog(contentPane, "Insertion successfull");
					element.setText("");

				}
			}
		});
		insert.setForeground(new Color(255, 0, 0));
		insert.setFont(new Font("Constantia", Font.BOLD, 17));
		insert.setBounds(581, 228, 125, 29);
		contentPane.add(insert);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete code
				if (r == -1 || f > r) {
					JOptionPane.showMessageDialog(contentPane, "deletion not Possible");
				} else {
//					String msg="delete the element at :" + q[f];
					JOptionPane.showMessageDialog(contentPane, "delete the element at :" + q[f]);
					++f;
				}
			}
		});
		delete.setForeground(new Color(128, 0, 0));
		delete.setFont(new Font("Constantia", Font.BOLD, 17));
		delete.setBounds(320, 309, 180, 29);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display code
				String msg = "";
				if (r == -1 || f > r) {
					JOptionPane.showMessageDialog(contentPane, "display not Possible");
				} else {
					for (int i = f; i <= r; i++) {
						msg = msg + " " + q[i];

					}
					displaybox.setText(msg);
				}
			}
		});
		display.setForeground(new Color(128, 128, 255));
		display.setFont(new Font("Constantia", Font.BOLD, 17));
		display.setBounds(320, 362, 180, 29);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBounds(78, 405, 628, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}

}
