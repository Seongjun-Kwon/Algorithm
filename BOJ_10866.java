import java.io.*;
import java.util.*;

class Deque
{
	int head;
	int tail;
	int arr[];

	public Deque(int size)
	{
		head = size / 2;
		tail = size / 2;
		arr = new int[2 * size];
	}

	public void push_front(int x)
	{
		arr[--head] = x;
	}

	public void push_back(int x)
	{
		arr[tail++] = x;
	}

	public int pop_front()
	{
		if (head == tail)
			return -1;
		return arr[head++];
	}

	public int pop_back()
	{
		if (head == tail)
			return -1;
		return arr[--tail];
	}

	public int size()
	{
		return (tail - head);
	}

	public int empty()
	{
		if (head == tail)
			return 1;
		else
			return 0;
	}

	public int front()
	{
		if (head == tail)
			return -1;
		return arr[head];
	}

	public int back()
	{
		if (head == tail)
			return -1;
		return arr[tail - 1];
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
		Deque deq = new Deque(n);

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push_front"))
				deq.push_front(Integer.parseInt(st.nextToken()));
			else if (str.equals("push_back"))
				deq.push_back(Integer.parseInt(st.nextToken()));
			else if (str.equals("pop_front"))
				bw.write(String.valueOf(deq.pop_front()) + "\n");
			else if (str.equals("pop_back"))
				bw.write(String.valueOf(deq.pop_back()) + "\n");
			else if (str.equals("size"))
				bw.write(String.valueOf(deq.size()) + "\n");
			else if (str.equals("empty"))
				bw.write(String.valueOf(deq.empty()) + "\n");
			else if (str.equals("front"))
				bw.write(String.valueOf(deq.front()) + "\n");
			else if (str.equals("back"))
				bw.write(String.valueOf(deq.back()) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
