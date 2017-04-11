package q1;
public class Sorter implements InfSorter
{
	int [] count = null;
	String [] table = null;
	int number = 0;
	int [] newCount = null;
	String [] newTable = null;
	public Sorter()
	{
		table = new String [1];
		count = new int[1];
		for (int i = 0; i < count.length; i++)
		{
			count [i] = 0;
		}
	}
	public void add(String str)
	{
		int key = 0, index = 0;
		key = index = hash(str);
		int c = 0;
		for (int i = 0; i < table.length; i++)
		{
			if (str.equals(table[i]))
			{
				count[i]++;
				return;
			}
		}
		while(table[index] != null)
		{
			c++;
			index = hash(key + c*c);
		}
		table [index] = str;
		count [index] ++;
		number ++;
		if (number * 2 >= table.length)
			rehashing();
	}
	public int hash(String key)
	{
		int x = 0;
		for (int i=0; i< key.length(); i++)
			x += key.charAt(i);
		return x % table.length;
	}
	int hash(int x) 
	{
		return x % table.length;
	}
	int nextPrime(int x)
	{
		int p = x;
		if (p == 2)
			return p;
		if (p%2 ==0)
			p++;
		while(!isPrime(p))
			p+=2;
		return p;
	}
	boolean isPrime(int x)
	{
		for (int i=2; i<=Math.sqrt(x); i++)
			if (x % i == 0)
			return false;
		return true;
	}
	void rehashing()
	{
		String [] oldTable = table;
		table = new String[nextPrime(oldTable.length * 2)];
		count = new int[nextPrime(oldTable.length * 2)];
		for (String x: oldTable)
		{
			if(x != null)
				add(x);
		}
	}
	public void printOrderedByAppearanceInDsc()
	{
		newCount = count;
		newTable = table;
		shellSort();
		for(int i = 0; i < count.length; i++)
			if(newTable[i]!=null)
				System.out.println((i)+"\t"+newTable[i]+"\t"+newCount[i]);
	}
	public void shellSort() 
	{
		int j;
		for (int gap = newCount.length / 2; gap > 0; gap /= 2) 
		{
			for (int i = gap; i < newCount.length; i++) 
			{
				int tmpCount = newCount[i];
				String tmpTable = newTable[i];
				for (j = i; j >= gap && tmpCount >= newCount[i]; j -= gap) 
				{
					if (tmpCount <= newCount[j - gap])
						break;
					newCount[j] = newCount[j - gap];
					newTable[j] = newTable[j - gap];
				}
				newTable[j] = tmpTable;
				newCount[j] = tmpCount;
			}
		}
	}
}