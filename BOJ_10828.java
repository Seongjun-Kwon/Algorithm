import java.io.*;
import java.util.*;

class Stack
{
	private int tail;
	private int arr[];

	public Stack(int size)
	{
		tail = -1;
		arr = new int[size];
	}

	public void push(int x)
	{
		arr[++tail] = x;
	}

	public int pop()
	{
		if (tail == -1)
			return -1;
		else
			return arr[tail--];
	}

	public int size()
	{
		return tail + 1;
	}

	public int empty()
	{
		if (tail == -1)
			return 1;
		else
			return 0;
	}

	public int top()
	{
		if (tail == -1)
			return -1;
		else
			return arr[tail];
	}
}

public class Main
{
	static int n;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		Stack s = new Stack(n);

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push"))
			{
				s.push(Integer.parseInt(st.nextToken()));
			}
			else if (str.equals("pop"))
			{
				bw.write(String.valueOf(s.pop()));
				bw.newLine();
			}
			else if (str.equals("size"))
			{
				bw.write(String.valueOf(s.size()));
				bw.newLine();
			}
			else if (str.equals("empty"))
			{
				bw.write(String.valueOf(s.empty()));
				bw.newLine();
			}
			else if (str.equals("top"))
			{
				bw.write(String.valueOf(s.top()));
				bw.newLine();
			}
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
