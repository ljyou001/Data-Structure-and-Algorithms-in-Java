import java.util.Scanner;
public class LinearProbing 
{
	int[] table = null;
	int numOfKeys = 0;

	public LinearProbing(int size) 
	{
		table = new int[size];
	}

	int hash(int x) 
	{
		return x % table.length;
	}

	public void insert(int x) 
	{
		if (numOfKeys >= table.length) 
		{
			System.out.println("The table is full!");
			return;
		}
		int k, c = 0;
		int index = k = hash(x);
		while (table[index] > 0) 
		{
			c++;
			index = hash(k + c);
		}
		table[index] = x;
		numOfKeys++;
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
			index = hash(k + c);
		}
		return result;
	}

	public void del(int x) 
	{
		int index = hash(x);
		while(table[index] != 0)
		{
			if(table[index] == x)
			{
				table[index] = -1;
			}
			index++;
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
		LinearProbing table = new LinearProbing(5);
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
