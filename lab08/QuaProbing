import java.util.Scanner;
public class QuaProbing 
{
	int[] table = null;
	int numOfKeys = 0;
	public QuaProbing(int size) 
	{
		table = new int[size];
	}
	
	int hash(int x) 
	{
		return x % table.length;
	}
	
	int find(int x) 
	{
		int result = -1;
		int k, c = 0;
		int index = k = hash(x);
		
		while (table[index] != 0) 
		{
			if (table[index] == x) 
			{
				result = index;
				break;
			}
			
			c++;
			index = hash(k + c*c);
		}
		return result;	
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
		int [] oldTable = table;
		table = new int[nextPrime(table.length * 2)];
		numOfKeys = 0;
		for (int x: oldTable)
		{
			if(x > 0)
				insert(x);
		}
		/*
    int[] newTable = new int[nextPrime(table.length * 2)];
		int index = 0, c = 0;
		numOfKeys = 0;
		for (int i = 0; i < table.length; i++)
		{
			if(table[i] > 0)
			{
				if(newTable[index] <= 0)
				{
					index = table[i] % newTable.length;
				}
				else
				{
					while(newTable[index]>0)
					{
						index = (table[i]% newTable.length + c*c) % newTable.length;
						c++;
					}
				}
				newTable[index] = table[i];
				numOfKeys++;
			}
		}
		this.table = newTable;
		*/
	}
	
	public void insert(int x) 
	{
		if (numOfKeys >= table.length) 
		{
			System.out.println("The table is full!");
			return;
		}
		int index, k, c = 0;
		index = k = hash(x);
		while(table[index] > 0) 
		{
			c++;
			index = hash(k + c*c);
		}
		table[index] = x;
		numOfKeys++;
		if (numOfKeys * 2 >= table.length)
			rehashing();
	}

	public void del(int x) 
	{
		if (numOfKeys == 0)
			return;
		int index = find(x);
		if (index >= 0) {
			table[index] = -1;
			numOfKeys--;
		}
	}
	
	public void print() 
	{
		System.out.println("\n\n" + this.getClass().getName());
		System.out.println("Idx:\tKey\n=============");
		for (int i=0; i<table.length; i++)
			System.out.println("#" + i + ":\t " + table[i]);
		System.out.println("----------\n");
	}
	
	public static void main(String[] args) 
	{
		QuaProbing table = new QuaProbing(5);
		Scanner scanner = new Scanner(System.in);
		String str = null;
		int key;

		while (true) 
		{
			try 
			{
				System.out
				.println("Use \"+\" to add an integer; use \"-\" to delete an integer.");
				str = scanner.nextLine();
				key = Integer.parseInt(str.substring(1, str.length()).trim());
				switch (str.charAt(0)) 
				{
				case '+':
					table.insert(key);
					break;
				case '-':
					table.del(key);
					break;
				}
				table.print();
			} 
			catch (Exception ex) 
			{
				System.out.println("Error! Please input again!");
			}
		}
	}
}
