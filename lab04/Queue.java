import java.io.IOException;

public class Queue {
	int[] arr;
	int first = 1;
	int last = 0;
	int count = 0;
	public Queue(int size) 
	{
		arr = new int[size];
	}
	public void enqueue(int v) throws IOException 
	{
		if (count >= arr.length)
			throw new IOException("Queue is full");
		last = (last + 1) % arr.length;
		arr[last] = v;
		count++;
	}
	public void enqueue(int...v) throws IOException 
	{
		for (int i=0; i<v.length; i++)
			enqueue(v[i]);
	}
	public int dequeue() throws IOException 
	{
		int v = 0;
		if(count == 0)
			throw new IOException("Queue is empty");
		v = arr[first];
		count--;
		return v;
	}
	public void printArray() 
	{
		System.out.println("The numbers stored in the array: ");
		for (int i=0; i<arr.length; i++)
			System.out.print(arr[i] + "\t");
		
		System.out.println();
	}
	public boolean isEmpty() 
	{
		return count == 0;
	}
	public boolean isFull() 
	{
		return count >= arr.length;
	}
	public static void main(String[] args) throws IOException {
		Queue queue = new Queue(5);
		System.out.println("Empty? " + queue.isEmpty());
		System.out.println("Full? " + queue.isFull());
		queue.enqueue(4, 5, 6, 7, 8);
		System.out.println("Empty? " + queue.isEmpty());
		System.out.println("Full? " + queue.isFull());
		queue.printArray();
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Dequeue: " + queue.dequeue());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.printArray();
	}
}
