import java.io.IOException;

public class Stack {
	int[] arr = null;
	int top = -1;
	public Stack(int size) 
	{
		arr = new int[size];
	}
	public void push(int v) throws IOException
	{
		if (top == arr.length - 1)
			throw new IOException("Stack is full");
		top++;
		arr[top] = v;
	}
	public void push(int...a) throws IOException
	{
		for (int i=0; i<a.length; i++) 
			push(a[i]);
	}
	public int pop() throws IOException 
	{
		int v = 0;
		if (top == -1)
			throw new IOException("Stack is empty");
		v = arr[top];
		top--;
		return v;
	}
	public int top() throws IOException 
	{
		if (top == -1)
			throw new IOException("Stack is empty");
		return arr[top];
	}
	public boolean isEmpty() 
	{
		return top == -1;
	}
	public boolean isFull() 
	{
		return top == arr.length - 1;
	}
	public void printArray() 
	{
		System.out.println("The numbers stored in the array: ");
		for (int i=0; i<=top; i++)
			System.out.print(arr[i] + "\t");
		System.out.println("\n");
	}
	public static void main(String[] args) throws IOException
	{
		Stack stack = new Stack(10);
		System.out.println("Empty? " + stack.isEmpty());
		System.out.println("Full? " + stack.isFull());
		stack.push(4, 7, 10, 22, 57, 81, 96);
		System.out.println("Empty? " + stack.isEmpty());
		System.out.println("Full? " + stack.isFull());
		stack.printArray();
		for (int i=0; i<3; i++)
			System.out.println("Pop: " + stack.pop());
		stack.push(1, 2);
		System.out.println("Top: " + stack.top());
		stack.printArray();
	}
}
