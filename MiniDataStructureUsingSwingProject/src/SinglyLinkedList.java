import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.Node;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SinglyLinkedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ele1;
	private JTextField ele2;
	private JTextField displaybox;
	private Node head;

	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
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
	public SinglyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SINGLYLINKEDLIST DATA STRUCTURE");
		lblNewLabel.setBackground(new Color(154, 5, 50));
		lblNewLabel.setBounds(164, 10, 354, 29);
		lblNewLabel.setForeground(new Color(154, 5, 50));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT  :");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1.setBounds(39, 86, 191, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT  :");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(39, 174, 191, 21);
		contentPane.add(lblNewLabel_1_1);

		ele1 = new JTextField();
		ele1.setBounds(268, 75, 113, 26);
		contentPane.add(ele1);
		ele1.setColumns(10);

		ele2 = new JTextField();
		ele2.setColumns(10);
		ele2.setBounds(268, 162, 113, 26);
		contentPane.add(ele2);

		JButton insertrear = new JButton("INSERT REAR");
		insertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int data = Integer.parseInt(ele1.getText());
				insertRear(data); // Correct method name
			}
		});
		insertrear.setForeground(new Color(255, 128, 192));
		insertrear.setFont(new Font("Constantia", Font.BOLD, 17));
		insertrear.setBounds(446, 74, 191, 29);
		contentPane.add(insertrear);

		JButton insertfront = new JButton("INSERT FRONT");
		insertfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// insert front code
				int data = Integer.parseInt(ele2.getText());
				insertFront(data);
			}
		});
		insertfront.setForeground(new Color(128, 128, 128));
		insertfront.setFont(new Font("Constantia", Font.BOLD, 17));
		insertfront.setBounds(457, 152, 180, 29);
		contentPane.add(insertfront);

		JButton btnDeleteRear = new JButton("DELETE REAR");
		btnDeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete rear code
				deleteRear();
			}
		});
		btnDeleteRear.setForeground(new Color(64, 0, 0));
		btnDeleteRear.setFont(new Font("Constantia", Font.BOLD, 17));
		btnDeleteRear.setBounds(245, 250, 180, 29);
		contentPane.add(btnDeleteRear);

		JButton insertfront_1_1 = new JButton("DELETE FRONT");
		insertfront_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete front code
				deleteFront();
			}
		});
		insertfront_1_1.setForeground(new Color(0, 128, 64));
		insertfront_1_1.setFont(new Font("Constantia", Font.BOLD, 17));
		insertfront_1_1.setBounds(245, 307, 180, 29);
		contentPane.add(insertfront_1_1);

		JButton insertfront_1_1_1 = new JButton("DISPLAY");
		insertfront_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display code
				display();

			}
		});
		insertfront_1_1_1.setForeground(new Color(0, 128, 192));
		insertfront_1_1_1.setFont(new Font("Constantia", Font.BOLD, 17));
		insertfront_1_1_1.setBounds(245, 362, 180, 29);
		contentPane.add(insertfront_1_1_1);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(242, 189, 216));
		displaybox.setBounds(54, 424, 565, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
	}
	// Methods for Singly Linked List Operations

	// Insert an element at the rear of the linked list
	private void insertRear(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		displayMessage("Element " + data + " inserted at the rear.");
		ele1.setText("");
	}

	// Insert an element at the front of the linked list
	private void insertFront(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		displayMessage("Element " + data + " inserted at the front.");
		ele2.setText("");
	}

	// Delete an element from the rear of the linked list
	private void deleteRear() {
		if (head == null) {
			displayMessage("Deletion not possible. The list is empty.");
			return;
		}

		if (head.next == null) {
			displayMessage("Deleted element: " + head.data + ". List is now empty.");
			head = null;
			return;
		}

		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		displayMessage("Deleted element: " + temp.next.data + " from the rear.");
		temp.next = null;
	}

	// Delete an element from the front of the linked list
	private void deleteFront() {
		if (head == null) {
			displayMessage("Deletion not possible. The list is empty.");
			return;
		}

		displayMessage("Deleted element: " + head.data + " from the front.");
		head = head.next;
	}

	// Display the linked list
	private void display() {
		if (head == null) {
			JOptionPane.showMessageDialog(contentPane, "Display not possible. The list is empty.");
		} else {
			StringBuilder result = new StringBuilder();
			Node temp = head;
			while (temp != null) {
				result.append(temp.data).append(" ");
				temp = temp.next;
			}
			result.append("");
			displayMessage(result.toString());
		}
	}

	// Display a message in the displaybox
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(contentPane, message);
		displaybox.setText(message);
	}
}