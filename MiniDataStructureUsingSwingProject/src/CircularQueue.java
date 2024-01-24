import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CircularQueue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField displaybox;
	private JTextField cqsize;
	private JTextField element;
	private int size;
	private int f = 0;
	private int count = 0;
	private int r = -1;
	private int cq[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(249, 172, 174));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CIRCULARQUEUE DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		lblNewLabel.setBounds(210, 24, 330, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER QUEUE SIZE  :");
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(0, 64, 64));
		lblNewLabel_1.setBounds(36, 115, 172, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTER AN ELEMENT  :");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(36, 280, 181, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JButton create = new JButton("CREATE CIRCULARQUEUE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create circularqueue code
				size = Integer.valueOf(cqsize.getText());
				cq = new int[size];
				String msg = "circularqueue of size " + size + " Created";
				JOptionPane.showMessageDialog(contentPane, msg);
			}
		});
		create.setForeground(new Color(0, 0, 255));
		create.setFont(new Font("Constantia", Font.BOLD, 17));
		create.setBounds(269, 180, 249, 29);
		contentPane.add(create);
		
		JButton insert = new JButton("INSERT");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert code
				int elem;
				if (count == size) {
					JOptionPane.showMessageDialog(contentPane, "insertion not possible");
				} else {
					elem=Integer.valueOf(element.getText());
					r = (r + 1) % size;
					cq[r] = elem;
					count++;
					JOptionPane.showMessageDialog(contentPane, "Insertion Successfull");
					element.setText("");
				}
			}
		});
		insert.setForeground(Color.BLUE);
		insert.setFont(new Font("Constantia", Font.BOLD, 17));
		insert.setBounds(538, 259, 123, 29);
		contentPane.add(insert);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete code
				if (count == 0) {
					JOptionPane.showMessageDialog(contentPane, "delete not possible");
				} else {
					JOptionPane.showMessageDialog(contentPane, "deleted element is:" + cq[f]);
					f = (f + 1) % size;
					count--;
				}
			}
		});
		delete.setForeground(new Color(255, 0, 0));
		delete.setFont(new Font("Constantia", Font.BOLD, 17));
		delete.setBounds(294, 371, 149, 29);
		contentPane.add(delete);
		
		JButton display = new JButton("DISPLAY");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display code
				int f1 = f;
				String msg="";
				if (count == 0) {
					JOptionPane.showMessageDialog(contentPane, "display not possible");
				} else {
					for (int i = 0; i < count; i++) {
//						JOptionPane.showMessageDialog(contentPane,msg+cq[i] + " ");
						 msg += cq[f1] + " ";
						f1 = (f1 + 1) % size;
						
					}
					displaybox.setText(msg);
				}
			}
		});
		display.setForeground(new Color(64, 0, 128));
		display.setFont(new Font("Constantia", Font.BOLD, 17));
		display.setBounds(294, 425, 155, 29);
		contentPane.add(display);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(128, 255, 255));
		displaybox.setBounds(62, 497, 585, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		cqsize = new JTextField();
		cqsize.setBounds(258, 115, 96, 19);
		contentPane.add(cqsize);
		cqsize.setColumns(10);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(258, 280, 96, 19);
		contentPane.add(element);
	}

}
