import java.io.*;
import java.util.*;

class a implements Comparable<a>
{
	int from;
	int to;
	int weight;

	public a(int from, int to, int weight)
	{
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(a args)
	{
		return this.weight <= args.weight ? -1 : 1;
	}
}

public class Main
{
	static int v;
	static int e;
	static PriorityQueue<a> pq = new PriorityQueue<a>();
	static int[] parent;
	static int result = 0;
	static int cnt = 0;

	static int find(int x)
	{
		if (x == parent[x])
			return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}

	static void union(int x, int y)
	{
		int xroot = find(x);
		int yroot = find(y);
		if (xroot != yroot)
			parent[xroot] = y;
		else
			return;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];

		for (int i = 0; i < e; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new a(x, y, z));
		}

		for (int i = 1; i <= v; i++)
			parent[i] = i;

		for (int i = 0; i < e; i++)
		{
			a node = pq.poll();
			int start = node.from;
			int end = node.to;
			int x = find(start);
			int y = find(end);
			if (x == y)
				continue;
			union(x, y);
			cnt++;
			result += node.weight;
			if (cnt == e - 1)
				break;
		}

		bw.write(Integer.toString(result));
		br.close();
		bw.flush();
		bw.close();
	}
}
