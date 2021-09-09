import java.io.*;
import java.util.*;

public class Main
{
	static class Tree
	{
		int to;
		int weight;

		public Tree(int to, int weight)
		{
			this.to = to;
			this.weight = weight;
		}
	}

	static int n, distance, index;
	static List<Tree>[] adj;
	static boolean[] vis;

	static void DFS(int start, int sum)
	{
		vis[start] = true;

		if (distance < sum)
		{
			distance = sum;
			index = start;
		}

		for (int i = 0; i < adj[start].size(); i++)
		{
			Tree nxt = adj[start].get(i);
			int nxtNode = nxt.to;
			int weight = nxt.weight;
			
			if (!vis[nxtNode])
				DFS(nxtNode, sum + weight);
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		adj = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());

			while (true)
			{
				int to = Integer.parseInt(st.nextToken());
				
				if (to == -1)
					break;
				
				int weight = Integer.parseInt(st.nextToken());
				adj[from].add(new Tree(to, weight));
			}

		}

		vis = new boolean[n + 1];
		distance = 0;
		index = 0;
		DFS(1, 0);
		
		vis = new boolean[n + 1];
		distance = 0;
		DFS(index, 0);
		
		bw.write(Integer.toString(distance));
		br.close();
		bw.flush();
		bw.close();
	}
}
