import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField stacksize;
	private JTextField displaybox;
	private JTextField element;
	private int s[];
	private int size;
	private int top = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(215, 184, 104));
		contentPane.setForeground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("STACK DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setBounds(179, 25, 225, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER THE STACK SIZE  :");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 16));
		lblNewLabel_1.setBounds(26, 81, 195, 20);
		contentPane.add(lblNewLabel_1);

		stacksize = new JTextField();
		stacksize.setBounds(246, 81, 114, 20);
		contentPane.add(stacksize);
		stacksize.setColumns(10);

		JButton createstack = new JButton("CREATE STACK");
		createstack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// stack creation code
				size = Integer.valueOf(stacksize.getText());
				s = new int[size];
				String msg = "Stack of size " + size + " Created";
				JOptionPane.showMessageDialog(contentPane, msg);
			}
		});
		createstack.setForeground(new Color(255, 128, 64));
		createstack.setFont(new Font("Constantia", Font.BOLD, 16));
		createstack.setBounds(246, 127, 149, 29);
		contentPane.add(createstack);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT  :");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(26, 211, 187, 20);
		contentPane.add(lblNewLabel_1_1);

		JButton push = new JButton("PUSH");
		push.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// push code
				int elem;
				if (top == size - 1) {
					JOptionPane.showMessageDialog(contentPane, "push not possible");
				} else {
					elem = Integer.valueOf(element.getText());
					++top;
					s[top] = elem;
					JOptionPane.showMessageDialog(contentPane, "push successfull");
					element.setText("");
				}
			}
		});
		push.setForeground(new Color(255, 128, 64));
		push.setFont(new Font("Constantia", Font.BOLD, 16));
		push.setBounds(453, 209, 77, 29);
		contentPane.add(push);

		JButton pop = new JButton("POP");
		pop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// pop code
				if (top == -1) {
					JOptionPane.showMessageDialog(contentPane, "pop not possible");
				} else {
					String msg = "element deleted is " + s[top];
					JOptionPane.showMessageDialog(contentPane, msg);
					--top;
				}
			}
		});
		pop.setForeground(new Color(255, 128, 64));
		pop.setFont(new Font("Constantia", Font.BOLD, 16));
		pop.setBounds(246, 270, 67, 29);
		contentPane.add(pop);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display code
				String msg = "";
				if (top == -1) {
					JOptionPane.showMessageDialog(contentPane, "display not possible");
				} else {
					for (int i = top; i >= 0; i--) {
						msg = msg + " " + s[i];

					}
					displaybox.setText(msg);
				}
			}
		});
		display.setForeground(new Color(255, 128, 64));
		display.setFont(new Font("Constantia", Font.BOLD, 16));
		display.setBounds(246, 328, 101, 29);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(128, 128, 128));
		displaybox.setBounds(38, 388, 492, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);

		element = new JTextField();
		element.setColumns(10);
		element.setBounds(246, 211, 138, 21);
		contentPane.add(element);
	}
}
