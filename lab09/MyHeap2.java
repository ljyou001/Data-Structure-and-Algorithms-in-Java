import java.util.Scanner;

public class MyHeap2 {
	
	int[] arr;
	int numOfElements = 0;
	
	public MyHeap2(int [] data) {
		arr = data;
		numOfElements = data.length - 1;
	}
	
	void buildHeap() {
		for (int i=numOfElements/2; i>0; i--)
			bubbleDown(i);
	}
	
	boolean isRoot(int i) {
		return i == 1;
	}
	
	boolean isLeaf(int i) {
		return i > 0.5 * numOfElements;
	}
	
	void bubbleDown(int p) {
		if (isLeaf(p)) return;
		
		int l = p * 2;
		int r = l + 1;
		int c = l;
		
		if (r <= numOfElements && arr[l] > arr[r])
			c = r;
		
		if (arr[c] < arr[p]) {
			swap(c, p);
			bubbleDown(c);
		}
	}
	
	void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i=1; i<= numOfElements; i++)
			str += arr[i] + " ";
		
		return str;
	}

	public static void main(String[] args) {
		
		int[] data = new int[10 + 1];
		
		for (int i=1; i< data.length; i++)
			data[i] = (int) (Math.random() * 100 + 1);
		
		MyHeap2 heap = new MyHeap2(data);
		System.out.println("The numbers in the heap (before buildHeap): " + heap);
		
		heap.buildHeap();
			
		System.out.println("The numbers in the heap (after buildHeap): " + heap);
		
	}

}
