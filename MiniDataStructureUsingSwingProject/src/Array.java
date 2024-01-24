import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Array extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField length;
	private JTextField insertposition;
	private JTextField element;
	private JTextField deleteposition;
	private JTextField displaybox;
	private int arr[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() {
		setBackground(new Color(192, 192, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(182, 39, 25, -10);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ARRAY DATA STRUCTURE");
		lblNewLabel_1.setFont(new Font("Algerian", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(224, 10, 203, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ENTER ARRAY LENGTH");
		lblNewLabel_2.setForeground(new Color(64, 0, 128));
		lblNewLabel_2.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_2.setBounds(197, 55, 162, 18);
		contentPane.add(lblNewLabel_2);

		length = new JTextField();
		length.setBounds(379, 53, 203, 19);
		contentPane.add(length);
		length.setColumns(10);

		JButton create = new JButton("CREATE ARRAY");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for creating array
				// String len=length.getText();
				// int l=Integer.valueOf(len);
				// OR
				int len = Integer.valueOf(length.getText());
				arr = new int[len];
				String message = "Array of length " + len + " Created";
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		create.setForeground(new Color(0, 64, 64));
		create.setFont(new Font("Constantia", Font.BOLD, 14));
		create.setBounds(292, 83, 141, 27);
		contentPane.add(create);

		JLabel lblNewLabel_2_1 = new JLabel("ENTER AN INTEGER ELEMENT");
		lblNewLabel_2_1.setForeground(new Color(64, 0, 128));
		lblNewLabel_2_1.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 158, 210, 18);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("POSITION");
		lblNewLabel_2_1_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_2_1_1.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(354, 158, 73, 18);
		contentPane.add(lblNewLabel_2_1_1);

		insertposition = new JTextField();
		insertposition.setBounds(428, 156, 96, 19);
		contentPane.add(insertposition);
		insertposition.setColumns(10);

		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for insertion
				int elem=Integer.valueOf(element.getText());
				int pos=Integer.valueOf(insertposition.getText());
				arr[pos]=elem;
				String message="Element "+elem+" Inserted @ position "+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				element.setText("");
				insertposition.setText("");
			}
		});
		insert.setForeground(new Color(0, 128, 255));
		insert.setFont(new Font("Constantia", Font.BOLD, 14));
		insert.setBounds(565, 154, 85, 27);
		contentPane.add(insert);

		element = new JTextField();
		element.setBounds(224, 156, 96, 19);
		contentPane.add(element);
		element.setColumns(10);

		JLabel lblNewLabel_2_1_2 = new JLabel("ENTER THE POSITION TO DELETE");
		lblNewLabel_2_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1_2.setFont(new Font("Constantia", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(10, 235, 238, 18);
		contentPane.add(lblNewLabel_2_1_2);

		deleteposition = new JTextField();
		deleteposition.setColumns(10);
		deleteposition.setBounds(263, 233, 96, 19);
		contentPane.add(deleteposition);

		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for deletion
				int pos=Integer.valueOf(deleteposition.getText());
				arr[pos]=0;
				String msg="Element deleted @ the position"+pos;
				JOptionPane.showMessageDialog(contentPane, msg);
				deleteposition.setText("");
			}
		});
		delete.setForeground(new Color(0, 128, 255));
		delete.setFont(new Font("Constantia", Font.BOLD, 14));
		delete.setBounds(454, 231, 87, 27);
		contentPane.add(delete);

		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for display
				String msg="";
				for(int i=0;i<=arr.length-1;i++) 
				{
					msg=msg+" "+arr[i];
				}
				displaybox.setText(msg);
			}
		});
		display.setForeground(new Color(0, 128, 255));
		display.setFont(new Font("Constantia", Font.BOLD, 14));
		display.setBounds(334, 307, 93, 27);
		contentPane.add(display);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(255, 128, 128));
		displaybox.setBounds(94, 359, 504, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}
}
