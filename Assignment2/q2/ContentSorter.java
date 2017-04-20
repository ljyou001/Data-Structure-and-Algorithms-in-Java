package q2;
import java.io.*;
public class ContentSorter extends AbsContentSorter
{
	public ContentSorter() throws IOException 
	{}
	public void sort() throws IOException
	{
		buffer[0] = getInt(0);
		buffer[1] = getInt(1);
		buffer[2] = getInt(2);
		buffer[3] = getInt(3);
		buffer[4] = getInt(4);
		while(buffer[0] != -1 && buffer[1] != -1 && buffer[2] != -1 && buffer[3] != -1 && buffer[4] != -1)
		{
			int c = findMinIndex(buffer);
			output(buffer[c]);
			buffer[c] = getInt(c);
		}
	}
	private int findMinIndex(int [] a)
	{
		int min = a[0];
		int count = 0;
		for (int i = 1; i < a.length; i++)
		{
			if (a[i] < min)
			{
				min = a[i];
				count = i;
			}
		}
		return count;
	}
}
