import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int m = Integer.parseInt(br.readLine());
		
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i < str.length(); i++)
			list.add(str.charAt(i));
		
		ListIterator<Character> it = list.listIterator();
		while (it.hasNext())
			it.next();

		for (int i = 0; i < m; i++)
		{
			String com = br.readLine();
			char c = com.charAt(0);
			if (c == 'P')
				it.add(com.charAt(2));
			else if (c == 'L')
			{
				if(it.hasPrevious())
					it.previous();
			}
			else if (c == 'D')
			{
				if (it.hasNext())
					it.next();
			}
			else if (c == 'B')
			{
				if (it.hasPrevious())
				{
					it.previous();
					it.remove();
				}
			}
		}

		for (Character ch : list)
			bw.write(ch);
		br.close();
		bw.flush();
		bw.close();
	}
}
