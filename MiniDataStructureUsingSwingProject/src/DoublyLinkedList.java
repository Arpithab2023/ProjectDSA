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

public class DoublyLinkedList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ele1;
	private JTextField ele2;
	private JTextField displaybox;
	private Node head;

	private static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
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
	public DoublyLinkedList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DOUBLYLINKEDLIST DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 19));
		lblNewLabel.setBounds(225, 22, 355, 26);
		contentPane.add(lblNewLabel);

		ele1 = new JTextField();
		ele1.setBounds(303, 89, 191, 21);
		contentPane.add(ele1);
		ele1.setColumns(10);

		ele2 = new JTextField();
		ele2.setColumns(10);
		ele2.setBounds(303, 152, 191, 24);
		contentPane.add(ele2);

		displaybox = new JTextField();
		displaybox.setBackground(new Color(242, 189, 216));
		displaybox.setForeground(new Color(255, 255, 255));
		displaybox.setBounds(55, 553, 653, 19);
		contentPane.add(displaybox);
		displaybox.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT  :");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1.setBounds(86, 90, 191, 21);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT  :");
		lblNewLabel_1_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1_1.setFont(new Font("Constantia", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(86, 155, 191, 21);
		contentPane.add(lblNewLabel_1_1);

		JButton insertrear = new JButton("INSERT REAR");
		insertrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int data = Integer.parseInt(ele1.getText());
				insertRear(data);
			}
		});

		insertrear.setForeground(new Color(0, 64, 128));
		insertrear.setFont(new Font("Constantia", Font.BOLD, 17));
		insertrear.setBounds(581, 75, 143, 29);
		contentPane.add(insertrear);

		JButton insertfront = new JButton("INSERT FRONT");
		insertfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int data = Integer.parseInt(ele2.getText());
				insertFront(data);
			}
		});

		insertfront.setForeground(new Color(128, 0, 255));
		insertfront.setFont(new Font("Constantia", Font.BOLD, 17));
		insertfront.setBounds(581, 150, 155, 29);
		contentPane.add(insertfront);

		JButton delrear = new JButton("DELETE REAR");
		delrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRear();
			}
		});

		delrear.setForeground(new Color(154, 5, 50));
		delrear.setFont(new Font("Constantia", Font.BOLD, 17));
		delrear.setBounds(320, 290, 155, 29);
		contentPane.add(delrear);

		JButton delfront = new JButton("DELETE FRONT");
		delfront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFront();
			}
		});

		delfront.setForeground(new Color(255, 0, 255));
		delfront.setFont(new Font("Constantia", Font.BOLD, 17));
		delfront.setBounds(320, 361, 159, 29);
		contentPane.add(delfront);

		JButton displayforw = new JButton("DISPLAY FORWARD");

		displayforw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayForward();
			}
		});
		displayforw.setForeground(new Color(255, 128, 128));
		displayforw.setFont(new Font("Constantia", Font.BOLD, 17));
		displayforw.setBounds(122, 465, 195, 29);
		contentPane.add(displayforw);

		JButton displayrev = new JButton("DISPLAY REVERSE");
		displayrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayReverse();
			}
		});

		displayrev.setForeground(new Color(128, 128, 192));
		displayrev.setFont(new Font("Constantia", Font.BOLD, 17));
		displayrev.setBounds(553, 465, 183, 29);
		contentPane.add(displayrev);
	}

	// Methods for Doubly Linked List Operations

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
			newNode.prev = temp;
		}
		displayMessage("Element " + data + " inserted at the rear.");
		ele1.setText("");
		ele2.setText("");
	}

	// Insert an element at the front of the linked list
	private void insertFront(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
		displayMessage("Element " + data + " inserted at the front.");
		ele1.setText("");
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
		if (head != null) {
			head.prev = null;
		}
	}

	// Display the linked list in forward direction
	private void displayForward() {
		if (head == null) {
			JOptionPane.showMessageDialog(contentPane, "Display not possible. The list is empty.");
		} else {
			StringBuilder result = new StringBuilder();
			Node temp = head;
			while (temp != null) {
				result.append(temp.data).append(" ");
				temp = temp.next;
			}
			displayMessage(result.toString());
		}
	}

	// Display the linked list in reverse direction
	private void displayReverse() {
		if (head == null) {
			JOptionPane.showMessageDialog(contentPane, "Display not possible. The list is empty.");
		} else {
			StringBuilder result = new StringBuilder();
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			while (temp != null) {
				result.append(temp.data).append(" ");
				temp = temp.prev;
			}
			displayMessage(result.toString());
		}
	}

	// Display a message in the displaybox
	private void displayMessage(String message) {
		JOptionPane.showMessageDialog(contentPane, message);
		displaybox.setText(message);
	}
}