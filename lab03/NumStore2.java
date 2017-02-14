import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Node {
	public int value;
	public Node next;
	
	public Node(int value) {
		this.value = value;
		next = null;
	}
}

public class NumStore2 extends JFrame implements ActionListener {
	JButton[] buttons;
	JTextField input;
	JTextArea output;
	JLabel count;

	//int[] A = new int[10];
	Node head = new Node(-1);	// head node is not for storing data
	int n = 0;

	public NumStore2() {
		super("NumStore");
		this.setSize(320, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.NORTH);

		input = new JTextField();
		input.setPreferredSize(new Dimension(50, 28));
		panel.add(input);

		String[] butLabels = { "Insert", "Delete", "Find" };
		buttons = new JButton[butLabels.length];
		for (int i = 0; i < butLabels.length; i++) {
			buttons[i] = new JButton(butLabels[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}

		output = new JTextArea();
		output.setEditable(false);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		this.add(output, BorderLayout.CENTER);
		
		count = new JLabel("Count: 0");
		this.add(count, BorderLayout.SOUTH);
		
	}

	public void actionPerformed(ActionEvent e) {
		int x;
		JButton button = (JButton) e.getSource();
		try {
			x = Integer.parseInt(input.getText());


		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please input an integer");
			return;
		} finally {
			input.setText("");
			input.requestFocus();
		}


		if (button == buttons[0]){
			insert(x);
			print();
		} else if (button == buttons[1]) {
			delete(x);
			print();
		} else if (button == buttons[2]) {
			int p = find(x);
			if (p >= 0)
				JOptionPane.showMessageDialog(null, "The number " + x + " is in the position " + p);
			else
				JOptionPane.showMessageDialog(null, "The number " + x + " is not in the storage!");
		}
		
		count.setText("Count: " + n);
	}

	void print() {
		String str = "";
		/*
		for (int i = 0; i < n; i++)
			str += (A[i] + "\t");
		*/
		
		Node theNode = head.next;
		while(theNode != null) {
			str += (theNode.value + "\t");
			theNode = theNode.next;
		}
		
		output.setText(str);
		output.validate();
	}

	void insert(int x) {
		/*
		if (n < A.length) {
			shiftRight(0);
			A[0] = x;
		}
		*/
		Node theNode = new Node(x);
		theNode.next = head.next;
		head.next = theNode;
		n++;
	}

	void delete(int x) {
		/*
		for (int i = 0; i < n; i++) {
			if (A[i] == x)
				shiftLeft(i + 1);
		}
		*/
		Node prevNode = head;
		while(prevNode.next != null && prevNode.next.value != x)
			prevNode = prevNode.next;
		
		if(prevNode.next != null) {
			prevNode.next = prevNode.next.next;
			n--;
		}
	}

	/*
	void shiftLeft(int p) {
		for (int i = p; i < n; i++)
			A[i - 1] = A[i];
		n--;
	}
	
	void shiftRight(int p) {
		for (int i=n; i>0; i--)
			A[i] = A[i-1];
		n++;
	}
	*/
	
	int find(int x) {
		int p = -1;
		/*
		for (int i = 0; i < n; i++)
			if (A[i] == x) {
				p = i;
				break;
			}
		*/
		Node theNode = head.next;
		for(int i=0; i<n; i++) {
			if (theNode.value == x) {
				p = i;
				break;
			}
			theNode = theNode.next;
		}
		return p;
	}

	public static void main(String[] args) {
		NumStore2 ns = new NumStore2();
		ns.setVisible(true);
	}
}
