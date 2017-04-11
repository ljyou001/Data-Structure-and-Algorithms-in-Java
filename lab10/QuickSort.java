public class QuickSort 
{
	public void sort(int [] arr)
	{
		sort(arr, 0, arr.length-1);
	}
	public void sort(int[] arr, int left, int right) 
	{
		if (left >= right) return;
		int p = right;
		int i = left;
		int j = right - 1;
		while (true) 
		{
			while (i < right && arr[i] < arr[p])
				i++;
			while (j > left && arr[j] >= arr[p])
				j--;
			if (i < j) 
				swap(arr, i, j);
			else
				break;
		}
		swap(arr, i, p);
		sort(arr, left, i - 1);
		sort(arr, i + 1, right);
	}
	void swap(int [] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String args[])
	{
		int[] num = {5, 3, 2, 8, 7, 3, 1, 9, 3};
		QuickSort qs = new QuickSort();
		qs.sort(num);
		for (int v : num) 
		{
			System.out.print(v + "\t");
		}
	}
}
