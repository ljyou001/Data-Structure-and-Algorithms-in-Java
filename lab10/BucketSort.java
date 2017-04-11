public class BucketSort 
{
	int [] bucket = null;
	public BucketSort(int arr[]) 
	{
		sort(arr);
	}
	public void sort(int [] arr)
	{
		createBucket(arr);
		for (int i = 0; i < arr.length; i++)
		{
			bucket[arr[i]]++;
		}
	}
	public void print()
	{
		for (int i = 0; i < bucket.length; i++)
			for(int j = 0; j < bucket[i]; j++)
				System.out.print(i + " ");
	}
	void createBucket(int arr[])
	{
		bucket = new int [findMax(arr) + 1];
	}
	int findMax(int arr[])
	{
		int max = arr[0];
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	public static void main(String args[])
	{
		int[] num = {5, 3, 2, 8, 7, 3, 1, 9, 3};
		BucketSort bs = new BucketSort(num);
		bs.print();
	}
}
