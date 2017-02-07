import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumLinkList extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	JButton[] buttons;
	JTextField input;
	JTextArea output;
	JLabel count;
	
	int n = 0;

	public static void main(String[] args) 
	{
		NumStore ns = new NumStore();
		ns.setVisible(true);
	}
	
	public NumLinkList() 
	{
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
		for (int i = 0; i < butLabels.length; i++) 
		{
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
	
	public void actionPerformed(ActionEvent e)
	{
		int x;
		JButton button = (JButton) e.getSource();
		try
		{
			x = Integer.parseInt(input.getText());
		} 
		catch (NumberFormatException ex) 
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please input an integer");
			return;
		} 
		finally 
		{
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
	
	void point()
	{
		String str = "";
		for (int i = 0; i < n; i++)
		{
			
		}
		output.setText(str);
		output.validate();
	}
}

class Node
{
	public int value;
	Node previous = null;
	Node next = null;
	public Node(int value)
	{
		this.value = value;
	}
}