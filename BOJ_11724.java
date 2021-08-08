import java.io.*;
import java.util.*;

public class Main
{
	static int v, e;
	static boolean[] vis;
	static List<Integer>[] adj;

	static void BFS(int x)
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		vis[x] = true;

		while (!q.isEmpty())
		{
			int cur = q.poll();

			for (int i = 0; i < adj[cur].size(); i++)
			{
				int nxt = adj[cur].get(i);
				if (vis[nxt] == true)
					continue;
				q.offer(nxt);
				vis[nxt] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[v + 1];
		vis = new boolean[v + 1];
		int cnt = 0;
		
		for (int i = 1; i <= v; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < e; i++)
		{
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}

		for (int i = 1; i <= v; i++)
		{
			if (vis[i] == true)
				continue;
			BFS(i);
			cnt++;
		}

		bw.write(Integer.toString(cnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
