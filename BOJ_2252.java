import java.io.*;
import java.util.*;

public class Main
{
	static int n, m;
	static int[] indeg;
	static List<Integer>[] adj;
	static List<Integer> result;

	static void Topo_sort()
	{
		Queue<Integer> q = new LinkedList<>();
		result = new ArrayList<>();

		for (int i = 1; i <= n; i++)
		{
			if (indeg[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty())
		{
			int cur = q.poll();
			result.add(cur);

			for (int i = 0; i < adj[cur].size(); i++)
			{
				int nxt = adj[cur].get(i);
				indeg[nxt]--;
				if (indeg[nxt] == 0)
					q.offer(nxt);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		indeg = new int[n + 1];
		adj = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 1; i <= m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			indeg[b]++;
		}

		Topo_sort();
		for (int i = 0; i < result.size(); i++)
			bw.write(result.get(i) + " ");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
