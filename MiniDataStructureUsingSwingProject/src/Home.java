import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setFont(new Font("Algerian", Font.BOLD, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE A DATASTRUCTURE");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 14));
		lblNewLabel.setBounds(120, 10, 194, 19);
		contentPane.add(lblNewLabel);
		
		JButton array = new JButton("ARRAY");
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE ARRAY WINDOW OPENING CODE HERE
//				Array a=new Array();
//				a.setVisible(true);
				//OR
				new Array().setVisible(true);
			}
		});
		array.setForeground(Color.MAGENTA);
		array.setFont(new Font("Constantia", Font.BOLD, 12));
		array.setBounds(181, 50, 73, 23);
		contentPane.add(array);
		
		JButton stack = new JButton("STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE STACK WINDOW OPENING CODE HERE
				new Stack().setVisible(true);
			}
		});
		stack.setForeground(new Color(128, 0, 64));
		stack.setFont(new Font("Constantia", Font.BOLD, 12));
		stack.setBounds(54, 107, 71, 23);
		contentPane.add(stack);
		
		JButton queue = new JButton("QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE QUEUE WINDOW OPENING CODE HERE
				new Queue().setVisible(true);
			}
		});
		queue.setForeground(new Color(0, 0, 255));
		queue.setFont(new Font("Constantia", Font.BOLD, 12));
		queue.setBounds(312, 106, 75, 23);
		contentPane.add(queue);
		
		JButton sll = new JButton("SINGLY LINKEDLIST");
		sll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE SINGLY LINKEDLIST WINDOW OPENING CODE HERE
				new SinglyLinkedList().setVisible(true);
			}
		});
		sll.setForeground(new Color(0, 64, 128));
		sll.setFont(new Font("Constantia", Font.BOLD, 12));
		sll.setBounds(262, 177, 151, 23);
		contentPane.add(sll);
		
		JButton cqueue = new JButton("CIRCULARQUEUE");
		cqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE CIRCULARQUEUE WINDOW OPENING CODE HERE
				new CircularQueue().setVisible(true);
			}
		});
		cqueue.setForeground(new Color(0, 128, 255));
		cqueue.setFont(new Font("Constantia", Font.BOLD, 12));
		cqueue.setBounds(54, 177, 139, 23);
		contentPane.add(cqueue);
		
		JButton dll = new JButton("DOUBLY LINKEDLIST");
		dll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PLACE DOUBLY LINKEDLIST WINDOW OPENING CODE HERE
				new DoublyLinkedList().setVisible(true);
			}
		});
		dll.setForeground(new Color(128, 0, 128));
		dll.setFont(new Font("Constantia", Font.BOLD, 12));
		dll.setBounds(149, 230, 159, 23);
		contentPane.add(dll);
	}
}
