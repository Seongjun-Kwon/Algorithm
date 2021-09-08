import java.io.*;
import java.util.*;

public class Main
{
	static int n;
	static List<Integer>[] adj;
	static boolean[] vis;
	static int[] parent;

	static void DFS(int start)
	{
		vis[start] = true;

		for (int i = 0; i < adj[start].size(); i++)
		{
			int nxt = adj[start].get(i);

			if (!vis[nxt])
			{
				parent[nxt] = start;
				DFS(nxt);
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n + 1];
		vis = new boolean[n + 1];
		parent = new int[n + 1];
		
		for (int i = 1; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}

		DFS(1);
		
		for (int i = 2; i <= n; i++)
			bw.write(Integer.toString(parent[i]) + "\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
