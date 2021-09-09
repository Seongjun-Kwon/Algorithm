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
	static boolean[] vis;
	static List<Tree>[] adj;

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

		if (n == 1)
		{
			bw.write("0");
			br.close();
			bw.flush();
			bw.close();
			return;
		}

		adj = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++)
		{
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[f].add(new Tree(t, w));
			adj[t].add(new Tree(f, w));
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
