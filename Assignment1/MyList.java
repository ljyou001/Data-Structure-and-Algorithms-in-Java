class MyList extends AbsList
{
	int count, start;
	public MyList(int size)
	{
		super(size);
		count = 0;
		start = 0;
		for (int i = 0; i < arr.length; i++)
		{
			arr[i][0] = 0;
			arr[i][1] = -1;
		}
	}
	public boolean append(int v)
	{
		if(isEmpty())
		{
			arr[start][0] = v;
			arr[start][1] = -1;
			count++;
			return true;
		}
		else if(isFull())
			return false;
		else
		{
			int po = start;
			while(arr[po][1] != -1)
			{
				po = arr[po][1];
			}
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i][0] == 0 && arr[i][1] == -1 || arr[i][1] == -2)
				{
					arr[po][1] = i;
					arr[i][0] = v;
					arr[i][1] = -1;
					count++;
					return true;
				}
			}
			return false;
		}
	}
	public boolean insert(int v, int p)
	{
		if (p-1 > count)
			return false;
		else if (isFull())
			return false;
		else if (p == 0)
		{
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i][0] == 0 && arr[i][1] == -1 || arr[i][1] == -2)
				{
					arr[i][1] = start;
					arr[i][0] = v;
					start = i;
					count++;
					return true;
				}
			}
		}
		else
		{
			int prePo = start;
			int aferPo = arr[start][1];
			for(int i = 0; i < p-1; i++)
			{
				prePo = arr[prePo][1];
				aferPo = arr[aferPo][1];
			}
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i][0] == 0 && arr[i][1] == -1 || arr[i][1] == -2)
				{
					arr[prePo][1] = i;
					arr[i][0] = v;
					arr[i][1] = aferPo;
					count++;
					return true;
				}
			}
		}
		return false;
	}
	public boolean delete(int v)
	{
		int po = start;
		for (int i = 1; i <= count; i++)
		{
			if(arr[start][0] == v)
			{
				if (count == 1)
				{
					arr[start][1] = -2;
					return true;
				}
				else
				{
					int alt = start;
					start = arr[start][1];
					arr[alt][1] = -2;
					count--;
					return true;
				}
			}
			else if (arr[arr[po][1]][0] == v)
			{
				int alt = arr[po][1];
				arr[po][1] = arr[alt][1];
				arr[alt][1] = -2;
				arr[alt][0] = 0 ;
				count--;
				return true;
			}
			po = arr[po][1];
		}
		return false;
	}
	public int find(int v)
	{
		int po = start;
		for (int i = 1; i <= count; i++)
		{
			if(arr[(arr[po][1])][0] == v)
			{
				return i;
			}
			po = arr[po][1];
		}
		return -1;
	}
	public void traversal()
	{
		int po = start;
		for (int i = 1; i <= count; i++)
		{
			System.out.print(arr[po][0]+" ");
			po = arr[po][1];
		}
	}
	boolean isEmpty()
	{
		if(count == 0)
			return true;
		return false;
	}
	boolean isFull()
	{
		if(count == arr.length)
	  		return true;
		return false;
	}
	int length()
	{
		return count;
	}
}
